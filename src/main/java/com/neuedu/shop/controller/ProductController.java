package com.neuedu.shop.controller;

import com.neuedu.shop.pojo.Product;
import com.neuedu.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
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
        Product p = service.findById(id);
        map.addAttribute("p", p);
        return "forward:product_update.jsp";
    }

    @RequestMapping("/back/update.product")
    public String update(Product product) {
        service.update(product);
        return "redirect:findAll.product";
    }

    @RequestMapping("/back/insert.product")
    public String insert(Product product, @RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) {
        service.insert(product, file, request);
        return "redirect:findAll.product";
    }

    @RequestMapping("/back/search.product")
    public String findByKeywords(String keywords, ModelMap map) {
        List<Product> products = service.findByKeywords(keywords);
        map.addAttribute("products", products);
        return "forward:product_search.jsp";
    }

    @RequestMapping("/pre/index.product")
    public String lastedProduct(ModelMap map) {
        List<Product> lproducts = service.lastedProduct();
        List<Product> rproducts = service.findAll();
        map.addAttribute("lproducts", lproducts);
        map.addAttribute("rproducts", rproducts);
        return "forward:index.jsp";
    }

    @RequestMapping("/pre/detail.product")
    public String productDetail(Integer id, ModelMap map) {
        Product p = service.findById(id);
        map.addAttribute("p", p);
        return "forward:product_detail.jsp";
    }
}
