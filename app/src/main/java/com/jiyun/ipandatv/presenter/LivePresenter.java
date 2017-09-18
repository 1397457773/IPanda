package com.jiyun.ipandatv.presenter;

import com.jiyun.ipandatv.model.entity.FunEnity;
import com.jiyun.ipandatv.model.entity.LiveEnity;
import com.jiyun.ipandatv.model.entity.LivetwoEnity;
import com.jiyun.ipandatv.view.IView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/9/18.
 */
public interface LivePresenter {
    public interface BaseView <T> extends IView {
        void showDatas(List<FunEnity.VideoBean> fresh, List<FunEnity.VideoBean> special, List<FunEnity.VideoBean> thing, List<FunEnity.VideoBean> top, List<FunEnity.VideoBean> list, List<T> two, List<FunEnity.VideoBean> book, ArrayList<FunEnity.VideoBean> bear);
        void live(ArrayList<LiveEnity> liveEnities, ArrayList<LivetwoEnity.ListBean> livetwoEnities);
    }
    public interface BasePresenter extends IPresenter{

    }
}
