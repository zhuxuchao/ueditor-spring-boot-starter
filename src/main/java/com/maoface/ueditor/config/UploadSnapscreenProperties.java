package com.maoface.ueditor.config;

import com.maoface.ueditor.consts.Constants;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zhuxuchao
 * @date 2020-04-15 16:24
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "ueditor.config.upload-snapscreen-config")
public class UploadSnapscreenProperties {
    /**
     * 执行上传截图的action名称
     */
    @Setter(AccessLevel.NONE)
    private String snapscreenActionName = Constants.Action.UPLOAD_IMAGE;
    /**
     * 图片访问路径前缀
     */
    private String snapscreenUrlPrefix = "";
    /**
     * 上传保存路径,可以自定义保存路径和文件名格式
     */
    private String snapscreenPathFormat = "/ueditor/upload/image/{yyyy}{mm}{dd}{hh}{ii}{ss}{rand:6}";
    /**
     * 插入的图片浮动方式
     */
    private String snapscreenInsertAlign = "none";
}
