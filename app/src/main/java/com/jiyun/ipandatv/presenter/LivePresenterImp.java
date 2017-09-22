package com.jiyun.ipandatv.presenter;

import android.os.Handler;

import com.google.gson.Gson;
import com.jiyun.ipandatv.model.HomeModelData;
import com.jiyun.ipandatv.model.callbacks.CallBacks;
import com.jiyun.ipandatv.model.entity.FunEnity;
import com.jiyun.ipandatv.model.entity.LiveEnity;
import com.jiyun.ipandatv.model.entity.LivetwoEnity;
import com.jiyun.ipandatv.model.utils.Urls;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/9/18.
 */
public class LivePresenterImp implements LivePresenter.BasePresenter {
    private LivePresenter.BaseView baseView;
    private final HomeModelData iModelImp;
    private Handler handler = new Handler();
    private List<FunEnity.VideoBean> list;
    private List<FunEnity.VideoBean> two;
    private ArrayList<FunEnity.VideoBean> book;
    private ArrayList<FunEnity.VideoBean> top;
    private ArrayList<FunEnity.VideoBean> thing;
    private ArrayList<FunEnity.VideoBean> special;
    private ArrayList<FunEnity.VideoBean> fresh;
    private ArrayList<LivetwoEnity.ListBean> livetwoEnities;
    private ArrayList<LiveEnity> liveEnities;
    private ArrayList<FunEnity.VideoBean> bear;

    public LivePresenterImp(LivePresenter.BaseView baseView) {
        this.baseView = baseView;
        iModelImp = new HomeModelData();
    }
    @Override
    public void getHomeMessage() {
        //网络请求数据解析放入listview
        iModelImp.getHomeOhhttp(Urls.FOUTFUN, new CallBacks() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                FunEnity funEnity = gson.fromJson(result, FunEnity.class);
                List<FunEnity.VideoBean> video = funEnity.getVideo();
                list = new ArrayList<FunEnity.VideoBean>();
                list.addAll(video);

            }

            @Override
            public void failure(String result) {

            }
        });
        iModelImp.getHomeOhhttp(Urls.FOUROUT, new CallBacks() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                FunEnity funEnity = gson.fromJson(result, FunEnity.class);
                List<FunEnity.VideoBean> video = funEnity.getVideo();
                two = new ArrayList<FunEnity.VideoBean>();
                two.addAll(video);

            }

            @Override
            public void failure(String result) {

            }
        });
        iModelImp.getHomeOhhttp(Urls.FOURBOOK, new CallBacks() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                FunEnity funEnity = gson.fromJson(result, FunEnity.class);
                List<FunEnity.VideoBean> video = funEnity.getVideo();
                book = new ArrayList<FunEnity.VideoBean>();
                book.addAll(video);
            }

            @Override
            public void failure(String result) {

            }
        });
        iModelImp.getHomeOhhttp(Urls.FOURTOP, new CallBacks() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                FunEnity funEnity = gson.fromJson(result, FunEnity.class);
                List<FunEnity.VideoBean> video = funEnity.getVideo();
                top = new ArrayList<FunEnity.VideoBean>();
                top.addAll(video);
            }

            @Override
            public void failure(String result) {

            }
        });
        iModelImp.getHomeOhhttp(Urls.FOURTHING, new CallBacks() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                FunEnity funEnity = gson.fromJson(result, FunEnity.class);
                List<FunEnity.VideoBean> video = funEnity.getVideo();
                thing = new ArrayList<FunEnity.VideoBean>();
                thing.addAll(video);
            }

            @Override
            public void failure(String result) {

            }
        });
        iModelImp.getHomeOhhttp(Urls.FOURSPECIAL, new CallBacks() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                FunEnity funEnity = gson.fromJson(result, FunEnity.class);
                List<FunEnity.VideoBean> video = funEnity.getVideo();
                special = new ArrayList<FunEnity.VideoBean>();
                special.addAll(video);
            }

            @Override
            public void failure(String result) {

            }
        });
        iModelImp.getHomeOhhttp(Urls.FOURNEW, new CallBacks() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                FunEnity funEnity = gson.fromJson(result, FunEnity.class);
                List<FunEnity.VideoBean> video = funEnity.getVideo();
                fresh = new ArrayList<FunEnity.VideoBean>();
                fresh.addAll(video);
            }

            @Override
            public void failure(String result) {

            }
        });
        iModelImp.getHomeOhhttp("http://api.cntv.cn/video/videolistById?vsid=VSET100332640004&n=7&serviceId=panda&o=desc&of=time&p=1", new CallBacks() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                FunEnity funEnity = gson.fromJson(result, FunEnity.class);
                List<FunEnity.VideoBean> video = funEnity.getVideo();
                bear = new ArrayList<FunEnity.VideoBean>();
                bear.addAll(video);
            }

            @Override
            public void failure(String result) {

            }
        });
        iModelImp.getHomeOhhttp("http://www.ipanda.com/kehuduan/PAGE14501769230331752/index.json", new CallBacks() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                LiveEnity liveEnity = gson.fromJson(result, LiveEnity.class);
                liveEnities = new ArrayList<>();
                liveEnities.add(liveEnity);


            }

            @Override
            public void failure(String result) {

            }
        });
        iModelImp.getHomeOhhttp("http://www.ipanda.com/kehuduan/PAGE14501769230331752/PAGE14501787896813312/index.json", new CallBacks() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                List<LivetwoEnity.ListBean> list = gson.fromJson(result, LivetwoEnity.class).getList();
                livetwoEnities = new ArrayList<>();
                livetwoEnities.addAll(list);
            }

            @Override
            public void failure(String result) {

            }
        });
        //发送到主线程
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                baseView.showDatas(list, two, book, top, thing, special, fresh, bear);
                baseView.live(liveEnities, livetwoEnities);
            }
        }, 500);
    }
}
