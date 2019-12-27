package com.neuedu.shop.service.impl;

import com.neuedu.shop.mapper.AdminMapper;
import com.neuedu.shop.pojo.Admin;
import com.neuedu.shop.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<Admin> findAll() {
        return adminMapper.findAll();
    }
}
