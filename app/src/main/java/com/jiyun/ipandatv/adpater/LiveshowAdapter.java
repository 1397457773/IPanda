package com.jiyun.ipandatv.adpater;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jiyun.ipandatv.R;
import com.jiyun.ipandatv.model.entity.TalkEnity;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/9/15.
 */
public class LiveshowAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<TalkEnity> talkEnities;
    public TextView tv_top;

    public LiveshowAdapter(Context context, ArrayList<TalkEnity> talkEnities) {
        this.context = context;
        this.talkEnities = talkEnities;
    }

    @Override
    public int getCount() {
        return talkEnities.size();
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
        view = LayoutInflater.from(context).inflate(R.layout.liveshow,null);
        TextView tv_content = (TextView) view.findViewById(R.id.tv_content);
        tv_top = (TextView) view.findViewById(R.id.tv_top);
        tv_content.setText(talkEnities.get(i).getContent());
        ConnectivityManager con = (ConnectivityManager) context.getSystemService(Activity.CONNECTIVITY_SERVICE);
        boolean internet = con.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnectedOrConnecting();
        if (internet==true){
            tv_top.setText("发送成功");
        }else {
            tv_top.setText("发送失败");
        }




        return view;
    }
}
