package com.miao.auth.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @description: 角色Mapper
 * @author: Niem
 * @date: 2020/10/19-15:06
 */
@Mapper
public interface SysRoleMapper {

    /**
     * 通过 username获取角色列表
     * @param username
     * @return
     */
    @Select("select role_code\n" +
            "from sys_role sr left join sys_user_role sur on sr.pk_id=sur.role_id\n" +
            "left join sys_user su on sur.user_id=su.pk_id\n" +
            "where username = #{username}")
    List<String> getRolesByUsername(@Param("username") String username);


}
