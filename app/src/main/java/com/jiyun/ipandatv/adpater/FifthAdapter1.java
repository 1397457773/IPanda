package com.jiyun.ipandatv.adpater;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.ipandatv.R;
import com.jiyun.ipandatv.model.entity.HomeCCtv;
import com.jiyun.ipandatv.model.utils.Urls;
import com.jiyun.ipandatv.ui.activity.CCTVActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 王云飞 on 2017/9/15.
 */
public class FifthAdapter1 extends RecyclerView.Adapter<FifthAdapter1.MyViewHolder> {
    private List<HomeCCtv.ListBean> ccList;
    private Context context;

    public FifthAdapter1(List<HomeCCtv.ListBean> ccList, Context context) {
        this.ccList = ccList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_fifth, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Picasso.with(context.getApplicationContext()).load(ccList.get(position).getImage()).into(holder.iv_cctv);
        holder.tv_jieshao.setText(ccList.get(position).getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,CCTVActivity.class);
                if (position==0){
                    intent.putExtra("url", Urls.NEH1);
                    intent.putExtra("url1",Urls.N1);
                }else if (position==1){
                    intent.putExtra("url", Urls.CHINA1);
                    intent.putExtra("url1",Urls.C1);
                }else if (position==2){
                    intent.putExtra("url",Urls.HPER1);
                    intent.putExtra("url1",Urls.H1);
                }else if (position==3){
                    intent.putExtra("url",Urls.ZW1);
                    intent.putExtra("url1",Urls.Z1);
                }else {
                    Toast.makeText(context, "我去开小差了", Toast.LENGTH_SHORT).show();
                }
                intent.putExtra("title",ccList.get(position).getTitle());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {

        return 4;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private  ImageView iv_cctv;
        private  TextView tv_jieshao;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv_cctv=(ImageView)itemView.findViewById(R.id.iv_cctv);
            tv_jieshao=(TextView)itemView.findViewById(R.id.tv_jieshao);
        }
    }
}
