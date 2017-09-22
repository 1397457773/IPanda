package com.jiyun.ipandatv.adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiyun.ipandatv.R;
import com.jiyun.ipandatv.model.entity.Home_GuoBao_JingCai;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 王云飞 on 2017/9/20.
 */
public class List_GuoBao_jingCai_Adapter extends BaseAdapter {
    private List<Home_GuoBao_JingCai.VideoBean> mList;
    private Context context;

    public List_GuoBao_jingCai_Adapter(List<Home_GuoBao_JingCai.VideoBean> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class ViewHolder{
        public ImageView iv_img_china;
        public TextView tv_smallTime;
        public TextView tv_jieshao;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.list_view_base_item, null);
            holder.iv_img_china = (ImageView) convertView.findViewById(R.id.iv_img_china);
            holder.tv_smallTime = (TextView) convertView.findViewById(R.id.tv_smallTime);
            holder.tv_jieshao = (TextView) convertView.findViewById(R.id.tv_jieshao);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        Picasso.with(context.getApplicationContext()).load(mList.get(position).getImg()).into(holder.iv_img_china);
        holder.tv_smallTime.setText(mList.get(position).getLen());
        holder.tv_jieshao.setText(mList.get(position).getT());
        return convertView;
    }
}
