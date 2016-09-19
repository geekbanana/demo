package com.cavalry.demo.memoryleak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.cavalry.demo.R;

import java.util.ArrayList;

public class Leak2Activity extends AppCompatActivity {
    StaticObjectHolder holder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak2);
    }

    private void init() {

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<1024;i++){
            list.add(new Integer(i));
        }

        Log.d("Leak2Activity","init-->size ="+list.size());

        holder = new StaticObjectHolder(this,list);

    }
}
