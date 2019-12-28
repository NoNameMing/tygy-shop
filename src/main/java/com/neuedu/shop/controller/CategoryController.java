package com.neuedu.shop.controller;

import com.neuedu.shop.pojo.Category;
import com.neuedu.shop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Transactional
public class CategoryController {

    @Autowired
    private CategoryService service;

    @RequestMapping("/back/findAll.category")
    public String findAll(ModelMap map) {
        List<Category> categories = service.findAll();
        map.addAttribute("categories", categories);
        return "forward:category_list.jsp";
    }

    @RequestMapping("/back/delete.category")
    public String delete(Integer id) {
        service.delete(id);
        return "redirect:findAll.category";
    }
}
