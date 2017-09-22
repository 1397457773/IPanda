package com.jiyun.ipandatv.ui.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.jiyun.ipandatv.R;
import com.jiyun.ipandatv.adpater.LiveAdapter;
import com.jiyun.ipandatv.base.BaseFragment;
import com.jiyun.ipandatv.model.entity.FunEnity;
import com.jiyun.ipandatv.model.entity.LiveEnity;
import com.jiyun.ipandatv.model.entity.LivetwoEnity;
import com.jiyun.ipandatv.presenter.LivePresenter;
import com.jiyun.ipandatv.presenter.LivePresenterImp;

import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * A simple {@link Fragment} subclass.
 */
public class showFragment extends BaseFragment implements LivePresenter.BaseView<FunEnity.VideoBean>{


    private JCVideoPlayer videocontroller1;
    private TabLayout tablayout;
    private ViewPager viewpager;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> title;
    private TextView tv_title;
    private TextView tv_content;

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_show;
    }

    @Override
    protected void initFragmentView(View view) {
        videocontroller1 = (JCVideoPlayer) view.findViewById(R.id.videocontroller1);
        tablayout = (TabLayout) view.findViewById(R.id.tablayout);
        viewpager = (ViewPager) view.findViewById(R.id.viewpager);
        tv_title = (TextView) view.findViewById(R.id.tv_title);
        tv_content = (TextView) view.findViewById(R.id.tv_content);
    }

    @Override
    protected void initFragmentData() {

        fragments = new ArrayList<>();
        fragments.add(new LiveshowFragment());
        fragments.add(new talkFragment());

        title = new ArrayList<>();
        title.add("多视角直播");
        title.add("边看边聊");

        LiveAdapter liveAdapter = new LiveAdapter(getChildFragmentManager(), fragments, title);
        viewpager.setAdapter(liveAdapter);
        tablayout.setupWithViewPager(viewpager);


        LivePresenterImp livePresenterImp = new LivePresenterImp(this);
        livePresenterImp.getHomeMessage();

    }

    @Override
    protected void updateFragmentTitleBar() {

    }

    @Override
    protected void setBundle(Bundle bundle) {

    }


    @Override
    public void showDatas(List<FunEnity.VideoBean> fresh, List<FunEnity.VideoBean> special, List<FunEnity.VideoBean> thing, List<FunEnity.VideoBean> top, List<FunEnity.VideoBean> list, List<FunEnity.VideoBean> two, List<FunEnity.VideoBean> book, ArrayList<FunEnity.VideoBean> bear) {

    }

    @Override
    public void live(ArrayList<LiveEnity> liveEnities, ArrayList<LivetwoEnity.ListBean> livetwoEnities) {
        String title = liveEnities.get(0).getLive().get(0).getTitle();
        String brief = liveEnities.get(0).getLive().get(0).getBrief();
        tv_title.setText(title);
        tv_content.setText(brief);

    }



    @Override
    public void showProgressDialog() {

    }

    @Override
    public void dismissProgressDialog() {

    }
}
