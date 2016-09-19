package com.cavalry.demo.memoryleak;

import android.app.Activity;

/**
 * Created by Cavalry on 2016/8/12.
 */
public class FactoryObjectHolder {
    private static Object obj;
    private static Activity activity;

    private static FactoryObjectHolder mHolder = new FactoryObjectHolder();

    public static FactoryObjectHolder getInstance(){
        return mHolder;
    }

    public void setData(Activity activity,Object obj){
        this.activity = activity;
        this.obj = obj;
    }

}
