package com.neuedu.shop.mapper;

import com.neuedu.shop.pojo.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMapper {
    /**
     * 查询 t_admin 中的所有数据
     */
    List<Admin> findAll();

    void delete(Integer id);

    void resetPassword(Integer id);

    void addAdmin(Admin admin);
}
