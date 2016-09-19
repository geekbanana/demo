package com.cavalry.demo.layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.LinearLayout;

import com.cavalry.demo.R;

public class ViewStubActivity extends AppCompatActivity {

    private LinearLayout importedView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_stub);
    }

    public void showViewStub(View view){
//        ViewStub viewStub = (ViewStub) findViewById(R.id.view_stub);
//        viewStub.setVisibility(View.VISIBLE);


        //或者
        importedView = (LinearLayout) ((ViewStub)findViewById(R.id.view_stub)).inflate();


    }

    public void addView(View view){
        Button button = new Button(getBaseContext());
        button.setText("增加的Button");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1,-1);
        importedView.addView(button,layoutParams);
    }
}
