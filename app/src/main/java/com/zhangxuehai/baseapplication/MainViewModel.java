package com.zhangxuehai.baseapplication;

import android.arch.lifecycle.MutableLiveData;

import com.zhangxuehai.baselibrary.viewmodel.BaseViewModel;

/**
 * 创建于2018/8/21 作者 章学海.
 */
public class MainViewModel extends BaseViewModel {
    public MutableLiveData<String> title=new MutableLiveData<>();
}
