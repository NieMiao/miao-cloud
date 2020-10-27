package com.miao.auth.controller;

import com.miao.auth.config.Auth2Config;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.KeyPair;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;

/**
 * @description: 获取公钥对
 * @author: Niem
 * @date: 2020/10/27-8:20
 */
@RestController
public class KeyPairController {

    @Autowired
    private Auth2Config auth2Config;

    @GetMapping("/rsa/publicKey")
    public Map<String, Object> getKey() {
        KeyPair keyPair = auth2Config.keyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAKey key = new RSAKey.Builder(publicKey).build();
        return new JWKSet(key).toJSONObject();
    }
}
