package com.zhangxuehai.baselibrary.net;

import java.io.IOException;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 *
 */
public abstract class AddHeaderInterceptor implements Interceptor {
    abstract Map<String,String> getHeader();
    abstract boolean addHeader();

    @Override
    public Response intercept(Chain chain) throws IOException {
        if(addHeader()){
            Request.Builder builder=chain.request().newBuilder();
            for (Map.Entry<String, String> entity : getHeader().entrySet()) {
                builder.addHeader(entity.getKey(),entity.getValue());
            }
            return chain.proceed(builder.build());
        }else{
            return chain.proceed(chain.request());
        }
    }
}
