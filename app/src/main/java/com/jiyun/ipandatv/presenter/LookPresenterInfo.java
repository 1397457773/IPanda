package com.jiyun.ipandatv.presenter;

import android.view.View;

import com.jiyun.ipandatv.view.IView;

import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by Lenovo on 2017/9/14.
        */

public interface LookPresenterInfo {
    public interface BaseViewInfo <Q> extends HomePresenter.BaseView {
        void showInfoData(List<Q> MList);
        void error(String string);
    }

    public interface BasePresenterInfo extends HomePresenter.BasePresenter{
        void getDatas();

    }
}
