package com.neuedu.shop.service;

import com.neuedu.shop.pojo.CartItem;

import java.util.List;

public interface CartItemService {

    /**
     * 查询单个用户的购物车
     * @return
     */
    List<CartItem> findByUserId(Integer userId);

    /**
     * 添加购物项
     * @param cartItem
     */
    void insert(CartItem cartItem);
}
