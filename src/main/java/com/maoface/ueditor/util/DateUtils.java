package com.maoface.ueditor.util;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.StrUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.TimeZone;

/**
 * 日期类型工具类
 * @author zhuxc
 * @since 1.0
 */
public abstract class DateUtils {
    public static final String NORM_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static String format(Date date){
        return format(date, NORM_DATETIME_PATTERN);
    }

    public static String format(Date date, String format) {
        if (null != date && !StrUtil.isBlank(format)) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            if (date instanceof DateTime) {
                TimeZone timeZone = ((DateTime) date).getTimeZone();
                if (null != timeZone) {
                    sdf.setTimeZone(timeZone);
                }
            }

            return format(date, sdf);
        } else {
            return null;
        }
    }

    public static LocalDateTime parseLocalDateTime(CharSequence dateStr, String format) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(format);

        try {
            return LocalDateTime.parse(dateStr, df);
        } catch (DateTimeParseException var4) {
            return LocalDate.parse(dateStr, df).atStartOfDay();
        }
    }

    private static String format(Date date, DateFormat format) {
        return null != format && null != date ? format.format(date) : null;
    }
}
