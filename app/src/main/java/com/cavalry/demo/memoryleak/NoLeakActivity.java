package com.cavalry.demo.memoryleak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cavalry.demo.R;

public class NoLeakActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_leak);
    }
}
