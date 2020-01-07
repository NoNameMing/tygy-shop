package com.neuedu.shop.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartItem implements Serializable {
    private static long serialVersionUID = 8789886302935563531L;

    private Integer id;

    private User user; // Integer id

    private Integer userid;

    private Product product;

    private Integer productid;

    private Integer pcount;

    private double memberprice;

    private Timestamp itemDate; // 添加购物车的时间
}
