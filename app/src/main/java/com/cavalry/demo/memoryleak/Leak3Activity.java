package com.cavalry.demo.memoryleak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.cavalry.demo.R;

import java.util.ArrayList;

public class Leak3Activity extends AppCompatActivity {
    private FactoryObjectHolder holder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak3);

        init();
    }

    private void init() {

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<1024;i++){
            list.add(new Integer(i));
        }

        Log.d("Leak3Activity","init-->size ="+list.size());

        holder = FactoryObjectHolder.getInstance();
        holder.setData(this,list);

    }
}
