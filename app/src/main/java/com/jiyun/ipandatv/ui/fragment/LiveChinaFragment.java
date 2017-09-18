package com.jiyun.ipandatv.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiyun.ipandatv.R;
import com.jiyun.ipandatv.base.BaseFragment;
import com.jiyun.ipandatv.presenter.HomePresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class LiveChinaFragment extends BaseFragment implements HomePresenter.BaseView {


    public LiveChinaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_live_china, container, false);
    }

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_live_china;
    }

    @Override
    protected void initFragmentView(View view) {

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
    public void showProgressDialog() {

    }

    @Override
    public void dismissProgressDialog() {

    }






    @Override
    public void showDatas() {

    }

    @Override
    public void error(String string) {

    }
}
