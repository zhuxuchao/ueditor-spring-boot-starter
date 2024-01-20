package com.zhuxc.ueditor.config;

import com.zhuxc.ueditor.consts.Constants;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhuxuchao
 * @date 2020-04-15 16:17
 */
@ConfigurationProperties(prefix = "ueditor.config.upload-file-config")
public class UploadFileProperties {
    /**
     * 执行上传视频的action名称
     */
    private String fileActionName = Constants.Action.UPLOAD_FILE;
    /**
     * 提交的文件表单名称
     */
    private String fileFieldName = "upfile";
    /**
     * 上传大小限制，单位B，默认10MB，注意修改服务器的大小限制
     */
    private int fileMaxSize = 10240000;
    /**
     * 文件访问路径前缀
     */
    private String fileUrlPrefix = "";
    /**
     * 上传保存路径,可以自定义保存路径和文件名格式
     */
    private String filePathFormat = "/ueditor/upload/file/{yyyy}{mm}{dd}{hh}{ii}{ss}{rand:6}";
    /**
     * 上传文件格式限制
     */
    private Set<String> fileAllowFiles = new HashSet<>(Arrays.asList(".png", ".jpg", ".jpeg", ".gif", ".bmp",
            ".flv", ".swf", ".mkv", ".avi", ".rm", ".rmvb", ".mpeg", ".mpg",
            ".ogg", ".ogv", ".mov", ".wmv", ".mp4", ".webm", ".mp3", ".wav", ".mid",
            ".rar", ".zip", ".tar", ".gz", ".7z", ".bz2", ".cab", ".iso",
            ".doc", ".docx", ".xls", ".xlsx", ".ppt", ".pptx", ".pdf", ".txt", ".md", ".xml"));

    public String getFileActionName() {
        return fileActionName;
    }

    public void setFileActionName(String fileActionName) {
        this.fileActionName = fileActionName;
    }

    public String getFileFieldName() {
        return fileFieldName;
    }

    public void setFileFieldName(String fileFieldName) {
        this.fileFieldName = fileFieldName;
    }

    public int getFileMaxSize() {
        return fileMaxSize;
    }

    public void setFileMaxSize(int fileMaxSize) {
        this.fileMaxSize = fileMaxSize;
    }

    public String getFileUrlPrefix() {
        return fileUrlPrefix;
    }

    public void setFileUrlPrefix(String fileUrlPrefix) {
        this.fileUrlPrefix = fileUrlPrefix;
    }

    public String getFilePathFormat() {
        return filePathFormat;
    }

    public void setFilePathFormat(String filePathFormat) {
        this.filePathFormat = filePathFormat;
    }

    public Set<String> getFileAllowFiles() {
        return fileAllowFiles;
    }

    public void setFileAllowFiles(Set<String> fileAllowFiles) {
        this.fileAllowFiles = fileAllowFiles;
    }
}
