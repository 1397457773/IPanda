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
import com.jiyun.ipandatv.model.entity.HomeEntiy;
import com.jiyun.ipandatv.ui.activity.ForthWebActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 王云飞 on 2017/9/14.
 */
public class ForthAdapter extends RecyclerView.Adapter<ForthAdapter.MyViewHolder> {
    private List<HomeEntiy.DataBean> interactiveList;
    private Context context;

    public ForthAdapter(List<HomeEntiy.DataBean> interactiveList, Context context) {
        this.interactiveList = interactiveList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_forth, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        Picasso.with(context.getApplicationContext()).load(interactiveList.get(position).getInteractive().getInteractiveone().get(0).getImage()).into(holder.iv_img_hua);
        holder.tv_panda_jieqi.setText(interactiveList.get(position).getInteractive().getInteractiveone().get(0).getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,ForthWebActivity.class );
                Intent url = intent.putExtra("url",interactiveList.get(position).getInteractive().getInteractiveone().get(0).getUrl());
                 context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private  ImageView iv_img_hua;
        private  TextView tv_panda_jieqi;

        public MyViewHolder(View itemView) {
            super(itemView);

            iv_img_hua=(ImageView)itemView.findViewById(R.id.iv_img_hua);
            tv_panda_jieqi=(TextView)itemView.findViewById(R.id.tv_panda_jieqi);
        }
    }
}
