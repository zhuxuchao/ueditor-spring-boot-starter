package com.maoface.ueditor.util;

import java.math.BigDecimal;

/**
 * @author zhuxuchao
 * @version 1.0
 * @since 2022/12/20
 */
public class NumberUtils {
    public static boolean equals(BigDecimal bigNum1, BigDecimal bigNum2) {
        return 0 == bigNum1.compareTo(bigNum2);
    }

    public static BigDecimal max(BigDecimal bigNum1, BigDecimal bigNum2) {
        int i = bigNum1.compareTo(bigNum2);
        return i >= 0 ? bigNum1 : bigNum2;
    }
}
