package com.jiyun.ipandatv.presenter;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.jiyun.ipandatv.model.HomeModelData;
import com.jiyun.ipandatv.model.callbacks.CallBacks;
import com.jiyun.ipandatv.model.entity.HomeEntiy;
import com.jiyun.ipandatv.model.entity.LiveChinaEntiy;
import com.jiyun.ipandatv.model.utils.Urls;

import java.util.ArrayList;
import java.util.List;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

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
        baseView.showProgressDialog();
        iModelImp.getHomeOhhttp(Urls.LIVECHINA, new CallBacks() {
        baseView.showProgressDialog();
        iModelImp.getHomeOhhttp(Urls.PANDAHOME, new CallBacks() {
            @Override
            public void success(String result) {
                Gson gson=new Gson();
                Type type= new TypeToken<LiveChinaEntiy>(){}.getType();
                LiveChinaEntiy liveChinaEntiy = gson.fromJson(result, type);
                List<LiveChinaEntiy> list=new ArrayList<LiveChinaEntiy>();
                list.add(liveChinaEntiy);
                Log.e("Tag","_________"+list);
                baseView.showDatas(list);
                baseView.dismissProgressDialog();
                Gson gson = new Gson();
                HomeEntiy homeEntiy = gson.fromJson(result, HomeEntiy.class);
                List<HomeEntiy> homeEntiys = new ArrayList<>();
                homeEntiys.add(homeEntiy);
                baseView.showDatas(homeEntiys);
                baseView.dismissProgressDialog();




            }

            @Override
            public void failure(String result) {
                baseView.error(result);
                baseView.dismissProgressDialog();
            }
        });
    }
}
