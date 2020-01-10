package com.neuedu.shop.controller;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.neuedu.shop.common.AlipayConfig;
import com.neuedu.shop.common.OrderUtil;
import com.neuedu.shop.pojo.Order;
import com.neuedu.shop.pojo.Product;
import com.neuedu.shop.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Transactional
@Slf4j
public class OrderController {

    @Autowired
    private OrderService service;

    @RequestMapping("/back/findAll.order")
    public String findAll(ModelMap modelMap) {
        List<Order> orders = service.findAll();
        modelMap.addAttribute("orders", orders);
        return "forward:order_list.jsp";
    }

    @RequestMapping("/pre/insert.order")
    public String insert(Order order) {
        service.insert(order);
        return "forward:/alipay/index.jsp";
    }

//    @RequestMapping("/alipay/pay")
//    @ResponseBody
//    public String goAlipay(String orderId, HttpServletRequest request, HttpServletRequest response) throws Exception {
//
//        // 1. 初始化SDK
//        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
//
//        // 2. 设置请求参数
//        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
//
//        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
//                + "\"total_amount\":\""+ 1 +"\","
//                + "\"subject\":\""+ "name" +"\","
//                + "\"body\":\""+ body +"\","
//                + "\"timeout_express\":\""+ timeout_express +"\"}");
//
//
//        AlipayTradePagePayResponse alipayTradePagePayResponse = alipayClient.pageExecute(alipayRequest);
//        if(alipayTradePagePayResponse.isSuccess()){
//            System.out.println("调用成功");
//        } else {
//            System.out.println("调用失败");
//        }
//
//        //获得初始化的AlipayClient
//
//        //设置请求参数
//        alipayRequest.setReturnUrl(AlipayConfig.return_url);
//        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
//
//        //商户订单号，商户网站订单系统中唯一订单号，必填
//        String out_trade_no = orderId;
//        //付款金额，必填
////        String total_amount = order.getOrderAmount();
//        //订单名称，必填
////        String subject = product.getName();
//        //商品描述，可空
////        String body = "用户订购商品个数：" + order.getBuyCounts();
//
//        String body = "用户订购商品个数：" + 1;
//
//        // 该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m。
//        String timeout_express = "1c";
//
//        //请求
//        String result = alipayClient.pageExecute(alipayRequest).getBody();
//
//        return result;
//    }
}
