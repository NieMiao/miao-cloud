package com.miao.security.exception;

import com.miao.common.entity.ErrorVO;
import com.miao.common.entity.Result;
import com.miao.common.exception.BaseException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @description: 异常捕获
 * @author: Niem
 * @date: 2020/10/20-9:31
 */
@RestControllerAdvice
public class SecurityExceptionHandler  {


    @ExceptionHandler(BaseException.class)
    public Result<ErrorVO> baseException(BaseException e, HttpServletRequest request) {
        ErrorVO errorVO = new ErrorVO(e,request.getRequestURI());
        return Result.error(errorVO);
    }
}
