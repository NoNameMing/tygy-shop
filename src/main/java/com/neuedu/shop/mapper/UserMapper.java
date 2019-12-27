package com.neuedu.shop.mapper;

import com.neuedu.shop.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    public List<User> findAll();
}
