package com.maoface.ueditor.entity;

import java.io.InputStream;
import java.io.Serializable;

/**
 * @author zhuxuchao
 * @date 2020-04-02 13:15
 */
public class InputStreamDetail implements Serializable {
    private InputStream inputStream;
    private String originFileName;
    private String suffix;

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String getOriginFileName() {
        return originFileName;
    }

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
