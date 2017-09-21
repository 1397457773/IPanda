package com.jiyun.ipandatv.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;
import com.jiyun.ipandatv.R;
import com.jiyun.ipandatv.model.HomeModelData;
import com.jiyun.ipandatv.model.callbacks.CallBacks;
import com.jiyun.ipandatv.model.entity.VideoEnity;
import com.jiyun.ipandatv.model.utils.Urls;

import java.util.ArrayList;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class Main2Activity extends AppCompatActivity {


    private HomeModelData homeModelData;
    private ArrayList<VideoEnity> videoBeen;
    private JCVideoPlayer videocontroller1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        initdata();
    }

    private void initdata() {
        Intent intent = getIntent();
        String vid = intent.getStringExtra("vid");
        homeModelData.getHomeOhhttp(Urls.VIDEOPLAY + vid, new CallBacks() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                VideoEnity videoEnity = gson.fromJson(result, VideoEnity.class);
                videoBeen = new ArrayList<>();
                videoBeen.add(videoEnity);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String url = videoBeen.get(0).getVideo().getChapters().get(0).getUrl();
                        String title = videoBeen.get(0).getTag();
                        videocontroller1.setUp(url,title);

                    }
                });
            }

            @Override
            public void failure(String result) {

            }
        });
    }

    private void initView() {

        homeModelData = new HomeModelData();

        videocontroller1 = (JCVideoPlayer) findViewById(R.id.videocontroller1);

    }
}
