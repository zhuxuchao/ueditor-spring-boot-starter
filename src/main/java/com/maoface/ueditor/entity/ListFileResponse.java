package com.maoface.ueditor.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhuxuchao
 * @date 2020-04-15 21:19
 */
@Setter
@Getter
public class ListFileResponse extends BaseResponse {
    private int start;
    private int total;
    private List<FileItem> list;

    @Setter
    @Getter
    @Builder
    public static class FileItem implements Serializable {
        private String url;
    }
}
