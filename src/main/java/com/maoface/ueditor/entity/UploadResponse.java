package com.maoface.ueditor.entity;

/**
 * @author zhuxuchao
 * @date 2020-04-02 14:24
 */
public class UploadResponse extends BaseResponse {
    private String url;
    private String title;
    private String original;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    @Override
    public String toString() {
        return "UploadResponse{" +
                "state='" + state + '\'' +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", original='" + original + '\'' +
                '}';
    }
}
