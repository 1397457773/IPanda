package com.jiyun.ipandatv.ui.fragment;


import android.app.ProgressDialog;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.util.Log;
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
import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
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
    @Bind(R.id.ptr_ShuaXin)
    PullToRefreshLayout ptrShuaXin;
    private List<LiveChinaScene.LiveBean> listData;
    private ProgressDialog progressDialog;


    public static NoScrollGridView myGridView_Buttom;
    public static TextView tv_TiShi;
    public static MyGridView myGridView_Top;
    public static Button btn_BianJi;
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
    private int position;
    private String url;
    private LiveChinaScene listTab;
    private String hls1;
    private String liveurl;
    private List<String> liveList = new ArrayList<String>();;

    public LiveChinaFragment() {
        // Required empty public constructor
    }


    @Override
    protected int getFragmentLayoutId() {
        progressDialog = new ProgressDialog(getActivity());
        return R.layout.fragment_live_china;
    }
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
        myGridView_Buttom = popuView.findViewById(R.id.myGridView_Buttom);
        tv_TiShi = popuView.findViewById(R.id.tv_TiShi);
        myGridView_Top = popuView.findViewById(R.id.myGridView_Top);
        btn_BianJi = popuView.findViewById(R.id.btn_BianJi);
        tv_FanHui = popuView.findViewById(R.id.tv_FanHui);



        adapterTop = new LiveChinaTopMyGridAdapter(listTitleTop, getContext());
        myGridView_Top.setAdapter(adapterTop);

        adapter_bottom = new LiveChinaMyGridAdapter(listTitleBottom, getContext());
        myGridView_Buttom.setAdapter(adapter_bottom);


        tv_FanHui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tbLiveChina.removeAllTabs();
                initTabData();
                popupWindow.dismiss();
            }
        });


        myGridView_Buttom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DaoBean daoBean = listTitleBottom.get(position);
                listTitleTop.add(new DaoTopBean(daoBean.getId(), daoBean.getOrder(), daoBean.getTitle(), daoBean.getType(), daoBean.getUrl()));
                daoTop.insert(new DaoTopBean(daoBean.getId(), daoBean.getOrder(), daoBean.getTitle(), daoBean.getType(), daoBean.getUrl()));
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
                if (adapterTop.getCount() > 4) {
                    listTitleBottom.add(new DaoBean(daoTopBean.getId(), daoTopBean.getOrder(), daoTopBean.getTitle(), daoTopBean.getType(), daoTopBean.getUrl()));
                    dao.insert(new DaoBean(daoTopBean.getId(), daoTopBean.getOrder(), daoTopBean.getTitle(), daoTopBean.getType(), daoTopBean.getUrl()));
                    adapterTop.notifyDataSetChanged();


                    daoTop.delete(listTitleTop.get(position));
                    listTitleTop.remove(position);
                    adapterTop.notifyDataSetChanged();
                } else {
                    Toast.makeText(getActivity(), "最少为4个标题栏", Toast.LENGTH_SHORT).show();
                }
            }
        });

        myGridView_Top.setOnChangeListener(new MyGridView.OnChanageListener() {
            @Override
            public void onChange(int form, int to) {
                DaoTopBean daoTopBean = listTitleTop.get(form);
                Collections.swap(listTitleTop, form,  to);
                listTitleTop.set(to, daoTopBean);
                adapterTop.notifyDataSetInvalidated();

                DaoTopBean tuoZhuaiTopBean = listTitleTop.get(to);
                DaoTopBean kaiShiTopBean = listTitleTop.get(form);


                daoTop.update(new DaoTopBean((long) form,kaiShiTopBean.getOrder(),kaiShiTopBean.getTitle(),kaiShiTopBean.getType(),kaiShiTopBean.getUrl()));
                daoTop.update(new DaoTopBean((long) to,tuoZhuaiTopBean.getOrder(),tuoZhuaiTopBean.getTitle(),tuoZhuaiTopBean.getType(),tuoZhuaiTopBean.getUrl()));
            }
        });
        myGridView_Buttom.setEnabled(false);
        myGridView_Top.setEnabled(false);
        btn_BianJi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i += 1;
                switch (i % 2) {
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
        progressDialog.show();
    }

    @Override
    public void dismissProgressDialog() {
        progressDialog.dismiss();
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
        initListData();
    }

    private void initListData() {
        tbLiveChina.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                lvLiveChina.setVisibility(View.GONE);
                position = tab.getPosition();
                url = listTabTitle.get(position).getUrl();
                parJson(url);
                lvLiveChina.setVisibility(View.VISIBLE);
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
            dao.delete(new DaoBean(daoTopBean.getId(), daoTopBean.getOrder(), daoTopBean.getTitle(), daoTopBean.getType(), daoTopBean.getUrl()));
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
                listTab = gson.fromJson(string, type);
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
        Log.e("TAG","listSize___________"+liveList.size());
        LiveChinaListAdapter adapter = new LiveChinaListAdapter(listData, getActivity(), liveList);
        lvLiveChina.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showDatas(List<LiveChinaEntiy> mBean) {
        alllist = mBean.get(0).getAlllist();
        dao = GreenDaoUtils.getInstance(getContext()).getDao();

        for (int i = 0; i < alllist.size(); i++) {
            dao.insertOrReplace(new DaoBean((long) i, alllist.get(i).getOrder(), alllist.get(i).getTitle(), alllist.get(i).getType(), alllist.get(i).getUrl()));
        }


        final List<LiveChinaEntiy.TablistBean> tablist = mBean.get(0).getTablist();
        daoTop = DaoTopUtils.getInstance(getContext()).getDao();
        for (int i = 0; i < tablist.size(); i++) {
            daoTop.insertOrReplace(new DaoTopBean((long) i, tablist.get(i).getOrder(), tablist.get(i).getTitle(), tablist.get(i).getType(), tablist.get(i).getUrl()));
        }

        List<DaoTopBean> listTop = daoTop.queryBuilder().list();
        for (int i = 0; i < listTop.size(); i++) {
            DaoTopBean daoTopBean = listTop.get(i);
            dao.queryBuilder().where(DaoBeanDao.Properties.Title.eq(daoTopBean.getTitle())).buildDelete().executeDeleteWithoutDetachingEntities();
        }
        initTabData();
        initGridData();
        ptrShuaXin.setCanLoadMore(false);
        ptrShuaXin.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                listData.clear();
                url = listTabTitle.get(position).getUrl();
                parJson(url);
                ptrShuaXin.finishRefresh();
            }

            @Override
            public void loadMore() {

            }
        });
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
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

}
