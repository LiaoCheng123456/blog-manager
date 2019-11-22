package com.service.blog.paramenum;

public enum ResultCodeEnum {

    SYSTEMERROR("SYSTEMERROR", "系统超时"),
    PARAM_ERROR("PARAM_ERROR", "参数错误"),
    JSON_EXCEPTION("JSON_EXCEPTION", "JSON错误"),
    AUTH_ERROR("AUTH_ERROR", "身份信息错误"),
    SUCCESS("SUCCESS", "200"),
    FREQUENCY_LIMITED("FREQUENCY_LIMITED", "频率限制");

    private String desc;
    private String value;

    ResultCodeEnum(String value, String desc) {
        this.desc = desc;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
