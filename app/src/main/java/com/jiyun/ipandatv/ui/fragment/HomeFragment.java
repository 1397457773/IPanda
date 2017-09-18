package com.jiyun.ipandatv.ui.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jiyun.ipandatv.App;
import com.jiyun.ipandatv.R;
import com.jiyun.ipandatv.adpater.HorizRecyAdapter;
import com.jiyun.ipandatv.adpater.MyRecyAdapter;
import com.jiyun.ipandatv.base.BaseFragment;
import com.jiyun.ipandatv.model.callbacks.CallBacks;
import com.jiyun.ipandatv.model.entity.HomeEntiy;
import com.jiyun.ipandatv.model.entity.HomeVideo;
import com.jiyun.ipandatv.model.utils.OkHttpUtils;
import com.jiyun.ipandatv.model.utils.Urls;
import com.jiyun.ipandatv.presenter.HomePresenter;
import com.jiyun.ipandatv.presenter.HomePresenterImp;
import com.jiyun.ipandatv.ui.activity.DownLoadActivity;
import com.jiyun.ipandatv.ui.activity.VideoActivity;
import com.kevin.wraprecyclerview.WrapRecyclerView;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment implements HomePresenter.BaseView<HomeEntiy>{


    private Banner banner;
    private WrapRecyclerView wrv_view;
    private List<String> mList;
    private List<String> tList;
    private HomeEntiy.DataBean data;
    private List<HomeEntiy.DataBean> list = new ArrayList<>();
    private HorizRecyAdapter horizRecyAdapter;
    private MyRecyAdapter myRecyAdapter;

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initFragmentView(View view) {
        wrv_view =(WrapRecyclerView) view.findViewById(R.id.wrv_view);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.item_banner_head, null);
        banner =(Banner) inflate.findViewById(R.id.banner);

        wrv_view.addHeaderView(inflate);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        wrv_view.setLayoutManager(manager);
        myRecyAdapter = new MyRecyAdapter(list, getContext());
        wrv_view.setAdapter(myRecyAdapter);
        HomePresenterImp homePresenterImp = new HomePresenterImp(this);
        homePresenterImp.getHomeMessage();
    }


    @Override
    protected void initFragmentData() {



    }

    @Override
    protected void updateFragmentTitleBar() {

    }

    @Override
    protected void setBundle(Bundle bundle) {

    }

    @Override
    public void showDatas(List<HomeEntiy> mBean) {
        for (int i = 0; i < mBean.size(); i++) {
            HomeEntiy homeEntiy = mBean.get(i);
            data = homeEntiy.getData();
        }
        List<HomeEntiy.DataBean.BigImgBean> bigImg = data.getBigImg();
        mList = new ArrayList<>();
        mList.add(bigImg.get(0).getImage());
        mList.add(bigImg.get(1).getImage());
        mList.add(bigImg.get(2).getImage());
        mList.add(bigImg.get(3).getImage());
        tList=new ArrayList<>();
        tList.add("");
        tList.add(bigImg.get(1).getTitle());
        tList.add(bigImg.get(2).getTitle());
        tList.add(bigImg.get(3).getTitle());

        //设置banner样式
        banner.setBannerStyle(BannerConfig.LEFT);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(mList);
        //设置标题集合（当banner样式有显示title时）
        banner.setBannerTitles(tList);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.RIGHT);
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(final int position) {
               if (position==0){
                   Intent intent = new Intent(getActivity(), DownLoadActivity.class);
                   startActivity(intent);

               }else {
                   OkHttpUtils.getInstance().sendGET(Urls.VIDEOPLAY + list.get(1).getBigImg().get(position).getPid(), new CallBacks() {
                       @Override
                       public void success(String result) {
                           Gson gson = new Gson();
                           HomeVideo homeVideo = gson.fromJson(result, HomeVideo.class);
                           HomeVideo.VideoBean video = homeVideo.getVideo();
                           List<HomeVideo.VideoBean.ChaptersBean> chapters = video.getChapters();

                           Intent intent = new Intent(getActivity(), VideoActivity.class);
                           intent.putExtra("url",chapters.get(0).getUrl());
                           intent.putExtra("title",list.get(1).getBigImg().get(position ).getTitle());
                           startActivity(intent);
                       }

                       @Override
                       public void failure(String result) {

                       }
                   });

               }
            }
        });
        banner.start();
        list.clear();
        for (int i = 0; i < 6; i++) {
            list.add(data);
        }

         myRecyAdapter.notifyDataSetChanged();

    }

    @Override
    public void error(String string) {

    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void dismissProgressDialog() {


    }
    public class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            String url = (String) path;
            Picasso.with(context).load(url).into(imageView);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        banner.stopAutoPlay();
    }
}
