package com.jiyun.ipandatv.presenter;

import com.jiyun.ipandatv.view.IView;

import java.util.List;

/**
 * Created by lenovo on 2017/9/18.
 */

public interface LiveChinaPresenter {
    public interface BaseView <T> extends IView {
        void showDatas(List<T> mBean);
        void error(String string);


    }

    public interface BasePresenter extends IPresenter {

    }
}
