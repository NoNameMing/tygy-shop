package com.neuedu.shop.controller;

import com.neuedu.shop.pojo.Product;
import com.neuedu.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;

@Controller
@Transactional
public class ProductController {

    @Autowired
    private ProductService service;

    @RequestMapping("/back/findAll.product")
    public String findAll(ModelMap map) {
        List<Product> products = service.findAll();
        System.out.println(products);
        map.addAttribute("products", products);
        return "forward:product_list.jsp";
    }

    @RequestMapping("/back/delete.product")
    public String delete(Integer id) {
        service.delete(id);
        return "redirect:product_list.jsp";
    }

    @RequestMapping("/back/findById.product")
    public String findById(Integer id, ModelMap map) {
        Product p = new Product();
        p.setId(id);
        map.addAttribute("p", p);
        return "forward:product_modify.jsp";
    }

    @RequestMapping("/back/update.product")
    public String update(Product product) {
        service.update(product);
        return "redirect:findAll.product";
    }
}
