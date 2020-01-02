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

    @Override
    public void addRootCategory(Category category) {
        mapper.addRootCategory(category);
    }

    @Override
    public List<Category> findToTree() {
        return mapper.findToTree();
    }

    @Override
    public void addChildCategory(String name, String desc, int pid) {
        // 查父级别的 grade
        int grade = mapper.findByParentId(pid);
        // 添加操作
        mapper.addChildCategory(new Category(name, desc, pid, grade+1));
        // 将父节点的 leaf 状态更改
        mapper.updateParent(pid);
    }

    @Override
    public Category findById(int id) {
        Category category = mapper.findById(id);
        return category;
    }

    @Override
    public void modifyCategoryDesc(Category category) {
        mapper.modifyCategoryDesc(category);
    }

    @Override
    public List<Category> findThree() {
        return mapper.findThree();
    }
}
