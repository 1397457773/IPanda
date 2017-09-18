package com.jiyun.ipandatv.adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiyun.ipandatv.R;
import com.jiyun.ipandatv.model.entity.FunEnity;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by lenovo on 2017/9/14.
 */
public class twoAdapter extends BaseAdapter{
    private Context context;

        public twoAdapter(Context context, List<FunEnity.VideoBean> videoBeen) {
            this.context = context;
            this.videoBeen = videoBeen;
        }

        private List<FunEnity.VideoBean> videoBeen;
        @Override
        public int getCount() {
            return videoBeen.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = LayoutInflater.from(context).inflate(R.layout.two_list, null);
            ImageView iv_two = (ImageView) view.findViewById(R.id.iv_two);
            TextView tv_two = (TextView) view.findViewById(R.id.tv_two);
            TextView tv_time = (TextView) view.findViewById(R.id.tv_time);
        TextView tv_name = (TextView) view.findViewById(R.id.tv_name);
        Picasso.with(context).load(videoBeen.get(i).getImg()).into(iv_two);
        tv_two.setText(videoBeen.get(i).getT());
        tv_time.setText(videoBeen.get(i).getPtime());
        tv_name.setText(videoBeen.get(i).getLen());
        return view;
    }
}
