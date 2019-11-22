package com.service.blog.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.service.blog.constbag.Const;
import com.service.blog.model.ResultUtils;
import com.service.blog.paramenum.NumberEnum;
import com.service.blog.paramenum.ResultCodeEnum;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class ParameterUtils {

    /**
     * this is check multi between parameter whether have one null parameter
     *
     * @param model must parameter
     * @param args  must check of parameter
     * @return if result is null then just normal. else just parameter exception
     */
    public static String checkParam(Object model, String... args) {

        if (model == null) {
            return JSON.toJSONString(new ResultUtils(ResultCodeEnum.PARAM_ERROR.toString(), ResultCodeEnum.PARAM_ERROR.getDesc()));
        }

        try {

            HashMap map = JSON.parseObject(JSON.toJSONString(model), HashMap.class);

            StringBuilder sb = new StringBuilder();

            sb.append(ResultCodeEnum.PARAM_ERROR.getDesc());

            for (int i = 0; args != null && i < args.length; i++) {
                if (map.get(args[i]) == null) {
                    sb.append(String.format(Const.FORMAT_PARAM, args[i]));
                }
            }

            if (sb.toString().length() == 4) {
                return null;
            } else {
                return JSON.toJSONString(new ResultUtils(ResultCodeEnum.PARAM_ERROR.toString(), sb.toString()));
            }
        } catch (JSONException jsonException) {
            return JSON.toJSONString(new ResultUtils(ResultCodeEnum.JSON_EXCEPTION.toString(), ResultCodeEnum.JSON_EXCEPTION.getDesc()));
        }
    }

    /**
     * hash MD5
     *
     * @param string encrypt parameter
     * @return encrypt result
     */
    public static String md5(String string) {

        if (string.isEmpty()) return Const.STRING_DEFAULT;

        StringBuffer buf = null;

        try {

            MessageDigest md = MessageDigest.getInstance(Const.MD5);

            md.update(string.getBytes());

            byte[] b = md.digest();

            int i;

            buf = new StringBuffer(Const.STRING_DEFAULT);

            for (byte item : b) {

                i = item;

                if (i < NumberEnum.ZERO_.VALUE)

                    i += NumberEnum.SIZE_256.VALUE;

                if (i < NumberEnum.SIXTEEN.VALUE)

                    buf.append(NumberEnum.ZERO_.VALUE);

                buf.append(Integer.toHexString(i));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        assert buf != null;

        return buf.toString();
    }
}
