package com.cavalry.demo.memoryleak;

import android.app.Activity;

/**
 * Created by Cavalry on 2016/8/12.
 */
public class StaticObjectHolder {
    private static Object obj;
    private static Activity activity;
    public StaticObjectHolder(Object obj){
        this.obj = obj;
    }

    public StaticObjectHolder(Activity activity){
        this.activity = activity;
    }

    public StaticObjectHolder(Activity activity,Object obj){
        this.activity = activity;
        this.obj = obj;
    }
}
