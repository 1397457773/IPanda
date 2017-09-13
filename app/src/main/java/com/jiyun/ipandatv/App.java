package com.jiyun.ipandatv;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.jiyun.ipandatv.ui.activity.BaseActivity;

/**
 * Created by Lenovo on 2017/9/13.
 */

public class App extends Application {
    public static Activity mActivity;
    public static FragmentActivity mBaseActivity;
    public static Fragment mBaseLastFragent;
}
