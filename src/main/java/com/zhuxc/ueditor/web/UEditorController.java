package com.zhuxc.ueditor.web;

import com.zhuxc.ueditor.config.*;
import com.zhuxc.ueditor.consts.Actions;
import com.zhuxc.ueditor.consts.Parameters;
import com.zhuxc.ueditor.entity.BaseResponse;
import com.zhuxc.ueditor.entity.InputStreamDetail;
import com.zhuxc.ueditor.service.UEditorActionService;
import com.zhuxc.ueditor.util.UeditorUtils;
import com.zhuxc.ueditor.util.Validator;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;

import java.io.IOException;

import static com.zhuxc.ueditor.consts.Actions.*;
import static com.zhuxc.ueditor.consts.Constants.Message.*;

/**
 * @author zhuxuchao
 * @since 2020-04-02 11:16
 */
public class UEditorController {
    private static final Logger logger = LoggerFactory.getLogger(UEditorController.class);
    public static final String REQUEST_MAPPING_METHOD = "action";
    private final UEditorActionService actionService;
    private final UEditorProperties properties;

    public UEditorController(UEditorActionService actionService, UEditorProperties properties) {
        this.actionService = actionService;
        this.properties = properties;
    }

    public ResponseEntity<Object> action(HttpServletRequest request) {
        String callbackName = request.getParameter(Parameters.CALLBACK);
        String actionName = request.getParameter(Parameters.ACTION);
        if (!StringUtils.hasText(actionName)) {
            return new ResponseEntity<>(new BaseResponse(BLANK_ACTION), HttpStatus.OK);
        }
        if (!Actions.containsKey(actionName)) {
            return new ResponseEntity<>(new BaseResponse(INVALID_ACTION), HttpStatus.OK);
        }
        if (StringUtils.hasText(callbackName)) {
            if (!UeditorUtils.validCallbackName(callbackName)) {
                return new ResponseEntity<>(new BaseResponse(ILLEGAL_CALLBACK), HttpStatus.OK);
            }
        }
        logger.info("百度UEditor请求{}", actionName);
        // 有可能拿到空值
        int action = Actions.getAction(actionName);
        try {
            switch (action) {
                case CONFIG: {
                    // 需要支持callback参数,返回jsonp格式 
                    String config = UeditorUtils.callbackConfig(properties, callbackName);
                    return new ResponseEntity<>(config, HttpStatus.OK);
                }
                case UPLOAD_FILE: {
                    UploadFileProperties properties = this.properties.getUploadFileConfig();
                    InputStreamDetail inputStreamDetail = actionService.resolveRequest(request, properties.getFileFieldName());
                    BaseResponse response = actionService.uploadFile(inputStreamDetail);
                    return new ResponseEntity<>(response, HttpStatus.OK);
                }
                case UPLOAD_SCRAWL: {
                    UploadScrawlProperties properties = this.properties.getUploadScrawlConfig();
                    InputStreamDetail inputStreamDetail = actionService.resolveRequest(request, properties.getScrawlFieldName());
                    BaseResponse response = actionService.uploadScrawl(inputStreamDetail);
                    return new ResponseEntity<>(response, HttpStatus.OK);
                }
                case UPLOAD_VIDEO: {
                    UploadVideoProperties properties = this.properties.getUploadVideoConfig();
                    InputStreamDetail inputStreamDetail = actionService.resolveRequest(request, properties.getVideoFieldName());
                    BaseResponse response = actionService.uploadVideo(inputStreamDetail);
                    return new ResponseEntity<>(response, HttpStatus.OK);
                }
                case UPLOAD_IMAGE: {
                    UploadImageProperties properties = this.properties.getUploadImageConfig();
                    InputStreamDetail inputStreamDetail = actionService.resolveRequest(request, properties.getImageFieldName());
                    BaseResponse response = actionService.uploadImage(inputStreamDetail);
                    return new ResponseEntity<>(response, HttpStatus.OK);
                }
                case LIST_FILE: {
                    FileManagerProperties properties = this.properties.getFileManagerConfig();
                    String startStr = request.getParameter(Parameters.START);
                    String sizeStr = request.getParameter(Parameters.SIZE);
                    int start = 0;
                    if (Validator.isNumber(startStr)) {
                        start = Integer.parseInt(startStr);
                    }
                    int size = properties.getFileManagerListSize();
                    if (Validator.isNumber(sizeStr)) {
                        size = Integer.parseInt(sizeStr);
                    }
                    BaseResponse response = actionService.listFile(start, size);
                    // 需要支持callback参数,返回jsonp格式
                    String body = UeditorUtils.callbackStr(response, callbackName);
                    return new ResponseEntity<>(body, HttpStatus.OK);
                }
                case LIST_IMAGE: {
                    ImageManagerProperties properties = this.properties.getImageManagerConfig();
                    String startStr = request.getParameter(Parameters.START);
                    String sizeStr = request.getParameter(Parameters.SIZE);
                    int start = 0;
                    if (Validator.isNumber(startStr)) {
                        start = Integer.parseInt(startStr);
                    }
                    int size = properties.getImageManagerListSize();
                    if (Validator.isNumber(sizeStr)) {
                        size = Integer.parseInt(sizeStr);
                    }
                    BaseResponse response = actionService.listImage(start, size);
                    // 需要支持callback参数,返回jsonp格式 
                    String body = UeditorUtils.callbackStr(response, callbackName);
                    return new ResponseEntity<>(body, HttpStatus.OK);
                }
                case CATCH_IMAGE: {
                    UploadCatcherProperties properties = this.properties.getUploadCatcherConfig();
                    String[] source = request.getParameterValues(Parameters.SOURCE);
                    BaseResponse response = actionService.catchImage(properties, source);
                    // 需要支持callback参数,返回jsonp格式 
                    String body = UeditorUtils.callbackStr(response, callbackName);
                    return new ResponseEntity<>(body, HttpStatus.OK);
                }
                default: {
                    return new ResponseEntity<>(new BaseResponse(INVALID_ACTION), HttpStatus.OK);
                }
            }
        } catch (IOException e) {
            logger.error("UEditor富文本文件上传IO异常", e);
            return new ResponseEntity<>(new BaseResponse(IO_ERROR), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("UEditor富文本文件上传异常", e);
            return new ResponseEntity<>(new BaseResponse(SERVER_ERROR), HttpStatus.OK);
        }
    }
}
