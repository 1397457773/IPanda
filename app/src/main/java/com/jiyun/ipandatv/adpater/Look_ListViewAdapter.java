package com.jiyun.ipandatv.adpater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiyun.ipandatv.R;
import com.jiyun.ipandatv.model.entity.LookInfoEntiy;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Lenovo on 2017/9/14.
 */

public class Look_ListViewAdapter extends MyBasrAdapter {
    private List<LookInfoEntiy.ListBean> list;
    private Context context;

    public Look_ListViewAdapter(List<LookInfoEntiy.ListBean> list, Context context) {
        super(list, context);
        this.list = list;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder holder = null;
        if (convertView == null){
            convertView = View.inflate(context,R.layout.item_lookinfoview, null);
            holder = new MyViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (MyViewHolder) convertView.getTag();
        }

        Picasso.with(context.getApplicationContext()).load(list.get(position).getPicurl()).into(holder.ivLookImg);

        holder.tvTitle.setText(list.get(position).getTitle());
        holder.tvTime.setText(list.get(position).getVideolength());

        return convertView;
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
