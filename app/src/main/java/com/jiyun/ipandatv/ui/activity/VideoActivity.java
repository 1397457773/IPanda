package com.jiyun.ipandatv.ui.activity;

import android.content.Intent;

import com.jiyun.ipandatv.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class VideoActivity extends BaseActivity {

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
        String title = intent.getStringExtra("title");
        String url = intent.getStringExtra("url");
        videocontroller1.setUp(url,title);
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
        return R.layout.activity_video;
    }


}
