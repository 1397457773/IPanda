package com.jiyun.ipandatv.ui.activity;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiyun.ipandatv.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HuDongWebActivity extends BaseActivity {


    @Bind(R.id.iv_img)
    ImageView ivImg;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_img_share)
    ImageView ivImgShare;
    @Bind(R.id.too_bar)
    Toolbar tooBar;
    @Bind(R.id.web_View)
    WebView webView;


    @Override
    public void initData() {
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String url = intent.getStringExtra("url");
        tvTitle.setText(title);
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
        return R.layout.activity_hu_dong_web;
    }


}
