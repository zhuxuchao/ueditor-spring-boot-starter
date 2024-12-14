package com.zhuxc.ueditor.config;

import jakarta.annotation.Resource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * UEditor配置类
 * @author zhuxuchao
 * @since 2020-04-02 10:46
 */
@EnableConfigurationProperties({
        UploadImageProperties.class,
        UploadVideoProperties.class,
        UploadFileProperties.class,
        UploadSnapscreenProperties.class,
        UploadCatcherProperties.class,
        UploadScrawlProperties.class,
        FileManagerProperties.class,
        ImageManagerProperties.class
})
@ConfigurationProperties(prefix = "ueditor.config")
public class UEditorProperties {
    /**
     * UEditor后端服务映射地址
     */
    private String requestMappingPath = "/baidu/ueditor/action";
    /**
     * 上传图片配置项
     */
    @Resource
    private UploadImageProperties uploadImageProperties;
    /**
     * 上传视频配置项
     */
    @Resource
    private UploadVideoProperties uploadVideoProperties;
    /**
     * 上传附件配置项
     */
    @Resource
    private UploadFileProperties uploadFileProperties;
    /**
     * 上传涂鸦图片配置项
     */
    @Resource
    private UploadScrawlProperties uploadScrawlProperties;
    /**
     * 上传抓取远程图片配置项
     */
    @Resource
    private UploadCatcherProperties uploadCatcherProperties;
    /**
     * 上传截图配置项
     */
    @Resource
    private UploadSnapscreenProperties uploadSnapscreenProperties;
    /**
     * 列出指定目录下的图片
     */
    @Resource
    private ImageManagerProperties imageManagerProperties;
    /**
     * 列出指定目录下的文件
     */
    @Resource
    private FileManagerProperties fileManagerProperties;

    public String getRequestMappingPath() {
        return requestMappingPath;
    }

    public void setRequestMappingPath(String requestMappingPath) {
        this.requestMappingPath = requestMappingPath;
    }

    public UploadImageProperties getUploadImageProperties() {
        return uploadImageProperties;
    }

    public void setUploadImageProperties(UploadImageProperties uploadImageProperties) {
        this.uploadImageProperties = uploadImageProperties;
    }

    public UploadVideoProperties getUploadVideoProperties() {
        return uploadVideoProperties;
    }

    public void setUploadVideoProperties(UploadVideoProperties uploadVideoProperties) {
        this.uploadVideoProperties = uploadVideoProperties;
    }

    public UploadFileProperties getUploadFileProperties() {
        return uploadFileProperties;
    }

    public void setUploadFileProperties(UploadFileProperties uploadFileProperties) {
        this.uploadFileProperties = uploadFileProperties;
    }

    public UploadScrawlProperties getUploadScrawlProperties() {
        return uploadScrawlProperties;
    }

    public void setUploadScrawlProperties(UploadScrawlProperties uploadScrawlProperties) {
        this.uploadScrawlProperties = uploadScrawlProperties;
    }

    public UploadCatcherProperties getUploadCatcherProperties() {
        return uploadCatcherProperties;
    }

    public void setUploadCatcherProperties(UploadCatcherProperties uploadCatcherProperties) {
        this.uploadCatcherProperties = uploadCatcherProperties;
    }

    public UploadSnapscreenProperties getUploadSnapscreenProperties() {
        return uploadSnapscreenProperties;
    }

    public void setUploadSnapscreenProperties(UploadSnapscreenProperties uploadSnapscreenProperties) {
        this.uploadSnapscreenProperties = uploadSnapscreenProperties;
    }

    public ImageManagerProperties getImageManagerProperties() {
        return imageManagerProperties;
    }

    public void setImageManagerProperties(ImageManagerProperties imageManagerProperties) {
        this.imageManagerProperties = imageManagerProperties;
    }

    public FileManagerProperties getFileManagerProperties() {
        return fileManagerProperties;
    }

    public void setFileManagerProperties(FileManagerProperties fileManagerProperties) {
        this.fileManagerProperties = fileManagerProperties;
    }
}
