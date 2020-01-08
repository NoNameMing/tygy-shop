package com.neuedu.shop.mapper;

import com.neuedu.shop.BaseTest;
import com.neuedu.shop.pojo.CartItem;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@Transactional
//@Rollback(false)
public class CartItemMapperTest extends BaseTest {

    @Autowired
    private CartItemMapper mapper;

    @Test
    public void findByUserId() {
        List<CartItem> list = mapper.findByUserId(28);
        for (CartItem cartItem : list) {
//            cartItem.setUserid(cartItem.getUser().getId());
//            cartItem.setPcount(cartItem.getProduct().getId());
            System.out.println(cartItem);
        }
    }

    @Test
    public void findAll() {
        Assert.assertNotEquals(0, mapper.findAll().size());
    }


    @Test
    public void update() {
        List<CartItem> list = mapper.findByUserId(28);
        for (CartItem cartItem : list) {
            if (cartItem.getProduct().getId().equals(19)) {
//                cartItem.setUserid(cartItem.getUser().getId()); // 正确
//                cartItem.setProductid(cartItem.getProduct().getId()); // 正确
                cartItem.setPcount(5);
                mapper.update(cartItem);
                System.out.println("更新后的商品：" + cartItem.getPcount());
            }
        }
    }
}