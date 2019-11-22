package com.service.blog.model;

import com.service.blog.paramenum.ResultCodeEnum;

/**
 * 统一返回工具类
 */
public class ResultUtils {
    private String code;
    private String msg;
    private Object data;

    public ResultUtils() {
        this.code = ResultCodeEnum.SUCCESS.toString();
        this.msg = ResultCodeEnum.SUCCESS.getDesc();
    }

    public ResultUtils(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultUtils(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
