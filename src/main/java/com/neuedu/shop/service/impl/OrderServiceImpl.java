package com.neuedu.shop.service.impl;

import com.neuedu.shop.common.OrderUtil;
import com.neuedu.shop.mapper.OrderMapper;
import com.neuedu.shop.pojo.Order;
import com.neuedu.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper mapper;

    @Override
    public List findAll() {
        return mapper.findAll();
    }

    @Override
    public void insert(Order order) {
        mapper.insert(order);
    }

    @Override
    public Order findOrderById(String orderId) {
        return mapper.findOrderById(orderId);
    }
}
