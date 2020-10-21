package com.miao.security.config;

import com.miao.security.handler.AuthenticationSuccessHandler;
import com.miao.security.handler.MyLogoutHandler;
import com.miao.security.service.UserDetailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author Nie
 * @description: Spring security 配置，@EnableGlobalMethodSecurity 开启注解方式校验权限
 * @author: Niem
 * @date: 2020/10/19-9:51
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private UserDetailServiceImpl userDetailService;

    @Resource
    private DataSource dataSource;

    @Resource
    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Resource
    private MyLogoutHandler myLogoutHandler;

    /**
     * 配置密码解码器
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 用户详情配置
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
            // 退出登录配置，退出登录成功后同时也会删除数据库中rememberMe的token信息
        http.logout()
                // 退出登录成功后跳转的页面，如果不配置的话，默认跳转到 login 页面
                //.logoutSuccessUrl("/login")
                // 退出登录后删除指定的 cookie,可删除多个
                .deleteCookies("JSESSIONID")
                // 退出登录后进行的操作，和logoutSuccessUrl两者只能存在一个
                .logoutSuccessHandler(myLogoutHandler)
                .and()
                // 记住登录状态
                .rememberMe()
                // rememberMe传递参数名称
                .rememberMeParameter("remember-me")
                // remember-me-cookie名称
                .rememberMeCookieName("remember-me-cookie")
                // remember-me-token过期时间
                .tokenValiditySeconds(2*24*60*60)
                // 数据库持久化存储 remember-me-token
                .tokenRepository(persistentTokenRepository())
                .and()
                .csrf()
                .disable()
                // formLogin的方式登录
                .formLogin()
                // 登录成功后如何处理，和defaultSuccessUrl 两者只能存在一个
                .successHandler(authenticationSuccessHandler)
                // 登录页面指定，如果不指定则使用springSecurity默认的登录页
                .loginPage("/login")
                // 登录流程处理页面
                .loginProcessingUrl("/login")
                // 登录用户名默认参数名称
                .usernameParameter("username")
                // 登录密码默认参数名称
                .passwordParameter("password")
                // 登录成功后默认跳转页面
                //.defaultSuccessUrl("/index")
                // 登录失败跳转页面
                .failureUrl("/error")
                .and()
                .authorizeRequests()
                // 以下页面不需要授权，可以直接访问登录页
                .antMatchers("/login","login.html","/captcha").permitAll()
                // index 页面需要鉴权
                .antMatchers("/index").authenticated()
                // 权限表达式，配置globalAuthManager类的hasPermission()方法，进行全路径鉴权
                //.anyRequest().access("@globalAuthManager.hasPermission(request,authentication)");
                // 除了以上请求外，所有请求都需要通过校验
                .anyRequest().authenticated();
    }


    /**
     * 配置数据源，保存 remember-me-cookie
     * @return
     */
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        return jdbcTokenRepository;
    }
}
