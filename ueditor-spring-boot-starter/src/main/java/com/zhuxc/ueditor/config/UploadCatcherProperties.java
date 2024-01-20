package com.zhuxc.ueditor.config;

import com.zhuxc.ueditor.consts.Constants;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhuxuchao
 * @date 2020-04-15 16:23
 */
@ConfigurationProperties(prefix = "ueditor.config.upload-catcher-config")
public class UploadCatcherProperties {
    /**
     * 执行抓取远程图片的action名称
     */
    private String catcherActionName = Constants.Action.CATCH_IMAGE;
    /**
     * 提交的图片列表表单名称
     */
    private String catcherFieldName = "source";
    /**
     * 上传大小限制，单位B。 默认2MB，注意修改服务器的大小限制
     */
    private int catcherMaxSize = 2048000;
    /**
     * 图片访问路径前缀
     */
    private String catcherUrlPrefix = "";
    /**
     * 上传保存路径,可以自定义保存路径和文件名格式
     */
    private String catcherPathFormat = "/ueditor/upload/image/{yyyy}{mm}{dd}{hh}{ii}{ss}{rand:6}";
    /**
     * 图片抓取域名
     */
    private Set<String> catcherLocalDomain = new HashSet<>(Arrays.asList("127.0.0.1", "localhost", "img.baidu.com"));
    /**
     * 抓取图片格式限制
     */
    private Set<String> catcherAllowFiles = new HashSet<>(Arrays.asList(".png", ".jpg", ".jpeg", ".gif", ".bmp"));

    public String getCatcherActionName() {
        return catcherActionName;
    }

    public void setCatcherActionName(String catcherActionName) {
        this.catcherActionName = catcherActionName;
    }

    public String getCatcherFieldName() {
        return catcherFieldName;
    }

    public void setCatcherFieldName(String catcherFieldName) {
        this.catcherFieldName = catcherFieldName;
    }

    public int getCatcherMaxSize() {
        return catcherMaxSize;
    }

    public void setCatcherMaxSize(int catcherMaxSize) {
        this.catcherMaxSize = catcherMaxSize;
    }

    public String getCatcherUrlPrefix() {
        return catcherUrlPrefix;
    }

    public void setCatcherUrlPrefix(String catcherUrlPrefix) {
        this.catcherUrlPrefix = catcherUrlPrefix;
    }

    public String getCatcherPathFormat() {
        return catcherPathFormat;
    }

    public void setCatcherPathFormat(String catcherPathFormat) {
        this.catcherPathFormat = catcherPathFormat;
    }

    public Set<String> getCatcherLocalDomain() {
        return catcherLocalDomain;
    }

    public void setCatcherLocalDomain(Set<String> catcherLocalDomain) {
        this.catcherLocalDomain = catcherLocalDomain;
    }

    public Set<String> getCatcherAllowFiles() {
        return catcherAllowFiles;
    }

    public void setCatcherAllowFiles(Set<String> catcherAllowFiles) {
        this.catcherAllowFiles = catcherAllowFiles;
    }
}
