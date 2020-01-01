package com.neuedu.shop.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product implements Serializable {
    private static final long serialVersionUID = -7101932018831986161L;
    private Integer id;
    private String name;
    private String desc;
    private double normalprice;
    private double memberprice;
    private String imgpath;
    private Timestamp pdate; // 上架日期

    private Category category;

    public Product(String name, String desc, double normalprice, String imgpath, Category category) {
        this.name = name;
        this.desc = desc;
        this.normalprice = normalprice;
        this.imgpath = imgpath;
        this.category = category;
    }
}
