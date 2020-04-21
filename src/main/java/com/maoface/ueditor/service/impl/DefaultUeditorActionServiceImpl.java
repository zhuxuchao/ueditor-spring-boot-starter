package com.maoface.ueditor.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import com.maoface.ueditor.config.FileManagerProperties;
import com.maoface.ueditor.config.ImageManagerProperties;
import com.maoface.ueditor.config.UeditorProperties;
import com.maoface.ueditor.config.UploadCatcherProperties;
import com.maoface.ueditor.config.UploadFileProperties;
import com.maoface.ueditor.config.UploadImageProperties;
import com.maoface.ueditor.config.UploadScrawlProperties;
import com.maoface.ueditor.config.UploadSnapscreenProperties;
import com.maoface.ueditor.config.UploadVideoProperties;
import com.maoface.ueditor.consts.Constants;
import com.maoface.ueditor.entity.BaseResponse;
import com.maoface.ueditor.entity.CatchImageResponse;
import com.maoface.ueditor.entity.InputStreamDetail;
import com.maoface.ueditor.entity.ListFileResponse;
import com.maoface.ueditor.entity.UploadResponse;
import com.maoface.ueditor.service.UeditorActionService;
import com.maoface.ueditor.util.PathFormat;
import com.maoface.ueditor.util.UeditorUtils;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author zhuxuchao
 * @date 2020-04-16 16:48
 */
public class DefaultUeditorActionServiceImpl implements UeditorActionService {
    private UeditorProperties properties;

    public DefaultUeditorActionServiceImpl(UeditorProperties properties) {
        this.properties = properties;
    }

    @Override
    public BaseResponse uploadImage(InputStreamDetail streamDetail) throws IOException {
        UploadImageProperties properties = this.properties.getUploadImageConfig();
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
        UeditorUtils.upload(bytes, path);
        UploadResponse uploadResponse = new UploadResponse();
        uploadResponse.setState(Constants.Message.SUCCESS);
        uploadResponse.setUrl(path);
        uploadResponse.setOriginal(originFileName);
        uploadResponse.setTitle(originFileName);
        return uploadResponse;
    }

    @Override
    public BaseResponse uploadVideo(InputStreamDetail streamDetail) throws IOException {
        UploadVideoProperties properties = this.properties.getUploadVideoConfig();
        if (streamDetail == null || streamDetail.getInputStream() == null) {
            return new BaseResponse(Constants.Message.NOTFOUND_UPLOAD_DATA);
        }
        Set<String> imageAllowFiles = properties.getVideoAllowFiles();
        String suffix = streamDetail.getSuffix();
        if (CollUtil.isNotEmpty(imageAllowFiles) && !imageAllowFiles.contains(suffix)) {
            return new BaseResponse(Constants.Message.NOT_ALLOW_FILE_TYPE);
        }
        int imageMaxSize = properties.getVideoMaxSize();
        InputStream inputStream = streamDetail.getInputStream();
        byte[] bytes = IoUtil.readBytes(inputStream);
        if (imageMaxSize < bytes.length) {
            return new BaseResponse(Constants.Message.MAX_SIZE);
        }
        String imagePathFormat = properties.getVideoPathFormat();
        String originFileName = streamDetail.getOriginFileName();
        String path = PathFormat.parse(imagePathFormat) + suffix;
        UeditorUtils.upload(bytes, path);
        UploadResponse uploadResponse = new UploadResponse();
        uploadResponse.setState(Constants.Message.SUCCESS);
        uploadResponse.setUrl(path);
        uploadResponse.setOriginal(originFileName);
        uploadResponse.setTitle(originFileName);
        return uploadResponse;
    }

