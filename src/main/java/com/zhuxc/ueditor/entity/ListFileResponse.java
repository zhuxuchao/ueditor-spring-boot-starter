package com.zhuxc.ueditor.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 文件管理响应对象
 * @author zhuxuchao
 * @since 2020-04-15 21:19
 */
public class ListFileResponse extends BaseResponse {
    /**
     * 开始索引
     */
    private int start;
    /**
     * 文件总数量
     */
    private int total;
    /**
     * 文件列表
     */
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

    /**
     * 文件对象
     */
    public static class FileItem implements Serializable {
        /**
         * 路径
         */
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
