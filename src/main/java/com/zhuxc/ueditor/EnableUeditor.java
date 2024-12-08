package com.zhuxc.ueditor;

import com.zhuxc.ueditor.config.UEditorAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author zhuxuchao
 * @since 2020-04-02 11:28
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE})
@Documented
@Import({UEditorAutoConfiguration.class})
public @interface EnableUeditor {
}
