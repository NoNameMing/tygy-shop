package com.neuedu.shop.controller;

import com.neuedu.shop.pojo.Admin;
import com.neuedu.shop.service.AdminService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Log4j
public class AdminController {

    @Autowired
    private AdminService service;

    @RequestMapping("/back/findAll.admin")
    public String findAll(ModelMap map, HttpSession session) {
        List<Admin> admins = service.findAll();
        int adminNum = service.countAdmin();
        // 将查询到的结果绑定到 modelMap
        map.addAttribute("admins", admins);
        session.setAttribute("adminNum", adminNum);
        log.info(admins);
        // 告诉controller层要将结果交给哪个页面显示
        return "forward:admin_list.jsp";
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

    @RequestMapping("/back/addAdmin.admin")
    public String addAdmin(Admin admin, HttpSession session) {
        int adminNum = (int) session.getAttribute("adminNum");
        if (adminNum >= 5) {
            session.setAttribute("err_admin_msg", "管理员人数已达上限，无法添加！");
            return "forward:findAll.admin";
        } else {
            service.addAdmin(admin);
            return "redirect:findAll.admin";
        }
    }

    /**
     *
     * @param name
     * @param pwd
     * @param inputcode 验证码
     * @param session
     * @param map
     * @return
     */
    @RequestMapping("/back/login.admin")
    public String login(String name, String pwd, String inputcode, HttpSession session, ModelMap map) {
        Admin admin = service.login(name, pwd);
        // 用户名密码正确
        if (admin != null) {
            String code = (String)session.getAttribute("code");
            // 验证码错误
            if (code.equals(inputcode)) {
                session.setAttribute("admin", admin);
                return "redirect:index.jsp"; // 登陆成功，返回首页
            } else {
                // 给出错误提示
                map.addAttribute("code_msg", "用户名或密码输入错误");
                return "forward:admin_login.jsp";
            }
        } else {
            map.addAttribute("error_msg", "用户名或密码输入错误");
            return "forward:admin_login.jsp";
        }
    }

    @RequestMapping("/back/logout.admin")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:admin_login.jsp";
    }
}
