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
        map.addAttribute("users", users);
        return "user_list.jsp";
    }

    @RequestMapping("/pre/register.user")
    public String register(User user) {
        service.insert(user);
        return "redirect:index.jsp";
    }

    @RequestMapping("/back/delete.user")
    public String delete(Integer id) {
        service.delete(id);
        return "redirect:findAll.user";
    }

    @RequestMapping("/back/deletes.user")
    public String delete(Integer[] ids) {
        for (int id : ids) {
            service.delete(id);
        }
        return "redirect:findAll.user";
    }
}
