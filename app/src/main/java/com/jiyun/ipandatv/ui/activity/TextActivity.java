package com.jiyun.ipandatv.ui.activity;

import android.content.Intent;

import com.jiyun.ipandatv.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class TextActivity extends BaseActivity {


    @Bind(R.id.videocontroller1)
    JCVideoPlayer videocontroller1;

    @Override
    protected void onPause() {
        JCVideoPlayer.releaseAllVideos();
        super.onPause();
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        String title = intent.getStringExtra("title");
        String url1 = intent.getStringExtra("url");
        String title2 = intent.getStringExtra("title");
        videocontroller1.setUp(url,title);
        videocontroller1.setUp(url1,title2);
        videocontroller1.ivStart.setClickable(false);
        videocontroller1.ivStart.performClick();
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
        return R.layout.activity_text;
    }


}
