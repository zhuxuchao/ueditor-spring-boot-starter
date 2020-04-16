package com.maoface.ueditor.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.InputStream;
import java.io.Serializable;

/**
 * @author zhuxuchao
 * @date 2020-04-02 13:15
 */
@Getter
@Setter
@Builder
public class InputStreamDetail implements Serializable {
    private InputStream inputStream;
    private String originFileName;
    private String suffix;
}
