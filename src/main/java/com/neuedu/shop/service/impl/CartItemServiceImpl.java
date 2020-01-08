package com.neuedu.shop.service.impl;

import com.neuedu.shop.mapper.CartItemMapper;
import com.neuedu.shop.pojo.CartItem;
import com.neuedu.shop.service.CartItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
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
        try {
            List<CartItem> cartItems = findByUserId(cartItem.getUserid());
            for (CartItem c : cartItems) {
                if (c.getProduct().getId().equals(cartItem.getProductid())) {
                    c.setPcount(c.getPcount() + 1);
                    mapper.update(c);
                    return;
                }
            }
            // 如果不是，再加新的
            mapper.insert(cartItem);
        } catch (Exception e) {
            log.error(String.valueOf(e));
            e.printStackTrace();
        }

    }
}
