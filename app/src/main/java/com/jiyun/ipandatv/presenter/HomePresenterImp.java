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
    private Handler handler = new Handler();


    public HomePresenterImp(HomePresenter.BaseView baseView) {
        this.baseView = baseView;

        iModelImp = new HomeModelData();
    }


    @Override
    public void getHomeMessage() {
        baseView.showProgressDialog();
        iModelImp.getHomeOhhttp(Urls.PANDAHOME, new CallBacks() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                HomeEntiy homeEntiy = gson.fromJson(result, HomeEntiy.class);
                List<HomeEntiy> homeEntiys = new ArrayList<>();
                homeEntiys.add(homeEntiy);
                baseView.showDatas(homeEntiys);
                baseView.dismissProgressDialog();




            }

            @Override
            public void failure(String result) {

            }
        });
    }
}
