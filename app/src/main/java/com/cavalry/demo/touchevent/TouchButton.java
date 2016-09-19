package com.cavalry.demo.touchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * Created by Cavalry on 2016/7/31.
 */
public class TouchButton extends Button {

    public TouchButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.i(null, "11-->dispatchTouchEvent-- action=" + event.getAction());
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(null, "11-->onTouchEvent-- action="+event.getAction());
        return super.onTouchEvent(event);
//        return false;
    }
}
