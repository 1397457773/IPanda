package com.jiyun.ipandatv.ui.activity;

import android.content.Intent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

import com.jiyun.ipandatv.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ForthWebActivity extends BaseActivity {


    @Bind(R.id.iv_img)
    ImageView ivImg;
    @Bind(R.id.iv_img_share)
    ImageView ivImgShare;
    @Bind(R.id.web_View)
    WebView webView;

    @Override
    public void initData() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        webView.loadUrl(url);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
    }

    @Override
    public void initListener() {
      ivImg.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              finish();
          }
      });
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_forth_web;
    }


}
