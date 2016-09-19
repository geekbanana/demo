package com.cavalry.demo.pool;

import android.graphics.Bitmap;
import android.support.v4.util.Pools;
import android.widget.TextView;

/**
 * Created by Cavalry on 2016/8/13.
 */
public class BitmapPool {
    private static final Pools.SynchronizedPool<Bitmap> mBitmapPool = new Pools.SynchronizedPool<Bitmap>(10);


}
