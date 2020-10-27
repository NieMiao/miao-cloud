package com.miao.auth.mapper;


import com.miao.auth.entity.AuthUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @description: 用户信息 mapper
 * @author: Niem
 * @date: 2020/10/19-15:35
 */
@Mapper
public interface SysUserMapper {

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    @Select("select username,password,enabled from sys_user where username = #{username}")
    AuthUser getUserByUsername(@Param("username") String username);
}
