package com.maoface.ueditor.util;

import cn.hutool.core.util.ArrayUtil;

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

    public static BigDecimal add(Number... values) {
        if (ArrayUtil.isEmpty(values)) {
            return BigDecimal.ZERO;
        } else {
            Number value = values[0];
            BigDecimal result = new BigDecimal(null == value ? "0" : value.toString());

            for(int i = 1; i < values.length; ++i) {
                value = values[i];
                if (null != value) {
                    result = result.add(new BigDecimal(value.toString()));
                }
            }
            return result;
        }
    }
}