    @Override
    public BaseResponse uploadFile(InputStreamDetail streamDetail) throws IOException {
        UploadFileProperties properties = this.properties.getUploadFileConfig();
        if (streamDetail == null || streamDetail.getInputStream() == null) {
            return new BaseResponse(Constants.Message.NOTFOUND_UPLOAD_DATA);
        }
        Set<String> imageAllowFiles = properties.getFileAllowFiles();
        String suffix = streamDetail.getSuffix();
        if (CollUtil.isNotEmpty(imageAllowFiles) && !imageAllowFiles.contains(suffix)) {
            return new BaseResponse(Constants.Message.NOT_ALLOW_FILE_TYPE);
        }
        int imageMaxSize = properties.getFileMaxSize();
        InputStream inputStream = streamDetail.getInputStream();
        byte[] bytes = IoUtil.readBytes(inputStream);
        if (imageMaxSize < bytes.length) {
            return new BaseResponse(Constants.Message.MAX_SIZE);
        }
        String imagePathFormat = properties.getFilePathFormat();
        String originFileName = streamDetail.getOriginFileName();
        String path = PathFormat.parse(imagePathFormat) + suffix;
        UeditorUtils.upload(bytes, path);
        UploadResponse uploadResponse = new UploadResponse();
        uploadResponse.setState(Constants.Message.SUCCESS);
        uploadResponse.setUrl(path);
        uploadResponse.setOriginal(originFileName);
        uploadResponse.setTitle(originFileName);
        return uploadResponse;
    }

    @Override
    public BaseResponse uploadScrawl(InputStreamDetail streamDetail) throws IOException {
        UploadScrawlProperties properties = this.properties.getUploadScrawlConfig();
        if (streamDetail == null || streamDetail.getInputStream() == null) {
            return new BaseResponse(Constants.Message.NOTFOUND_UPLOAD_DATA);
        }
        String suffix = streamDetail.getSuffix();
        int imageMaxSize = properties.getScrawlMaxSize();
        InputStream inputStream = streamDetail.getInputStream();
        byte[] bytes = IoUtil.readBytes(inputStream);
        if (imageMaxSize < bytes.length) {
            return new BaseResponse(Constants.Message.MAX_SIZE);
        }
        String imagePathFormat = properties.getScrawlPathFormat();
        String originFileName = streamDetail.getOriginFileName();
        String path = PathFormat.parse(imagePathFormat) + suffix;
        UeditorUtils.upload(bytes, path);
        UploadResponse uploadResponse = new UploadResponse();
        uploadResponse.setState(Constants.Message.SUCCESS);
        uploadResponse.setUrl(path);
        uploadResponse.setOriginal(originFileName);
        uploadResponse.setTitle(originFileName);
        return uploadResponse;
    }

    @Override
    public BaseResponse uploadSnapscreen(InputStreamDetail streamDetail) throws IOException {
        UploadSnapscreenProperties properties = this.properties.getUploadSnapscreenConfig();
        if (streamDetail == null || streamDetail.getInputStream() == null) {
            return new BaseResponse(Constants.Message.NOTFOUND_UPLOAD_DATA);
        }
        String suffix = streamDetail.getSuffix();
        InputStream inputStream = streamDetail.getInputStream();
        byte[] bytes = IoUtil.readBytes(inputStream);
        String imagePathFormat = properties.getSnapscreenPathFormat();
        String originFileName = streamDetail.getOriginFileName();
        String path = PathFormat.parse(imagePathFormat) + suffix;
        UeditorUtils.upload(bytes, path);
        UploadResponse uploadResponse = new UploadResponse();
        uploadResponse.setState(Constants.Message.SUCCESS);
        uploadResponse.setUrl(path);
        uploadResponse.setOriginal(originFileName);
        uploadResponse.setTitle(originFileName);
        return uploadResponse;
    }

    @Override
    public BaseResponse listFile(int start, int size) throws IOException {
        final FileManagerProperties properties = this.properties.getFileManagerConfig();
        final String listPath = properties.getFileManagerListPath();
        final Set<String> allowFiles = properties.getFileManagerAllowFiles();
        final List<File> files = getFiles(listPath, allowFiles);
        ListFileResponse response = new ListFileResponse();
        response.setState(Constants.Message.SUCCESS);
        response.setStart(start);
        if (!CollectionUtils.isEmpty(files)) {
            final List<ListFileResponse.FileItem> fileItems = subList(files, start, size);
            final int total = files.size();
            response.setTotal(total);
            response.setList(fileItems);
        }
        return response;
    }

