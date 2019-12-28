package com.neuedu.shop.mapper;

import com.neuedu.shop.pojo.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper {
    List<Category> findAll();

    void delete(Integer id);
}
