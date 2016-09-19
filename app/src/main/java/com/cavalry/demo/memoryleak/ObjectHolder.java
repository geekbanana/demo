package com.cavalry.demo.memoryleak;

import android.app.Activity;

/**
 * Created by Cavalry on 2016/8/8.
 */
public class ObjectHolder {
    private Object obj;
    private Activity activity;
    public ObjectHolder(Object obj){
        this.obj = obj;
    }

    public ObjectHolder(Activity activity){
        this.activity = activity;
    }

    public ObjectHolder(Activity activity,Object obj){
        this.activity = activity;
        this.obj = obj;
    }
}
