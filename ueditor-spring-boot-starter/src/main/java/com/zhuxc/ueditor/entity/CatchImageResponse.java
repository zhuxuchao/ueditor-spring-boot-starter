package com.zhuxc.ueditor.entity;

import java.util.List;

/**
 * @author zhuxuchao
 * @date 2020-04-15 21:25
 */
public class CatchImageResponse extends BaseResponse {
    private List<CatchImageItem> list;

    public List<CatchImageItem> getList() {
        return list;
    }

    public void setList(List<CatchImageItem> list) {
        this.list = list;
    }

    public static class CatchImageItem {
        private String url;
        private String source;
        private String state;

        public CatchImageItem() {
        }

        public CatchImageItem(String url, String source, String state) {
            this.url = url;
            this.source = source;
            this.state = state;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }
    }
}
