package com.neuedu.shop.service.impl;

import com.neuedu.shop.BaseTest;
import com.neuedu.shop.mapper.UserMapper;
import com.neuedu.shop.pojo.Admin;
import com.neuedu.shop.pojo.User;
import com.neuedu.shop.service.UserService;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;


public class UserServiceImplTest extends BaseTest {

    @Autowired
    private UserMapper mapper;

    @Test
    public void findAll() {
    }

    @Test
    @Ignore
    public void insert() {
        User user = new User();
//        user.setId(1);
        user.setId(88);
        user.setName("test");
        user.setPassword("123");
        user.setAddr("地址测试");
        user.setPhone("13888888888");
        mapper.insert(user);
    }

    @Test
    @Transactional
    public void delete() {
        boolean res = mapper.delete(9);
        assertEquals(true, res);
    }

    @Test
    public void deletes() {
        Integer ids[] = {8, 13};
        for (int id : ids) {
            boolean res = mapper.delete(id);
            assertEquals(true, res);
        }
    }


}