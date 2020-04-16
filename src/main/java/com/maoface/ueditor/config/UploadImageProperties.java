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
 * @date 2020-04-15 16:01
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "ueditor.config.upload-image-config")
public class UploadImageProperties {
    /**
     * 执行上传图片的action名称
     */
    @Setter(AccessLevel.NONE)
    private String imageActionName = Constants.Action.UPLOAD_IMAGE;
    /**
     * 提交的图片表单名称
     */
    private String imageFieldName = "upfile";
    /**
     * 上传大小限制,单位B,默认2MB，注意修改服务器的大小限制
     */
    private int imageMaxSize = 2048000;
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
}
