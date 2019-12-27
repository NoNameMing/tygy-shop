package com.neuedu.shop.controller;

import com.neuedu.shop.pojo.Admin;
import com.neuedu.shop.pojo.User;
import com.neuedu.shop.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping("/back/findAll.user")
    public String findAll(ModelMap map) {
        List<User> users = service.findAll();
        // 将查询到的结果绑定到 modelMap
        map.addAttribute("users", users);
        log.info(String.valueOf(users));
        // 告诉controller层要将结果交给哪个页面显示
        return "user_list.jsp";
    }
}
