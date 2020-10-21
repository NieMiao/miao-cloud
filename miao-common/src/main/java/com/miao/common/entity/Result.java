package com.miao.common.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Description: 全局返回对象
 * @Author: Niem
 * @Date: 2020/6/21-20:04
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {

    /**
     * 操作成功（true）或者失败（false）
     */
    private boolean success;

    /**
     * 封装的数据对象，传入vo或者自定义的Exception类
     */
    private  T data;


    /**
    * @Description: 返回执行成功标志，没有data数据 
    * @Param: []
    * @Return: cn.miao.hfadmin.entity.Result<java.lang.Object>
    * @Date: 2020/6/21
    */
    public static Result<Object> ok() {
        return new Result<>(true,null);
    }

    /**
    * @Description: 返回成功标志，并附加消息
    * @Param: [msg]
    * @Return: cn.miao.hfadmin.entity.Result<java.lang.String>
    * @Date: 2020/6/21
    */
    public static Result<String> ok(String msg) {
        return new Result<>(true,null);
    }
    
    /**
    * @Description: 返回执行成功标志，附加data数据
    * @Param: [data]
    * @Return: cn.miao.hfadmin.entity.Result<java.lang.Object>
    * @Date: 2020/6/21
    */
    public static Result<Object> ok(Object data) {
        return new Result<>(true,data);
    }

    /**
    * @Description: 返回执行失败标志
    * @Param: []
    * @Return: cn.miao.hfadmin.entity.Result<java.lang.String>
    * @Date: 2020/6/21
    */
    public static Result<Object> error() {
        return new Result<>(false,null);
    }

    public static Result<String> error(String msg) {
        return new Result<>(false,null);
    }
    
    /**
    * @Description: 返回执行失败标志，返回异常对象
    * @Param: [error]
    * @Return: cn.miao.hfadmin.entity.Result<cn.miao.hfadmin.entity.ErrorVO>
    * @Date: 2020/6/21
    */
    public static Result<ErrorVO> error(ErrorVO error) {
        return new Result<>(false,error);
    }

}
