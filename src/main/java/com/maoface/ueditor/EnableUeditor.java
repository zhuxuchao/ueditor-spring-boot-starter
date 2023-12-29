package com.maoface.ueditor;

import com.maoface.ueditor.config.UeditorAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author zhuxuchao
 * @date 2020-04-02 11:28
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE})
@Documented
@Import({UeditorAutoConfiguration.class})
public @interface EnableUeditor {
}
