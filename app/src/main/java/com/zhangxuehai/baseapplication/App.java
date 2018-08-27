package com.zhangxuehai.baseapplication;

import android.support.annotation.NonNull;

import com.zhangxuehai.baselibrary.BaseApplication;
import com.zhangxuehai.baselibrary.net.ApiProviders;

/**
 * 创建于2018/8/21 作者 章学海.
 */
public class App extends BaseApplication {
    @NonNull
    @Override
    protected ApiProviders.Initer getNetConfig() {
        return new ApiProviders.Initer("xb.net-x.cn/");
    }
}
