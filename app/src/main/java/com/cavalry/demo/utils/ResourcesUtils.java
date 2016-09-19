package com.cavalry.demo.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.cavalry.demo.DemoApplication;

/**
 * Created by Cavalry on 2016/4/13.
 * 功能:
 * 描述:
 */
public class ResourcesUtils {
    public static Context getApplicationContext() {
        return DemoApplication.getContext();
    }

    public static int getColor(int id) {
        return getApplicationContext().getResources().getColor(id);
    }

    public static String getString(int id) {
        return getApplicationContext().getResources().getString(id);
    }

    public static Drawable getDrawable(int id) {
        return getApplicationContext().getResources().getDrawable(id);
    }
}
