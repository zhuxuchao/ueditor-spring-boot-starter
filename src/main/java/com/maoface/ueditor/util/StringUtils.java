package com.maoface.ueditor.util;

import cn.hutool.core.lang.Assert;

import java.util.Objects;

/**
 * @author zhuxuchao
 * @version 1.0
 * @since 2022/12/20
 */
public class StringUtils {

    public static String trim(String str) {
        return str != null ? str.trim() : null;
    }

    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    public static boolean anyEquals(String str, String... others) {
        Assert.notEmpty(others, "要比较的字符串数组不能是空");
        for (int i = 0; i < others.length; i++) {
            String other = others[i];
            if (Objects.equals(str, other)) {
                return true;
            }
        }
        return false;
    }
}
