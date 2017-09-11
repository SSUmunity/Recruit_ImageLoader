package com.example.forhack.imageloader;


import android.app.Application;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class BaseApplication extends Application {
    private static RequestQueue mQueue;

    @Override
    public void onCreate() {
        super.onCreate();

        initNetwork();
    }

    private void initNetwork() {
        Context context = getApplicationContext();
        mQueue = Volley.newRequestQueue(context);
    }

    public static RequestQueue getRequestQueue() {
        return mQueue;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }
}

