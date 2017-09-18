package com.jiyun.ipandatv.adpater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.ipandatv.R;
import com.jiyun.ipandatv.model.entity.LookInfoEntiy;
import com.lhh.ptrrv.library.PullToRefreshRecyclerView;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Lenovo on 2017/9/14.
 */

public class Look_RefreshRecycler_Adapter extends RecyclerView.Adapter<Look_RefreshRecycler_Adapter.MyViewHolder>{

    private List<LookInfoEntiy.ListBean> list;
    private Context context;

    public Look_RefreshRecycler_Adapter(List<LookInfoEntiy.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_lookinfoview, parent, false);
        Look_RefreshRecycler_Adapter.MyViewHolder myViewHolder = new Look_RefreshRecycler_Adapter.MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Picasso.with(context.getApplicationContext()).load(list.get(position).getPicurl()).into(holder.ivLookImg);

        holder.tvTitle.setText(list.get(position).getTitle());
        holder.tvTime.setText(list.get(position).getVideolength());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_lookImg)
        ImageView ivLookImg;
        @Bind(R.id.tv_time)
        TextView tvTime;
        @Bind(R.id.tv_title)
        TextView tvTitle;
        @Bind(R.id.tv_content)
        TextView tvContent;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
