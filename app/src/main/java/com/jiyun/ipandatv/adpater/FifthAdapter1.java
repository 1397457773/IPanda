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
import com.jiyun.ipandatv.model.entity.HomeCCtv;
import com.jiyun.ipandatv.ui.activity.CCTVActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 王云飞 on 2017/9/15.
 */
public class FifthAdapter1 extends RecyclerView.Adapter<FifthAdapter1.MyViewHolder> {
    private List<HomeCCtv.ListBean> ccList;
    private Context context;

    public FifthAdapter1(List<HomeCCtv.ListBean> ccList, Context context) {
        this.ccList = ccList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_fifth, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Picasso.with(context.getApplicationContext()).load(ccList.get(position).getImage()).into(holder.iv_cctv);
        holder.tv_jieshao.setText(ccList.get(position).getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,CCTVActivity.class);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {

        return 4;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private  ImageView iv_cctv;
        private  TextView tv_jieshao;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv_cctv=(ImageView)itemView.findViewById(R.id.iv_cctv);
            tv_jieshao=(TextView)itemView.findViewById(R.id.tv_jieshao);
        }
    }
}
