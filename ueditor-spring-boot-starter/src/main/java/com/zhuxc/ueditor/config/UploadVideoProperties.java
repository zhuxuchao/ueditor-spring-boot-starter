package com.zhuxc.ueditor.config;

import com.zhuxc.ueditor.consts.Constants;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhuxuchao
 * @date 2020-04-15 16:10
 */
@ConfigurationProperties(prefix = "ueditor.config.upload-video-config")
public class UploadVideoProperties {
    /**
     * 执行上传视频的action名称
     */
    private String videoActionName = Constants.Action.UPLOAD_VIDEO;
    /**
     * 提交的视频表单名称
     */
    private String videoFieldName = "upfile";
    /**
     * 上传大小限制，单位B，默认100MB。注意修改服务器的大小限制
     */
    private int videoMaxSize = 102400000;
    /**
     * 视频访问路径前缀
     */
    private String videoUrlPrefix = "";
    /**
     * 上传保存路径,可以自定义保存路径和文件名格式
     */
    private String videoPathFormat = "/ueditor/upload/video/{yyyy}{mm}{dd}{hh}{ii}{ss}{rand:6}";
    /**
     * 上传视频格式限制
     */
    private Set<String> videoAllowFiles = new HashSet<>(Arrays.asList(".flv", ".swf", ".mkv", ".avi", ".rm", ".rmvb",
            ".mpeg", ".mpg", ".ogg", ".ogv", ".mov", ".wmv", ".mp4", ".webm", ".mp3", ".wav", ".mid"));

    public String getVideoActionName() {
        return videoActionName;
    }

    public void setVideoActionName(String videoActionName) {
        this.videoActionName = videoActionName;
    }

    public String getVideoFieldName() {
        return videoFieldName;
    }

    public void setVideoFieldName(String videoFieldName) {
        this.videoFieldName = videoFieldName;
    }

    public int getVideoMaxSize() {
        return videoMaxSize;
    }

    public void setVideoMaxSize(int videoMaxSize) {
        this.videoMaxSize = videoMaxSize;
    }

    public String getVideoUrlPrefix() {
        return videoUrlPrefix;
    }

    public void setVideoUrlPrefix(String videoUrlPrefix) {
        this.videoUrlPrefix = videoUrlPrefix;
    }

    public String getVideoPathFormat() {
        return videoPathFormat;
    }

    public void setVideoPathFormat(String videoPathFormat) {
        this.videoPathFormat = videoPathFormat;
    }

    public Set<String> getVideoAllowFiles() {
        return videoAllowFiles;
    }

    public void setVideoAllowFiles(Set<String> videoAllowFiles) {
        this.videoAllowFiles = videoAllowFiles;
    }
}
