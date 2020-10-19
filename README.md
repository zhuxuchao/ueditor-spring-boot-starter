# ueditor-spring-boot-starter
百度UEditor富文本编辑器后台服务

### 如何使用：
1. 在工程pom.xml里加入相关依赖 
    ```xml
    <dependency>
        <groupId>com.maoface</groupId>
        <artifactId>ueditor-spring-boot-starter</artifactId>
        <version>1.0.0</version>
    </dependency>
    <dependency>
        <groupId>cn.hutool</groupId>
        <artifactId>hutool-core</artifactId>
        <version>5.3.0</version>
    </dependency>
    <dependency>
        <groupId>cn.hutool</groupId>
        <artifactId>hutool-json</artifactId>
        <version>5.3.0</version>
    </dependency>
    ```
2. SpringBoot启动类加开启Ueditor服务注解
    ```java
    @SpringBootApplication
    @EnableUeditor
    public class DemoUeditorApplication {
    
        public static void main(String[] args) {
            SpringApplication.run(DemoUeditorApplication.class, args);
        }
    
    }
    ```
3. 实现UeditorActionService接口(可选)
    ```java
   import com.maoface.ueditor.service.UeditorActionService;
   public class MyUeditorActionServiceImpl implements UeditorActionService{
       // 实现相关上传和查询文件方法
   }
    ```
> 组件有一个默认的Ueditor后端服务器实现类DefaultUeditorActionServiceImpl。 
> 默认实现中文件存储位置是各action配置中xxxPathFormat的值。因为SpringBoot应用大部分以jar形式发布，所以xxxPathFormat的值是服务器绝对路径，也就是说不属于项目路径。
> 因此前端页面想直接访问图片资源，必须针对性配置nginx监听，将访问Ueditor资源的请求根目录指向xxxPathFromat目录。   

### 配置项，具体参考[官网说明](http://fex.baidu.com/ueditor/#server-config) 
```yaml
ueditor:
  config:
    # Ueditor后端服务唯一地址
    request-mapping-path: /baidu/ueditor/action
    # 上传图片配置项。具体参考官网说明
    upload-image-config:
    # 上传视频配置项。具体参考官网说明
    upload-video-config:
    # 上传附件配置项。具体参考官网说明
    upload-file-config:
    # 上传涂鸦图片配置项。具体参考官网说明
    upload-scrawl-config:
    # 上传截图配置项。具体参考官网说明
    upload-snapscreen-config:
    # 抓取远程图片配置项。具体参考官网说明
    upload-catcher-config:
    # 图片管理配置项。具体参考官网说明
    image-manager-config:
    # 文件管理配置项。具体参考官网说明
    file-manager-config:
```
> 所有配置项全部都有默认值，因此也都可以省略不配置
