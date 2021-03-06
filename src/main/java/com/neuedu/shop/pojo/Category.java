package com.neuedu.shop.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

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
    /**
     * 存放该类别子类别的容器
     */
    private List<Category> children;

    public Category(String name, String desc, Integer pid, Integer grade) {
        this.name = name;
        this.desc = desc;
        this.pid = pid;
        this.grade = grade;
    }
}
