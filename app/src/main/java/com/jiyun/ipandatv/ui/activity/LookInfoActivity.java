package com.jiyun.ipandatv.ui.activity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jiyun.ipandatv.R;
import com.jiyun.ipandatv.dao.BigImgBeanDaoDao;
import com.jiyun.ipandatv.model.callbacks.CallBacks;
import com.jiyun.ipandatv.model.db.BigImgBeanDao;
import com.jiyun.ipandatv.model.entity.PDBCInfotwoBean;
import com.jiyun.ipandatv.model.utils.ImgsDao_Utils;
import com.jiyun.ipandatv.model.utils.OkHttpUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.jiyun.ipandatv.R.id.iv_collect;

public class LookInfoActivity extends BaseActivity {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(iv_collect)
    ImageView ivCollect;
    @Bind(R.id.iv_share)
    ImageView ivShare;
    @Bind(R.id.textView_title)
    TextView textViewTitle;
    @Bind(R.id.textView_time)
    TextView textViewTime;
    @Bind(R.id.textView_info)
    TextView textViewInfo;
    private long l;
    private BigImgBeanDaoDao dao;
    private String img;
    private String title;
    private String id;

    public View rootView;
    public RadioButton rbut_fcb;
    public RadioButton rbut_twitter;
    public RadioButton rbut_sinawebo;
    public RadioButton rbut_wechat;
    public RadioButton rbut_moments;
    public RadioGroup rg_Froup;
    public Button but_Cancel;
    private PopupWindow popupWindow;
    private Handler handler;


    @Override
    public void initData() {
        Intent intent = getIntent();

        id = intent.getStringExtra("id");

        OkHttpUtils.getInstance().sendGET("http://api.cntv.cn/article/contentinfo?id=" + id + "&serviceId=panda", new CallBacks() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                PDBCInfotwoBean pdbcInfotwoBean = gson.fromJson(result, PDBCInfotwoBean.class);
                String titleString = pdbcInfotwoBean.getTitle();
                String pubtime = pdbcInfotwoBean.getPubtime();

                textViewTitle.setText(titleString);
                textViewTime.setText(pubtime);

                final String content = pdbcInfotwoBean.getContent();
                textViewInfo.setMovementMethod(ScrollingMovementMethod.getInstance());

                handler = new Handler(){
                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        if (msg.what == 0 * 101) {
                            textViewInfo.setText((CharSequence) msg.obj);
                        }
                    }
                };

                Thread thread = new Thread(new Runnable() {
                    Message message  = new Message();
                    @Override
                    public void run() {
                        Html.ImageGetter imageGetter = new Html.ImageGetter() {
                            @Override
                            public Drawable getDrawable(String source) {
                                URL url;
                                Drawable drawable = null;

                                try {
                                    url = new URL(source);
                                    drawable = Drawable.createFromStream(url.openStream(),null);
                                    drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());

                                } catch (MalformedURLException e) {
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                return drawable;
                            }
                        };

                        CharSequence spanned = Html.fromHtml(content, imageGetter, null);
                        message.what = 0 * 101;
                        message.obj = spanned;

                        handler.sendMessage(message);
                    }
                });

                thread.start();
            }

            @Override
            public void failure(String result) {

            }
        });


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
            case iv_collect:
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

                popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.MATCH_PARENT, (int) (600 * 1.6), true);
                popupWindow.setBackgroundDrawable(new BitmapDrawable());
                popupWindow.setAnimationStyle(R.anim.share_alph_style);
                popupWindow.showAtLocation(ivShare, Gravity.BOTTOM, 0, 0);

                popupListener();
                break;
        }
    }

    private void popupListener() {
        rg_Froup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
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
        this.but_Cancel = (Button) rootView.findViewById(R.id.popu_cancel);


    }

}
