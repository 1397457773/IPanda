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
import com.jiyun.ipandatv.adpater.List_GuoBao_jingCai_Adapter;
import com.jiyun.ipandatv.model.entity.Home_GuoBao_JingCai;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class JingCaiFragment extends Fragment {

    private  List<Home_GuoBao_JingCai> list;
    @Bind(R.id.lv_view)
    ListView lvView;
    List<Home_GuoBao_JingCai.VideoBean> cList = new ArrayList<>();
    private List_GuoBao_jingCai_Adapter list_guoBao_jingCai_adapter;

    public JingCaiFragment() {
    }

    public JingCaiFragment(List<Home_GuoBao_JingCai> list) {
        this.list=list;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_jing_cai, container, false);
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
                   String vid = cList.get(position).getVid();
                    myDatabase.setDataBase(vid);
               }
           });
    }

    private void initAdapter() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                list_guoBao_jingCai_adapter = new List_GuoBao_jingCai_Adapter(cList, getActivity());
                lvView.setAdapter(list_guoBao_jingCai_adapter);
                list_guoBao_jingCai_adapter.notifyDataSetChanged();
            }
        });

    }

    private void initData() {
        List<Home_GuoBao_JingCai.VideoBean> video = list.get(0).getVideo();
        cList.clear();
        cList.addAll(video);



    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
    private MyDatabase myDatabase;

    public void onDataBase(MyDatabase myDatabase){
        this.myDatabase = myDatabase;
    }

    public interface  MyDatabase{
        void setDataBase(String vid);
    }

}
