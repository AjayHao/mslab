package com.ajayhao.mslab.crawler.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;

import java.io.InputStream;
import java.security.MessageDigest;

/**
 * MD5工具类
 */
public class MD5Utils {

    private static Logger log = LoggerFactory.getLogger(MD5Utils.class);

    private static final char[] HEX = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    public static String encode(String source) {
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f' };
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(source.getBytes("UTF-8"));
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            log.error("MD5Util.encode error,source is {}", source, e);
            return null;
        }
    }

    public static boolean isValid(String encPass, String rawPass) {
        if (encPass.equals(rawPass)) {
            return true;
        }
        return MD5Utils.encode(rawPass).equals(encPass);
    }

    // 对输入流做摘要
    public static String getMd5(InputStream is) {
        try {
            return DigestUtils.md5DigestAsHex(is);
        } catch (Exception e) {
            return null;
        }
    }

}
