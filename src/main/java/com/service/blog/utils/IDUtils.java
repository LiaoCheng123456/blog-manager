package com.service.blog.utils;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class IDUtils {
    public static Long getId() {
        String ipAddress = "";

        try {
            //获取服务器IP地址
            ipAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String uuid = ipAddress + "$" + UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();

        long suffix = Math.abs(uuid.hashCode() % 100000000);

        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");

        String time = sdf.format(new Date(System.currentTimeMillis()));

        long prefix = Long.parseLong(time) * 100000000;

        return Long.parseLong(String.valueOf(prefix + suffix));
    }

    public static void main(String[] args) {
        System.out.println(getId());
    }
}
