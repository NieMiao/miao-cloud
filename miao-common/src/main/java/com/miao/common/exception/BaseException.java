package com.miao.common.exception;

import com.miao.common.enums.ErrorCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 基础异常类
 * @Author: Niem
 * @Date: 2020/6/21-15:15
 */
@Getter
@Setter
public class BaseException extends RuntimeException {

    private final ErrorCode code;

    private final Map<String,String> detail = new HashMap<>();

    /**
    * @Description: 基础异常，无附加信息
    * @Param: [code]
    * @Return:
    * @Date: 2020/6/21
    */
    public BaseException(ErrorCode code) {
        this.code = code;
    }

    /**
    * @Description: 基础异常附加额外信息
    * @Param: [code, data]
    * @Return: 
    * @Date: 2020/6/21
    */
    public BaseException(ErrorCode code,Map<String,String> params) {
        this.code = code;
        if (!ObjectUtils.isEmpty(params)) {
            this.detail.putAll(params);
        }
    }
    /**
    * @Description: 异常附加描述信息
    * @Param: [code, msg]
    * @Return: 
    * @Date: 2020/6/23
    */
    public BaseException(ErrorCode code,String msg) {
        this.code = code;
        HashMap<String,String> map = new HashMap<>();
        map.put("description",msg);
        detail.putAll(map);
    }

}
