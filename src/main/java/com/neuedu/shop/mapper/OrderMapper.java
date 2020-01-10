package com.neuedu.shop.mapper;

import com.neuedu.shop.pojo.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    /**
     * 查询所有订单的方法
     */
    List<Order> findAll();

    /**
     * 建立一个新订单
     * @param order
     */
    void insert(Order order);
}
