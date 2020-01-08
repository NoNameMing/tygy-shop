package com.neuedu.shop.controller;

import com.neuedu.shop.pojo.Order;
import com.neuedu.shop.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
