package com.jiyun.ipandatv.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

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

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class Look_VideoActivity extends BaseActivity {

    private JCVideoPlayer jcVideoPlayer;
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
                if (url != null){
                    jcVideoPlayer.setUp(url,title,true);
                    jcVideoPlayer.ivStart.setClickable(false);
                    jcVideoPlayer.ivStart.performClick();


                }else {
                    Toast.makeText(Look_VideoActivity.this, "地址为空", Toast.LENGTH_SHORT).show();
                }



            }

            @Override
            public void failure(String result) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        if (jcVideoPlayer.isPressed()){
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onStop() {
        super.onStop();
        jcVideoPlayer.destroyDrawingCache();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initView() {
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        jcVideoPlayer = (JCVideoPlayer) findViewById(R.id.videoplayer);

    }

    @Override
    public int getLayout() {
        return R.layout.activity_look_video;
    }






}
