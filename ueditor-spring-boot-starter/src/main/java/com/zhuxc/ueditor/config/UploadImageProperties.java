package com.zhuxc.ueditor.config;

import com.zhuxc.ueditor.consts.Constants;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhuxuchao
 * @date 2020-04-15 16:01
 */
@ConfigurationProperties(prefix = "ueditor.config.upload-image-config")
public class UploadImageProperties {
    /**
     * 执行上传图片的action名称
     */
    private String imageActionName = Constants.Action.UPLOAD_IMAGE;
    /**
     * 提交的图片表单名称
     */
    private String imageFieldName = "upfile";
    /**
     * 上传大小限制,单位B,默认2MB，注意修改服务器的大小限制
     */
    private int imageMaxSize = 10240000;
    /**
     * 上传保存路径,可以自定义保存路径和文件名格式
     */
    private String imagePathFormat = "/ueditor/upload/image/{yyyy}{mm}{dd}{hh}{ii}{ss}{rand:6}";
    /**
     * 图片访问路径前缀
     */
    private String imageUrlPrefix = "";
    /**
     * 图片压缩最长边限制
     */
    private int imageCompressBorder = 1600;
    /**
     * 是否压缩图片
     */
    private boolean imageCompressEnable = true;
    /**
     * 插入的图片浮动方式
     */
    private String imageInsertAlign = "none";
    /**
     * 上传图片格式限制
     */
    private Set<String> imageAllowFiles = new HashSet<>(Arrays.asList(".png", ".jpg", ".jpeg", ".gif", ".bmp"));

    public String getImageActionName() {
        return imageActionName;
    }

    public void setImageActionName(String imageActionName) {
        this.imageActionName = imageActionName;
    }

    public String getImageFieldName() {
        return imageFieldName;
    }

    public void setImageFieldName(String imageFieldName) {
        this.imageFieldName = imageFieldName;
    }

    public int getImageMaxSize() {
        return imageMaxSize;
    }

    public void setImageMaxSize(int imageMaxSize) {
        this.imageMaxSize = imageMaxSize;
    }

    public String getImagePathFormat() {
        return imagePathFormat;
    }

    public void setImagePathFormat(String imagePathFormat) {
        this.imagePathFormat = imagePathFormat;
    }

    public String getImageUrlPrefix() {
        return imageUrlPrefix;
    }

    public void setImageUrlPrefix(String imageUrlPrefix) {
        this.imageUrlPrefix = imageUrlPrefix;
    }

    public int getImageCompressBorder() {
        return imageCompressBorder;
    }

    public void setImageCompressBorder(int imageCompressBorder) {
        this.imageCompressBorder = imageCompressBorder;
    }

    public boolean isImageCompressEnable() {
        return imageCompressEnable;
    }

    public void setImageCompressEnable(boolean imageCompressEnable) {
        this.imageCompressEnable = imageCompressEnable;
    }

    public String getImageInsertAlign() {
        return imageInsertAlign;
    }

    public void setImageInsertAlign(String imageInsertAlign) {
        this.imageInsertAlign = imageInsertAlign;
    }

    public Set<String> getImageAllowFiles() {
        return imageAllowFiles;
    }

    public void setImageAllowFiles(Set<String> imageAllowFiles) {
        this.imageAllowFiles = imageAllowFiles;
    }
}
