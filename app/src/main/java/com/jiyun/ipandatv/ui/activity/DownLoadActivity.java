package com.jiyun.ipandatv.ui.activity;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

import com.jiyun.ipandatv.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DownLoadActivity extends BaseActivity implements View.OnClickListener {


    @Bind(R.id.web_View)
    WebView webView;
    @Bind(R.id.iv_img)
    ImageView ivImg;
    @Bind(R.id.iv_img_share)
    ImageView ivImgShare;
    @Bind(R.id.too_bar)
    Toolbar tooBar;

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        ivImg.setOnClickListener(this);
        ivImgShare.setOnClickListener(this);

    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        webView.loadUrl("http://download.cntv.cn/app/ipanda/index.html");
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);

    }

    @Override
    public int getLayout() {
        return R.layout.activity_down_load;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_img:
                finish();
                break;
            case R.id.iv_img_share:

                break;
        }
    }
}


