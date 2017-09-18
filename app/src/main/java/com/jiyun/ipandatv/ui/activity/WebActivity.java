package com.jiyun.ipandatv.ui.activity;

import android.webkit.WebView;

import com.jiyun.ipandatv.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WebActivity extends BaseActivity {


    @Bind(R.id.web_View)
    WebView webView;

    @Override
    public void initData() {
        webView.loadUrl("https://itunes.apple.com/cn/app/xiong-mao-pin-dao/id1071208653?mt=8");
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initView() {
        ButterKnife.bind(this);


    }

    @Override
    public int getLayout() {
        return R.layout.activity_web;
    }




}
