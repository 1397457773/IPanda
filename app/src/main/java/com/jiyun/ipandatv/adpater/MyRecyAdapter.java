package com.jiyun.ipandatv.adpater;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jiyun.ipandatv.R;
import com.jiyun.ipandatv.model.callbacks.CallBacks;
import com.jiyun.ipandatv.model.entity.HomeCCtv;
import com.jiyun.ipandatv.model.entity.HomeEntiy;
import com.jiyun.ipandatv.model.entity.HomeList;
import com.jiyun.ipandatv.model.entity.HomeText;
import com.jiyun.ipandatv.model.utils.OkHttpUtils;
import com.jiyun.ipandatv.model.utils.Urls;
import com.jiyun.ipandatv.ui.activity.TextActivity;
import com.kevin.wraprecyclerview.WrapRecyclerView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王云飞 on 2017/9/14.
 */
public class MyRecyAdapter extends WrapRecyclerView.Adapter{
    private List<HomeEntiy.DataBean> list;
    private Context context;



    public MyRecyAdapter(List<HomeEntiy.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return 0;
        }else if (position==1){
            return 1;
        }else if (position==2){
            return 2;
        }else if (position==3){
            return 3;
        }else if (position==4){
            return 4;
        }else if (position==5){
            return 5;
        }else {
            return position;
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        if (viewType==0){
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_first_wrecy, parent, false);
            holder = new ViewHolder0(inflate);

        }else if (viewType==1){
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_second_wrecy, parent, false);
            holder = new ViewHolder1(inflate);
        }else if (viewType==2){
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_third_wrecy, parent, false);
             holder= new ViewHolder2(inflate);
        }else if (viewType==3){
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_forth_wrecy, parent, false);
            holder = new ViewHolder3(inflate);
        }else if (viewType==4){
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_fifth_wrecy, parent, false);
            holder = new ViewHolder4(inflate);
        }else if (viewType==5){
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_sixth_wrecy, parent, false);
            holder = new ViewHolder5(inflate);

        }
        return holder;
    }




    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType==0){
            Picasso.with(context.getApplicationContext()).load(list.get(position).getArea().getImage()).into(((ViewHolder0)holder).iv_img);
            ((ViewHolder0)holder).tv_head_title.setText(list.get(position).getArea().getTitle());
            LinearLayoutManager manager = new LinearLayoutManager(context);
            manager.setOrientation(LinearLayoutManager.HORIZONTAL);
            ((ViewHolder0)holder).rcy_cler.setLayoutManager(manager);
            ((ViewHolder0)holder).rcy_cler.setAdapter(new HorizRecyAdapter(list,context));
        }else if (itemViewType==1){
            ((ViewHolder1)holder).tv_title.setText(list.get(position).getPandaeye().getTitle());
             Picasso.with(context.getApplicationContext()).load(list.get(position).getPandaeye().getPandaeyelogo()).into(((ViewHolder1)holder).iv_img_head);
            ((ViewHolder1)holder).textView.setText(list.get(position).getPandaeye().getItems().get(0).getTitle());
            ((ViewHolder1)holder).textView1.setText(list.get(position).getPandaeye().getItems().get(1).getTitle());
            ((ViewHolder1)holder).new_student.setText(list.get(position).getPandaeye().getItems().get(0).getBrief());
            ((ViewHolder1)holder).instrest.setText(list.get(position).getPandaeye().getItems().get(1).getBrief());

            ((ViewHolder1)holder).textView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                       OkHttpUtils.getInstance().sendGET(Urls.VIDEOPLAY+list.get(position).getPandaeye().getItems().get(0).getPid(),new CallBacks() {
                        @Override
                        public void success(String result) {
                            Gson gson = new Gson();
                            HomeText homeText = gson.fromJson(result, HomeText.class);
                            List<HomeText.VideoBean.ChaptersBean> chapters = homeText.getVideo().getChapters();
                            Intent intent = new Intent(context, TextActivity.class);
                            intent.putExtra("url",chapters.get(0).getUrl());
                            intent.putExtra("title",list.get(position).getPandaeye().getItems().get(0).getTitle());
                            context.startActivity(intent);
                        }

                        @Override
                        public void failure(String result) {

                        }
                    });
               }
            });

            ((ViewHolder1)holder).textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OkHttpUtils.getInstance().sendGET(Urls.VIDEOPLAY+list.get(position).getPandaeye().getItems().get(1).getPid(),new CallBacks() {
                        @Override
                        public void success(String result) {
                            Gson gson = new Gson();
                            HomeText homeText = gson.fromJson(result, HomeText.class);
                            List<HomeText.VideoBean.ChaptersBean> chapters = homeText.getVideo().getChapters();
                            Intent intent = new Intent(context, TextActivity.class);
                            intent.putExtra("url",chapters.get(0).getUrl());
                            intent.putExtra("title",list.get(position).getPandaeye().getItems().get(1).getTitle());
                            context.startActivity(intent);
                        }

                        @Override
                        public void failure(String result) {

                        }
                    });
                }
            });





        }else if (itemViewType==2){
            ((ViewHolder2)holder).tv_panda_live.setText(list.get(position).getPandalive().getTitle());
            ((ViewHolder2)holder).tv_panda_live1.setText(list.get(position).getWalllive().getTitle());
            ((ViewHolder2)holder).tv_panda_live2.setText(list.get(position).getChinalive().getTitle());
            GridLayoutManager manager = new GridLayoutManager(context, 3);
            manager.setOrientation(GridLayoutManager.VERTICAL);
            GridLayoutManager manager1 = new GridLayoutManager(context, 3);
            manager1.setOrientation(GridLayoutManager.VERTICAL);
            GridLayoutManager manager2 = new GridLayoutManager(context, 3);
            manager2.setOrientation(GridLayoutManager.VERTICAL);
            ((ViewHolder2)holder).rcy_cler.setLayoutManager(manager);
            ((ViewHolder2)holder).rcy_cler.setAdapter(new ThirdAdapter(list,context));
            ((ViewHolder2)holder).rcy_cler1.setLayoutManager(manager1);
            ((ViewHolder2)holder).rcy_cler1.setAdapter(new ThirdAdapter1(list,context));
            ((ViewHolder2)holder).rcy_cler2.setLayoutManager(manager2);
            ((ViewHolder2)holder).rcy_cler2.setAdapter(new ThirdAdapter2(list,context));
        }else {
            if (itemViewType == 3) {
                ((ViewHolder3) holder).tv_panda_live.setText(list.get(position).getInteractive().getTitle());
                GridLayoutManager manager = new GridLayoutManager(context, 1);
                manager.setOrientation(GridLayoutManager.VERTICAL);
                ((ViewHolder3) holder).rcy_cler.setLayoutManager(manager);
                ((ViewHolder3) holder).rcy_cler.setAdapter(new ForthAdapter(list, context));

            } else {
                if (itemViewType == 4) {
                    final List<HomeCCtv.ListBean> ccList = new ArrayList<HomeCCtv.ListBean>();
                    ((ViewHolder4) holder).tv_panda_live.setText(list.get(position).getCctv().getTitle());
                    String listurl = list.get(position).getCctv().getListurl();
                    OkHttpUtils.getInstance().sendGET(listurl, new CallBacks() {
                        @Override
                        public void success(String result) {
                            Gson gson = new Gson();
                            HomeCCtv homeCCtv = gson.fromJson(result, HomeCCtv.class);
                            List<HomeCCtv.ListBean> list1 = homeCCtv.getList();
                            ccList.clear();
                            ccList.addAll(list1);

                            GridLayoutManager manager = new GridLayoutManager(context, 2);
                            manager.setOrientation(GridLayoutManager.VERTICAL);
                            ((ViewHolder4) holder).rcy_cler.setLayoutManager(manager);
                            FifthAdapter1 fifthAdapter1 = new FifthAdapter1(ccList, context);
                            ((ViewHolder4) holder).rcy_cler.setAdapter(fifthAdapter1);
                            fifthAdapter1.notifyDataSetChanged();
                        }

                        @Override
                        public void failure(String result) {

                        }
                    });


                } else if (itemViewType == 5) {
                    final List<HomeList.ListBean> listList= new ArrayList<HomeList.ListBean>();
                    ((ViewHolder5) holder).tv_panda_live.setText(list.get(position).getList().get(0).getTitle());
                    String listUrl = list.get(position).getList().get(0).getListUrl();
                    OkHttpUtils.getInstance().sendGET(listUrl, new CallBacks() {
                        @Override
                        public void success(String result) {
                            Gson gson = new Gson();
                            HomeList homeList = gson.fromJson(result, HomeList.class);
                            List<HomeList.ListBean> list2 = homeList.getList();
                            listList.clear();
                            listList.addAll(list2);
                            LinearLayoutManager manager = new LinearLayoutManager(context);
                            manager.setOrientation(LinearLayoutManager.VERTICAL);
                            ((ViewHolder5) holder).rcy_cler.setLayoutManager(manager);
                            SixAdapter sixAdapter = new SixAdapter(context, listList);
                            ((ViewHolder5) holder).rcy_cler.setAdapter(sixAdapter);
                            sixAdapter.notifyDataSetChanged();
                        }

                        @Override
                        public void failure(String result) {

                        }
                    });

                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size();

    }
    class ViewHolder5 extends RecyclerView.ViewHolder{


        private  TextView tv_panda_live;
        private  RecyclerView rcy_cler;

        public ViewHolder5(View inflate) {
            super(inflate);
            rcy_cler=(RecyclerView)inflate.findViewById(R.id.rcy_cler);
            tv_panda_live=(TextView)itemView.findViewById(R.id.tv_panda_live);
        }
    }
    class ViewHolder4 extends RecyclerView.ViewHolder{


        private  TextView tv_panda_live;
        private  RecyclerView rcy_cler;


        public ViewHolder4(View inflate) {
            super(inflate);
            rcy_cler=(RecyclerView)inflate.findViewById(R.id.rcy_cler);
            tv_panda_live=(TextView)inflate.findViewById(R.id.tv_panda_live);
        }
    }
    class ViewHolder3 extends RecyclerView.ViewHolder{


        private  RecyclerView rcy_cler;
        private  TextView tv_panda_live;


        public ViewHolder3(View inflate) {
            super(inflate);
            tv_panda_live=(TextView)inflate.findViewById(R.id.tv_panda_live);
            rcy_cler=(RecyclerView)inflate.findViewById(R.id.rcy_cler);

        }
    }
    class ViewHolder2 extends RecyclerView.ViewHolder {


        private  TextView tv_panda_live;
        private  TextView tv_panda_live1;
        private  TextView tv_panda_live2;
        private  RecyclerView rcy_cler;
        private  RecyclerView rcy_cler1;
        private  RecyclerView rcy_cler2;
        public ViewHolder2(View inflate) {
            super(inflate);
            tv_panda_live=(TextView)inflate.findViewById(R.id.tv_panda_live);
            tv_panda_live1=(TextView)inflate.findViewById(R.id.tv_panda_live1);
            tv_panda_live2=(TextView)inflate.findViewById(R.id.tv_panda_live2);
            rcy_cler=(RecyclerView)itemView.findViewById(R.id.rcy_cler);
            rcy_cler1=(RecyclerView)inflate.findViewById(R.id.rcy_cler1);
            rcy_cler2=(RecyclerView)inflate.findViewById(R.id.rcy_cler2);
        }
    }
    class ViewHolder1 extends RecyclerView.ViewHolder  {


        private  RecyclerView rcy_cler;
        private  Button new_student;
        private  Button instrest;
        private  TextView textView;
        private  TextView textView1;
        private  TextView tv_title;
        private  ImageView iv_img_head;

        public ViewHolder1(View inflate) {
            super(inflate);
            tv_title=(TextView)inflate.findViewById(R.id.tv_title);
            iv_img_head=(ImageView)inflate.findViewById(R.id.iv_img_head);
            textView=(TextView)inflate.findViewById(R.id.textView);
            textView1=(TextView)inflate.findViewById(R.id.textView1);
            new_student=(Button)inflate.findViewById(R.id.new_student);
            instrest=(Button)inflate.findViewById(R.id.instrest);
            rcy_cler=(RecyclerView)itemView.findViewById(R.id.rcy_cler);
        }
    }
    class ViewHolder0 extends RecyclerView.ViewHolder {
        private  RecyclerView rcy_cler;
        private ImageView iv_img;
        private TextView tv_head_title;


        public ViewHolder0(View inflate) {
            super(inflate);
            iv_img=(ImageView)inflate.findViewById(R.id.iv_img);
            tv_head_title=(TextView)inflate.findViewById(R.id.tv_head_title);
            rcy_cler=(RecyclerView)itemView.findViewById(R.id.rcy_cler);
        }
    }


}
