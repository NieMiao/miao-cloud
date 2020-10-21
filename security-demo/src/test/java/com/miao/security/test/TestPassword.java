package com.miao.security.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @description:
 * @author: Niem
 * @date: 2020/10/19-18:39
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestPassword {

    @Resource
    PasswordEncoder passwordEncoder;

    @Test
    public void passwordEncoder() {
        String encode = passwordEncoder.encode("123456");
        System.out.println(encode);
    }


}
