package com.cavalry.demo.string;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cavalry.demo.R;

public class StringActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string);

        MyClass myClass = new MyClass();
        StringBuffer buffer = new StringBuffer("StringBuffer: hello");
        myClass.changeValue(buffer);
        System.out.println(buffer.toString());

        String str = "String: hello";
        myClass.changeValueStr(str);
        System.out.println(str);
    }

    class MyClass {

        void changeValue(final StringBuffer buffer) {
            buffer.append("world");
        }

        void changeValueStr(String str){
            str += "world";
        }
    }
}
