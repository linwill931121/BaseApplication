package com.zhangxuehai.baselibrary.net;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * 创建于2018/8/15 作者 章学海.
 */
final class DateDeserializer implements JsonDeserializer<Date> {
    SimpleDateFormat df;
    public DateDeserializer() {
        df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        df.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    }

    @Override
    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        try {
            return df.parse(json.getAsJsonPrimitive().getAsString());
        } catch (ParseException e) {
            e.printStackTrace();
            throw new JsonParseException(e.getMessage(),e);
        }
    }
}
