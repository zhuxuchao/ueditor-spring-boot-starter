package com.maoface.ueditor.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author zhuxuchao
 * @date 2020-04-02 10:46
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
public class UeditorProperties {
    /**
     * Ueditor后端服务映射地址
     */
    private String requestMappingPath = "/baidu/ueditor/action";
    /**
     * 上传图片配置项
     */
    @Autowired
    private UploadImageProperties uploadImageConfig;
    /**
     * 上传视频配置项
     */
    @Autowired
    private UploadVideoProperties uploadVideoConfig;
    /**
     * 上传附件配置项
     */
    @Autowired
    private UploadFileProperties uploadFileConfig;
    /**
     * 上传涂鸦图片配置项
     */
    @Autowired
    private UploadScrawlProperties uploadScrawlConfig;
    /**
     * 上传抓取远程图片配置项
     */
    @Autowired
    private UploadCatcherProperties uploadCatcherConfig;
    /**
     * 上传截图配置项
     */
    @Autowired
    private UploadSnapscreenProperties uploadSnapscreenConfig;
    /**
     * 列出指定目录下的图片
     */
    @Autowired
    private ImageManagerProperties imageManagerConfig;
    /**
     * 列出指定目录下的文件
     */
    @Autowired
    private FileManagerProperties fileManagerConfig;

    public String getRequestMappingPath() {
        return requestMappingPath;
    }

    public void setRequestMappingPath(String requestMappingPath) {
        this.requestMappingPath = requestMappingPath;
    }

    public UploadImageProperties getUploadImageConfig() {
        return uploadImageConfig;
    }

    public void setUploadImageConfig(UploadImageProperties uploadImageConfig) {
        this.uploadImageConfig = uploadImageConfig;
    }

    public UploadVideoProperties getUploadVideoConfig() {
        return uploadVideoConfig;
    }

    public void setUploadVideoConfig(UploadVideoProperties uploadVideoConfig) {
        this.uploadVideoConfig = uploadVideoConfig;
    }

    public UploadFileProperties getUploadFileConfig() {
        return uploadFileConfig;
    }

    public void setUploadFileConfig(UploadFileProperties uploadFileConfig) {
        this.uploadFileConfig = uploadFileConfig;
    }

    public UploadScrawlProperties getUploadScrawlConfig() {
        return uploadScrawlConfig;
    }

    public void setUploadScrawlConfig(UploadScrawlProperties uploadScrawlConfig) {
        this.uploadScrawlConfig = uploadScrawlConfig;
    }

    public UploadCatcherProperties getUploadCatcherConfig() {
        return uploadCatcherConfig;
    }

    public void setUploadCatcherConfig(UploadCatcherProperties uploadCatcherConfig) {
        this.uploadCatcherConfig = uploadCatcherConfig;
    }

    public UploadSnapscreenProperties getUploadSnapscreenConfig() {
        return uploadSnapscreenConfig;
    }

    public void setUploadSnapscreenConfig(UploadSnapscreenProperties uploadSnapscreenConfig) {
        this.uploadSnapscreenConfig = uploadSnapscreenConfig;
    }

    public ImageManagerProperties getImageManagerConfig() {
        return imageManagerConfig;
    }

    public void setImageManagerConfig(ImageManagerProperties imageManagerConfig) {
        this.imageManagerConfig = imageManagerConfig;
    }

    public FileManagerProperties getFileManagerConfig() {
        return fileManagerConfig;
    }

    public void setFileManagerConfig(FileManagerProperties fileManagerConfig) {
        this.fileManagerConfig = fileManagerConfig;
    }
}
