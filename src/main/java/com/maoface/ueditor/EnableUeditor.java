package com.maoface.ueditor;

import com.maoface.ueditor.config.UeditorConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @author zhuxuchao
 * @date 2020-04-02 11:28
 */
@Retention(value = java.lang.annotation.RetentionPolicy.RUNTIME)
@Target(value = {java.lang.annotation.ElementType.TYPE})
@Documented
@Import({UeditorConfiguration.class})
public @interface EnableUeditor {
}
