package com.neuedu.shop.service.impl;

import com.neuedu.shop.mapper.ProductMapper;
import com.neuedu.shop.pojo.Category;
import com.neuedu.shop.pojo.Product;
import com.neuedu.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> findAll() {
        return mapper.findAll();
    }

    @Override
    public void delete(Integer id) {
        mapper.delete(id);
    }

    @Override
    public void update(Product product) {
        mapper.update(product);
    };

    @Override
    public Product findById(Integer id) {
        return mapper.findById(id);
    };
}
