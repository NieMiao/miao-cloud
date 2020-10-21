package com.miao.cloud.service;

import cn.hutool.core.collection.CollUtil;
import com.miao.cloud.entity.SecurityUser;
import com.miao.cloud.entity.User;
import com.miao.common.enums.ErrorCode;
import com.miao.common.exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 查询用户信息
 * @author: Niem
 * @date: 2020/10/16-19:05
 */
@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private List<User> userList;

    /**
     * @PostConstruct 注解用于在方法上，当 javabean 的依赖注入完成之后执行被注释修饰的方法，在此阶段一般用来初始化 javaBean
     */
    @PostConstruct
    private void initData() {
        // 创建固定密码
        String password = passwordEncoder.encode("123456");
        // 创建几个内存用户
        userList = new ArrayList<>();
        userList.add(new User(1L,"zhangSan",password,1, CollUtil.toList("Admin")));
        userList.add(new User(1L,"zhangSan",password,1, CollUtil.toList("Admin")));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 判断传入的 username 是否和内存 username 可以匹配上
        List<User> users = userList.stream()
                .filter(item -> item.getUsername()
                        .equals(username))
                .collect(Collectors.toList());
        // 如果为空
        if (users.isEmpty()) {
            throw new BaseException(ErrorCode.USER_IS_NOT_EXIST);
        }
        // 这里返回的 SecurityUser 是 UserDetails 接口的实现类，后期会修改
        SecurityUser securityUser = new SecurityUser(users.get(0));
        if (!securityUser.isEnabled()) {
            throw new BaseException(ErrorCode.USER_IS_DISABLE);
        }else if (!securityUser.isAccountNonExpired()) {
            throw new BaseException(ErrorCode.USER_IS_DISABLE);
        }else if (!securityUser.isAccountNonLocked()) {
            throw new BaseException(ErrorCode.USER_IS_DISABLE);
        }else if (!securityUser.isCredentialsNonExpired()) {
            throw new BaseException(ErrorCode.USER_IS_DISABLE);
        }
        return securityUser;
    }
}
