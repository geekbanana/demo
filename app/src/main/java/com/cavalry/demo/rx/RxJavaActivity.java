package com.cavalry.demo.rx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.cavalry.demo.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Single;
import rx.SingleSubscriber;
import rx.Subscriber;
import rx.functions.Func1;

public class RxJavaActivity extends AppCompatActivity {
    private final static String tag = "RxJavaActivity";
    @Bind(R.id.btn_demo_1)
    Button btnDemo1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.btn_demo_1})
    void click(View view){
        switch (view.getId()){
            case R.id.btn_demo_1:
                demo1();
                break;
        }
    }


    private void demo1() {
        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onNext(String s) {
                Log.d(tag, "Item: " + s);
            }

            @Override
            public void onCompleted() {
                Log.d(tag, "Completed!");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(tag, "Error!");
            }
        };

        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello");
                subscriber.onNext("Hi");
                subscriber.onNext("Aloha");
                subscriber.onCompleted();
            }
        });

        observable.subscribe(subscriber);
    }

    private int addValue(int a,int b){
        return a+b;
    }

    private void demoSingle1(){
        Single
                .just(addValue(1,2))
                .subscribe(new SingleSubscriber<Integer>() {
                    @Override
                    public void onSuccess(Integer value) {
                        Log.d(tag,"demoSingle-->value="+value);// value = 3;
                    }

                    @Override
                    public void onError(Throwable error) {

                    }
                });
    }

    private void demoSingle2(){
        Single.just(addValue(1,2))
                .compose(new Single.Transformer<Integer, String>() {
                    @Override
                    public Single<String> call(Single<Integer> integerSingle) {
                        return integerSingle.map(new Func1<Integer, String>() {
                            @Override
                            public String call(Integer integer) {
                                return String.valueOf(integer+2);
                            }
                        });
                    }
                })
                .subscribe(new SingleSubscriber<String>() {
                    @Override
                    public void onSuccess(String value) {
                        Log.d(tag,"demoSingle-->value="+value);// value = "5";
                    }

                    @Override
                    public void onError(Throwable error) {

                    }
                });
    }

}
