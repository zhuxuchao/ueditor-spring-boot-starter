package com.maoface.ueditor.util;

/**
 * @author zhuxuchao
 * @version 1.0
 * @since 2022/12/20
 */
public class StringUtils {

    public static String trim(String str) {
        return str != null ? str.trim() : str;
    }

    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    public static boolean anyEquals(String str, String... others) {
        // TODO: 2023/1/27 需要实现给定字符串满足equals字符串数组任一元素的逻辑
        return false;
    }
}
