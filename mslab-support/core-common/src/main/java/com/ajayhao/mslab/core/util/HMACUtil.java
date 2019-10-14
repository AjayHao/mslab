package com.ajayhao.mslab.core.util;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * @ClassName HMACUtil
 * @Description HMAC摘要算法
 * @Author Ajay Hao
 * @Date 2018/6/21 15:27
 * @Version 1.0
 **/
public class HMACUtil {
    private static final String MAC_NAME = "HmacSHA1";
    private static final String ENCODING = "UTF-8";

    /**
     * 加密
     * @param key
     * @param text
     * @return
     * @throws Exception
     */
    public static String encode(String key, String text) throws Exception{
        Mac mac = Mac.getInstance(MAC_NAME);
        mac.init(new SecretKeySpec(key.getBytes(ENCODING), MAC_NAME));
        return bytes2Hex(mac.doFinal(text.getBytes(ENCODING)));
    }

    public static String bytes2Hex(byte[] bytes) {
        String hex = "";
        for (int n = 0; n < bytes.length; n++) {
            String byteStr = (Integer.toHexString(bytes[n] & 0XFF));
            if (byteStr.length() == 1) {
                hex = hex + "0" + byteStr;
            } else {
                hex = hex + byteStr;
            }
        }
        return hex.toLowerCase();
    }
}
