package com.zhuxc.ueditor.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zhuxuchao
 * @version 1.0
 * @since 2022/12/18
 */
public class BeanUtils {
    private static final Logger logger = LoggerFactory.getLogger(BeanUtils.class);
    public static <S, T> void copy(S source, T tagert) {
        BeanInfo targetBeanInfo;
        BeanInfo sourceBeanInfo;
        try {
            targetBeanInfo = Introspector.getBeanInfo(tagert.getClass());
            sourceBeanInfo = Introspector.getBeanInfo(source.getClass());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        PropertyDescriptor[] sourcePdArray = sourceBeanInfo.getPropertyDescriptors();
        Map<String, PropertyDescriptor> map = new HashMap<>(16);
        if (sourcePdArray != null) {
            Arrays.stream(sourcePdArray).forEach(pd -> map.put(pd.getName(), pd));
        }
        PropertyDescriptor[] targetPdArray = targetBeanInfo.getPropertyDescriptors();
        for (PropertyDescriptor targetPd : targetPdArray) {
            if (map.containsKey(targetPd.getName())) {
                PropertyDescriptor sourcePd = map.get(targetPd.getName());
                Method writeMethod = targetPd.getWriteMethod();
                Method readMethod = sourcePd.getReadMethod();
                if (writeMethod != null && readMethod != null && readMethod.getReturnType().equals(writeMethod.getParameterTypes()[0])) {
                    try {
                        Object obj = readMethod.invoke(source, (Object) null);
                        writeMethod.invoke(tagert, obj);
                    } catch (Exception e) {
                        logger.error("属性拷贝异常", e);
                    }
                }
            }
        }
    }

    public static Set<String> findFieldNames(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        return Arrays.stream(fields).map(Field::getName).collect(Collectors.toSet());
    }

    public static PropertyDescriptor[] getPropertyDescriptors(Class<?> clazz) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(clazz);

        return (PropertyDescriptor[]) Arrays.stream(beanInfo.getPropertyDescriptors()).filter((t) -> !"class".equals(t.getName())).toArray();
    }

}
