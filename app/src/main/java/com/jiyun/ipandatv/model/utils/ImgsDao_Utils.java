package com.jiyun.ipandatv.model.utils;

import android.content.Context;

import com.jiyun.ipandatv.App;
import com.jiyun.ipandatv.dao.BigImgBeanDaoDao;
import com.jiyun.ipandatv.dao.DaoMaster;
import com.jiyun.ipandatv.model.db.BigImgBeanDao;

/**
 * Created by Lenovo on 2017/9/16.
 */

public class ImgsDao_Utils {
    private static ImgsDao_Utils utils;
        private DaoMaster.DevOpenHelper helper;
        private static final String DB_NAME = "img.db";
        private ImgsDao_Utils (){
            helper = new DaoMaster.DevOpenHelper(App.mActivity,DB_NAME);
        }

        public static ImgsDao_Utils getInstance() {
            if (utils == null) {
                synchronized (ImgsDao_Utils.class){
                    if (utils == null) {
                        utils = new ImgsDao_Utils();
                    }
                }
            }
            return utils;
        }

        public BigImgBeanDaoDao getDao(){
            DaoMaster master = new DaoMaster(helper.getReadableDatabase());
            return master.newSession().getBigImgBeanDaoDao();
        }
}
