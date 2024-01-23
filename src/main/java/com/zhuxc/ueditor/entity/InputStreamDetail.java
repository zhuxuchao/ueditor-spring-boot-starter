package com.zhuxc.ueditor.entity;

import java.io.InputStream;
import java.io.Serializable;

/**
 * 输入流详情
 * @author zhuxuchao
 * @since 2020-04-02 13:15
 */
public class InputStreamDetail implements Serializable {
    /**
     * 输入流
     */
    private InputStream inputStream;
    /**
     * 原始文件名
     */
    private String originFileName;
    /**
     * 后缀
     */
    private String suffix;

    public InputStream getInputStream() {
        return inputStream;
    }

    /**
     * 设置文件流
     * @param inputStream 文件流
     */
    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String getOriginFileName() {
        return originFileName;
    }

    /**
     * 设置文件名
     * @param originFileName 文件名
     */
    public void setOriginFileName(String originFileName) {
        this.originFileName = originFileName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
