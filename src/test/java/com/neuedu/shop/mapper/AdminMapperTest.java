package com.neuedu.shop.mapper;

import com.neuedu.shop.pojo.Admin;
import com.neuedu.shop.service.AdminService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class AdminMapperTest {

    @Autowired
    private AdminService service;

    @Test
    public void findAll() {
        Admin admin = new Admin();
        admin.setId(3);
        admin.setName("ut4");
        admin.setPassword("ut4");
    }
}