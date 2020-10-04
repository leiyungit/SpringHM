package com.itcast.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String,Date> {
    @Override
    public Date convert(String resource) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parse = df.parse(resource);
            return parse;
        } catch (Exception e) {
            throw new  RuntimeException("日期转换异常");
        }
    }
}
