package com.neuedu.shop.mapper;

import com.neuedu.shop.BaseTest;
import com.neuedu.shop.pojo.Category;
import com.neuedu.shop.pojo.Product;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class ProductMapperTest extends BaseTest {

    @Autowired
    ProductMapper mapper;

    @Test
    public void findById() {
        Product product = mapper.findById(14);
        System.out.println(product);
    }

    @Test
    public void update() {
        Product product = new Product();
        product.setId(2);
        product.setDesc("HELLO");
        product.setName("TEST");
        mapper.update(product);
    }

    @Test
    public void countByParentId() {
        Product product = mapper.findById(14);
        System.out.println(product.getCategory().getId());
        System.out.println(mapper.countByParentId(product.getCategory().getId()));
    }
}