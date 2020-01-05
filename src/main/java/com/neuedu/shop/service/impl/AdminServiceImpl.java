package com.neuedu.shop.service.impl;

import com.neuedu.shop.mapper.AdminMapper;
import com.neuedu.shop.pojo.Admin;
import com.neuedu.shop.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.neuedu.shop.common.CommonUtil.getMD5;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<Admin> findAll() {
        return adminMapper.findAll();
    }

    @Override
    public void delete(Integer id) {
        adminMapper.delete(id);
    }

    @Override
    public void resetPassword(Integer id) {
        adminMapper.resetPassword(id);
    }

    @Override
    public void addAdmin(Admin admin) {
        adminMapper.addAdmin(admin);
    }

    @Override
    public Admin login(String name, String pwd) {
        Admin admin = adminMapper.findByName(name);
        if (admin != null && admin.getPassword().equals(getMD5(pwd))) {
            return admin;
        } else {
            return null;
        }
    }

    @Override
    public int countAdmin() {
        return adminMapper.countAdmin();
    }


}
