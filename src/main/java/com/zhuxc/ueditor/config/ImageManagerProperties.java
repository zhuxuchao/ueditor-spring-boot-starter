package com.zhuxc.ueditor.config;

import com.zhuxc.ueditor.consts.Constants;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 图片管理相关配置
 * @author zhuxuchao
 * @date 2020-04-15 16:27
 */
@ConfigurationProperties(prefix = "ueditor.config.image-manager-config")
public class ImageManagerProperties {
    /**
     * 执行图片管理的action名称
     */
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

    public String getImageManagerActionName() {
        return imageManagerActionName;
    }

    public void setImageManagerActionName(String imageManagerActionName) {
        this.imageManagerActionName = imageManagerActionName;
    }

    public String getImageManagerListPath() {
        return imageManagerListPath;
    }

    public void setImageManagerListPath(String imageManagerListPath) {
        this.imageManagerListPath = imageManagerListPath;
    }

    public String getImageManagerUrlPrefix() {
        return imageManagerUrlPrefix;
    }

    public void setImageManagerUrlPrefix(String imageManagerUrlPrefix) {
        this.imageManagerUrlPrefix = imageManagerUrlPrefix;
    }

    public String getImageManagerInsertAlign() {
        return imageManagerInsertAlign;
    }

    public void setImageManagerInsertAlign(String imageManagerInsertAlign) {
        this.imageManagerInsertAlign = imageManagerInsertAlign;
    }

    public int getImageManagerListSize() {
        return imageManagerListSize;
    }

    public void setImageManagerListSize(int imageManagerListSize) {
        this.imageManagerListSize = imageManagerListSize;
    }

    public Set<String> getImageManagerAllowFiles() {
        return imageManagerAllowFiles;
    }

    public void setImageManagerAllowFiles(Set<String> imageManagerAllowFiles) {
        this.imageManagerAllowFiles = imageManagerAllowFiles;
    }
}
