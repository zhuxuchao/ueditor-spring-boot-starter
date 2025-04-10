package com.zhuxc.ueditor.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

/**
 * @auther zhuxc
 * @date 2025/4/10 10:15
 * @since 1.0
 */
public class ApplicationContextUtil {
    private static ApplicationContext context;

    public ApplicationContextUtil() {
    }

    public void setApplicationContext(ApplicationContext context) throws BeansException {
        ApplicationContextUtil.context = context;
    }

    public static ApplicationContext getContext() {
        return context;
    }
}
