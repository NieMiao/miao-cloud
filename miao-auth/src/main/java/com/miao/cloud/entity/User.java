package com.miao.cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: Niem
 * @date: 2020/10/16-19:07
 */
@Data
@AllArgsConstructor
public class User {
    private Long id;
    private String username;
    private String password;
    private Integer status;
    private List<String> roles;
}
