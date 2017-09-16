package com.jiyun.ipandatv.presenter;

import com.google.gson.Gson;
import com.jiyun.ipandatv.model.HomeModelData;
import com.jiyun.ipandatv.model.callbacks.CallBacks;
import com.jiyun.ipandatv.model.entity.LookImgEntiy;
import com.jiyun.ipandatv.model.entity.LookInfoEntiy;
import com.jiyun.ipandatv.model.utils.Urls;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2017/9/13.
 */

public class LookPresenterImpInfo implements LookPresenterInfo.BasePresenterInfo {
    private LookPresenterInfo.BaseViewInfo baseView;
    private HomeModelData homeModelData;

    public LookPresenterImpInfo(LookPresenterInfo.BaseViewInfo baseView) {
        this.baseView = baseView;
        homeModelData = new HomeModelData();
    }


    @Override
    public void getHomeMessage() {
        baseView.showProgressDialog();
        homeModelData.getHomeOhhttp(Urls.PANDABROADCAST, new CallBacks() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                LookImgEntiy lookEntiy = gson.fromJson(result, LookImgEntiy.class);
                List<LookImgEntiy> lookEntiys = new ArrayList<LookImgEntiy>();
                lookEntiys.add(lookEntiy);

                baseView.showDatas(lookEntiys);
                baseView.dismissProgressDialog();
            }

            @Override
            public void failure(String result) {

            }
        });
    }

    @Override
    public void getDatas() {
        baseView.showProgressDialog();
        homeModelData.getHomeOhhttp(Urls.PANDABROADCAST2, new CallBacks() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                LookInfoEntiy lookInfoEntiy = gson.fromJson(result, LookInfoEntiy.class);
                List<LookInfoEntiy> list = new ArrayList<LookInfoEntiy>();
                list.add(lookInfoEntiy);
                baseView.showInfoData(list);

                baseView.dismissProgressDialog();
            }

            @Override
            public void failure(String result) {

            }
        });
    }
}
