package com.miao.cloud.controller;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.KeyPair;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;

/**
 * @description: 获取公钥的接口,由于我们的网关服务需要RSA的公钥来验证签名是否合法，所以认证服务需要有个接口把公钥暴露出来；
 * @author: Niem
 * @date: 2020/10/16-20:55
 */
@Controller
public class KeyPairController {

    @Autowired
    private KeyPair keyPair;

    @GetMapping("/rsa/publicKey")
    public Map<String, Object> getKey() {
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAKey key = new RSAKey.Builder(publicKey).build();
        return new JWKSet(key).toJSONObject();
    }
}
