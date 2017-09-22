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
import com.jiyun.ipandatv.model.entity.HomeList;
import com.jiyun.ipandatv.model.entity.HomeListVideo;
import com.jiyun.ipandatv.model.utils.OkHttpUtils;
import com.jiyun.ipandatv.model.utils.Urls;
import com.jiyun.ipandatv.ui.activity.SixVideoActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 王云飞 on 2017/9/15.
 */
public class SixAdapter extends RecyclerView.Adapter<SixAdapter.MyViewHolder> {
    private Context context;
    private List<HomeList.ListBean> list;

    public SixAdapter(Context context, List<HomeList.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public SixAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_sixth, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(SixAdapter.MyViewHolder holder, final int position) {
        Picasso.with(context.getApplicationContext()).load(list.get(position).getImage()).into(holder.iv_img_china);
        holder.tv_smallTime.setText(list.get(position).getVideoLength());
        holder.tv_place.setText(list.get(position).getTitle());
        holder.tv_time.setText(list.get(position).getDaytime());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OkHttpUtils.getInstance().sendGET(Urls.VIDEOPLAY+list.get(position).getPid(), new CallBacks() {
                    @Override
                    public void success(String result) {
                        Gson gson = new Gson();
                        HomeListVideo homeListVideo = gson.fromJson(result, HomeListVideo.class);
                        HomeListVideo.VideoBean video = homeListVideo.getVideo();
                        List<HomeListVideo.VideoBean.ChaptersBean> chapters = video.getChapters();
                        Intent intent = new Intent(context, SixVideoActivity.class);
                        intent.putExtra("url",chapters.get(0).getUrl());
                        intent.putExtra("title",list.get(position).getTitle());
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
        return 6;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView iv_img_china;
        public TextView tv_smallTime;
        public TextView tv_place;
        public TextView tv_time;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv_img_china = (ImageView) itemView.findViewById(R.id.iv_img_china);
            tv_smallTime = (TextView) itemView.findViewById(R.id.tv_smallTime);
            tv_place = (TextView) itemView.findViewById(R.id.tv_place);
            tv_time = (TextView) itemView.findViewById(R.id.tv_time);
        }
    }

}
