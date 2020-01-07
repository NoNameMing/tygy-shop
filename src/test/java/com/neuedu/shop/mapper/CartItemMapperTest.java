package com.neuedu.shop.mapper;

import com.neuedu.shop.BaseTest;
import com.neuedu.shop.pojo.CartItem;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class CartItemMapperTest extends BaseTest {

    @Autowired
    private CartItemMapper mapper;

    @Test
    public void findByUserId() {
        List<CartItem> list = mapper.findByUserId(22);
        for (CartItem cartItem : list) {
            System.out.println(cartItem);
        }
    }

    @Test
    public void findAll() {
        Assert.assertNotEquals(0, mapper.findAll().size());
    }
}