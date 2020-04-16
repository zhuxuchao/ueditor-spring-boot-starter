package com.maoface.ueditor.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author zhuxuchao
 * @date 2020-04-02 10:46
 */
@Setter
@Getter
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
}
