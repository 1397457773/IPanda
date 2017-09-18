package com.jiyun.ipandatv.presenter;

import com.jiyun.ipandatv.view.IView;

/**
 * Created by Lenovo on 2017/9/13.
 */

public interface HomePresenter {
    public interface BaseView <T> extends IView{
        void showDatas();
        void error(String string);


    }

    public interface BasePresenter extends IPresenter{

    }
}
