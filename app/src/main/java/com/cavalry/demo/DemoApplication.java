package com.cavalry.demo;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by Cavalry on 2016/8/8.
 */
public class DemoApplication extends Application {
    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        LeakCanary.install(this);

    }

    public static Context getContext(){
        return mContext;
    }
}
