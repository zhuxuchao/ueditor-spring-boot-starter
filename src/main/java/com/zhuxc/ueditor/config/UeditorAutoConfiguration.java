package com.zhuxc.ueditor.config;

import com.zhuxc.ueditor.service.UeditorActionService;
import com.zhuxc.ueditor.service.impl.DefaultUeditorActionServiceImpl;
import com.zhuxc.ueditor.web.UeditorController;
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
 * 自动配置{@link UeditorController}映射和{@link UeditorActionService} 服务
 * @author zhuxuchao
 * @date 2020-04-02 11:13
 */
@Configuration
@EnableConfigurationProperties({UeditorProperties.class})
public class UeditorAutoConfiguration {
    private static final Logger log = LoggerFactory.getLogger(UeditorAutoConfiguration.class);

    /**
     * 当Spring容器中不存在UeditorActionService实例，注册默认UeditorActionService实现
     *
     * @return UeditorActionService
     */
    @Bean
    @ConditionalOnMissingBean
    public UeditorActionService ueditorActionService(UeditorProperties properties) {
        log.info("注册百度Ueditor默认服务实现[DefaultUeditorActionServiceImpl]...........................................");
        return new DefaultUeditorActionServiceImpl(properties);
    }

    /**
     * 当前是Web应用，且Spring容器中存在UeditorActionService实现时，注册UeditorController
     *
     * @param applicationContext 应用程序上下文对象
     * @param properties Ueditor配置对象
     * @param actionService Ueditor相关服务处理类
     * @return Ueditor映射处理类 UeditorController
     */
    @Bean
    @ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
    @ConditionalOnBean(UeditorActionService.class)
    public UeditorController registerUeditorMapping(ApplicationContext applicationContext, UeditorProperties properties, UeditorActionService actionService) {
        RequestMappingHandlerMapping handlerMapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
        // 找到处理该路由的方法
        Method targetMethod = ReflectionUtils.findMethod(UeditorController.class, UeditorController.REQUEST_MAPPING_METHOD, HttpServletRequest.class);
        final String requestMappingPath = properties.getRequestMappingPath();
        final UeditorController editorController = new UeditorController(actionService, properties);
        RequestMappingInfo.BuilderConfiguration builderConfiguration = handlerMapping.getBuilderConfiguration();
        RequestMappingInfo requestMappingInfo = RequestMappingInfo.paths(requestMappingPath)
                .methods(RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS)
                .options(builderConfiguration)
                .build();
        // 注册映射处理
        handlerMapping.registerMapping(requestMappingInfo, editorController, targetMethod);
        log.info("注册百度Ueditor后端服务映射[" + requestMappingPath + "]...........................................");
        return editorController;
    }
}
