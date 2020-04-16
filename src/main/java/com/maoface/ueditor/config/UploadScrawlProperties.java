package com.maoface.ueditor.config;

import com.maoface.ueditor.consts.Constants;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zhuxuchao
 * @date 2020-04-15 16:26
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "ueditor.config.upload-scrawl-config")
public class UploadScrawlProperties {
    /**
     * 执行上传涂鸦的action名称
     */
    @Setter(AccessLevel.NONE)
    private String scrawlActionName = Constants.Action.UPLOAD_SCRAWL;
    /**
     * 提交的图片表单名称
     */
    private String scrawlFieldName = "upfile";
    /**
     * 上传大小限制，单位B。 默认2MB，注意修改服务器的大小限制
     */
    private int scrawlMaxSize = 2048000;
    /**
     * 图片访问路径前缀
     */
    private String scrawlUrlPrefix = "";
    /**
     * 上传保存路径,可以自定义保存路径和文件名格式
     */
    private String scrawlPathFormat = "/ueditor/upload/image/{yyyy}{mm}{dd}{hh}{ii}{ss}{rand:6}";
    /**
     * 插入的图片浮动方式
     */
    private String scrawlInsertAlign = "none";
}
