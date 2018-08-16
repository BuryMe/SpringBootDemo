package com.example.util;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 日期，时间工具类
 * Created by constanting on 2018/7/3.
 */
public class DateUtil {

    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    /**
     * 根据自定义格式返回当前时间
     * @return
     */
    public static String getDateTimeByFormat(String fromat){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(fromat));
    }

    public static void main(String[] args) {
        System.out.println(getDateTimeByFormat("yyyyMMddHHmmss"));
    }
}
