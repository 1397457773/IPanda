package com.jiyun.ipandatv.ui.activity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.jiyun.ipandatv.R;
import com.jiyun.ipandatv.dao.BigImgBeanDaoDao;
import com.jiyun.ipandatv.model.db.BigImgBeanDao;
import com.jiyun.ipandatv.model.utils.ImgsDao_Utils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.jiyun.ipandatv.R.id.iv_collect;

public class LookInfoActivity extends BaseActivity {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.mWebView)
    WebView mWebView;
    @Bind(iv_collect)
    ImageView ivCollect;
    @Bind(R.id.iv_share)
    ImageView ivShare;
    private long l;
    private BigImgBeanDaoDao dao;
    private String img;
    private String title;

    public View rootView;
    public RadioButton rbut_fcb;
    public RadioButton rbut_twitter;
    public RadioButton rbut_sinawebo;
    public RadioButton rbut_wechat;
    public RadioButton rbut_moments;
    public RadioGroup rg_Froup;
    public Button but_Cancel;
    private PopupWindow popupWindow;


    @Override
    public void initData() {
        Intent intent = getIntent();

        String url = intent.getStringExtra("url");
        img = intent.getStringExtra("img");
        title = intent.getStringExtra("title");

        WebSettings settings = mWebView.getSettings();
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        //如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        // 设置可以被显示的屏幕控制
        settings.setDisplayZoomControls(true);
        // 设置缓存
        settings.setAppCacheEnabled(true);
        // 设置缓存模式,一共有四种模式
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        //缩放操作
        settings.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
        settings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
        settings.setDisplayZoomControls(false); //隐藏原生的缩放控件

        mWebView.loadUrl(url);

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        mWebView.onPause();
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initView() {
        ButterKnife.bind(this);

        dao = ImgsDao_Utils.getInstance().getDao();
    }

    @Override
    public int getLayout() {
        return R.layout.activity_look_info;
    }

    @OnClick({R.id.iv_back, iv_collect, R.id.iv_share})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_collect:
                l++;
                Toast toast = new Toast(this);

                if (l % 2 == 1) {
                    ivCollect.setImageResource(R.drawable.collect_yes);
                    toast.makeText(this, "已添加，请到[我的收藏]中查看", Toast.LENGTH_SHORT).show();

                    BigImgBeanDao beanDao = new BigImgBeanDao();
                    beanDao.setImgs(img);
                    beanDao.setTime("2017-09-16 09:05");
                    beanDao.setTitle(title);

                    dao.insert(beanDao);

                } else {
                    ivCollect.setImageResource(R.drawable.collect_no);
                    toast.makeText(this, "以取消收藏", Toast.LENGTH_SHORT).show();
                    dao.deleteAll();
                    l = 0;
                }

                break;
            case R.id.iv_share:
                View popupView = View.inflate(this, R.layout.item_sharepopupwindow, null);
                popupViewId(popupView);

                popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.MATCH_PARENT, (int) (600*1.6),true);
                popupWindow.setBackgroundDrawable(new BitmapDrawable());
                popupWindow.setAnimationStyle(R.anim.share_alph_style);
                popupWindow.showAtLocation(ivShare, Gravity.BOTTOM,0,0);

                popupListener();
                break;
        }
    }

    private void popupListener() {
        rg_Froup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rbut_fcb:
                        Toast.makeText(LookInfoActivity.this, "0", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbut_twitter:
                        break;
                    case R.id.rbut_sinawebo:
                        break;
                    case R.id.rbut_wechat:
                        break;
                    case R.id.rbut_moments:
                        break;
                }
            }
        });

        but_Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }

    private void popupViewId(View rootView) {
        rbut_fcb = (RadioButton) rootView.findViewById(R.id.rbut_fcb);
        this.rbut_twitter = (RadioButton) rootView.findViewById(R.id.rbut_twitter);
        this.rbut_sinawebo = (RadioButton) rootView.findViewById(R.id.rbut_sinawebo);
        this.rbut_wechat = (RadioButton) rootView.findViewById(R.id.rbut_wechat);
        this.rbut_moments = (RadioButton) rootView.findViewById(R.id.rbut_moments);
        this.rg_Froup = (RadioGroup) rootView.findViewById(R.id.rg_Froup);
        this.but_Cancel = (Button) rootView.findViewById(R.id.but_Cancel);


    }


}
