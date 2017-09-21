package com.jiyun.ipandatv.ui.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.jiyun.ipandatv.App;

public abstract class BaseActivity extends AppCompatActivity {



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
