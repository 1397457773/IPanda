package com.jiyun.ipandatv.ui.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.jiyun.ipandatv.App;

public abstract class BaseActivity extends AppCompatActivity {

    // 定义一个变量，来标识是否退出
    private static boolean isExit = false;

    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.mActivity = this;
        App.mBaseActivity = this;

        setContentView(getLayout());

        initView();
        initListener();
        initData();


    }

    public abstract void initData();

    public abstract void initListener();

    public abstract void initView();

    public abstract int getLayout();

    public void showToast(String content) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();

    }

    public PopupWindow showPopupWindow(View mView) {
        PopupWindow popupWindow = new PopupWindow(mView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
        return popupWindow;
    }




    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        //你的代码
        super.onConfigurationChanged(newConfig);
    }

}
