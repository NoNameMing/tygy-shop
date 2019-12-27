package com.neuedu.shop.service;

import com.neuedu.shop.pojo.Admin;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AdminService {
    /**
     * 查询 t_admin 中的所有数据
     */
    List<Admin> findAll();
}
