package com.miao.security.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @description: 菜单权限 mapper
 * @author: Niem
 * @date: 2020/10/19-15:16
 */
@Mapper
public interface SysMenuMapper {

    /**
     * 根据 username 获取所有的权限列表
     * @param username
     * @return
     */
    @Select("SELECT menu_url\n" +
            "FROM sys_menu sm left join sys_role_menu srm ON sm.pk_id=srm.menu_id\n" +
            "LEFT JOIN sys_role sr ON sr.pk_id = srm.role_id\n" +
            "LEFT JOIN sys_user_role sur ON sur.role_id = sr.pk_id\n" +
            "LEFT JOIN sys_user su ON su.pk_id = sur.user_id\n" +
            "WHERE username = #{username}")
    List<String> getMenusByUsername(@Param("username") String username);

}
