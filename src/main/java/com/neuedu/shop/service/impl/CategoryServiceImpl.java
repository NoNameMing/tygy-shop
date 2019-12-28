package com.neuedu.shop.service.impl;

import com.neuedu.shop.mapper.CategoryMapper;
import com.neuedu.shop.pojo.Category;
import com.neuedu.shop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper mapper;

    @Override
    public List<Category> findAll() {
        return mapper.findAll();
    }

    @Override
    public void delete(Integer id) {
        mapper.delete(id);
    }
}
