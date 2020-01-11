package com.neuedu.shop.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order implements Serializable {
    private static long serialVersionUID = -6538891887222435414L;

    private Integer id;

    private User user;

    private CartItem cartitem;

    private Product product;

    private Integer uid; // 用户id

    private String oid; // 订单id

    private String addr; // 订单地址

    private Timestamp odate; // 下单时间

    private int status; // 订单状态

    private List<Product> productList;
}
