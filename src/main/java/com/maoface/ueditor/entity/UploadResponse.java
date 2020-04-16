package com.maoface.ueditor.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zhuxuchao
 * @date 2020-04-02 14:24
 */
@Getter
@Setter
public class UploadResponse extends BaseResponse {
    private String url;
    private String title;
    private String original;
}
