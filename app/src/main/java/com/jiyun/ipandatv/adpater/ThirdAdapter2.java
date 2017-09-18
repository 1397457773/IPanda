package com.jiyun.ipandatv.adpater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiyun.ipandatv.R;
import com.jiyun.ipandatv.model.entity.HomeEntiy;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 王云飞 on 2017/9/15.
 */
public class ThirdAdapter2 extends RecyclerView.Adapter<ThirdAdapter2.MyViewHolder> {
    private List<HomeEntiy.DataBean> chinaliveList;
    private Context context;

    public ThirdAdapter2(List<HomeEntiy.DataBean> chinaliveList, Context context) {
        this.chinaliveList = chinaliveList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_third, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Picasso.with(context.getApplicationContext()).load(chinaliveList.get(position).getChinalive().getList().get(position).getImage()).into(holder.iv_img_live);
        holder.tv_content.setText(chinaliveList.get(position).getChinalive().getList().get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_content;
        private ImageView iv_img_live;
        public MyViewHolder(View itemView) {
            super(itemView);
            iv_img_live=(ImageView)itemView.findViewById(R.id.iv_img_live);
            tv_content=(TextView)itemView.findViewById(R.id.tv_content);
        }
    }
}
