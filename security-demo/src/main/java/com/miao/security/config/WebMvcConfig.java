package com.miao.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @description: 页面跳转管理  
 * @author: Niem
 * @date: 2020/10/19-9:45
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {


    /**
     * 配置视图解析器
     * @return
     */
    @Bean
    public ViewResolver getViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("classpath:/templates");
        resolver.setSuffix(".html");
        return resolver;
    }


    /**
     * 配置视图映射
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/sysUser").setViewName("sysUser");
        registry.addViewController("/syslog").setViewName("syslog");
        registry.addViewController("/businessA").setViewName("businessA");
        registry.addViewController("/businessB").setViewName("businessB");
        registry.addViewController("/error").setViewName("error");
    }
}
