package com.cavalry.demo.dropdownmenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.cavalry.demo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DropDownMenuActivity extends AppCompatActivity {

    @Bind(R.id.drop_down_menu_header)
    TextView tvTitle;
    @Bind(R.id.drop_down_menu_filter)
    RecyclerView recyclerView;
    @Bind(R.id.drop_down_menu_content)
    FrameLayout dropDownMenuContent;
    @Bind(R.id.drop_down_menu)
    DropDownMenu dropDownMenu;
    private TranslateAnimation showAnimation;
    private List<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drop_down_menu);
        ButterKnife.bind(this);


        initData();
        initAnimation();
        initView();
    }

    private void initData() {
        data = new ArrayList<>();
        data.add("111");
        data.add("222");
        data.add("333");
        data.add("44444444");
        data.add("6666666666");
    }

    private void initAnimation() {
//        showAnimation = new TranslateAnimation(0,0,-1,0);
//        showAnimation.setDuration(1000);
        showAnimation = (TranslateAnimation) AnimationUtils.loadAnimation(this, R.anim.top_in);
    }

    private void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        recyclerView.setAdapter(new DropDownMenuAdapter(this, data));
    }

    @OnClick(R.id.drop_down_menu_header)
    void clickTitle(View view) {
        dropDownMenu.toggleFilter();
    }
}
