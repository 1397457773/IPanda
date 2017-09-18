package com.jiyun.ipandatv.adpater;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiyun.ipandatv.R;
import com.jiyun.ipandatv.model.entity.HomeHuDong;
import com.jiyun.ipandatv.ui.activity.HuDongWebActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 王云飞 on 2017/9/16.
 */
public class HuDongAdapter extends RecyclerView.Adapter<HuDongAdapter.MyViewHolder> {
    private List<HomeHuDong.InteractiveBean> mList;
    private Context context;

    public HuDongAdapter(List<HomeHuDong.InteractiveBean> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_hudong, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
         holder.tv_hudong_title.setText(mList.get(position).getTitle());
         Picasso.with(context.getApplicationContext()).load(mList.get(position).getImage()).into(holder.iv_img_hudong);
         holder.itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(context,HuDongWebActivity.class);
                 intent.putExtra("title",mList.get(position).getTitle());
                 intent.putExtra("url",mList.get(position).getUrl());
                 context.startActivity(intent);
             }
         });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private  TextView tv_hudong_title;
        private  ImageView iv_img_hudong;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_hudong_title=(TextView)itemView.findViewById(R.id.tv_hudong_title);
            iv_img_hudong=(ImageView)itemView.findViewById(R.id.iv_img_hudong);
        }
    }
}
