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

    /**
     * 查找所有管理员
     * @param map
     * @param session
     * @return
     */
    @RequestMapping("/back/findAll.admin")
    public String findAll(ModelMap map, HttpSession session) {
        List<Admin> admins = service.findAll();
        int adminNum = service.countAdmin();
        session.setAttribute("adminNum", adminNum);
        // 将查询到的结果绑定到 modelMap
        map.addAttribute("admins", admins);
        Admin adminCheck = (Admin) session.getAttribute("admin");
        if (adminNum > 5) {
            if (adminCheck.getLevel() == 1) {
                map.addAttribute("err_admin_msg", "管理员人数已超限，请您删除多余管理员");
            } else {
                map.addAttribute("err_admin_msg", "管理员人数已超限，请您联系超级管理员删除多余管理员");
            }
        }
        log.info(admins);
        // 告诉controller层要将结果交给哪个页面显示
        return "forward:admin_list.jsp";
    }

    /**
     * 删除需要权限
     * @param id
     * @return
     */
    @RequestMapping("/back/delete.admin")
    public String delete(Integer id, HttpSession session, ModelMap modelMap) {
        try {
            Admin adminCheck = (Admin) session.getAttribute("admin");
            if (adminCheck.getLevel() == 1) {
                service.delete(id);
                return "redirect:findAll.admin";
            } else {
                modelMap.addAttribute("err_admin_msg", "请勿尝试越权删除操作");
                return "forward:findAll.admin";
            }
        } catch (Exception e) {
            modelMap.addAttribute("err_admin_msg", "session 信息错误");
            log.error(e);
            return "forward:findAll.admin";
        }
    }

    /**
     * 重置需要权限
     * @param id
     * @return
     */
    @RequestMapping("/back/resetPassword.admin")
    public String resetPassword(Integer id, HttpSession session, ModelMap modelMap) {
        try {
            Admin adminCheck = (Admin) session.getAttribute("admin");
            if (adminCheck.getLevel() == 1) {
                service.resetPassword(id);
            } else {
                modelMap.addAttribute("err_admin_msg", "请勿尝试越权重置密码操作");
                return "forward:findAll.admin";
            }
        } catch (Exception e) {
            modelMap.addAttribute("err_admin_msg", "session 信息错误");
            log.error(e);
            return "forward:findAll.admin";
        }
        return "redirect:findAll.admin";
    }

    /**
     * 添加需要权限
     * @param admin
     * @param session
     * @return
     */
    @RequestMapping("/back/addAdmin.admin")
    public String addAdmin(Admin admin, HttpSession session, ModelMap modelMap) {
        try {
            int adminNum = service.countAdmin();
            Admin adminCheck = (Admin) session.getAttribute("admin");
            if (adminCheck.getLevel() == 1) {
                 if (adminNum >= 5){
                    modelMap.addAttribute("err_admin_msg", "管理员人数已达上限，无法添加！");
                    return "forward:findAll.admin";
                } else {
                    service.addAdmin(admin);
                    return "redirect:findAll.admin";
                }
            } else {
                modelMap.addAttribute("err_admin_msg", "请勿尝试越权添加操作");
                return "forward:findAll.admin";
            }
        } catch (Exception e) {
            modelMap.addAttribute("err_admin_msg", "session 信息错误");
            log.error(e);
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

    @RequestMapping("/back/findById.admin")
    public String findById(Integer id, ModelMap modelMap) {
        Admin a = service.findById(id);
        modelMap.addAttribute("a", a);
        return "forward:admin_update.jsp";
    }

    @RequestMapping("/back/update.admin")
    public String update(Admin admin, HttpSession session, ModelMap modelMap) {
        Admin adminCheck = (Admin) session.getAttribute("admin");
        try {
            if (adminCheck.getLevel() == 1 || adminCheck.getId() == admin.getId()) {
                service.update(admin);
                return "redirect:findAll.admin";
            } else {
                modelMap.addAttribute("err_admin_msg", "请勿尝试越权修改操作");
                return "forward:findAll.admin";
            }
        } catch (Exception e) {
            modelMap.addAttribute("err_admin_msg", "session 信息错误");
            log.error(e);
            return "redirect:findAll.admin";
        }
    }

    @RequestMapping("/back/logout.admin")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:admin_login.jsp";
    }
}
