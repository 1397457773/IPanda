package com.jiyun.ipandatv.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.gson.Gson;
import com.jiyun.ipandatv.R;
import com.jiyun.ipandatv.model.HomeModelData;
import com.jiyun.ipandatv.model.callbacks.CallBacks;
import com.jiyun.ipandatv.model.entity.LookInfoEntiy;
import com.jiyun.ipandatv.model.entity.Look_VideoEntiy;
import com.jiyun.ipandatv.model.utils.OkHttpUtils;
import com.jiyun.ipandatv.model.utils.Urls;
import com.jiyun.ipandatv.presenter.HomePresenter;

import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

import static com.jiyun.ipandatv.R.id.mWebView;


public class Look_VideoActivity extends BaseActivity {

    private JCVideoPlayer jzVideoPlayerStandard;
    private List<Look_VideoEntiy.VideoBean.ChaptersBean> list = new ArrayList<>();
    private Intent intent;
    private String title;

    @Override
    public void initData() {
        intent = getIntent();
        String guid = intent.getStringExtra("guid");
        title = intent.getStringExtra("title");

        OkHttpUtils.getInstance().sendGET(Urls.VIDEOPLAY + guid, new CallBacks() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                Look_VideoEntiy look_videoEntiy = gson.fromJson(result, Look_VideoEntiy.class);
                List<Look_VideoEntiy.VideoBean.ChaptersBean> chapters = look_videoEntiy.getVideo().getChapters();

                list.clear();
                list.addAll(chapters);

                String url = list.get(0).getUrl();

//                jzVideoPlayerStandard.setUp(url, title);
                jzVideoPlayerStandard.setUp(url,title,true);


            }

            @Override
            public void failure(String result) {

            }
        });


    }

    @Override
    public void initListener() {

    }

    @Override
    public void initView() {
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        jzVideoPlayerStandard = (JCVideoPlayer) findViewById(R.id.videoplayer);

    }

    @Override
    public int getLayout() {
        return R.layout.activity_look_video;
    }






}
