package com.neuedu.shop.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Category implements Serializable {
    private static final long serialVersionUID = 1451767353966996205L;
    private Integer id;
    private String name;
    private String desc;
    private Integer pid;
    private boolean leaf;
    private Integer grade;
}
