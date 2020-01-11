package com.neuedu.shop.service;

import com.neuedu.shop.pojo.Order;
import org.aspectj.weaver.ast.Or;

import java.util.List;

public interface OrderService {
    /**
     * 查询所有订单的方法
     */
    List<Order> findAll();

    void insert(Order order);

    Order findOrderById(String orderId);
}
