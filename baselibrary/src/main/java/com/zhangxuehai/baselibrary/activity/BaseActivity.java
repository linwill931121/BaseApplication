package com.zhangxuehai.baselibrary.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * 创建于2018/8/21 作者 章学海.
 */
public abstract class BaseActivity extends AppCompatActivity {
    /**
     * @return layout file res id
     */
    protected abstract @LayoutRes int getViewResId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getViewResId());
        ButterKnife.bind(this);
    }
}
