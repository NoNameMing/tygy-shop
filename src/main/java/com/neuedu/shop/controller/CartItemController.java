package com.neuedu.shop.controller;

import com.neuedu.shop.pojo.CartItem;
import com.neuedu.shop.pojo.User;
import com.neuedu.shop.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CartItemController {

    @Autowired
    private CartItemService service;

    @RequestMapping("/pre/insert.cartitem")
    public String insert(CartItem cartItem) {
        service.insert(cartItem);
        return "redirect:index.product";
    }

    @RequestMapping("/pre/findByUserId.cartitem")
    public String findByUserId(Integer userid, ModelMap map) {
        List<CartItem> items = service.findByUserId(userid);
        map.addAttribute("items", items);
        return "forward:cart.jsp";
    }

    @RequestMapping("/pre/delete.cartitem")
    public String delete(CartItem cartItem, HttpSession session) {
        service.delete(cartItem, session);
        User user = (User) session.getAttribute("user");
        return "redirect:findByUserId.cartitem?userid=" + user.getId();
    }

    @RequestMapping("/pre/update.cartitem")
    public String update(CartItem cartItem, Integer cnt, HttpSession session) {
        cartItem.setPcount(cnt); // 更新数量
        service.update(cartItem);
        User user = (User) session.getAttribute("user");
        return "redirect:findByUserId.cartitem?userid=" + user.getId();
    }

}
