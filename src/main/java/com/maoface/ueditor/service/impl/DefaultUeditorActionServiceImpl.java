package com.maoface.ueditor.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.IoUtil;
import com.maoface.ueditor.config.FileManagerProperties;
import com.maoface.ueditor.config.ImageManagerProperties;
import com.maoface.ueditor.config.UploadCatcherProperties;
import com.maoface.ueditor.config.UploadFileProperties;
import com.maoface.ueditor.config.UploadImageProperties;
import com.maoface.ueditor.config.UploadScrawlProperties;
import com.maoface.ueditor.config.UploadSnapscreenProperties;
import com.maoface.ueditor.config.UploadVideoProperties;
import com.maoface.ueditor.consts.Constants;
import com.maoface.ueditor.entity.BaseResponse;
import com.maoface.ueditor.entity.InputStreamDetail;
import com.maoface.ueditor.entity.UploadResponse;
import com.maoface.ueditor.service.UeditorActionService;
import com.maoface.ueditor.util.PathFormat;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

/**
 * @author zhuxuchao
 * @date 2020-04-16 16:48
 */
public class DefaultUeditorActionServiceImpl implements UeditorActionService {
    @Override
    public BaseResponse uploadImage(InputStreamDetail streamDetail, UploadImageProperties properties) throws IOException {
        if (streamDetail == null || streamDetail.getInputStream() == null) {
            return new BaseResponse(Constants.Message.NOTFOUND_UPLOAD_DATA);
        }
        Set<String> imageAllowFiles = properties.getImageAllowFiles();
        String suffix = streamDetail.getSuffix();
        if (CollUtil.isNotEmpty(imageAllowFiles) && !imageAllowFiles.contains(suffix)) {
            return new BaseResponse(Constants.Message.NOT_ALLOW_FILE_TYPE);
        }
        int imageMaxSize = properties.getImageMaxSize();
        InputStream inputStream = streamDetail.getInputStream();
        byte[] bytes = IoUtil.readBytes(inputStream);
        if (imageMaxSize < bytes.length) {
            return new BaseResponse(Constants.Message.MAX_SIZE);
        }
        String imagePathFormat = properties.getImagePathFormat();
        String originFileName = streamDetail.getOriginFileName();
        String path = PathFormat.parse(imagePathFormat) + suffix;
        ClassPathResource resource = new ClassPathResource("");
        final File resourceDir = resource.getFile();
        File file = new File(resourceDir, "/static" + path);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }
        FileOutputStream outputStream = new FileOutputStream(file);
        IoUtil.write(outputStream, true, bytes);
        UploadResponse uploadResponse = new UploadResponse();
        uploadResponse.setState(Constants.Message.SUCCESS);
        uploadResponse.setUrl(path);
        uploadResponse.setOriginal(originFileName);
        uploadResponse.setTitle(originFileName);
        return uploadResponse;
    }

    @Override
    public BaseResponse uploadVideo(InputStreamDetail streamDetail, UploadVideoProperties properties) throws IOException {
        return null;
    }

    @Override
    public BaseResponse uploadFile(InputStreamDetail streamDetail, UploadFileProperties properties) throws IOException {
        return null;
    }

    @Override
    public BaseResponse uploadScrawl(InputStreamDetail streamDetail, UploadScrawlProperties properties) throws IOException {
        return null;
    }

    @Override
    public BaseResponse uploadSnapscreen(InputStreamDetail streamDetail, UploadSnapscreenProperties properties) throws IOException {
        return null;
    }

    @Override
    public BaseResponse listFile(FileManagerProperties properties, int start, int size) throws IOException {
        return null;
    }

    @Override
    public BaseResponse listImage(ImageManagerProperties properties, int start, int size) throws IOException {
        final String imageManagerListPath = properties.getImageManagerListPath();
        ClassPathResource resource = new ClassPathResource(imageManagerListPath);
        final File[] files = resource.getFile().listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return true;
            }
        });
        return null;
    }

    @Override
    public BaseResponse catchImage(UploadCatcherProperties properties, String... source) throws IOException {
        return null;
    }
}
