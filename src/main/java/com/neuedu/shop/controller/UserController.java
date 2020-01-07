package com.neuedu.shop.controller;

import com.neuedu.shop.pojo.Admin;
import com.neuedu.shop.pojo.User;
import com.neuedu.shop.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
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
    public String register(User user, String hcity, String hproper, String harea, String addr2) {
        if (harea == null) harea = "";
        user.setAddr(hcity+hproper+harea+addr2);
        service.insert(user);
        return "redirect:index.product";
    }

    @RequestMapping("/back/delete.user")
    public String delete(Integer id) {
        service.delete(id);
        return "redirect:findAll.user";
    }

    @RequestMapping("/back/delete.users")
    public String delete(Integer[] ids) {
        service.delete(ids);
    log.error("删除验证：" + ids);
        return "redirect:findAll.user";
    }

    @RequestMapping("/back/resetPassword.user")
    public String resetPassword(Integer id) {
        service.resetPassword(id);
        return "redirect:findAll.user";
    }

    @RequestMapping("/back/addUser.user")
    public String addAdmin(User user) {
        service.insert(user);
        return "redirect:findAll.user";
    }

    @RequestMapping("/pre/login.user")
    public String login(String name, String pwd, String inputcode, HttpSession session, ModelMap map) {
        User user = service.login(name,pwd);
        //用户名和密码输入正确
        if(user!=null) {
            String code=(String) session.getAttribute("code");
            //验证码也相同
            if(code.equals(inputcode)) {
                //将登录正确的user对象绑定到session对象中
                session.setAttribute("user", user);
                return "redirect:index.product";
            }else {
                //给出错误提示
                map.addAttribute("code_msg", "验证码错误");
                return "forward:user_login.jsp";
            }
        }else {
            //给出错误提示
            map.addAttribute("error_msg", "用户名或密码错误");
            return "forward:user_login.jsp";
        }
    }

    @RequestMapping("/pre/logout.user")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:user_login.jsp";
    }
}
