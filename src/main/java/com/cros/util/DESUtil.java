package com.cros.util;

/**
 * Created by Administrator on 2017/5/21.
 */
public class DESUtil {
    public static String decrypt(String v) {
        return v+"_DES";
    }

    public static String encrypt(String v) {
        return v+ "_ENC";
    }
}
