package com.miao.cloud.utils;

import com.miao.cloud.entity.SecurityUser;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: jwt 增强
 * @author: Niem
 * @date: 2020/10/16-20:40
 */
public class JwtTokenEnhancer implements TokenEnhancer {

    /**
     * 增强方法，将用户信息追加到token中，比如用户名，Id，权限集合
     * @param accessToken
     * @param authentication
     * @return
     */
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        SecurityUser securityUser = (SecurityUser) authentication.getPrincipal();
        Map<String, Object> info = new HashMap<>();
        //把用户名设置到JWT中
        info.put("username", securityUser.getUsername());
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
        return accessToken;
    }
}
