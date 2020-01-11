package com.neuedu.shop.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.neuedu.shop.common.AlipayConfig;
import com.neuedu.shop.common.OrderUtil;
import com.neuedu.shop.pojo.CartItem;
import com.neuedu.shop.pojo.Order;
import com.neuedu.shop.pojo.Product;
import com.neuedu.shop.pojo.User;
import com.neuedu.shop.service.CartItemService;
import com.neuedu.shop.service.OrderService;
import com.neuedu.shop.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

import static redis.clients.jedis.Protocol.CHARSET;

@Controller
@Transactional
@Slf4j
public class OrderController {

    @Autowired
    private OrderService service;

    @Autowired
    private ProductService productService;

    @Autowired
    private CartItemService cartItemService;

    /**
     * 后台订单列表
     * @param modelMap
     * @return
     */
    @RequestMapping("/back/findAll.order")
    public String findAll(ModelMap modelMap) {
        List<Order> orders = service.findAll();
        modelMap.addAttribute("orders", orders);
        return "forward:order_list.jsp";
    }

    /**
     * 确认信息以下单
     * @param order
     * @return
     */
    @RequestMapping("/pre/insert.order")
    public String insert(Order order, ModelMap map, HttpSession session) {
        String oid = OrderUtil.generateOrder(); // 生成订单号
        order.setOid(oid);
        service.insert(order); // 插入数据
        Order order1 = service.findOrderById(oid); // 找到数据
        map.addAttribute("order", order1); // 存入 order 信息

        User user = (User) session.getAttribute("user");
        List<CartItem> items = cartItemService.findByUserId(user.getId());
        map.addAttribute("items", items); // 存入 购物车信息

        double amount = 0.0;

        for (CartItem item : items) {
            amount += item.getPcount() * item.getMemberprice();
        }

        map.addAttribute("amount", amount); // 存入 购物车信息
        return "forward:user_order.jsp";
    }

    /**
     * 支付请求
     * @param httpResponse
     * @throws Exception
     */
    @RequestMapping("/pre/pay.order")
    @ResponseBody
    public void goAlipay(HttpServletResponse httpResponse, HttpServletRequest request) throws Exception {

        // 1. 初始化SDK
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key,"json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        // 2. 设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();

        // 订单号，必填，测试用
        String out_trade_no = request.getParameter("order_id");

        // 订单标题，必填，测试用
        String subject = "果蔬平台交易" + request.getParameter("order_id");

        // 总金额，必填，测试用
        String total_amount = request.getParameter("amount");

        // 设置请求参数
        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        // 设置返回、异步参数
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        // 3. 设置相应参数
        AlipayTradePagePayResponse alipayTradePagePayResponse = alipayClient.pageExecute(alipayRequest);
        if(alipayTradePagePayResponse.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }


        String form = "";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); // 调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=" + CHARSET);
        httpResponse.getWriter().write(form);// 直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }



    /**
     * 支付相应
     * @param request
     * @param response
     * @return
     * @throws IOException
     * @throws AlipayApiException
     */
    @RequestMapping("/pre/return_url")
    public String returnUrl(HttpServletRequest request, HttpServletResponse response)
            throws IOException, AlipayApiException {
        System.out.println("=================================同步回调=====================================");

        // 获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("utf-8"), "utf-8");
            params.put(name, valueStr);
        }

        System.out.println(params);//查看参数都有哪些
        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); // 调用SDK验证签名
        //验证签名通过
        if(signVerified){
            // 商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

            // 支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

            // 付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");

            System.out.println("商户订单号="+out_trade_no);
            System.out.println("支付宝交易号="+trade_no);
            System.out.println("付款金额="+total_amount);

            //支付成功，修复支付状态
//            payService.updateById(Integer.valueOf(out_trade_no));
            return "forward:index.product";//跳转付款成功页面
        }else{
            return "no";//跳转付款失败页面
        }

    }

}
