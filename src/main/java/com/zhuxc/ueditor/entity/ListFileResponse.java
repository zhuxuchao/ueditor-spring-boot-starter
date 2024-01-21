package com.zhuxc.ueditor.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhuxuchao
 * @date 2020-04-15 21:19
 */

public class ListFileResponse extends BaseResponse {
    private int start;
    private int total;
    private List<FileItem> list;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<FileItem> getList() {
        return list;
    }

    public void setList(List<FileItem> list) {
        this.list = list;
    }

    public static class FileItem implements Serializable {
        private String url;

        public FileItem() {
        }

        public FileItem(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
