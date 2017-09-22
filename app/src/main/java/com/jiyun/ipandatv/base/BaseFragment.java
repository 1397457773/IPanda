package com.jiyun.ipandatv.base;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

@SuppressLint("NewApi")
public abstract class BaseFragment extends Fragment {

    private boolean flag;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(getFragmentLayoutId(), container, false);
        initFragmentView(view);
        updateFragmentTitleBar();
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initFragmentData();
    }

    /**
     * 加载不同的Fragment的布局
     *
     * @return
     */
    protected abstract int getFragmentLayoutId();

    /**
     * 初始化Fragment中的控件
     */
    protected abstract void initFragmentView(View view);

    /**
     * 初始化Fragment中数据
     */
    protected abstract void initFragmentData();

    /**
     * 更新Fragment中的标题栏
     */
    protected abstract void updateFragmentTitleBar();

    /**
     * Fragment之间传值
     */
    protected abstract void setBundle(Bundle bundle);

    /**
     * add(),hide(),show();
     * <p>
     * AFragment------->BFragment
     * <p>
     * 当AFragment隐藏的时候会调用这个方法
     */
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            hideTitleBar();//如果当前fragment显示，就调用该方法，让该方法去调用更新TitleBar
        } else {

            showTitleBar();
        }
    }

    /**
     * 隐藏标题栏
     */
    private void hideTitleBar() {
        updateFragmentTitleBar();
    }

    /**
     * 显示标题栏
     */
    private void showTitleBar() {

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        //你的代码
        super.onConfigurationChanged(newConfig);
    }
}
