package com.miao.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description: 启动类
 * @author: Niem
 * @date: 2020/10/19-9:07
 */
@SpringBootApplication
@MapperScan("com.miao.security.mapper")
public class SecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class,args);
    }
}
