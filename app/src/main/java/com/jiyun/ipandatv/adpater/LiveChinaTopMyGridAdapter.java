package com.jiyun.ipandatv.adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiyun.ipandatv.R;
import com.jiyun.ipandatv.model.entity.DaoTopBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2017/9/15.
 */

public class LiveChinaTopMyGridAdapter extends MyBasrAdapter<DaoTopBean> {
    List<DaoTopBean> list;
    Context context;
    int i=0;

    public LiveChinaTopMyGridAdapter(List<DaoTopBean> list, Context context) {
        super(list, context);
        this.list = list;
        this.context = context;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder vh;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_mygrild, parent, false);
            vh=new ViewHolder(convertView);
            convertView.setTag(vh);
        }else {
            vh= (ViewHolder) convertView.getTag();
        }
        vh.tvBiaoQianTop.setText(list.get(position).getTitle());
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.tv_BiaoQian_Top)
        TextView tvBiaoQianTop;
        @Bind(R.id.iv_shanchu)
        ImageView ivShanchu;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
