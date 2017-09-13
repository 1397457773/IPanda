package com.jiyun.ipandatv.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jiyun.ipandatv.App;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        App.mActivity = this;
        App.mBaseActivity = this;

        initView();
        initData();
        initListener();

    }

    public abstract int getLayoutId();
    public abstract void initView();
    public abstract void initData();
    public abstract void initListener();


}
