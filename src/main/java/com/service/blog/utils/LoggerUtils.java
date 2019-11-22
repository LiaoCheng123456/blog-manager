package com.service.blog.utils;

import com.alibaba.fastjson.JSON;
import com.service.blog.model.ResultUtils;
import com.service.blog.paramenum.ResultCodeEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.PrintWriter;
import java.io.StringWriter;

public class LoggerUtils {
    private static Logger logger = LogManager.getLogger();
    public static String error(String requestParam, Exception e) {
        if (e != null) {
            e.printStackTrace();
        }
        logger.error("\n方法出错" + "【" + Thread.currentThread().getStackTrace()[2].getMethodName() + "】\n请求参数为：" + requestParam + "\n异常信息为：" + getTrace(e));
        return JSON.toJSONString(new ResultUtils(ResultCodeEnum.SYSTEMERROR.toString(), ResultCodeEnum.SYSTEMERROR.getDesc()));
    }

    /**
     * 获取异常信息
     * @param t
     * @return
     */
    private static String getTrace(Throwable t) {
        StringWriter stringWriter= new StringWriter();
        PrintWriter writer= new PrintWriter(stringWriter);
        t.printStackTrace(writer);
        StringBuffer buffer= stringWriter.getBuffer();
        return buffer.toString();
    }
}
