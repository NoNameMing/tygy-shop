package com.neuedu.shop.service;

import com.neuedu.shop.pojo.Category;
import com.neuedu.shop.pojo.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void delete(Integer id);

    void update(Product product);

    Product findById(Integer id);
}
