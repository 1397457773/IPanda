package com.jiyun.ipandatv.model.utils;

import com.jiyun.ipandatv.App;
import com.jiyun.ipandatv.model.callbacks.CallBacks;

import java.io.IOException;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Lenovo on 2017/9/13.
 */

public class OkHttpUtils {
    private static OkHttpUtils utils;
    private OkHttpClient client;

    private OkHttpUtils() {
        Cache cache = new Cache(App.mActivity.getCacheDir(), 1024 * 1024 * 8);
        client = new OkHttpClient.Builder().cache(cache).addNetworkInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Response proceed = chain.proceed(request);
                Response pragma = proceed.newBuilder()
                        .removeHeader("Pragma")
                        .removeHeader("Cache-Control")
                        .addHeader("Cache-Control", "max-age=" + 1024 * 1024*500)
                        .build();
                return pragma;
            }
        }).build();
    }

    public static OkHttpUtils getInstance() {
        if (utils == null) {
            synchronized (OkHttpUtils.class) {
                if (utils == null) {
                    utils = new OkHttpUtils();
                }

            }
        }

        return utils;
    }

    public void sendGET(String url, final CallBacks callBacks) {
        Request request = new Request.Builder().url(url).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                App.mActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callBacks.failure(e.toString());
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();

                App.mActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callBacks.success(string);
                    }
                });
            }
        });
    }

    public void sendPOST(String url, RequestBody body, Callback callback) {
        Request request = new Request.Builder().url(url).post(body).build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}
