package com.neuedu.shop.service.impl;

import com.neuedu.shop.common.CommonUtil;
import com.neuedu.shop.mapper.UserMapper;
import com.neuedu.shop.pojo.User;
import com.neuedu.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public List<User> findAll() {
        return mapper.findAll();
    }

    @Override
    public void insert(User user) {
        mapper.insert(user);
    }

    @Override
    public void delete(Integer id) {
        mapper.delete(id);
    }

    @Override
    public void delete(Integer[] ids) {
        for (int id : ids) {
            mapper.delete(id);
        }
    }

    @Override
    public void resetPassword(Integer id) {
        mapper.resetPassword(id);
    }

    @Override
    public User login(String name, String pwd) {
        User user = mapper.findByName(name);
        if(user != null && user.getPassword().equals(CommonUtil.getMD5(pwd))) {
            return user;
        }
        return null;
    }

//    @Override
//    public void addUser(User user) {
//        mapper.addUser(user);
//    }

}
