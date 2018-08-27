package com.zhangxuehai.baselibrary.net;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * 创建于2018/8/15 作者 章学海.
 */
final class DateSerialize implements JsonSerializer<Date> {
    SimpleDateFormat df;

    public DateSerialize() {
        df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        df.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    }

    @Override
    public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(df.format(src));
    }
}
