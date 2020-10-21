package com.miao.cloud.service;

import cn.hutool.core.collection.CollUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @description: 资源类
 * @author: Niem
 * @date: 2020/10/16-21:06
 */
@Service
public class ResourceServiceImpl {

    private Map<String, List<String>> resourceRolesMap;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @PostConstruct
    public void initData() {
        resourceRolesMap = new TreeMap<>();
        resourceRolesMap.put("/api/hello", CollUtil.toList("ADMIN"));
        resourceRolesMap.put("/api/user/currentUser", CollUtil.toList("ADMIN", "TEST"));
        redisTemplate.opsForHash().putAll("AUTH:RESOURCE_ROLES_MAP", resourceRolesMap);
    }
}
