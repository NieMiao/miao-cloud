package com.miao.common.enums;

import cn.hutool.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * @Description: 聂淼
 * @Author: Niem
 * @Date: 2020/6/21-15:32
 */
@Getter
@AllArgsConstructor
public enum ErrorCode {

    /**
     * 未找到该资源
     */
    RESOURCE_NOT_FOUNT(1001, HttpStatus.HTTP_NOT_FOUND,"未找到该资源"),
    /**
     * 请求参数格式错误
     */
    PARAMS_FORMAT_INVALID(1002,HttpStatus.HTTP_BAD_REQUEST,"请求参数格式错误"),
    /**
     * 用户名不存在
     */
    USER_IS_NOT_EXIST(1003,HttpStatus.HTTP_NOT_FOUND,"用户名不存在！"),
    /**
     * 用户已被禁用
     */
    USER_IS_DISABLE(1003,HttpStatus.HTTP_UNAUTHORIZED,"用户已被禁用！"),
    /**
     * 存在非法字段
     */
    EXIST_ILLEGAL_CHARACTERS(1004,HttpStatus.HTTP_BAD_REQUEST,"存在非法字段"),

    /**
     * 远程接口调用出错
     */
    Interface_call_error(1005,HttpStatus.HTTP_INTERNAL_ERROR,"远程接口调用出错");

    private final int code;

    private final int httpStatus;

    private final String message;
}
