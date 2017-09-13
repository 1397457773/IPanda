package com.jiyun.ipandatv.model;

import android.content.Context;

import com.jiyun.ipandatv.model.callbacks.CallBacks;
import com.jiyun.ipandatv.model.utils.OkHttpUtils;


/**
 * Created by Lenovo on 2017/9/13.
 */

public class HomeModelData {

    public void getHomeOhhttp(String url, CallBacks callBacks){
        OkHttpUtils.getInstance().sendGET(url,callBacks);
    }

}
