package com.maoface.ueditor.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zhuxuchao
 * @date 2020-04-15 20:08
 */
@Getter
@Setter
public class BaseResponse implements Response {
    String state;

    public BaseResponse() {
    }

    public BaseResponse(String state) {
        this.state = state;
    }
}
