package com.miao.common.entity;

import com.miao.common.enums.ErrorCode;
import com.miao.common.exception.BaseException;
import lombok.*;
import org.springframework.util.ObjectUtils;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 异常实体
 * @Author: Niem
 * @Date: 2020/6/21-20:36
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ErrorVO {

    /**
     * 异常编码
     */
    private Integer code;
    /**
     * http状态码
     */
    private Integer httpStatus;
    /**
     * 信
     */
    private String message;
    /**
     * 发生异常的请求
     */
    private String path;
    /**
     * 异常发生时间戳
     */
    private Instant timestamp;
    /**
     * 异常附加信息
     */
    private Map<String, String> detail;

    /**
    * @Description: 返回异常对象无附加信息
    * @Param: [e, path]
    * @Return:
    * @Date: 2020/6/21
    */
    public ErrorVO(BaseException e, String path) {
        this.code = e.getCode().getCode();
        this.httpStatus = e.getCode().getHttpStatus();
        this.timestamp = Instant.now();
        this.path = path;
        this.message = e.getCode().getMessage();
        detail = new HashMap<>();
        if (ObjectUtils.isEmpty(e.getDetail())){
            this.detail = null;
        }else {
            this.detail.putAll(e.getDetail());
        }
    }

    /**
    * @description: 返回异常对象 使用errorCode构建
    * @param: [e, path, map]
    * @return:
    * @date: 2020/8/1
    */
    public ErrorVO(ErrorCode e, String path, HashMap<String,String> map) {
        this.code = e.getCode();
        this.httpStatus = e.getHttpStatus();
        this.timestamp = Instant.now();
        this.path = path;
        this.message = e.getMessage();
        detail = new HashMap<>();
        if (ObjectUtils.isEmpty(map)){
            this.detail = null;
        }else {
            this.detail.putAll(map);
        }
    }
}
