package com.jiyun.ipandatv.adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiyun.ipandatv.R;
import com.jiyun.ipandatv.model.entity.Home_GuoBao_Video;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 王云飞 on 2017/9/20.
 */
public class LiveAdapter extends BaseAdapter {
    private List<Home_GuoBao_Video.VideoBean> mList;
    private Context context;

    public LiveAdapter(List<Home_GuoBao_Video.VideoBean> mList, Context context) {
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
        if (convertView==null){
            holder=new ViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.list_view_base_item,null);
            holder.iv_img_china=(ImageView)convertView.findViewById(R.id.iv_img_china);
            holder.tv_smallTime=(TextView)convertView.findViewById(R.id.tv_smallTime);
            holder.tv_jieshao=(TextView)convertView.findViewById(R.id.tv_jieshao);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        Picasso.with(context.getApplicationContext()).load(mList.get(position).getImg()).into(holder.iv_img_china);
        holder.tv_smallTime.setText(mList.get(position).getLen());
        holder.tv_jieshao.setText(mList.get(position).getT());
        return convertView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/9/15.
 */
public class LiveAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragments;
    private ArrayList<String> title;

    public LiveAdapter(FragmentManager fm, ArrayList<Fragment> fragments, ArrayList<String> title) {
        super(fm);
        this.fragments = fragments;
        this.title = title;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}
