package com.jiyun.ipandatv.adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.jiyun.ipandatv.R;
import com.jiyun.ipandatv.model.callbacks.CallBacks;
import com.jiyun.ipandatv.model.entity.LiveChinaScene;
import com.jiyun.ipandatv.model.entity.LiveChinaZhiBoBean;
import com.jiyun.ipandatv.model.utils.OkHttpUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;


/**
 * Created by lenovo on 2017/9/14.
 */

public class LiveChinaListAdapter extends MyBasrAdapter {
    public int a = 0;
    List<LiveChinaScene.LiveBean> list;
    Context context;
    private String url;

    public LiveChinaListAdapter(List<LiveChinaScene.LiveBean> list, Context context, List<String> liveList) {
        super(list, context);
        this.list = list;
        this.context = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder vh = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_livechina_list, parent, false);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        vh.tvZhibo.setText("[正在直播]" + list.get(position).getTitle());
        vh.tvContent.setText(list.get(position).getBrief());
        final ViewHolder finalVh = vh;
        String id = list.get(position).getId();
        String liveurl = "http://vdn.live.cntv.cn/api2/live.do?channel=pa://cctv_p2p_hd" + id + "&amp;client=androidapp";
        OkHttpUtils.getInstance().sendGET(liveurl, new CallBacks() {
            @Override
            public void success(String result) {
                Gson gson=new Gson();
                 LiveChinaZhiBoBean liveChinaZhiBoBean = gson.fromJson(result, LiveChinaZhiBoBean.class);
                url = liveChinaZhiBoBean.getHls_url().getHls1();
                finalVh.videoplayer.setUp(url, list.get(position).getTitle());
            }

            @Override
            public void failure(String result) {

            }
        });


        vh.videoplayer.ivThumb.setScaleType(ImageView.ScaleType.FIT_XY);
        Glide.with(context).load(list.get(position).getImage()).into(vh.videoplayer.ivThumb);
        finalVh.tvContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalVh.ivXianshi.setImageResource(R.drawable.com_facebook_tooltip_blue_bottomnub);
                a += 1;
                finalVh.tvContent.setVisibility(View.GONE);
            }
        });
        vh.ivXianshi.setOnClickListener(new View.OnClickListener() {

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
