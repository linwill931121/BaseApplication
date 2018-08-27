package com.zhangxuehai.baselibrary.utils;

import android.support.annotation.Nullable;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 创建于2018/8/21 作者 章学海.
 */
public final class ClassUtils {
    /**
     * @param clazz source class
     * @return Genericity Class
     */
    public static final @Nullable Class getClassGenericityClass(Class clazz){
        Type genType = clazz.getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        if(params.length>0){
            return (Class) params[0];
        }else{
            return null;
        }
    }
}
