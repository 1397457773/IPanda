package com.jiyun.ipandatv.ui.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
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
import static com.jiyun.ipandatv.R.id.rg_froup;

public class MainActivity extends BaseActivity {

    @Bind(R.id.mFramelayout)
    FrameLayout mFramelayout;
    @Bind(R.id.rbut_home)
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

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        ivHudong.setVisibility(View.VISIBLE);
        ivPanda.setVisibility(View.VISIBLE);
        ivPerson.setVisibility(View.VISIBLE);
        FragmentBuilder.getInstance().start(R.id.mFramelayout, HomeFragment.class).buid();
        rbutHome.setBackgroundColor(0xFFD9D9D9);

    }

    @Override
    public int getLayout() {

        return R.layout.activity_main;

    }

    //下面RadioButton的点击事件、切换Fragment视图
    @OnClick({R.id.rbut_home, R.id.rbut_Look, R.id.rbut_Culture, rbut_Live, rbut_China,R.id.iv_panda, R.id.iv_hudong, R.id.iv_person})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rbut_home:
                FragmentBuilder.getInstance().start(R.id.mFramelayout, HomeFragment.class).buid();

                ivHudong.setVisibility(View.VISIBLE);
                ivPanda.setVisibility(View.VISIBLE);
                ivPerson.setVisibility(View.VISIBLE);

                tvTitle.setText("");

                rbutHome.setBackgroundColor(0xFFD9D9D9);
                rbutLook.setBackgroundColor(0xFFFFFFFF);
                rbutCulture.setBackgroundColor(0xFFFFFFFF);
                rbutLive.setBackgroundColor(0xFFFFFFFF);
                rbutChina.setBackgroundColor(0xFFFFFFFF);

                break;
            case R.id.rbut_Look:

                tvTitle.setText("熊猫观察");

                ivHudong.setVisibility(View.GONE);
                ivPanda.setVisibility(View.GONE);

                rbutLook.setBackgroundColor(0xFFD9D9D9);
                rbutHome.setBackgroundColor(0xFFFFFFFF);
                rbutCulture.setBackgroundColor(0xFFFFFFFF);
                rbutLive.setBackgroundColor(0xFFFFFFFF);
                rbutChina.setBackgroundColor(0xFFFFFFFF);

                break;
            case R.id.rbut_Culture:

                tvTitle.setText("熊猫文化");

                ivHudong.setVisibility(View.GONE);
                ivPanda.setVisibility(View.GONE);

                rbutCulture.setBackgroundColor(0xFFD9D9D9);
                rbutHome.setBackgroundColor(0xFFFFFFFF);
                rbutLook.setBackgroundColor(0xFFFFFFFF);
                rbutLive.setBackgroundColor(0xFFFFFFFF);
                rbutChina.setBackgroundColor(0xFFFFFFFF);

                break;
            case R.id.rbut_Live:

                tvTitle.setText("熊猫直播");

                ivHudong.setVisibility(View.GONE);
                ivPanda.setVisibility(View.GONE);

                rbutLive.setBackgroundColor(0xFFD9D9D9);
                rbutHome.setBackgroundColor(0xFFFFFFFF);
                rbutLook.setBackgroundColor(0xFFFFFFFF);
                rbutCulture.setBackgroundColor(0xFFFFFFFF);
                rbutChina.setBackgroundColor(0xFFFFFFFF);
                break;
            case R.id.rbut_China:

                tvTitle.setText("直播中国");

                ivHudong.setVisibility(View.GONE);
                ivPanda.setVisibility(View.GONE);

                rbutChina.setBackgroundColor(0xFFD9D9D9);
                rbutHome.setBackgroundColor(0xFFFFFFFF);
                rbutLook.setBackgroundColor(0xFFFFFFFF);
                rbutCulture.setBackgroundColor(0xFFFFFFFF);
                rbutLive.setBackgroundColor(0xFFFFFFFF);
                break;
            case R.id.iv_panda:
                Toast.makeText(this, ".", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_hudong:
                Toast.makeText(this, ".", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_person:
                Toast.makeText(this, ".", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
