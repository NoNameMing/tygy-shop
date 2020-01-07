package com.neuedu.shop.mapper;

import com.neuedu.shop.BaseTest;
import com.neuedu.shop.pojo.Category;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;


public class CategoryMapperTest extends BaseTest {

    @Autowired
    CategoryMapper categoryMapper;

    @Test
    public void countChild() { // 删除功能第一步：看有没有孩子
        Category middleCategory = categoryMapper.findById(14);
        System.out.println("该结点总孩子数量：" + categoryMapper.countChild(middleCategory.getId())); // step1
        System.out.println("该结点父亲结点孩子的数量：" + categoryMapper.judgeParentStatus(middleCategory.getPid())); // step3
    }

    @Test
    public void testUpdateLeaf() {
        categoryMapper.updateParent(15); // 设为非叶子结点
        Category category = categoryMapper.findById(15);
        System.out.println("测试设为非叶子结点功能，false就成功了：" + category.isLeaf());

        categoryMapper.updateParentAfterDelete(category.getId()); // 设为叶子结点
        category = categoryMapper.findById(15);
        System.out.println("测试设为叶子结点功能，true就成功了：" + category.isLeaf());
    }
}