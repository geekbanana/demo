package com.cavalry.demo.memoryleak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.cavalry.demo.R;

import java.util.ArrayList;

public class Leak1Activity extends AppCompatActivity {

    private ObjectHolder holder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak1);

        init();
    }

    private void init() {

            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0;i<1024;i++){
                list.add(new Integer(i));
            }

            Log.d("Leak1Activity","init-->size ="+list.size());

            holder = new ObjectHolder(this,list);

    }
}
