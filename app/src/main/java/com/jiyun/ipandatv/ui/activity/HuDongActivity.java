package com.jiyun.ipandatv.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.jiyun.ipandatv.R;
import com.jiyun.ipandatv.adpater.HuDongAdapter;
import com.jiyun.ipandatv.model.callbacks.CallBacks;
import com.jiyun.ipandatv.model.entity.HomeHuDong;
import com.jiyun.ipandatv.model.utils.OkHttpUtils;
import com.jiyun.ipandatv.model.utils.Urls;
import com.kevin.wraprecyclerview.WrapRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HuDongActivity extends BaseActivity {
private List<HomeHuDong.InteractiveBean> mList=new ArrayList<>();

    @Bind(R.id.iv_img)
    ImageView ivImg;
    @Bind(R.id.wrv_view)
    WrapRecyclerView wrvView;
    private HuDongAdapter huDongAdapter;

    @Override
    public void initData() {
        OkHttpUtils.getInstance().sendGET(Urls.HUDONG, new CallBacks() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                HomeHuDong homeHuDong = gson.fromJson(result, HomeHuDong.class);
                List<HomeHuDong.InteractiveBean> interactive = homeHuDong.getInteractive();
                mList.clear();
                mList.addAll(interactive);
                huDongAdapter.notifyDataSetChanged();
            }

            @Override
            public void failure(String result) {

            }
        });
    }

    @Override
    public void initListener() {
      ivImg.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              finish();
          }
      });
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        wrvView.setLayoutManager(manager);
        huDongAdapter = new HuDongAdapter(mList, this);
        wrvView.setAdapter(huDongAdapter);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_hu_dong;
    }


}
