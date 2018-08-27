package com.zhangxuehai.baselibrary.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.zhangxuehai.baselibrary.utils.ClassUtils;
import com.zhangxuehai.baselibrary.viewmodel.BaseViewModel;

/**
 * 创建于2018/8/21 作者 章学海.
 */
public abstract class BaseVMActivity<VM extends BaseViewModel> extends BaseActivity {
    protected VM viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel= (VM) ViewModelProviders.of(this).get(ClassUtils.getClassGenericityClass(getClass()));
    }
}
