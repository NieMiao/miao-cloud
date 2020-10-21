package com.miao.security.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: 退出登录处理
 * @author: Niem
 * @date: 2020/10/20-12:58
 */
@Component
public class MyLogoutHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest
            , HttpServletResponse httpServletResponse
            , Authentication authentication) throws IOException, ServletException {
        httpServletResponse.sendRedirect("/login");
    }
}
