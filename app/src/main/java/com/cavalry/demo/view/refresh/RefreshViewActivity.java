package com.cavalry.demo.view.refresh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.cavalry.demo.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RefreshViewActivity extends AppCompatActivity {

    @Bind(R.id.btn_start)
    Button btnStart;
    @Bind(R.id.btn_finish)
    Button btnFinish;
    @Bind(R.id.container)
    FrameLayout container;
    private RefreshView refreshView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh_view);
        ButterKnife.bind(this);

        init();
    }

    private void init() {
        refreshView = new RefreshView(getBaseContext());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        container.addView(refreshView,layoutParams);
    }

    @OnClick(R.id.btn_start)
    void startRefresh(){
        refreshView.startRefresh();
    }

    @OnClick(R.id.btn_finish)
    void finishRefresh(){
        refreshView.finishRefresh();
    }

}
