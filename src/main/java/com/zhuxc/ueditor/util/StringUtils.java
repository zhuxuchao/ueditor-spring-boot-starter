package com.zhuxc.ueditor.util;

import cn.hutool.core.util.CharUtil;

import java.util.function.Predicate;

public class StringUtils {
    public static boolean isEmptyIfStr(Object obj) {
        if (null == obj) {
            return true;
        } else if (obj instanceof CharSequence) {
            return ((CharSequence) obj).isEmpty();
        } else {
            return false;
        }
    }

    public static void trim(String[] strs) {
        if (null != strs) {
            for (int i = 0; i < strs.length; ++i) {
                String str = strs[i];
                if (null != str) {
                    strs[i] = trim(str);
                }
            }

        }
    }

    public static String trim(CharSequence str) {
        return null == str ? null : trim(str, 0);
    }

    public static String trim(CharSequence str, int mode) {
        return trim(str, mode, CharUtil::isBlankChar);
    }

    public static String trim(CharSequence str, int mode, Predicate<Character> predicate) {
        String result;
        if (str == null) {
            result = null;
        } else {
            int length = str.length();
            int start = 0;
            int end = length;
            if (mode <= 0) {
                while (start < end && predicate.test(str.charAt(start))) {
                    ++start;
                }
            }

            if (mode >= 0) {
                while (start < end && predicate.test(str.charAt(end - 1))) {
                    --end;
                }
            }

            if (start <= 0 && end >= length) {
                result = str.toString();
            } else {
                result = str.toString().substring(start, end);
            }
        }

        return result;
    }
}
