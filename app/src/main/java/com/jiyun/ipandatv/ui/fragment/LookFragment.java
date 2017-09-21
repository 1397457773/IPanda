package com.jiyun.ipandatv.ui.fragment;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jiyun.ipandatv.App;
import com.jiyun.ipandatv.R;
import com.jiyun.ipandatv.adpater.Look_XRecycler_Adapter;
import com.jiyun.ipandatv.base.BaseFragment;
import com.jiyun.ipandatv.model.callbacks.CallBacks;
import com.jiyun.ipandatv.model.entity.LookImgEntiy;
import com.jiyun.ipandatv.model.entity.LookInfoEntiy;
import com.jiyun.ipandatv.model.utils.OkHttpUtils;
import com.jiyun.ipandatv.model.utils.Urls;
import com.jiyun.ipandatv.presenter.LookPresenterImg;
import com.jiyun.ipandatv.presenter.LookPresenterInfo;
import com.jiyun.ipandatv.presenter.LookPresenterImpInfo;
import com.jiyun.ipandatv.ui.activity.LookInfoActivity;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class LookFragment extends BaseFragment implements LookPresenterImg.BaseViewImg<LookImgEntiy>, LookPresenterInfo.BaseViewInfo<LookInfoEntiy> {

    private TextView tv_HeadTitle;
    private XRecyclerView mListView_look;
    private List<LookImgEntiy.DataBean.BigImgBean> listHead = new ArrayList<>();
    private List<LookInfoEntiy.ListBean> listInfo = new ArrayList<>();
    private ProgressDialog dialog;
    private Look_XRecycler_Adapter adapter;
    private RollPagerView roll_ViewPager;
    private int x = 0;
    public boolean netStatus = false;
    private LinearLayout linear;
    // 标志位，标志已经初始化完成。
    private boolean isPrepared ;

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_look;
    }

    @Override
    protected void initFragmentView(View view) {
        isPrepared = true;
        mListView_look = view.findViewById(R.id.mListView_look);
        linear = view.findViewById(R.id.linear);

        initFragmentData();
        NetworkStatus(App.mActivity);


    }

    public void NetworkStatus(Context context) {
        ConnectivityManager con = (ConnectivityManager) context.getSystemService(Activity.CONNECTIVITY_SERVICE);
        boolean wifi = con.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnectedOrConnecting();
        boolean internet = con.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnectedOrConnecting();
        if (internet) {
            //执行相关操作
            //连接到移动网络
            netStatus = true;
            adapter = new Look_XRecycler_Adapter(listInfo, App.mActivity);
            mListView_look.setLayoutManager(new LinearLayoutManager(App.mActivity, LinearLayoutManager.VERTICAL, false));
            mListView_look.setAdapter(adapter);
            Toast.makeText(context, "以连接到移动网络", Toast.LENGTH_SHORT).show();
        } else if (wifi) {
            //连接到WiFi
            netStatus = true;
            adapter = new Look_XRecycler_Adapter(listInfo, App.mActivity);
            mListView_look.setLayoutManager(new LinearLayoutManager(App.mActivity, LinearLayoutManager.VERTICAL, false));
            mListView_look.setAdapter(adapter);
            Toast.makeText(context, "以连接到WiFi", Toast.LENGTH_SHORT).show();
        } else {
            //无网络
            linear.setBackground(getResources().getDrawable(R.drawable._no_net));
            netStatus = true;
            adapter = new Look_XRecycler_Adapter(listInfo, App.mActivity);
            mListView_look.setLayoutManager(new LinearLayoutManager(App.mActivity, LinearLayoutManager.VERTICAL, false));
            mListView_look.setAdapter(adapter);
            Toast.makeText(context, "无网络", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void initFragmentData() {
        if (!isPrepared || isVisible){
            return;
        }
        LookPresenterImpInfo lookPresenterImp = new LookPresenterImpInfo(this);
        dialog = new ProgressDialog(getContext());
        lookPresenterImp.getHomeMessage();
        lookPresenterImp.getDatas();


    }


    @Override
    protected void updateFragmentTitleBar() {

    }

    @Override
    protected void setBundle(Bundle bundle) {

    }


    @Override
    public void showInfoData(List<LookInfoEntiy> mList) {
        listInfo.clear();
        for (int i = 0; i < mList.size(); i++) {
            listInfo.addAll(mList.get(i).getList());
        }

        mListView_look.setPullRefreshEnabled(true);
        mListView_look.setLoadingMoreEnabled(true);
        adapter.notifyDataSetChanged();


        initListener();


    }

    private void initListener() {

        mListView_look.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                //refresh data here

                mListView_look.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                // load more data here

                OkHttpUtils.getInstance().sendGET(Urls.SHANGLAURL, new CallBacks() {
                    @Override
                    public void success(String result) {

                        Gson gson = new Gson();
                        LookInfoEntiy lookInfoEntiy = gson.fromJson(result, LookInfoEntiy.class);
                        List<LookInfoEntiy.ListBean> list = lookInfoEntiy.getList();

                        listInfo.addAll(listInfo.size() - 1, list);

                        mListView_look.loadMoreComplete();
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void failure(String result) {

                    }
                });

            }
        });

    }


    @Override
    public void showDatas(List mBean) {
        listHead.clear();
        for (int i = 0; i < mBean.size(); i++) {
            LookImgEntiy lookImgEntiy = (LookImgEntiy) mBean.get(i);
            LookImgEntiy.DataBean data = lookImgEntiy.getData();
            listHead.addAll(data.getBigImg());
        }

        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 600);
        View view = LayoutInflater.from(App.mActivity).inflate(R.layout.item_lookheadview, null, false);
        view.setLayoutParams(layoutParams);
        tv_HeadTitle = view.findViewById(R.id.tv_headTitle);
        roll_ViewPager = view.findViewById(R.id.roll_ViewPager);

        tv_HeadTitle.setText(listHead.get(0).getTitle());
        RollViewPagerAdapter rollViewPagerAdapter = new RollViewPagerAdapter();
        roll_ViewPager.setHintView(null);
        roll_ViewPager.setAdapter(rollViewPagerAdapter);

        mListView_look.addHeaderView(view);
    }

    @Override
    public void error(String string) {

    }

    @Override
    public void showProgressDialog() {
        dialog.show();
    }

    @Override
    public void dismissProgressDialog() {

        dialog.dismiss();
    }

    public class RollViewPagerAdapter extends StaticPagerAdapter {

        @Override
        public int getCount() {
            return listHead.size();
        }

        @Override
        public View getView(ViewGroup container, int position) {
            View view = View.inflate(getActivity(), R.layout.item_headimg, null);
            ImageView img = view.findViewById(R.id.iv_headImg);
            Picasso.with(getActivity().getApplicationContext()).load(listHead.get(position).getImage()).into(img);
            img.setScaleType(ImageView.ScaleType.FIT_XY);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), LookInfoActivity.class);
                    intent.putExtra("id", listHead.get(0).getId());
                    startActivity(intent);
                }
            });
            return view;
        }
    }

}
