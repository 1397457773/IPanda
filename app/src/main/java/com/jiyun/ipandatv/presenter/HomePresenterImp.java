package com.jiyun.ipandatv.presenter;

import android.os.Handler;

import com.jiyun.ipandatv.model.HomeModelData;

/**
 * Created by Lenovo on 2017/9/13.
 */

public class HomePresenterImp implements HomePresenter.BasePresenter {
    private HomePresenter.BaseView baseView;
    private final HomeModelData iModelImp;
    private Handler handler = new Handler();


    public HomePresenterImp(HomePresenter.BaseView baseView) {
        this.baseView = baseView;
        iModelImp = new HomeModelData();
    }

    @Override
    public void getHomeMessage() {

    }
}