package com.cavalry.demo.exception;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.cavalry.demo.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ExceptionActivity extends AppCompatActivity {

    @Bind(R.id.btn)
    Button btn;

    private final static String TAG = "ExceptionActivity";
    @Bind(R.id.btn_syn)
    Button btnSyn;
    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exception);
        ButterKnife.bind(this);

        initThread();
    }

    private void initThread() {

    }


    private void test(int count) {
        Log.d(TAG, "before count=" + count);
        if (flag) {
            throw new RuntimeException("count:" + count);
        }
        flag = true;
        Log.d(TAG, "after count=" + count);
    }

    private void testSyn(int count) {
        Log.d(TAG, "before  syn  count=" + count);
        synchronized (this){
            if (flag) {
                throw new RuntimeException("count:" + count);
            }
            flag = true;
        }

        Log.d(TAG, "after syn count=" + count);
    }

    private void testError(){
        Log.d(TAG, "before error");
        if(true){
            throw new AssertionError();
        }
        Log.d(TAG, "after error");
    }

    @OnClick({R.id.btn,R.id.btn_syn,R.id.btn_error})
    void click(View view){
        switch (view.getId()){
            case R.id.btn:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        test(1);
                    }
                }).start();


                        test(2);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        test(3);
                    }
                }).start();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        test(4);
                    }
                }).start();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        test(5);
                    }
                }).start();
                break;
            case R.id.btn_syn:

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        testSyn(1);
                    }
                }).start();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        testSyn(2);
                    }
                }).start();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        testSyn(3);
                    }
                }).start();


                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        testSyn(4);
                    }
                }).start();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        testSyn(5);
                    }
                }).start();


                break;
            case R.id.btn_error:
                testError();
                break;
        }
    }



}
