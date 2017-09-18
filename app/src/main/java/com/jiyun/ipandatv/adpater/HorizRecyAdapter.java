package com.jiyun.ipandatv.adpater;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jiyun.ipandatv.R;
import com.jiyun.ipandatv.model.callbacks.CallBacks;
import com.jiyun.ipandatv.model.entity.HomeEntiy;
import com.jiyun.ipandatv.model.entity.HomeHoriz;
import com.jiyun.ipandatv.model.utils.OkHttpUtils;
import com.jiyun.ipandatv.model.utils.Urls;
import com.jiyun.ipandatv.ui.activity.HorizActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 王云飞 on 2017/9/14.
 */
public class HorizRecyAdapter extends RecyclerView.Adapter<HorizRecyAdapter.MyViewHolder> {
    private List<HomeEntiy.DataBean> areaList;
    private Context context;

    public HorizRecyAdapter(List<HomeEntiy.DataBean> areaList, Context context) {
        this.areaList = areaList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_first, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        Picasso.with(context.getApplicationContext()).load(areaList.get(0).getArea().getListscroll().get(position).getImage()).into(holder.iv_img_wrecy);
        holder.tv_info.setText(areaList.get(0).getArea().getListscroll().get(position).getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OkHttpUtils.getInstance().sendGET(Urls.VIDEOPLAY + areaList.get(0).getArea().getListscroll().get(position).getPid(), new CallBacks() {
                    @Override
                    public void success(String result) {
                        Gson gson = new Gson();
                        HomeHoriz homeHoriz = gson.fromJson(result, HomeHoriz.class);
                        List<HomeHoriz.VideoBean.ChaptersBean> chapters = homeHoriz.getVideo().getChapters();
                        Intent intent = new Intent(context,HorizActivity.class);
                        intent.putExtra("url",chapters.get(0).getUrl());
                        intent.putExtra("title",areaList.get(0).getArea().getListscroll().get(position).getTitle());
                        context.startActivity(intent);
                    }

                    @Override
                    public void failure(String result) {

                    }
                });


            }
        });

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv_img_wrecy;
        private TextView tv_info;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv_img_wrecy = (ImageView) itemView.findViewById(R.id.iv_img_wrecy);
            tv_info = (TextView) itemView.findViewById(R.id.tv_info);
        }
    }
}
