package com.cavalry.demo.dropdownmenu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import com.cavalry.demo.R;

/**
 * Created by Cavalry on 2016/8/5.
 */
public class DropDownMenu extends RelativeLayout {

    private View mHeader;
    private View mFilter;
    private View mContent;
    private Animation mShowAnimation;
    private Animation mHideAnimation;

    public DropDownMenu(Context context) {
        this(context,null);
    }

    public DropDownMenu(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DropDownMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        initAnimation();
        layoutViews();
    }

    private void initAnimation() {
        mShowAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.top_in);
        mHideAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.top_out);
    }

    private void layoutViews() {
        mHeader = findViewById(R.id.drop_down_menu_header);
        mFilter = findViewById(R.id.drop_down_menu_filter);
        mContent = findViewById(R.id.drop_down_menu_content);

        mFilter.setVisibility(View.INVISIBLE);

        mFilter.bringToFront();
        mHeader.bringToFront();
        ///android4.4之前的版本需要让view的父控件调用这两个方法使其重绘。
        requestLayout();
        invalidate();

        LayoutParams filterLayoutParams = (LayoutParams) mFilter.getLayoutParams();
        filterLayoutParams.addRule(BELOW,R.id.drop_down_menu_header);
        mFilter.setLayoutParams(filterLayoutParams);

        LayoutParams headerLayoutParams = (LayoutParams) mContent.getLayoutParams();
        headerLayoutParams.addRule(BELOW,R.id.drop_down_menu_header);
        mContent.setLayoutParams(headerLayoutParams);
    }


    public void showFilter(){
        mFilter.startAnimation(mShowAnimation);
        mFilter.setVisibility(View.VISIBLE);
    }

    public void hideFilter(){
        mFilter.startAnimation(mHideAnimation);
        mFilter.setVisibility(View.INVISIBLE);
    }

    public boolean isFilterShowing(){
        return mFilter.getVisibility()==View.VISIBLE;
    }

    public void toggleFilter(){
        if(isFilterShowing()){
            hideFilter();
        }else{
            showFilter();
        }
    }
}
