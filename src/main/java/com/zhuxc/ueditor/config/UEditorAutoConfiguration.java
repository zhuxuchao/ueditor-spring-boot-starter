package com.zhuxc.ueditor.config;

import com.zhuxc.ueditor.service.UEditorActionService;
import com.zhuxc.ueditor.service.impl.DefaultUEditorActionServiceImpl;
import com.zhuxc.ueditor.web.UEditorController;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

/**
 * 自动配置{@link UEditorController}映射和{@link UEditorActionService} 服务
 * @author zhuxuchao
 * @since 2020-04-02 11:13
 */
@Configuration
@EnableConfigurationProperties({UEditorProperties.class})
public class UEditorAutoConfiguration {
    private static final Logger log = LoggerFactory.getLogger(UEditorAutoConfiguration.class);

    /**
     * 当Spring容器中不存在UEditorActionService实例，注册默认UEditorActionService实现
     *
     * @return UEditorActionService
     */
    @Bean
    @ConditionalOnMissingBean
    public UEditorActionService ueditorActionService(UEditorProperties properties) {
        log.info("注册百度UEditor默认服务实现[DefaultUEditorActionServiceImpl]...........................................");
        return new DefaultUEditorActionServiceImpl(properties);
    }

    /**
     * 当前是Web应用，且Spring容器中存在UEditorActionService实现时，注册UEditorController
     *
     * @param applicationContext 应用程序上下文对象
     * @param properties UEditor配置对象
     * @param actionService UEditor相关服务处理类
     * @return UEditor映射处理类 UEditorController
     */
    @Bean
    @ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
    @ConditionalOnBean(UEditorActionService.class)
    public UEditorController registerUEditorMapping(ApplicationContext applicationContext, UEditorProperties properties, UEditorActionService actionService) {
        RequestMappingHandlerMapping handlerMapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
        // 找到处理该路由的方法
        Method targetMethod = ReflectionUtils.findMethod(UEditorController.class, UEditorController.REQUEST_MAPPING_METHOD, HttpServletRequest.class);
        final String requestMappingPath = properties.getRequestMappingPath();
        final UEditorController editorController = new UEditorController(actionService, properties);
        RequestMappingInfo.BuilderConfiguration builderConfiguration = handlerMapping.getBuilderConfiguration();
        RequestMappingInfo requestMappingInfo = RequestMappingInfo.paths(requestMappingPath)
                .methods(RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS)
                .options(builderConfiguration)
                .build();
        // 注册映射处理
        assert targetMethod != null;
        handlerMapping.registerMapping(requestMappingInfo, editorController, targetMethod);
        log.info("注册百度UEditor后端服务映射[{}]...........................................", requestMappingPath);
        return editorController;
    }
}
