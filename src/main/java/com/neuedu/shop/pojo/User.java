package com.neuedu.shop.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -3130038793228632674L;
    private Integer id;
    private String name;
    private String password;
    private String phone;
    private String addr;
    private Timestamp rdate;
}
