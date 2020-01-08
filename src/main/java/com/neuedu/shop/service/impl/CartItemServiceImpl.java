package com.neuedu.shop.service.impl;

import com.neuedu.shop.mapper.CartItemMapper;
import com.neuedu.shop.pojo.CartItem;
import com.neuedu.shop.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemMapper mapper;

    @Override
    public List<CartItem> findByUserId(Integer userId) {
        return mapper.findByUserId(userId);
    }

    @Override
    public void insert(CartItem cartItem) {
        List<CartItem> cartItems = findByUserId(cartItem.getUserid());
        for (CartItem c : cartItems) {
            if (c.getProductid().equals(cartItem.getProductid())) {
                c.setPcount(c.getPcount() + cartItem.getPcount());
                return;
            }
        }
        // 如果不是，再加新的
        mapper.insert(cartItem);
    }
}
