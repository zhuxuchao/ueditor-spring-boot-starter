package com.maoface.ueditor.consts;

/**
 * @author zhuxuchao
 * @date 2020-04-02 13:39
 */
public abstract class Constants {
    public static final String CALLBACK_NAME_REGEX = "^[a-zA-Z_]+[\\w0-9_]*$";

    public interface Action {
        String CONFIG = "config";
        String UPLOAD_IMAGE = "uploadimage";
        String UPLOAD_VIDEO = "uploadvideo";
        String UPLOAD_FILE = "uploadfile";
        String UPLOAD_SCRAWL = "uploadscrawl";
        String CATCH_IMAGE = "catchimage";
        String LIST_FILE = "listfile";
        String LIST_IMAGE = "listimage";
    }

    public interface Message {
        String SUCCESS = "SUCCESS";
        // 无效的Action
        String BLANK_ACTION = "Action不能为空";
        // 无效的Action
        String INVALID_ACTION = "非法的Action操作";
        // 配置文件初始化失败
        String CONFIG_ERROR = "配置文件初始化失败";
        // 抓取远程图片失败
        String REMOTE_FAIL = "抓取远程图片失败";
        // 被阻止的远程主机
        String PREVENT_HOST = "被阻止的远程主机";
        // 远程连接出错
        String CONNECTION_ERROR = "远程连接出错";
        // "文件大小超出限制"
        String MAX_SIZE = "文件大小超出限制";
        // 权限不足， 多指写权限
        String PERMISSION_DENIED = "权限不足";
        // 创建文件失败
        String FAILED_CREATE_FILE = "创建文件失败";
        // IO错误
        String IO_ERROR = "IO错误";
        // 上传表单不是multipart/form-data类型
        String NOT_MULTIPART_CONTENT = "上传表单不是multipart/form-data类型";
        // 解析上传表单错误
        String PARSE_REQUEST_ERROR = "解析上传表单错误";
        // 未找到上传数据
        String NOTFOUND_UPLOAD_DATA = "未找到上传数据";
        // 不允许的文件类型
        String NOT_ALLOW_FILE_TYPE = "不允许的文件类型";
        // 指定路径不是目录
        String NOT_DIRECTORY = "指定路径不是目录";
        // 指定路径并不存在
        String NOT_EXIST = "指定路径并不存在";
        // callback参数名不合法
        String ILLEGAL_CALLBACK = "Callback参数名不合法";
        // 服务器错误
        String SERVER_ERROR = "上传错误";
    }
}
