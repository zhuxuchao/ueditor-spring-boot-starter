package com.maoface.ueditor.util;


import org.springframework.util.Assert;

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

    public static boolean isBlank(CharSequence str) {
        int length;
        if (str != null && (length = str.length()) != 0) {
            for (int i = 0; i < length; ++i) {
                if (!isBlankChar(str.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }

    public static boolean isBlankChar(int c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c) || c == 65279 || c == 8234;
    }

    public static boolean isNotBlank(CharSequence str) {
        return !isBlank(str);
    }

    public static boolean hasBlank(CharSequence... strs) {
        if (strs == null || strs.length == 0) {
            return true;
        } else {
            CharSequence[] var1 = strs;
            int var2 = strs.length;

            for (int var3 = 0; var3 < var2; ++var3) {
                CharSequence str = var1[var3];
                if (isBlank(str)) {
                    return true;
                }
            }

            return false;
        }
    }

    public static boolean isAllBlank(CharSequence... strs) {
        if (strs == null || strs.length == 0) {
            return true;
        } else {
            CharSequence[] var1 = strs;
            int var2 = strs.length;

            for (int var3 = 0; var3 < var2; ++var3) {
                CharSequence str = var1[var3];
                if (isNotBlank(str)) {
                    return false;
                }
            }

            return true;
        }
    }
}
