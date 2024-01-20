package com.zhuxc.ueditor.config;

import com.zhuxc.ueditor.consts.Constants;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zhuxuchao
 * @date 2020-04-15 16:26
 */
@ConfigurationProperties(prefix = "ueditor.config.upload-scrawl-config")
public class UploadScrawlProperties {
    /**
     * 执行上传涂鸦的action名称
     */
    private String scrawlActionName = Constants.Action.UPLOAD_SCRAWL;
    /**
     * 提交的图片表单名称
     */
    private String scrawlFieldName = "upfile";
    /**
     * 上传大小限制，单位B。 默认2MB，注意修改服务器的大小限制
     */
    private int scrawlMaxSize = 10240000;
    /**
     * 图片访问路径前缀
     */
    private String scrawlUrlPrefix = "";
    /**
     * 上传保存路径,可以自定义保存路径和文件名格式
     */
    private String scrawlPathFormat = "/com/zhuxc/ueditor/upload/image/{yyyy}{mm}{dd}{hh}{ii}{ss}{rand:6}";
    /**
     * 插入的图片浮动方式
     */
    private String scrawlInsertAlign = "none";

    public String getScrawlActionName() {
        return scrawlActionName;
    }

    public void setScrawlActionName(String scrawlActionName) {
        this.scrawlActionName = scrawlActionName;
    }

    public String getScrawlFieldName() {
        return scrawlFieldName;
    }

    public void setScrawlFieldName(String scrawlFieldName) {
        this.scrawlFieldName = scrawlFieldName;
    }

    public int getScrawlMaxSize() {
        return scrawlMaxSize;
    }

    public void setScrawlMaxSize(int scrawlMaxSize) {
        this.scrawlMaxSize = scrawlMaxSize;
    }

    public String getScrawlUrlPrefix() {
        return scrawlUrlPrefix;
    }

    public void setScrawlUrlPrefix(String scrawlUrlPrefix) {
        this.scrawlUrlPrefix = scrawlUrlPrefix;
    }

    public String getScrawlPathFormat() {
        return scrawlPathFormat;
    }

    public void setScrawlPathFormat(String scrawlPathFormat) {
        this.scrawlPathFormat = scrawlPathFormat;
    }

    public String getScrawlInsertAlign() {
        return scrawlInsertAlign;
    }

    public void setScrawlInsertAlign(String scrawlInsertAlign) {
        this.scrawlInsertAlign = scrawlInsertAlign;
    }
}
