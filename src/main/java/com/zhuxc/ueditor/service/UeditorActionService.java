package com.zhuxc.ueditor.service;

import com.zhuxc.ueditor.config.UploadCatcherProperties;
import com.zhuxc.ueditor.entity.BaseResponse;
import com.zhuxc.ueditor.entity.InputStreamDetail;
import com.zhuxc.ueditor.util.UeditorUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
     *
     * @param request 请求对象
     * @return 封装了文件流的详情对象
     */
    default InputStreamDetail resolveRequest(HttpServletRequest request, String uploadFiledName) throws IOException {
        MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
        final Map<String, MultipartFile> fileMap = req.getFileMap();
        final MultipartFile multipartFile = fileMap.get(uploadFiledName);
        final String originalFilename = multipartFile.getOriginalFilename();
        final String suffix = UeditorUtils.getSuffix(originalFilename);
        final InputStream inputStream = multipartFile.getInputStream();
        InputStreamDetail inputStreamDetail = new InputStreamDetail();
        inputStreamDetail.setSuffix(suffix);
        inputStreamDetail.setInputStream(inputStream);
        inputStreamDetail.setOriginFileName(originalFilename);
        return inputStreamDetail;
    }

    /**
     * 上传图片
     *
     * @param streamDetail 文件流
     * @return 处理结果
     */
    BaseResponse uploadImage(InputStreamDetail streamDetail) throws IOException;

    /**
     * 上传视频
     *
     * @param streamDetail 文件流
     * @return 处理结果
     */
    BaseResponse uploadVideo(InputStreamDetail streamDetail) throws IOException;

    /**
     * 上传附件
     *
     * @param streamDetail 文件流
     * @return 处理结果
     */
    BaseResponse uploadFile(InputStreamDetail streamDetail) throws IOException;

    /**
     * 上传涂鸦
     *
     * @param streamDetail 文件流
     * @return 处理结果
     */
    BaseResponse uploadScrawl(InputStreamDetail streamDetail) throws IOException;

    /**
     * 上传截图
     *
     * @param streamDetail 文件流
     * @return 处理结果
     */
    BaseResponse uploadSnapscreen(InputStreamDetail streamDetail) throws IOException;

    /**
     * 文件管理
     *
     * @param start 开始索引
     * @param size 条数
     * @return 文件列表
     */
    BaseResponse listFile(int start, int size) throws IOException;

    /**
     * 图片管理
     *
     * @param start 开始索引
     * @param size 条数
     * @return 图片列表
     */
    BaseResponse listImage(int start, int size) throws IOException;

    /**
     * 抓取远程图片
     *
     * @param properties 配置类
     * @param source 源地址
     * @return 图片列表
     */
    BaseResponse catchImage(UploadCatcherProperties properties, String... source) throws IOException;
}
