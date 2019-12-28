package com.neuedu.shop.controller;

import com.neuedu.shop.pojo.Admin;
import com.neuedu.shop.service.AdminService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Log4j
public class AdminController {

    @Autowired
    private AdminService service;

    @RequestMapping("/back/findAll.admin")
    public String findAll(ModelMap map) {
        List<Admin> admins = service.findAll();
        // 将查询到的结果绑定到 modelMap
        map.addAttribute("admins", admins);
        log.info(admins);
        // 告诉controller层要将结果交给哪个页面显示
        return "admin_list.jsp";
    }

    @RequestMapping("/back/delete.admin")
    public String delete(Integer id) {
        service.delete(id);
        return "redirect:findAll.admin";
    }

    @RequestMapping("/back/resetPassword.admin")
    public String resetPassword(Integer id) {
        service.resetPassword(id);
        return "redirect:findAll.admin";
    }
}
