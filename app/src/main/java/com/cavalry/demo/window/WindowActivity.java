package com.cavalry.demo.window;

import android.content.Context;
import android.graphics.PixelFormat;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.Button;

import com.cavalry.demo.R;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class WindowActivity extends AppCompatActivity {

    private Button mButton;
    private WindowManager mWindowManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_window);
        initView();
    }

    private void initView() {
        mButton = new Button(this);
        mButton.setText("button");
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                0,//type
                0,//flag
                PixelFormat.TRANSPARENT);

//        layoutParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
        layoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                |   WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                |   WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED;

        layoutParams.gravity = Gravity.LEFT | Gravity.TOP;

        layoutParams.x = 100;
        layoutParams.y = 300;

        mWindowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        mWindowManager.addView(mButton,layoutParams);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mWindowManager.removeViewImmediate(mButton);
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }

}
