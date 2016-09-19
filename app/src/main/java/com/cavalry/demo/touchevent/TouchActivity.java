package com.cavalry.demo.touchevent;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.cavalry.demo.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TouchActivity extends AppCompatActivity implements View.OnTouchListener, View.OnClickListener {
    private final static String TAG = "TouchActivity";

    @Bind(R.id.test_button)
    TouchButton testButton;
    @Bind(R.id.relative_layout)
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);
        ButterKnife.bind(this);

        testButton.setOnTouchListener(this);
        relativeLayout.setOnTouchListener(this);

        testButton.setOnClickListener(this);
        relativeLayout.setOnClickListener(this);

    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.i(null, "11-->OnTouchListener--onTouch-- action="+event.getAction()+" --"+v);
        return false;
    }

    @Override
    public void onClick(View v) {
        Log.i(null, "11-->OnClickListener--onClick--"+v);
    }
}
