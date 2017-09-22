package com.jiyun.ipandatv.model.dao;

import android.content.Context;

/**
 * Created by lenovo on 2017/9/15.
 */

public class DaoTopUtils {
    private static DaoTopUtils utils;
    private static final String DB_NAME="DiZhiTop.db";
    private final DaoMaster.DevOpenHelper helper;

    private DaoTopUtils(Context context){
        helper = new DaoMaster.DevOpenHelper(context,DB_NAME);
    }
    public static synchronized DaoTopUtils getInstance(Context context){
        if (utils==null){
            utils=new DaoTopUtils(context);
        }
        return utils;
    }
    public DaoTopBeanDao getDao(){
        DaoMaster master=new DaoMaster(helper.getReadableDb());
        DaoSession daoSession = master.newSession();
        DaoTopBeanDao daoTopBeanDao = daoSession.getDaoTopBeanDao();
        return daoTopBeanDao;
    }
}
