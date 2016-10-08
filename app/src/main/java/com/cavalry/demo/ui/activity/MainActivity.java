package com.cavalry.demo.ui.activity;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import android.view.ViewGroup;

import com.cavalry.demo.R;
import com.cavalry.demo.bitmap.BitmapActivity;
import com.cavalry.demo.date.DatePickerActivity;
import com.cavalry.demo.dropdownmenu.DropDownMenuActivity;
import com.cavalry.demo.entity.MainEntity;
import com.cavalry.demo.exception.ExceptionActivity;
import com.cavalry.demo.layout.ViewStubActivity;
import com.cavalry.demo.md.CoordinateLayoutActivity;
import com.cavalry.demo.memoryleak.LeakDemoActivity;
import com.cavalry.demo.rx.RxJavaActivity;
import com.cavalry.demo.sdview.cliprect.ClipRectActivity;
import com.cavalry.demo.sdview.relativemedicine.RelativeMedicineActivity;
import com.cavalry.demo.section.BaseSection;
import com.cavalry.demo.string.StringActivity;
import com.cavalry.demo.touchevent.TouchActivity;
import com.cavalry.demo.ui.adapter.MainRecyclerViewAdapter;
import com.cavalry.demo.view.refresh.RefreshViewActivity;
import com.cavalry.demo.window.WindowActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.drop_down_menu_filter)
    android.support.v7.widget.RecyclerView recyclerView;
    private List<BaseSection<MainEntity>> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
/*
    Android提供了一个叫做Strict Mode的工具，我们可以通过手机设置里面的开发者选项，打开Strict Mode选项，
    如果程序存在潜在的隐患，屏幕就会闪现红色。
    我们也可以通过StrictMode API在代码层面做细化的跟踪，可以设置StrictMode监听那些潜在问题，
    出现问题时如何提醒开发者，可以对屏幕闪红色，也可以输出错误日志。下面是官方的代码示例：
 */
        if(false){
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectDiskReads()
                    .detectDiskWrites()
                    .detectNetwork()   // or .detectAll() for all detectable problems
                    .penaltyLog()
                    .build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectLeakedSqlLiteObjects()
                    .detectLeakedClosableObjects()
                    .penaltyLog()
                    .penaltyDeath()
                    .build());
        }


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initData();
        initView();
    }

    private void initData() {
        mData = new ArrayList<BaseSection<MainEntity>>();
        mData.add(new BaseSection(true,"Bitmap"));
        mData.add(new BaseSection<MainEntity>(new MainEntity("缩略图", BitmapActivity.class)));

        mData.add(new BaseSection(true,"布局"));
        mData.add(new BaseSection<MainEntity>(new MainEntity("ViewStub", ViewStubActivity.class)));

        mData.add(new BaseSection(true,"Date"));
        mData.add(new BaseSection<MainEntity>(new MainEntity("DatePicker", DatePickerActivity.class)));

        mData.add(new BaseSection(true,"异常"));
        mData.add(new BaseSection<MainEntity>(new MainEntity("Exception", ExceptionActivity.class)));

        mData.add(new BaseSection(true,"MaterialDesign"));
        mData.add(new BaseSection<MainEntity>(new MainEntity("CoordinateLayout", CoordinateLayoutActivity.class)));

        mData.add(new BaseSection(true,"MemoryLeak"));
        mData.add(new BaseSection<MainEntity>(new MainEntity("MemoryLeak", LeakDemoActivity.class)));

        mData.add(new BaseSection(true,"Rx"));
        mData.add(new BaseSection<MainEntity>(new MainEntity("RxJava", RxJavaActivity.class)));

        mData.add(new BaseSection(true,"String"));
        mData.add(new BaseSection<MainEntity>(new MainEntity("String", StringActivity.class)));

        mData.add(new BaseSection(true,"TouchEvent"));
        mData.add(new BaseSection<MainEntity>(new MainEntity("OnTouchEvent", TouchActivity.class)));

        mData.add(new BaseSection(true,"Window"));
        mData.add(new BaseSection<MainEntity>(new MainEntity("WindowManager", WindowActivity.class)));

        mData.add(new BaseSection(true,"自定义View"));
        mData.add(new BaseSection<MainEntity>(new MainEntity("RelativeMedicineView", RelativeMedicineActivity.class)));
        mData.add(new BaseSection<MainEntity>(new MainEntity("clipRect", ClipRectActivity.class)));
        mData.add(new BaseSection<MainEntity>(new MainEntity("DropDownMenu", DropDownMenuActivity.class)));
        mData.add(new BaseSection<MainEntity>(new MainEntity("RefreshView", RefreshViewActivity.class)));


    }

    private void initView() {
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(new MainRecyclerViewAdapter(this,mData));
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }
}
