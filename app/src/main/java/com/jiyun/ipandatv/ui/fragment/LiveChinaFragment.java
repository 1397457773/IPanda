package com.jiyun.ipandatv.ui.fragment;


import android.app.ProgressDialog;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jiyun.ipandatv.R;
import com.jiyun.ipandatv.adpater.LiveChinaListAdapter;
import com.jiyun.ipandatv.adpater.LiveChinaMyGridAdapter;
import com.jiyun.ipandatv.adpater.LiveChinaTopMyGridAdapter;
import com.jiyun.ipandatv.base.BaseFragment;
import com.jiyun.ipandatv.model.dao.DaoBeanDao;
import com.jiyun.ipandatv.model.dao.DaoTopBeanDao;
import com.jiyun.ipandatv.model.dao.DaoTopUtils;
import com.jiyun.ipandatv.model.dao.GreenDaoUtils;
import com.jiyun.ipandatv.model.entity.DaoBean;
import com.jiyun.ipandatv.model.entity.DaoTopBean;
import com.jiyun.ipandatv.model.entity.LiveChinaEntiy;
import com.jiyun.ipandatv.model.entity.LiveChinaScene;
import com.jiyun.ipandatv.presenter.LiveChinaPresenter;
import com.jiyun.ipandatv.presenter.LiveChinaPresenterImp;
import com.jiyun.ipandatv.view.MyGridView;
import com.jiyun.ipandatv.view.NoScrollGridView;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class LiveChinaFragment extends BaseFragment implements LiveChinaPresenter.BaseView<LiveChinaEntiy> {


    @Bind(R.id.tb_LiveChina)
    TabLayout tbLiveChina;
    @Bind(R.id.btn_tianjia)
    Button btnTianjia;
    @Bind(R.id.lv_LiveChina)
    ListView lvLiveChina;
    @Bind(R.id.liear)
    LinearLayout liear;
    private List<LiveChinaScene.LiveBean> listData;
    private ProgressDialog progressDialog;



    public static NoScrollGridView myGridView_Buttom;
    public static TextView tv_TiShi;
    public static MyGridView myGridView_Top;
    public  static Button btn_BianJi;
    private TextView tv_FanHui;
    private PopupWindow popupWindow;
    private List<LiveChinaEntiy.AlllistBean> alllist;
    private List<DaoBean> listTitleBottom;
    private DaoBeanDao dao;
    private DaoTopBeanDao daoTop;
    private List<DaoTopBean> listTitleTop;
    private LiveChinaTopMyGridAdapter adapterTop;
    private LiveChinaMyGridAdapter adapter_bottom;
    private List<DaoTopBean> listTabTitle;
    private int i;


    public LiveChinaFragment() {
        // Required empty public constructor
    }


    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_live_china;
    }

    @Override
    protected void initFragmentView(View view) {
        ButterKnife.bind(this, view);
        btnTianjia.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                View popuView = LayoutInflater.from(getActivity()).inflate(R.layout.popuwindow_item, null);
                popupWindow = new PopupWindow(popuView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                popupWindow.setFocusable(true);
                popupWindow.setBackgroundDrawable(new BitmapDrawable());
                popupWindow.showAtLocation(liear, Gravity.CENTER, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                initPoPuView(popuView);
            }
        });
    }

    @Override
    protected void initFragmentData() {
        LiveChinaPresenterImp liveChinaPresenterImp = new LiveChinaPresenterImp(this);
        liveChinaPresenterImp.getHomeMessage();
    }

    @Override
    protected void updateFragmentTitleBar() {

    }

    private void initPoPuView(final View popuView) {
        myGridView_Buttom= (NoScrollGridView) popuView.findViewById(R.id.myGridView_Buttom);
        tv_TiShi= (TextView) popuView.findViewById(R.id.tv_TiShi);
        myGridView_Top= (MyGridView) popuView.findViewById(R.id.myGridView_Top);
        btn_BianJi= (Button) popuView.findViewById(R.id.btn_BianJi);
        tv_FanHui= (TextView) popuView.findViewById(R.id.tv_FanHui);


        adapterTop = new LiveChinaTopMyGridAdapter(listTitleTop,getContext());
        myGridView_Top.setAdapter(adapterTop);

        adapter_bottom = new LiveChinaMyGridAdapter(listTitleBottom,getContext());
        myGridView_Buttom.setAdapter(adapter_bottom);



        tv_FanHui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tbLiveChina.removeAllTabs();
                initTabData();
                popupWindow.dismiss();
            }
        });

        myGridView_Top.setOnChangeListener(new MyGridView.OnChanageListener() {
            @Override
            public void onChange(int form, int to) {
                DaoTopBean daoTopBean = listTitleTop.get(form);
                if(form < to){
                    for(int i=form; i<to; i++){
                        Collections.swap(listTitleTop, i, i+1);
                    }
                }else if(form > to){
                    for(int i=form; i>to; i--){
                        Collections.swap(listTitleTop, i, i-1);
                    }
                }

                listTitleTop.set(to, daoTopBean);

                adapterTop.notifyDataSetChanged();
            }
        });



        myGridView_Buttom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DaoBean daoBean = listTitleBottom.get(position);
                listTitleTop.add(new DaoTopBean(daoBean.getId(),daoBean.getOrder(),daoBean.getTitle(),daoBean.getType(),daoBean.getUrl()));
                daoTop.insert(new DaoTopBean(daoBean.getId(),daoBean.getOrder(),daoBean.getTitle(),daoBean.getType(),daoBean.getUrl()));
                adapterTop.notifyDataSetChanged();


                dao.delete(listTitleBottom.get(position));
                listTitleBottom.remove(position);

                adapter_bottom.notifyDataSetChanged();

            }
        });
        myGridView_Top.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DaoTopBean daoTopBean = listTitleTop.get(position);
                if (adapterTop.getCount()>4){
                    listTitleBottom.add(new DaoBean(daoTopBean.getId(),daoTopBean.getOrder(),daoTopBean.getTitle(),daoTopBean.getType(),daoTopBean.getUrl()));
                    dao.insert(new DaoBean(daoTopBean.getId(),daoTopBean.getOrder(),daoTopBean.getTitle(),daoTopBean.getType(),daoTopBean.getUrl()));
                    adapterTop.notifyDataSetChanged();


                    daoTop.delete(listTitleTop.get(position));
                    listTitleTop.remove(position);
                    adapterTop.notifyDataSetChanged();
                }else {
                    Toast.makeText(getActivity(), "最少为4个标题栏", Toast.LENGTH_SHORT).show();
                }

            }
        });
        myGridView_Buttom.setEnabled(false);
        myGridView_Top.setEnabled(false);
        btn_BianJi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i+=1;
                switch (i%2){
                    case 0:
                        tv_TiShi.setVisibility(View.GONE);
                        btn_BianJi.setText("编辑");
                        myGridView_Buttom.setEnabled(false);
                        myGridView_Top.setEnabled(false);
                        break;
                    case 1:
                        tv_TiShi.setVisibility(View.VISIBLE);
                        btn_BianJi.setText("完成");
                        myGridView_Top.setEnabled(true);
                        myGridView_Buttom.setEnabled(true);
                        break;
                }
            }
        });



    }

    @Override
    protected void setBundle(Bundle bundle) {

    }

    @Override
    public void showProgressDialog() {
//        progressDialog.show();
    }

    @Override
    public void dismissProgressDialog() {
//        progressDialog.dismiss();
    }


    private void initTabData() {
        final List<DaoTopBean> listDao = daoTop.queryBuilder().list();
        listTabTitle = new ArrayList<>();
        listTabTitle.clear();
        listTabTitle.addAll(listDao);
        for (int i = 0; i < listTabTitle.size(); i++) {
            tbLiveChina.addTab(tbLiveChina.newTab().setText(listTabTitle.get(i).getTitle()));
        }

        final String url = listDao.get(0).getUrl();
        parJson(url);
        lvLiveChina.setVisibility(View.VISIBLE);
        tbLiveChina.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                switch (position) {
                    case 0:
                        String url0 = listTabTitle.get(0).getUrl();
                        parJson(url0);
                        lvLiveChina.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        String url1 = listTabTitle.get(1).getUrl();
                        parJson(url1);
                        lvLiveChina.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        String url2 = listTabTitle.get(2).getUrl();
                        parJson(url2);
                        lvLiveChina.setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        String url3 = listTabTitle.get(3).getUrl();
                        parJson(url3);
                        lvLiveChina.setVisibility(View.VISIBLE);
                        break;
                    case 4:
                        String url4 = listTabTitle.get(4).getUrl();
                        parJson(url4);
                        lvLiveChina.setVisibility(View.VISIBLE);
                        break;
                    case 5:
                        String url5 = listTabTitle.get(5).getUrl();
                        parJson(url5);
                        lvLiveChina.setVisibility(View.VISIBLE);
                        break;
                    case 6:
                        String url6 = listTabTitle.get(6).getUrl();
                        parJson(url6);
                        lvLiveChina.setVisibility(View.VISIBLE);
                        break;
                    case 7:
                        String url7 = listTabTitle.get(7).getUrl();
                        parJson(url7);
                        lvLiveChina.setVisibility(View.VISIBLE);
                        break;
                    case 8:
                        String url8 = listTabTitle.get(8).getUrl();
                        parJson(url8);
                        lvLiveChina.setVisibility(View.VISIBLE);
                        break;
                    case 9:
                        String url9 = listTabTitle.get(9).getUrl();
                        parJson(url9);
                        lvLiveChina.setVisibility(View.VISIBLE);
                        break;
                    case 10:
                        String url10 = listTabTitle.get(10).getUrl();
                        parJson(url10);
                        lvLiveChina.setVisibility(View.VISIBLE);
                        break;
                    case 11:
                        String url11 = listTabTitle.get(11).getUrl();
                        parJson(url11);
                        lvLiveChina.setVisibility(View.VISIBLE);
                        break;
                    case 12:
                        String url12 = listTabTitle.get(12).getUrl();
                        parJson(url12);
                        lvLiveChina.setVisibility(View.VISIBLE);
                        break;
                    case 13:
                        String url13 = listTabTitle.get(13).getUrl();
                        parJson(url13);
                        lvLiveChina.setVisibility(View.VISIBLE);
                        break;
                    case 14:
                        String url14 = listTabTitle.get(14).getUrl();
                        parJson(url14);
                        lvLiveChina.setVisibility(View.VISIBLE);
                        break;
                    case 15:
                        String url15 = listTabTitle.get(15).getUrl();
                        parJson(url15);
                        lvLiveChina.setVisibility(View.VISIBLE);
                        break;
                    case 16:
                        String url16 = listTabTitle.get(16).getUrl();
                        parJson(url16);
                        lvLiveChina.setVisibility(View.VISIBLE);
                        break;
                    case 17:
                        String url17 = listTabTitle.get(17).getUrl();
                        parJson(url17);
                        lvLiveChina.setVisibility(View.VISIBLE);
                        break;
                    case 18:
                        String url18 = listTabTitle.get(18).getUrl();
                        parJson(url18);
                        lvLiveChina.setVisibility(View.VISIBLE);
                        break;
                    case 19:
                        String url19 = listTabTitle.get(19).getUrl();
                        parJson(url19);
                        lvLiveChina.setVisibility(View.VISIBLE);
                        break;
                    case 20:
                        String url20 = listTabTitle.get(20).getUrl();
                        parJson(url20);
                        lvLiveChina.setVisibility(View.VISIBLE);
                        break;
                    case 21:
                        String url21 = listTabTitle.get(21).getUrl();
                        parJson(url21);
                        lvLiveChina.setVisibility(View.VISIBLE);
                        break;
                    case 22:
                        String url22 = listTabTitle.get(22).getUrl();
                        parJson(url22);
                        lvLiveChina.setVisibility(View.VISIBLE);
                        break;
                    case 23:
                        String url23 = listTabTitle.get(23).getUrl();
                        parJson(url23);
                        lvLiveChina.setVisibility(View.VISIBLE);
                        break;
                    case 24:
                        String url24 = listTabTitle.get(24).getUrl();
                        parJson(url24);
                        lvLiveChina.setVisibility(View.VISIBLE);
                        break;
                    case 25:
                        String url25 = listTabTitle.get(25).getUrl();
                        parJson(url25);
                        lvLiveChina.setVisibility(View.VISIBLE);
                        break;
                    case 26:
                        String url26 = listTabTitle.get(26).getUrl();
                        parJson(url26);
                        lvLiveChina.setVisibility(View.VISIBLE);
                        break;



                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


    private void initGridData() {

        List<DaoTopBean> listDao = daoTop.queryBuilder().list();
        listTitleTop = new ArrayList<>();
        listTitleTop.clear();
        listTitleTop.addAll(listDao);

        for (int i = 0; i < listDao.size(); i++) {
            DaoTopBean daoTopBean = listDao.get(i);
            dao.delete(new DaoBean(daoTopBean.getId(),daoTopBean.getOrder(),daoTopBean.getTitle(),daoTopBean.getType(),daoTopBean.getUrl()));
        }

        List<DaoBean> list = dao.queryBuilder().list();
        listTitleBottom = new ArrayList<>();
        listTitleBottom.clear();
        listTitleBottom.addAll(list);




    }

    private void parJson(String url) {
        Cache cache = new Cache(getActivity().getCacheDir(), 1024 * 1024 * 8);
        OkHttpClient client = new OkHttpClient.Builder().cache(cache).addNetworkInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Response proceed = chain.proceed(request);
                Response pragma = proceed.newBuilder()
                        .removeHeader("Pragma")
                        .removeHeader("Cache-Control")
                        .addHeader("Cache-Control", "max-age=" + 1000 * 30)
                        .build();
                return pragma;
            }
        }).build();
        final Request request = new Request.Builder().url(url).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                Type type = new TypeToken<LiveChinaScene>() {
                }.getType();
                LiveChinaScene listTab = gson.fromJson(string, type);
                listData = new ArrayList<>();
                listData.addAll(listTab.getLive());
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initListAdapter();
                    }
                });
            }
        });
    }

    private void initListAdapter() {
        LiveChinaListAdapter adapter = new LiveChinaListAdapter(listData, getActivity());
        lvLiveChina.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showDatas(List<LiveChinaEntiy> mBean) {
        alllist = mBean.get(0).getAlllist();
        dao = GreenDaoUtils.getInstance(getContext()).getDao();

        for (int i = 0; i < alllist.size(); i++) {
            dao.insertOrReplace(new DaoBean((long) i,alllist.get(i).getOrder(),alllist.get(i).getTitle(),alllist.get(i).getType() ,alllist.get(i).getUrl()));
        }


        final List<LiveChinaEntiy.TablistBean> tablist = mBean.get(0).getTablist();
        daoTop = DaoTopUtils.getInstance(getContext()).getDao();
        for (int i = 0; i < tablist.size(); i++) {
            daoTop.insertOrReplace(new DaoTopBean((long) i,tablist.get(i).getOrder(),tablist.get(i).getTitle(),tablist.get(i).getType(),tablist.get(i).getUrl()));
        }

        List<DaoTopBean> listTop = daoTop.queryBuilder().list();
        for (int i = 0; i <listTop.size() ; i++) {
            DaoTopBean daoTopBean = listTop.get(i);
            dao.queryBuilder().where(DaoBeanDao.Properties.Title.eq(daoTopBean.getTitle())).buildDelete().executeDeleteWithoutDetachingEntities();
        }
        initTabData();

        initGridData();

    }

    @Override
    public void error(String string) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getActivity(), "服务器开小差了", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


}
