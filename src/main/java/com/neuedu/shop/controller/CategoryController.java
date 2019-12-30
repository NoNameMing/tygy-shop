package com.neuedu.shop.controller;

import com.neuedu.shop.pojo.Category;
import com.neuedu.shop.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Transactional
@Slf4j
public class CategoryController {

    @Autowired
    private CategoryService service;

    @RequestMapping("/back/findAll.category")
    public String findAll(ModelMap map) {
        List<Category> categories = service.findAll();
        map.addAttribute("categories", categories);
        return "forward:category_list.jsp";
    }

//    @RequestMapping("/back/delete.category")
//    public String delete(Integer id) {
//        service.delete(id);
//        return "redirect:findAll.category";
//    }

    @RequestMapping("/back/addRoot.category")
    public String addRootCategory(Category category) {
        service.addRootCategory(category);
        return "redirect:findAll.category";
    }

    @RequestMapping("/back/findToTree.category")
    @ResponseBody
    public List<Category> findToTree() {
        return service.findToTree(); // category 容器
    }

    @RequestMapping("/back/addChild.category")
    public String addChildCategory(String name, String desc, int pid) {
        service.addChildCategory(name, desc, pid);
        return "redirect:category_list.jsp";
    }

    @RequestMapping("/back/findById.category")
    public String findById(int id, ModelMap map) {
        Category c = service.findById(id);
        map.addAttribute("c", c);
        return "forward:category_addchild.jsp";
    }

    @RequestMapping("/back/modifyById.category")
    public String modifyById(int id, ModelMap map) {
        Category c = service.findById(id);
        map.addAttribute("c", c);
        return "forward:category_modify.jsp";
    }

    @RequestMapping("/back/modifyDesc.category")
    public String modifyCategoryDesc(Category category) {
        service.modifyCategoryDesc(category);
        return "redirect:category_list.jsp";
    }


}
