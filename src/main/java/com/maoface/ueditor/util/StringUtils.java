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

    public static boolean isNotEmpty(CharSequence str) {
        return !isEmpty(str);
    }

    public static void trim(String[] strs) {
        if (null != strs) {
            for(int i = 0; i < strs.length; ++i) {
                String str = strs[i];
                if (null != str) {
                    strs[i] = str.trim();
                }
            }

        }
    }

    private static boolean isNullOrUndefinedStr(CharSequence str) {
        String strString = str.toString().trim();
        return "null".equals(strString) || "undefined".equals(strString);
    }

    public static String nullToDefault(CharSequence str, String defaultStr) {
        return str == null ? defaultStr : str.toString();
    }

    public static String emptyToDefault(CharSequence str, String defaultStr) {
        return isEmpty(str) ? defaultStr : str.toString();
    }

    public static String blankToDefault(CharSequence str, String defaultStr) {
        return isBlank(str) ? defaultStr : str.toString();
    }

    public static String subBefore(CharSequence string, char separator, boolean isLastSeparator) {
        if (isEmpty(string)) {
            return null == string ? null : string.toString();
        } else {
            String str = string.toString();
            int pos = isLastSeparator ? str.lastIndexOf(separator) : str.indexOf(separator);
            if (-1 == pos) {
                return str;
            } else {
                return 0 == pos ? "" : str.substring(0, pos);
            }
        }
    }

    public static String subAfter(CharSequence string, CharSequence separator, boolean isLastSeparator) {
        if (isEmpty(string)) {
            return null == string ? null : string.toString();
        } else if (separator == null) {
            return "";
        } else {
            String str = string.toString();
            String sep = separator.toString();
            int pos = isLastSeparator ? str.lastIndexOf(sep) : str.indexOf(sep);
            return -1 != pos && string.length() - 1 != pos ? str.substring(pos + separator.length()) : "";
        }
    }

    public static String subBetween(CharSequence str, CharSequence before, CharSequence after) {
        if (str != null && before != null && after != null) {
            String str2 = str.toString();
            String before2 = before.toString();
            String after2 = after.toString();
            int start = str2.indexOf(before2);
            if (start != -1) {
                int end = str2.indexOf(after2, start + before2.length());
                if (end != -1) {
                    return str2.substring(start + before2.length(), end);
                }
            }

            return null;
        } else {
            return null;
        }
    }

    public static String subBetween(CharSequence str, CharSequence beforeAndAfter) {
        return subBetween(str, beforeAndAfter, beforeAndAfter);
    }
}
