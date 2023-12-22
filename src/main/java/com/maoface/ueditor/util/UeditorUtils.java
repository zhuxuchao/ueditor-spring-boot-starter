package com.maoface.ueditor.util;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONUtil;
import com.maoface.ueditor.config.UeditorProperties;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static com.maoface.ueditor.consts.Constants.CALLBACK_NAME_REGEX;

/**
 * @author zhuxuchao
 * @date 2020-04-15 20:35
 */
public class UeditorUtils {
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
     * @param properties 配置对象
     * @param callbackName JS回调函数名
     * @return jsonp字符串
     */
    public static String callbackConfig(UeditorProperties properties, String callbackName) {
        Map<String, Object> config = new HashMap<>(16);

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

    public static void upload(byte[] bytes, String path) throws IOException {
        final File resource = new File(path);
        if (!resource.exists()) {
            resource.getParentFile().mkdirs();
        }
        FileOutputStream outputStream = new FileOutputStream(resource);
        outputStream.write(bytes);
        outputStream.close();
    }

    /**
     * 获取文件名后缀<br>
     * --> .jpg <br>
     * --> .txt
     *
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

    public static boolean validHost(String hostname, Collection<String> filters) {
        try {
            InetAddress ip = InetAddress.getByName(hostname);
            if (ip.isSiteLocalAddress()) {
                return false;
            }
        } catch (UnknownHostException e) {
            return false;
        }
        return !filters.contains(hostname);
    }
}
