package com.service.blog.constbag;

public class Const {

    // 格式化适用的字符串
    public static final String FORMAT_PARAM = "%s,";
    public static final String DOT = ".";

    // 用来校验不能为空的参数
    public static final String MUST_PARAM_TITLE = "title";
    public static final String ID = "id";
    public static final String MUST_PARAM_CONTENT = "content";
    public static final String MUST_PARAM_USERNAME = "username";
    public static final String MUST_PARAM_PASSWORD = "password";
    public static final String MUST_PARAM_AUTHOR = "author";

    // controller 公用头
    public static final String HEADERS = "Accept=*/*";
    public static final String PRODUCES_JSON = "application/json;charset=UTF-8";

    // boolean
    public static final boolean TRUE = true;
    public static final boolean FALSE = false;

    // 加密方式
    public static final String MD5 = "md5";
    public static final String STRING_DEFAULT = "";
}
