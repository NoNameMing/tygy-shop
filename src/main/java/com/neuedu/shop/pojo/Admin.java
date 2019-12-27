package com.neuedu.shop.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Admin implements Serializable {
    private static final long serialVersionUID = -4646071853932996952L;
    private Integer id;
    private String name;
    private String password;
}
