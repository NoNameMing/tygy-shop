package com.neuedu.shop.service;

import com.neuedu.shop.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    void insert(User user);

    void delete(Integer id);

    void delete(Integer[] ids);

    void resetPassword(Integer id);
}
