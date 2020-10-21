package com.miao.security.service;

import com.miao.security.mapper.SysMenuMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @description: 全局权限校验
 * @author: Niem
 * @date: 2020/10/19-16:03
 */
@Service
@RequiredArgsConstructor
public class GlobalAuthManager {

    private final SysMenuMapper sysMenuMapper;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        // 被验证的用户主体
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails) {
            // 获取username
            String username = ((UserDetails) principal).getUsername();
            //根据username获得权限列表
            List<String> menus = sysMenuMapper.getMenusByUsername(username);

            String requestURI = request.getRequestURI();

            boolean b = menus.stream().anyMatch(
                    url -> antPathMatcher.match(url, requestURI)
            );
            return b;
        }
        return false;
    }
}
