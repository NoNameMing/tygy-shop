package com.neuedu.shop.service;

import com.neuedu.shop.pojo.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    void delete(Integer id);

    void addRootCategory(Category category);

    List<Category> findToTree();

    void addChildCategory(String name, String desc, int pid);

    Category findById(int id);

    void modifyCategoryDesc(Category category);

    List<Category> findThree();
}
