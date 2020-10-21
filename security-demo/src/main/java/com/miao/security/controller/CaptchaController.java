package com.miao.security.controller;

import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:  验证码获取
 * @author: Niem
 * @date: 2020/10/20-15:21
 */
@RestController
public class CaptchaController {

    @GetMapping("/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CaptchaUtil.out(request,response);
    }
}
