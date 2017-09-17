package com.jiyun.ipandatv.model.dao;

import android.content.Context;

/**
 * Created by lenovo on 2017/9/15.
 */

public class GreenDaoUtils {
    private static GreenDaoUtils utils;
    private static final String DB_NAME="DiZhi.db";
    private final DaoMaster.DevOpenHelper helper;

    private GreenDaoUtils(Context context){
        helper = new DaoMaster.DevOpenHelper(context,DB_NAME);
    }
    public static synchronized GreenDaoUtils getInstance(Context context){
        if (utils==null){
            utils=new GreenDaoUtils(context);
        }
        return utils;
    }
    public DaoBeanDao getDao(){
        DaoMaster master=new DaoMaster(helper.getReadableDb());
        DaoSession daoSession = master.newSession();
        DaoBeanDao daoBeanDao = daoSession.getDaoBeanDao();
        return daoBeanDao;
    }
}
