package com.zhangxuehai.baselibrary;

import android.app.Application;
import android.support.annotation.NonNull;
import com.blankj.utilcode.util.Utils;
import com.zhangxuehai.baselibrary.net.ApiProviders;

/**
 * 创建于2018/8/21 作者 章学海.
 */
public abstract class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        getNetConfig().init();//初始化网络
        Utils.init(this);
    }
    protected abstract @NonNull ApiProviders.Initer getNetConfig();

    //a639db8c222303c80a2e9f57b5729f319f03fa29

}
