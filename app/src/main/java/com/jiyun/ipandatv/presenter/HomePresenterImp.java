package com.jiyun.ipandatv.presenter;

import com.jiyun.ipandatv.model.HomeModelData;
import com.jiyun.ipandatv.model.callbacks.CallBacks;
import com.jiyun.ipandatv.model.utils.OkHttpUtils;
import com.jiyun.ipandatv.model.utils.Urls;

/**
 * Created by Lenovo on 2017/9/13.
 */

public class HomePresenterImp implements HomePresenter.BasePresenter {
    private HomePresenter.BaseView baseView;
    private final HomeModelData iModelImp;

    public HomePresenterImp(HomePresenter.BaseView baseView) {
        this.baseView = baseView;

        iModelImp = new HomeModelData();
    }


    @Override
    public void getHomeMessage() {
        iModelImp.getHomeOhhttp(Urls.PANDABROADCAST, new CallBacks() {
            @Override
            public void success(String result) {
              baseView.error(result);
            }

            @Override
            public void failure(String result) {

            }
        });
    }
}
