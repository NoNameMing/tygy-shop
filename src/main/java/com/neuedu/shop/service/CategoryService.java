package com.neuedu.shop.service;

import com.neuedu.shop.pojo.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    void delete(Integer id);
}
