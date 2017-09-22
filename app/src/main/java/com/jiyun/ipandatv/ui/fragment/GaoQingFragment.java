package com.jiyun.ipandatv.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jiyun.ipandatv.R;
import com.jiyun.ipandatv.adpater.LiveAdapters;
import com.jiyun.ipandatv.model.entity.Home_GuoBao_Video;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class GaoQingFragment extends Fragment {

    List<Home_GuoBao_Video> mList;
    private LiveAdapters liveAdapter;

    public GaoQingFragment() {
    }
    public GaoQingFragment(List<Home_GuoBao_Video> mList) {
        this.mList=mList;

    }
    @Bind(R.id.lv_view)
    ListView lvView;
    List<Home_GuoBao_Video.VideoBean> nList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_gao_qing, container, false);
        ButterKnife.bind(this, inflate);
        initData();
        initAdapter();
        initListener();
        return inflate;
    }

    private void initListener() {
        lvView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String vid = nList.get(position).getVid();
                myData.setData(vid);
            }
        });
    }

    private void initAdapter() {

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                liveAdapter = new LiveAdapters(nList, getActivity());
                lvView.setAdapter(liveAdapter);
                liveAdapter.notifyDataSetChanged();
            }
        });



    }

    private void initData() {
        List<Home_GuoBao_Video.VideoBean> video = mList.get(0).getVideo();
        nList.clear();
        nList.addAll(video);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);

    }


    private MyData myData;

    public void onData(MyData myData){
        this.myData = myData;
    }

    public interface  MyData{
        void setData(String id);
    }



}
