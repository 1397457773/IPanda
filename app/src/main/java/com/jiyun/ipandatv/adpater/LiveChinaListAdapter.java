package com.jiyun.ipandatv.adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiyun.ipandatv.R;
import com.jiyun.ipandatv.model.entity.LiveChinaScene;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;


/**
 * Created by lenovo on 2017/9/14.
 */

public class LiveChinaListAdapter extends MyBasrAdapter {
    List<LiveChinaScene.LiveBean> list;
    Context context;

    public LiveChinaListAdapter(List<LiveChinaScene.LiveBean> list, Context context) {
        super(list, context);
        this.list = list;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_livechina_list, parent, false);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        vh.tvZhibo.setText("[正在直播]"+list.get(position).getTitle());
        vh.tvContent.setText(list.get(position).getBrief());
        final ViewHolder finalVh = vh;

        vh.ivXianshi.setOnClickListener(new View.OnClickListener() {
            public int a = 0;

            @Override
            public void onClick(View v) {
                a += 1;
                switch (a % 2) {
                    case 0:
                        finalVh.ivXianshi.setImageResource(R.drawable.com_facebook_tooltip_blue_topnub);
                        finalVh.tvContent.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        finalVh.ivXianshi.setImageResource(R.drawable.com_facebook_tooltip_blue_bottomnub);
                        finalVh.tvContent.setVisibility(View.GONE);
                        break;
                }
            }
        });
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.videoplayer)
        JCVideoPlayer videoplayer;
        @Bind(R.id.iv_xianshi)
        ImageView ivXianshi;
        @Bind(R.id.tv_zhibo)
        TextView tvZhibo;
        @Bind(R.id.tv_content)
        TextView tvContent;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
