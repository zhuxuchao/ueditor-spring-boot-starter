package com.maoface.ueditor.config;

import com.maoface.ueditor.consts.Constants;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhuxuchao
 * @date 2020-04-15 16:23
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "ueditor.config.upload-catcher-config")
public class UploadCatcherProperties {
    /**
     * 执行抓取远程图片的action名称
     */
    @Setter(AccessLevel.NONE)
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
}
