package com.mybatis.utils;

import java.util.Base64;

public class CodeUtils {
    public static String base64(String str) throws Exception {
        byte[] bytes = str.getBytes();
        //Base64 加密
          String encoded = Base64.getEncoder().encodeToString(bytes);
          System.out.println("Base 64 加密后：" + encoded);
        //Base64 解密
        byte[] decoded = Base64.getDecoder().decode(bytes);
        String decodeStr = new String(decoded);
        System.out.println("Base 64 解密后：" + decodeStr);
        return decodeStr;
//          //另一种写法：
//          String frozen = (new BASE64Encoder()).encodeBuffer(str.getBytes());
//          System.out.println("另一种写法 加密后：" + frozen);
//          String defrozen = new String((new BASE64Decoder()).decodeBuffer(frozen));
//          System.out.println("另一种写法 解密后：" +  defrozen);
    }

}
