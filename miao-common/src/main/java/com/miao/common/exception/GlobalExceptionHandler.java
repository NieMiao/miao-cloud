package com.miao.common.exception;

import com.miao.common.entity.ErrorVO;
import com.miao.common.entity.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 全局异常处理类
 * @Author: Niem
 * @Date: 2020/6/21-20:46
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
    * @description: 捕获BaseException异常
    * @param: [e, request]
    * @return: com.nie.gmall.common.entity.Result<com.nie.gmall.common.entity.ErrorVO>
    * @date: 2020/8/1
    */
    @ExceptionHandler(BaseException.class)
    public Result<ErrorVO> baseException(BaseException e, HttpServletRequest request) {
        ErrorVO errorVO = new ErrorVO(e,request.getRequestURI());
        return Result.error(errorVO);
    }

}
