package com.neuedu.shop.controller;

import com.neuedu.shop.pojo.Category;
import com.neuedu.shop.service.CategoryService;
import com.neuedu.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 实现后台删除类别的功能
 */
public class DeleteController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

//    @RequestMapping("/back/")
//    public String deleteCategory (){
//
//    }
}
