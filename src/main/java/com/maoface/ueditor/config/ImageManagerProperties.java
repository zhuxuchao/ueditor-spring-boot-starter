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
 * @date 2020-04-15 16:27
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "ueditor.config.image-manager-config")
public class ImageManagerProperties {
    /**
     * 执行图片管理的action名称
     */
    @Setter(AccessLevel.NONE)
    private String imageManagerActionName = Constants.Action.LIST_IMAGE;
    /**
     * 指定要列出图片的目录
     */
    private String imageManagerListPath = "/ueditor/upload/image/";
    /**
     * 图片访问路径前缀
     */
    private String imageManagerUrlPrefix = "";
    /**
     * 插入的图片浮动方式
     */
    private String imageManagerInsertAlign = "none";
    /**
     * 每次列出文件数量
     */
    private int imageManagerListSize = 10;
    /**
     * 列出的文件类型
     */
    private Set<String> imageManagerAllowFiles = new HashSet<>(Arrays.asList(".png", ".jpg", ".jpeg", ".gif", ".bmp"));
}
