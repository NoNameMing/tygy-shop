package com.neuedu.shop.mapper;

import com.neuedu.shop.pojo.CartItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemMapper {

    /**
     * 添加购物项
     * @param cartItem
     */
    void insert(CartItem cartItem);

    /**
     * 查询所有购物车的接口，不准备实现
     * @return
     */
    List<CartItem> findAll();

    /**
     * 查询单个用户的购物车
     * @return
     */
    List<CartItem> findByUserId(Integer userId);

    /**
     * 更新购物车数量
     * @param cartItem
     */
    void update(CartItem cartItem);
}
