package com.jiyun.ipandatv.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jiyun.ipandatv.R;
import com.jiyun.ipandatv.model.callbacks.CallBacks;
import com.jiyun.ipandatv.model.entity.Home_GuoBao_JingCai;
import com.jiyun.ipandatv.model.entity.Home_GuoBao_Video;
import com.jiyun.ipandatv.model.entity.Home_Video;
import com.jiyun.ipandatv.model.entity.Home_Video1;
import com.jiyun.ipandatv.model.utils.OkHttpUtils;
import com.jiyun.ipandatv.model.utils.Urls;
import com.jiyun.ipandatv.ui.fragment.GaoQingFragment;
import com.jiyun.ipandatv.ui.fragment.JingCaiFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class CCTVActivity extends AppCompatActivity implements GaoQingFragment.MyData,JingCaiFragment.MyDatabase{
    @Bind(R.id.iv_img_back)
    ImageView ivImgBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.videocontroller1)
    JCVideoPlayer videocontroller1;
    @Bind(R.id.tv_first_time)
    TextView tvFirstTime;
    @Bind(R.id.tv_info_jieshao)
    TextView tvInfoJieshao;
    @Bind(R.id.ll_Layout)
    LinearLayout llLayout;
    @Bind(R.id.iv_content)
    ImageView ivContent;
    @Bind(R.id.tv_content)
    TextView tvContent;
    @Bind(R.id.tab_Layout)
    TabLayout tabLayout;
    @Bind(R.id.vip_Pager)
    ViewPager vipPager;
    @Bind(R.id.iv_img_shoucang)
    ImageView ivImgShoucang;
    @Bind(R.id.iv_img_share)
    ImageView ivImgShare;
    private ArrayList<String> strings;
    private ArrayList<Fragment> fragments;
    private List<Home_GuoBao_Video> mList;
    private int tag;
    private Home_GuoBao_Video video;
    private GaoQingFragment gaoQingFragment;
    private JingCaiFragment jingCaiFragment;
    private List<Home_GuoBao_JingCai> list;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cctv);
        ButterKnife.bind(this);
        initIntent();
        initListener();



    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    private void initListener() {
        ivContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tag++;
                if (tag==1){
                    tvContent.setText(video.getVideoset().get_$0().getDesc());
                    tvContent.setVisibility(View.VISIBLE);
                    ivContent.setImageResource(R.drawable.com_facebook_tooltip_blue_topnub);
                }else {
                    ivContent.setImageResource(R.drawable.com_facebook_tooltip_blue_bottomnub);
                    tvContent.setVisibility(View.GONE);
                    tag=0;
                }

            }
        });
        ivImgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ivImgShoucang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




            }
        });
        ivImgShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

    }

    String url;
    String url1;
    private void initIntent() {
        Intent intent = getIntent();
        url= intent.getStringExtra("url");
        url1 = intent.getStringExtra("url1");
        String title = intent.getStringExtra("title");
        tvTitle.setText(title);
        OkHttpUtils.getInstance().sendGET(url, new CallBacks() {


            @Override
            public void success(String result) {
                Gson gson = new Gson();
                video = gson.fromJson(result, Home_GuoBao_Video.class);
                tvFirstTime.setText("首播时间:"+video.getVideoset().get_$0().getSbsj());
                mList = new ArrayList<Home_GuoBao_Video>();
                mList.clear();
                mList.add(video);
                initData();

            }

            @Override
            public void failure(String result) {

            }
        });
        OkHttpUtils.getInstance().sendGET(url1, new CallBacks() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                Home_GuoBao_JingCai home_guoBao_jingCai = gson.fromJson(result, Home_GuoBao_JingCai.class);
                list = new ArrayList<Home_GuoBao_JingCai>();
                list.clear();
                list.add(home_guoBao_jingCai);
                initData();
            }

            @Override
            public void failure(String result) {

            }
        });
    }


    private void initData() {
        strings = new ArrayList<>();
        strings.add("高清完整");
        strings.add("精彩看点");

        fragments = new ArrayList<>();
        gaoQingFragment = new GaoQingFragment(mList);
        gaoQingFragment.onData(this);
        fragments.add(gaoQingFragment);
        jingCaiFragment = new JingCaiFragment(list);
        jingCaiFragment.onDataBase(this);
        fragments.add(jingCaiFragment);

        tabLayout.addTab(tabLayout.newTab().setText(strings.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(strings.get(1)));

        tabLayout.setupWithViewPager(vipPager);

        MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager());
        vipPager.setAdapter(myAdapter);
    }

    @Override
    public void setData(String id) {
        OkHttpUtils.getInstance().sendGET(Urls.VIDEOPLAY + id, new CallBacks() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                Home_Video home_video = gson.fromJson(result, Home_Video.class);
                Home_Video.VideoBean video = home_video.getVideo();
                List<Home_Video.VideoBean.ChaptersBean> chapters = video.getChapters();
                String url = chapters.get(0).getUrl();
                videocontroller1.setUp(url,null);
                videocontroller1.ivStart.setFocusable(false);
                videocontroller1.ivStart.performClick();
            }

            @Override
            public void failure(String result) {

            }
        });

    }

    @Override
    public void setDataBase(String vid) {
        OkHttpUtils.getInstance().sendGET(Urls.VIDEOPLAY + vid, new CallBacks() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                Home_Video1 home_video1 = gson.fromJson(result, Home_Video1.class);
                Home_Video1.VideoBean video = home_video1.getVideo();
                List<Home_Video1.VideoBean.ChaptersBean> chapters = video.getChapters();
                String url = chapters.get(0).getUrl();
                videocontroller1.setUp(url,null);
                videocontroller1.ivStart.setFocusable(false);
                videocontroller1.ivStart.performClick();
            }

            @Override
            public void failure(String result) {

            }
        });
    }

    private class MyAdapter extends FragmentPagerAdapter{
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return strings.get(position);
        }
    }


}

