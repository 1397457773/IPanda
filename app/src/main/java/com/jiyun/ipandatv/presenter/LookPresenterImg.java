package com.jiyun.ipandatv.presenter;

import com.jiyun.ipandatv.view.IView;

import java.util.List;

/**
 * Created by Lenovo on 2017/9/13.
 */

public interface LookPresenterImg {
    public interface BaseViewImg <T> extends IView{
        void showDatas(List<T> mBean);
        void error(String string);
    }

    public interface BasePresenterImg extends IPresenter{

    }
}
