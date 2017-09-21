package com.jiyun.ipandatv.ui.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.ipandatv.R;
import com.jiyun.ipandatv.base.FragmentBuilder;
import com.jiyun.ipandatv.ui.fragment.HomeFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.jiyun.ipandatv.R.id.rbut_China;
import static com.jiyun.ipandatv.R.id.rbut_Live;
import static com.jiyun.ipandatv.R.id.rbut_home;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Bind(R.id.mFramelayout)
    FrameLayout mFramelayout;
    @Bind(rbut_home)
    RadioButton rbutHome;
    @Bind(R.id.rbut_Look)
    RadioButton rbutLook;
    @Bind(R.id.rbut_Culture)
    RadioButton rbutCulture;
    @Bind(rbut_Live)
    RadioButton rbutLive;
    @Bind(rbut_China)
    RadioButton rbutChina;
    @Bind(R.id.iv_panda)
    ImageView ivPanda;
    @Bind(R.id.iv_hudong)
    ImageView ivHudong;
    @Bind(R.id.iv_person)
    ImageView ivPerson;
    @Bind(R.id.linear)
    LinearLayout linear;
    @Bind(R.id.activity_main)
    RelativeLayout activityMain;
    @Bind(R.id.rg_froup)
    RadioGroup rgFroup;
    @Bind(R.id.tv_title)
    TextView tvTitle;

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
    public void initData() {

    }

    @Override
    public void initListener() {
        ivHudong.setOnClickListener(this);
        ivPerson.setOnClickListener(this);
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        ivHudong.setVisibility(View.VISIBLE);
        ivPanda.setVisibility(View.VISIBLE);
        ivPerson.setVisibility(View.VISIBLE);
        FragmentBuilder.getInstance().start(R.id.mFramelayout, HomeFragment.class).buid();
        rbutHome.setBackgroundColor(0xFFBABABA);

    }

    @Override
    public int getLayout() {

        return R.layout.activity_main;

    }

    //下面RadioButton的点击事件、切换Fragment视图
    @OnClick({rbut_home, R.id.rbut_Look, R.id.rbut_Culture, rbut_Live, rbut_China,R.id.iv_panda, R.id.iv_hudong, R.id.iv_person})
    public void onViewClicked(View view) {
        rbutLook.setBackgroundColor(0xFFFFFFFF);
        rbutCulture.setBackgroundColor(0xFFFFFFFF);
        rbutLive.setBackgroundColor(0xFFFFFFFF);
        rbutChina.setBackgroundColor(0xFFFFFFFF);

        switch (view.getId()) {
            case rbut_home:
                FragmentBuilder.getInstance().start(R.id.mFramelayout, HomeFragment.class).buid();

                ivHudong.setVisibility(View.VISIBLE);
                ivPanda.setVisibility(View.VISIBLE);
                ivPerson.setVisibility(View.VISIBLE);

                tvTitle.setText("");

                rbutHome.setBackgroundColor(0xFFBABABA);

                break;
            case R.id.rbut_Look:
                tvTitle.setText("熊猫观察");

                ivHudong.setVisibility(View.GONE);
                ivPanda.setVisibility(View.GONE);

                rbutLook.setBackgroundColor(0xFFBABABA);
                rbutHome.setBackgroundColor(0xFFFFFFFF);

                break;
            case R.id.rbut_Culture:

                tvTitle.setText("熊猫文化");

                ivHudong.setVisibility(View.GONE);
                ivPanda.setVisibility(View.GONE);

                rbutCulture.setBackgroundColor(0xFFBABABA);
                rbutHome.setBackgroundColor(0xFFFFFFFF);
                break;
            case R.id.rbut_Live:

                tvTitle.setText("熊猫直播");

                ivHudong.setVisibility(View.GONE);
                ivPanda.setVisibility(View.GONE);

                rbutLive.setBackgroundColor(0xFFBABABA);
                rbutHome.setBackgroundColor(0xFFFFFFFF);
                break;
            case R.id.rbut_China:

                tvTitle.setText("直播中国");

                ivHudong.setVisibility(View.GONE);
                ivPanda.setVisibility(View.GONE);

                rbutChina.setBackgroundColor(0xFFBABABA);
                rbutHome.setBackgroundColor(0xFFFFFFFF);
                break;
            case R.id.iv_panda:
                Toast.makeText(this, ".", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_hudong:
                startActivity(new Intent(MainActivity.this,HuDongActivity.class));
                break;
            case R.id.iv_person:
                Toast.makeText(this, ".", Toast.LENGTH_SHORT).show();
                break;
        }
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


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_hudong:
                Intent intent = new Intent(MainActivity.this,HuDongActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_person:
                break;
        }
    }



}
