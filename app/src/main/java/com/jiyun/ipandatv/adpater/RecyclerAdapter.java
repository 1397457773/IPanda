package com.jiyun.ipandatv.adpater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiyun.ipandatv.R;
import com.jiyun.ipandatv.model.entity.LivetwoEnity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/9/15.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Myviewholder> {
    private Context context;
    private ArrayList<LivetwoEnity.ListBean> livetwoEnities;

    public RecyclerAdapter(Context context, ArrayList<LivetwoEnity.ListBean> livetwoEnities) {
        this.context = context;
        this.livetwoEnities = livetwoEnities;
    }

    @Override
    public Myviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.live_show, parent, false);
        Myviewholder myviewholder = new Myviewholder(inflate);
        return myviewholder;
    }

    @Override
    public void onBindViewHolder(Myviewholder holder, int position) {
        Picasso.with(context).load(livetwoEnities.get(position).getImage()).into(holder.iv_show);
        holder.tv_show.setText(livetwoEnities.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return livetwoEnities.size();
    }

    public class Myviewholder extends RecyclerView.ViewHolder {

        private  ImageView iv_show;
        private  TextView tv_show;

        public Myviewholder(View itemView) {
            super(itemView);
            iv_show = (ImageView) itemView.findViewById(R.id.iv_show);
            tv_show = (TextView) itemView.findViewById(R.id.tv_show);
        }
    }
}
