package com.neuedu.shop.mapper;

import com.neuedu.shop.BaseTest;
import com.neuedu.shop.common.OrderUtil;
import com.neuedu.shop.pojo.Order;
import com.neuedu.shop.pojo.Product;
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

    @Test
    public void insert() {
        Order order = new Order();
        order.setOid(OrderUtil.generateOrder());
        mapper.insert(order);
    }

    @Test
    public void findById() {
        System.out.println(mapper.findOrderById("GSPT578658756855846"));
    }

    @Test
    public void findOrderById() {
        Order order = mapper.findOrderById("GSPT578669812547347");
//        List<Product> products = order.getProductList();
        System.out.println(order.getCartitem());
    }
}