package com.jiyun.ipandatv.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

import com.jiyun.ipandatv.App;
import com.jiyun.ipandatv.R;
import com.jiyun.ipandatv.base.BaseFragment;
import com.jiyun.ipandatv.presenter.HomePresenter;
import com.jiyun.ipandatv.presenter.HomePresenterImp;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment implements HomePresenter.BaseView{


    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initFragmentView(View view) {
        HomePresenterImp homePresenterImp = new HomePresenterImp(this);
//        homePresenterImp.getHomeMessage();
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
    public void showDatas(List mBean) {

    }

    @Override
    public void error(String string) {
        Toast.makeText(App.mActivity, string, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void dismissProgressDialog() {

    }
}
