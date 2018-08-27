package com.zhangxuehai.baselibrary.net;

import android.support.annotation.NonNull;

import com.blankj.utilcode.util.RegexUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 创建于2018/2/25 作者 章学海.
 */

public final class ApiProviders {
    private static final int CONNECT_TIMEOUT = 20;
    private static final int READ_TIMEOUT = 60;
    private static final int WRITE_TIMEOUT = 60;
    private static Retrofit retrofit;
    private static Map<Class,Object> apis;

    private ApiProviders() {
    }

    public static <API> API getInstance(Class<API> api){
        if(retrofit==null){
            throw new RuntimeException("RetrofitProviders must Init by Initer");
        }
        API _api= (API) apis.get(api);
        if(_api==null){
            _api=retrofit.create(api);
            apis.put(api,_api);
        }
        return _api;
    }
    public static class Initer{
        private Gson gson=null;
        private Set<Interceptor> interceptors;
        private String baseUrl;

        public Initer(String baseUrl) {
            if(!RegexUtils.isURL(baseUrl)){
                throw new RuntimeException("Initer field baseUrl is not url");
            }
            this.baseUrl=baseUrl;
            interceptors=new HashSet<>();
        }

        public Initer gsonConverter(@NonNull Gson gson){
            this.gson=gson;
            return this;
        }
        public Initer addInterceptor(Interceptor interceptor){
            interceptors.add(interceptor);
            return this;
        }
        public void init(){
            Retrofit.Builder builder=new Retrofit.Builder();
            builder.baseUrl(baseUrl);
            builder.addConverterFactory(
                    GsonConverterFactory.create(
                            gson==null?getDefGson():gson
                    )
            );
            builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
            OkHttpClient.Builder clientBuilder=new OkHttpClient.Builder()
                    .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)//设置读取超时时间
                    .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)//设置写的超时时间
                    .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS);//设置连接超时时间
            for (Interceptor interceptor : interceptors) {
                clientBuilder.addInterceptor(interceptor);
            }
            builder.client(clientBuilder.build());
            apis=new HashMap<>();
            retrofit=builder.build();
        }
        private Gson getDefGson(){
            GsonBuilder gsonBuilder=new GsonBuilder()
                    .registerTypeAdapter(Date.class,new DateSerialize())
                    .registerTypeAdapter(Date.class,new DateDeserializer());
            return gsonBuilder.create();
        }
    }
}
