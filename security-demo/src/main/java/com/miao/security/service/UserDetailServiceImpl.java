package com.miao.security.service;

import com.miao.common.enums.ErrorCode;
import com.miao.common.exception.BaseException;
import com.miao.security.entity.AuthUser;
import com.miao.security.mapper.SysMenuMapper;
import com.miao.security.mapper.SysRoleMapper;
import com.miao.security.mapper.SysUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 用户详情获取
 * @author: Niem
 * @date: 2020/10/19-14:48
 */
@RequiredArgsConstructor
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final SysUserMapper sysUserMapper;
    private final SysRoleMapper sysRoleMapper;
    private final SysMenuMapper sysMenuMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //加载基础用户信息
        AuthUser user = sysUserMapper.getUserByUsername(username);
        if (user == null) {
            throw new BaseException(ErrorCode.USER_IS_NOT_EXIST);
        }
        //加载用户角色列表
        List<String> roles = sysRoleMapper.getRolesByUsername(username);

        //加载用户权限列表
        List<String> menus = sysMenuMapper.getMenusByUsername(username);

        menus.addAll(roles);
        // 将权限字符串集合转化为权限列表
        user.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(String.join(",",menus)));

        return user;
    }
}
