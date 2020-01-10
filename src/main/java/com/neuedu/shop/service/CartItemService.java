package com.neuedu.shop.service;

import com.neuedu.shop.pojo.CartItem;

import javax.servlet.http.HttpSession;
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

    /**
     * 从购物车中删除信息
     * @param cartItem
     */
    void delete(CartItem cartItem, HttpSession session);

    /**
     * 更新购物车数量
     *
     */
    void update(CartItem cartItem);

}
