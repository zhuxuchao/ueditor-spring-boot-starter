package com.maoface.ueditor.util;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONUtil;
import com.maoface.ueditor.config.UeditorProperties;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

import static com.maoface.ueditor.consts.Constants.CALLBACK_NAME_REGEX;

/**
 * @author zhuxuchao
 * @date 2020-04-15 20:35
 */
public abstract class UeditorUtils {
    public static final char EXTENSION_SEPARATOR = '.';

    /**
     * callback参数验证
     *
     * @param callbackName
     */
    public static boolean validCallbackName(String callbackName) {
        return callbackName.matches(CALLBACK_NAME_REGEX);
    }

    /**
     * 生成配置项
     *
     * @param properties
     * @param callbackName
     * @return
     */
    public static String callbackConfig(UeditorProperties properties, String callbackName) {
        Map<String, Object> config = new HashMap<>();

        config.putAll(BeanUtil.beanToMap(properties.getUploadImageConfig()));
        config.putAll(BeanUtil.beanToMap(properties.getUploadVideoConfig()));
        config.putAll(BeanUtil.beanToMap(properties.getUploadFileConfig()));
        config.putAll(BeanUtil.beanToMap(properties.getUploadCatcherConfig()));
        config.putAll(BeanUtil.beanToMap(properties.getUploadScrawlConfig()));
        config.putAll(BeanUtil.beanToMap(properties.getUploadSnapscreenConfig()));
        config.putAll(BeanUtil.beanToMap(properties.getFileManagerConfig()));
        config.putAll(BeanUtil.beanToMap(properties.getImageManagerConfig()));

        return callbackStr(config, callbackName);
    }

    public static String callbackStr(Object response, String callbackName) {
        final String str = JSONUtil.toJsonStr(response);
        if (!StringUtils.hasText(callbackName) || !validCallbackName(callbackName)) {
            return str;
        }
        return callbackName + "(" + str + ");";
    }

    /**
     * 获取文件名后缀<br>
     * --> .jpg <br>
     * --> .txt
     * @param originalFileName
     * @return
     */
    public static String getSuffix(String originalFileName) {
        final int i = originalFileName.lastIndexOf(EXTENSION_SEPARATOR);
        if (i > 0) {
            return originalFileName.substring(i);
        }
        return "";
    }
}
