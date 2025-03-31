package com.zhuxc.ueditor.util;

import java.util.Collection;

/**
 * 断言工具类
 * @auther zhuxc
 * @date 2025/3/21 13:51
 * @since 1.0
 */
public abstract class Assert {
    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void hasLength(String text, String message) {
        if (!(text != null && !text.isEmpty())) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void hasText(String text, String message) {
        if (!(text != null && !text.isBlank())) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void isEmpty(Collection<?> collection, String message) {
        if (collection != null && !collection.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void isNotEmpty(Collection<?> collection, String message) {
        if (collection == null || collection.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }
}
