package com.jiyun.ipandatv.ui.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.jiyun.ipandatv.App;
import com.jiyun.ipandatv.R;

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

    //对返回键进行监听
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exit() {
        if (!isExit) {
            isExit = true;
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            // 利用handler延迟发送更改状态信息
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            finish();
            System.exit(0);
        }
    }

}
