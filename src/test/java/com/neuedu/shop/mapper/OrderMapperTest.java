package com.neuedu.shop.mapper;

import com.neuedu.shop.BaseTest;
import com.neuedu.shop.pojo.Order;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class OrderMapperTest extends BaseTest {

    @Autowired
    private OrderMapper mapper;

    @Test
    public void findAll() {
        List<Order> list = mapper.findAll();
        System.out.println("查到的订单：" + list);
    }
}