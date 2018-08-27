package com.zhangxuehai.baseapplication;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.zhangxuehai.baselibrary.activity.BaseVMActivity;
import com.zhangxuehai.baselibrary.viewmodel.BaseViewModel;

import butterknife.BindView;

public class MainActivity extends BaseVMActivity<MainViewModel> {
    @BindView(R.id.content)
    TextView content;


    @Override
    protected int getViewResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel.title.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                setTitle(s);
                content.setText(s);
            }
        });
        viewModel.title.postValue("测试");
    }
}
