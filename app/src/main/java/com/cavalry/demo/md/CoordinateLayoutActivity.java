package com.cavalry.demo.md;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cavalry.demo.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CoordinateLayoutActivity extends AppCompatActivity {

    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;
    @Bind(R.id.fab)
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinate_layout);
        ButterKnife.bind(this);

        initView();

    }

    private void initView() {

        List<String> data = new ArrayList<>();
        for(int i=0;i<20;i++){
            data.add("String: "+i);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new BaseQuickAdapter<String>(R.layout.item_text,data) {
            @Override
            protected void convert(BaseViewHolder helper, String item) {
                helper.setText(R.id.tv,item);
            }
        });
    }
}
