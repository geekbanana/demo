package com.cavalry.demo.memoryleak;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.cavalry.demo.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LeakDemoActivity extends AppCompatActivity {

    @Bind(R.id.btn_no_leak)
    Button btnNoLeak;
    @Bind(R.id.btn_leak_1)
    Button btnLeak1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak_demo);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.gc();
    }

    @OnClick({R.id.btn_no_leak,R.id.btn_leak_1,R.id.btn_leak_2,R.id.btn_leak_3})
    void click(View view){
        switch (view.getId()){
            case R.id.btn_no_leak:
                readyGo(NoLeakActivity.class);
                break;
            case R.id.btn_leak_1:
                readyGo(Leak1Activity.class);
                break;
            case R.id.btn_leak_2:
                readyGo(Leak2Activity.class);
                break;
            case R.id.btn_leak_3:
                readyGo(Leak3Activity.class);
                break;
        }
    }

    private void readyGo(Class clazz){
        Intent intent = new Intent(this,clazz);
        startActivity(intent);
    }
}
