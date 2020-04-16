package com.maoface.ueditor.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author zhuxuchao
 * @date 2020-04-15 21:25
 */
@Getter
@Setter
public class CatchImageResponse extends BaseResponse {
    private List<CatchImageItem> list;

    @Getter
    @Setter
    @Builder
    public static class CatchImageItem {
        private String url;
        private String source;
        private String state;
    }
}
