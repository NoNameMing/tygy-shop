package com.neuedu.shop.mapper;

import com.neuedu.shop.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    List<User> findAll();

    boolean insert(User user);

    boolean delete(Integer id);

    void resetPassword(Integer id);
}
