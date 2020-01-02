package com.neuedu.shop.service;

import com.neuedu.shop.pojo.Category;
import com.neuedu.shop.pojo.Product;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void delete(Integer id);

    void update(Product product);

    Product findById(Integer id);

    void insert(Product product, CommonsMultipartFile file, HttpServletRequest request);

    List<Product> findByKeywords(String keywords);
}
