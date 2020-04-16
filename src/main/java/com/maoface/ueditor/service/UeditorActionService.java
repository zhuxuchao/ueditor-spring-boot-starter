package com.maoface.ueditor.service;

import cn.hutool.core.io.FileUtil;
import com.maoface.ueditor.config.FileManagerProperties;
import com.maoface.ueditor.config.ImageManagerProperties;
import com.maoface.ueditor.config.UploadCatcherProperties;
import com.maoface.ueditor.config.UploadFileProperties;
import com.maoface.ueditor.config.UploadImageProperties;
import com.maoface.ueditor.config.UploadScrawlProperties;
import com.maoface.ueditor.config.UploadSnapscreenProperties;
import com.maoface.ueditor.config.UploadVideoProperties;
import com.maoface.ueditor.entity.BaseResponse;
import com.maoface.ueditor.entity.InputStreamDetail;
import com.maoface.ueditor.util.UeditorUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * @author zhuxuchao
 * @date 2020-04-02 11:48
 */
public interface UeditorActionService {
    /**
     * 解析request对象包含的文件流详情
     * @param request
     * @return
     */
    default InputStreamDetail resolveRequest(HttpServletRequest request, String uploadFiledName) throws IOException {
        MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
        final Map<String, MultipartFile> fileMap = req.getFileMap();
        final MultipartFile multipartFile = fileMap.get(uploadFiledName);
        final String originalFilename = multipartFile.getOriginalFilename();
        final String suffix = UeditorUtils.getSuffix(originalFilename);
        final InputStream inputStream = multipartFile.getInputStream();
        return InputStreamDetail.builder()
                .suffix(suffix)
                .originFileName(originalFilename)
                .inputStream(inputStream)
                .build();
    }

    /**
     * 上传图片
     * @param streamDetail 文件流
     * @return
     */
    BaseResponse uploadImage(InputStreamDetail streamDetail, UploadImageProperties properties) throws IOException;

    /**
     * 上传视频
     * @param streamDetail 文件流
     * @return
     */
    BaseResponse uploadVideo(InputStreamDetail streamDetail, UploadVideoProperties properties) throws IOException;

    /**
     * 上传附件
     * @param streamDetail 文件流
     * @return
     */
    BaseResponse uploadFile(InputStreamDetail streamDetail, UploadFileProperties properties) throws IOException;

    /**
     * 上传涂鸦
     * @param streamDetail 文件流
     * @return
     */
    BaseResponse uploadScrawl(InputStreamDetail streamDetail, UploadScrawlProperties properties) throws IOException;

    /**
     * 上传截图
     * @param streamDetail 文件流
     * @return
     */
    BaseResponse uploadSnapscreen(InputStreamDetail streamDetail, UploadSnapscreenProperties properties) throws IOException;

    /**
     * 文件管理
     * @param properties
     * @param start
     * @param size
     * @return
     */
    BaseResponse listFile(FileManagerProperties properties, int start, int size) throws IOException;

    /**
     * 图片管理
     * @param properties
     * @param start
     * @param size
     * @return
     */
    BaseResponse listImage(ImageManagerProperties properties, int start, int size) throws IOException;

    /**
     * 抓取远程图片
     * @param properties
     * @param source
     * @return
     */
    BaseResponse catchImage(UploadCatcherProperties properties, String... source) throws IOException;
}
