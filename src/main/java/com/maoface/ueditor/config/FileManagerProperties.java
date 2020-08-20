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
 * @date 2020-04-15 16:26
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "ueditor.config.file-manager-config")
public class FileManagerProperties {
    /**
     * 执行文件管理的action名称
     */
    @Setter(AccessLevel.NONE)
    private String fileManagerActionName = Constants.Action.LIST_FILE;
    /**
     * 指定要列出文件的目录
     */
    private String fileManagerListPath = "/ueditor/upload/file/";
    /**
     * 文件访问路径前缀
     */
    private String fileManagerUrlPrefix = "";
    /**
     * 每次列出文件数量
     */
    private int fileManagerListSize = 10;
    /**
     * 列出的文件类型
     */
    private Set<String> fileManagerAllowFiles = new HashSet<>(Arrays.asList(".png", ".jpg", ".jpeg", ".gif", ".bmp",
            ".flv", ".swf", ".mkv", ".avi", ".rm", ".rmvb", ".mpeg", ".mpg",
            ".ogg", ".ogv", ".mov", ".wmv", ".mp4", ".webm", ".mp3", ".wav", ".mid",
            ".rar", ".zip", ".tar", ".gz", ".7z", ".bz2", ".cab", ".iso",
            ".doc", ".docx", ".xls", ".xlsx", ".ppt", ".pptx", ".pdf", ".txt", ".md", ".xml"));
}
