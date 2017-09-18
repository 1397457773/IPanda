package com.jiyun.ipandatv.adpater;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jiyun.ipandatv.R;
import com.jiyun.ipandatv.model.entity.LookInfoEntiy;
import com.jiyun.ipandatv.ui.activity.Look_VideoActivity;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Lenovo on 2017/9/13.
 */

public class Look_XRecycler_Adapter extends XRecyclerView.Adapter<Look_XRecycler_Adapter.MyViewHolder> {
    private List<LookInfoEntiy.ListBean> list;
    private Context context;
    private List<String> listTime = new ArrayList<>();

    public Look_XRecycler_Adapter(List<LookInfoEntiy.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_lookinfoview, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        listData();

        Picasso.with(context.getApplicationContext()).load(list.get(position).getPicurl()).into(holder.ivLookImg);

        holder.tvTitle.setText(list.get(position).getTitle());
        holder.tvTime.setText(list.get(position).getVideolength());
        holder.tvContent.setText(listTime.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Look_VideoActivity.class);
                intent.putExtra("guid",list.get(position).getGuid());
                intent.putExtra("title",list.get(position).getTitle());
                intent.putExtra("img",list.get(position).getPicurl());

                context.startActivity(intent);
            }
        });
    }

    private void listData() {
        listTime.add("2017年09月14日 11:27");
        listTime.add("2017年09月14日 11:27");
        listTime.add("2017年09月14日 11:19");
        listTime.add("2017年09月11日 15:31");
        listTime.add("2017年09月07日 09:19");
        listTime.add("2017年09月06日 08:43");
        listTime.add("2017年09月02日 22:11");
        listTime.add("2017年08月30日 09:31");
        listTime.add("2017年08月30日 09:29");
        listTime.add("2017年08月29日 09:03");
        listTime.add("2017年08月26日 09:27");
        listTime.add("2017年08月25日 08:49");

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
