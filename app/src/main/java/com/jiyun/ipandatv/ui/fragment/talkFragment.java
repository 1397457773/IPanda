package com.jiyun.ipandatv.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.jiyun.ipandatv.R;
import com.jiyun.ipandatv.adpater.LiveshowAdapter;
import com.jiyun.ipandatv.base.BaseFragment;
import com.jiyun.ipandatv.model.entity.talkEnity;

import java.util.ArrayList;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class talkFragment extends BaseFragment {



    private ArrayList<talkEnity> talkEnities;
    private EditText etContent;
    private Button btUp;
    private ListView listview;
    private LiveshowAdapter liveshowAdapter;

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_talk;
    }

    @Override
    protected void initFragmentView(View view) {
        etContent = (EditText) view.findViewById(R.id.et_content);
        btUp = (Button) view.findViewById(R.id.bt_up);
        listview = (ListView) view.findViewById(R.id.listview);
        talkEnities = new ArrayList<>();
        liveshowAdapter = new LiveshowAdapter(getActivity(), talkEnities);
        listview.setAdapter(liveshowAdapter);
        btUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String content = etContent.getText().toString();
                if (content.equals("")){
                    Toast.makeText(getActivity(), "输入内容为空", Toast.LENGTH_SHORT).show();
                }else {
                    talkEnities.add(new talkEnity(content));
                    etContent.setText("");
                    liveshowAdapter.notifyDataSetChanged();
                }
            }
        });
    }
    @Override
    protected void initFragmentData() {

    }

    @Override
    protected void updateFragmentTitleBar() {

    }

    @Override
    protected void setBundle(Bundle bundle) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