    @Override
    public BaseResponse listImage(int start, int size) throws IOException {
        final ImageManagerProperties properties = this.properties.getImageManagerConfig();
        final String listPath = properties.getImageManagerListPath();
        final Set<String> allowFiles = properties.getImageManagerAllowFiles();
        final List<File> files = getFiles(listPath, allowFiles);
        ListFileResponse response = new ListFileResponse();
        response.setState(Constants.Message.SUCCESS);
        response.setStart(start);
        if (!CollectionUtils.isEmpty(files)) {
            final List<ListFileResponse.FileItem> fileItems = subList(files, start, size);
            final int total = files.size();
            response.setTotal(total);
            response.setList(fileItems);
        }
        return response;
    }

    @Override
    public BaseResponse catchImage(UploadCatcherProperties properties, String... source) throws IOException {
        CatchImageResponse response = new CatchImageResponse();
        response.setState(Constants.Message.SUCCESS);
        List<CatchImageResponse.CatchImageItem> list = new ArrayList<>(source.length);
        response.setList(list);
        try {
            for (String imageUrl : source) {
                URL url = new URL(imageUrl);
                final Set<String> allowDomain = properties.getCatcherLocalDomain();
                if (!UeditorUtils.validHost(url.getHost(), allowDomain)) {
                    return new BaseResponse(Constants.Message.PREVENT_HOST);
                }
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setInstanceFollowRedirects(true);
                connection.setUseCaches(true);
                if (HttpURLConnection.HTTP_OK != connection.getResponseCode()) {
                    return new BaseResponse(Constants.Message.CONNECTION_ERROR);
                }
                String suffix = UeditorUtils.getSuffix(connection.getContentType());
                final Set<String> allowFiles = properties.getCatcherAllowFiles();
                if (!allowFiles.contains(suffix)) {
                    return new BaseResponse(Constants.Message.NOT_ALLOW_FILE_TYPE);
                }
                final int catcherMaxSize = properties.getCatcherMaxSize();
                if (connection.getContentLength() > catcherMaxSize) {
                    return new BaseResponse(Constants.Message.MAX_SIZE);
                }
                final String catcherPathFormat = properties.getCatcherPathFormat();
                String path = PathFormat.parse(catcherPathFormat) + suffix;
                final InputStream inputStream = connection.getInputStream();
                byte[] bytes = IoUtil.readBytes(inputStream);
                UeditorUtils.upload(bytes, path);
                final CatchImageResponse.CatchImageItem item = CatchImageResponse.CatchImageItem.builder()
                        .source(imageUrl)
                        .state(Constants.Message.SUCCESS)
                        .url(path).build();
                list.add(item);
            }
        } catch (Exception e) {
            return new BaseResponse(Constants.Message.REMOTE_FAIL);
        }
        return response;
    }

    private List<File> getFiles(String listPath, Set<String> allowFiles) {
        return FileUtil.loopFiles(listPath, new FileFilter() {
            @Override
            public boolean accept(File file) {
                final String suffix = UeditorUtils.getSuffix(file.getName());
                return suffix != null && allowFiles.contains(suffix);
            }
        });
    }

    private List<ListFileResponse.FileItem> subList(List<File> files, int start, int size) {
        List<ListFileResponse.FileItem> listItem = new ArrayList<>();
        final int total = files.size();
        if (total > start) {
            for (int i = start, j = 0;
                 i < total && j < size;
                 i++, j++) {
                final File image = files.get(i);
                final ListFileResponse.FileItem item = ListFileResponse.FileItem.builder().url(image.getAbsolutePath()).build();
                listItem.add(item);
            }
        }
        return listItem;
    }
}
