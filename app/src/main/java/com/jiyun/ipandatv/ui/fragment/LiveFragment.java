package com.jiyun.ipandatv.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jiyun.ipandatv.R;
import com.jiyun.ipandatv.adpater.FragAdapter;
import com.jiyun.ipandatv.adpater.threeAdapter;
import com.jiyun.ipandatv.adpater.TwoAdapter;
import com.jiyun.ipandatv.base.BaseFragment;
import com.jiyun.ipandatv.model.entity.FunEnity;
import com.jiyun.ipandatv.model.entity.LiveEnity;
import com.jiyun.ipandatv.model.entity.LivetwoEnity;
import com.jiyun.ipandatv.presenter.LivePresenter;
import com.jiyun.ipandatv.presenter.LivePresenterImp;
import com.jiyun.ipandatv.ui.activity.Main2Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class LiveFragment extends BaseFragment implements LivePresenter.BaseView<FunEnity.VideoBean> {


    private TabLayout tab;
    private ListView listView;
    private ArrayList<Fragment> fragments;
    private ViewPager viewPager;


    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_live;
    }

    @Override
    protected void initFragmentView(View view) {
        //获取控价ID
        tab = (TabLayout) view.findViewById(R.id.tablayout);
        listView = (ListView) view.findViewById(R.id.listview);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        //加载直播fragment
        fragments = new ArrayList<>();
        fragments.add(new showFragment());
        FragAdapter fragAdapter = new FragAdapter(getActivity().getSupportFragmentManager(), fragments);
        viewPager.setAdapter(fragAdapter);
        //设置首页时listview隐藏
        listView.setVisibility(View.INVISIBLE);
        viewPager.setVisibility(View.VISIBLE);
        tab();
    }
    private void tab() {
        //添加tab标签
        tab.addTab(tab.newTab().setText("直播"));
        tab.addTab(tab.newTab().setText("熊猫那些事"));
        tab.addTab(tab.newTab().setText("特别节目"));
        tab.addTab(tab.newTab().setText("原创新闻"));
        tab.addTab(tab.newTab().setText("精彩一刻"));
        tab.addTab(tab.newTab().setText("熊猫档案"));
        tab.addTab(tab.newTab().setText("超萌滚滚秀"));
        tab.addTab(tab.newTab().setText("熊猫TOP榜"));
        tab.addTab(tab.newTab().setText("当熊不让"));
    }

    @Override
    protected void initFragmentData() {
        //调用presenter层方法
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
    public void showDatas(final List<FunEnity.VideoBean> fresh, final List<FunEnity.VideoBean> special, final List<FunEnity.VideoBean> thing, final List<FunEnity.VideoBean> top, final List<FunEnity.VideoBean> list, final List<FunEnity.VideoBean> two, final List<FunEnity.VideoBean> book, final ArrayList<FunEnity.VideoBean> bear) {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), Main2Activity.class);
                intent.putExtra("vid", fresh.get(i).getVid());
                startActivity(intent);
            }
        });
        //设置tab选择监听
        tab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //获取tab的索引来做listview的处理
                if (tab.getPosition() == 0) {
                    listView.setVisibility(View.INVISIBLE);
                    viewPager.setVisibility(View.VISIBLE);
                }
                if (tab.getPosition() == 1) {
                    listView.setVisibility(View.VISIBLE);
                    viewPager.setVisibility(View.INVISIBLE);
                    threeAdapter threeAdapter = new threeAdapter(getActivity(), list);
                    listView.setAdapter(threeAdapter);

                }
                if (tab.getPosition() == 2) {
                    listView.setVisibility(View.VISIBLE);
                    viewPager.setVisibility(View.INVISIBLE);
                    TwoAdapter twoAdapter = new TwoAdapter(getActivity(), two);
                    listView.setAdapter(twoAdapter);

                }
                if (tab.getPosition() == 3) {
                    listView.setVisibility(View.VISIBLE);
                    viewPager.setVisibility(View.INVISIBLE);
                    threeAdapter threeAdapter = new threeAdapter(getActivity(), book);
                    listView.setAdapter(threeAdapter);

                }
                if (tab.getPosition() == 4) {
                    listView.setVisibility(View.VISIBLE);
                    viewPager.setVisibility(View.INVISIBLE);
                    threeAdapter threeAdapter = new threeAdapter(getActivity(), fresh);
                    listView.setAdapter(threeAdapter);

                }
                if (tab.getPosition() == 5) {
                    listView.setVisibility(View.VISIBLE);
                    viewPager.setVisibility(View.INVISIBLE);
                    threeAdapter threeAdapter = new threeAdapter(getActivity(), thing);
                    listView.setAdapter(threeAdapter);

                }
                if (tab.getPosition() == 6) {
                    listView.setVisibility(View.VISIBLE);
                    viewPager.setVisibility(View.INVISIBLE);
                    threeAdapter threeAdapter = new threeAdapter(getActivity(), special);
                    listView.setAdapter(threeAdapter);

                }
                if (tab.getPosition() == 7) {
                    listView.setVisibility(View.VISIBLE);
                    viewPager.setVisibility(View.INVISIBLE);
                    threeAdapter threeAdapter = new threeAdapter(getActivity(), top);
                    listView.setAdapter(threeAdapter);
                }
                if (tab.getPosition() == 8) {
                    listView.setVisibility(View.VISIBLE);
                    viewPager.setVisibility(View.INVISIBLE);
                    threeAdapter threeAdapter = new threeAdapter(getActivity(), bear);
                    listView.setAdapter(threeAdapter);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void live(ArrayList<LiveEnity> liveEnities, ArrayList<LivetwoEnity.ListBean> livetwoEnities) {

    }


    @Override
    public void showProgressDialog() {

    }

    @Override
    public void dismissProgressDialog() {

    }


}
