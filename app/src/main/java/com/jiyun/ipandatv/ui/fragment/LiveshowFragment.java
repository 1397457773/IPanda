package com.jiyun.ipandatv.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jiyun.ipandatv.R;
import com.jiyun.ipandatv.adpater.RecyclerAdapter;
import com.jiyun.ipandatv.base.BaseFragment;
import com.jiyun.ipandatv.model.entity.FunEnity;
import com.jiyun.ipandatv.model.entity.LiveEnity;
import com.jiyun.ipandatv.model.entity.LivetwoEnity;
import com.jiyun.ipandatv.presenter.LivePresenter;
import com.jiyun.ipandatv.presenter.LivePresenterImp;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class LiveshowFragment extends BaseFragment implements LivePresenter.BaseView<FunEnity.VideoBean>{


    private RecyclerView recyclerView;

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_liveshow;
    }

    @Override
    protected void initFragmentView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);

    }

    @Override
    protected void initFragmentData() {
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
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        recyclerView.setLayoutManager(gridLayoutManager);
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(getActivity(), livetwoEnities);
        recyclerView.setAdapter(recyclerAdapter);
    }



    @Override
    public void showProgressDialog() {

    }

    @Override
    public void dismissProgressDialog() {

    }
}
