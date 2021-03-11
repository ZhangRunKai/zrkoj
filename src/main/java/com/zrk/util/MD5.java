package com.zrk.util;

import org.springframework.util.DigestUtils;

public class MD5 {
    private final static String salt = "asdasdohyndba";

    public static String getMD5(String message){
        String base = message + "/" + salt;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }
}
