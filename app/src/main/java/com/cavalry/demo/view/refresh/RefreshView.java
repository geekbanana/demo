package com.cavalry.demo.view.refresh;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cavalry.demo.R;

/**
 * Created by cavalry on 16-9-27.
 */
public class RefreshView extends RelativeLayout {

    private ImageView mRoundImageView;
    private RotateAnimation mRotateAnimation;
    private TextView mTextView;
    private CharSequence mText = "正在加载...";
    private float mTextSize = 16;
    private float mTextLeftMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,8,getContext().getResources().getDisplayMetrics());

    private final int DEFAULT_PADDING = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,12,getContext().getResources().getDisplayMetrics());

    public RefreshView(Context context) {
        this(context,null);
    }

    public RefreshView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public RefreshView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        setPadding(DEFAULT_PADDING,DEFAULT_PADDING,DEFAULT_PADDING,DEFAULT_PADDING);

        //中心logo,环形圈,文字
        LinearLayout contentContainer = new LinearLayout(getContext());
        contentContainer.setBackgroundColor(Color.GREEN);
        contentContainer.setOrientation(LinearLayout.HORIZONTAL);
        RelativeLayout.LayoutParams contentLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        contentLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        contentContainer.setLayoutParams(contentLayoutParams);

        //中心logo和环形圈
        RelativeLayout loadingContainer = new RelativeLayout(getContext());
        loadingContainer.setGravity(Gravity.CENTER_VERTICAL);
        LinearLayout.LayoutParams loadingContainerLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        loadingContainer.setLayoutParams(loadingContainerLayoutParams);
        Drawable loadingLogoDrawable = getContext().getResources().getDrawable(R.mipmap.icon_find_loading_logo);
        Drawable loadingRoundDrawable = getContext().getResources().getDrawable(R.mipmap.icon_find_loading_round);

        //中心logo
        ImageView logoImageView = new ImageView(getContext());
        RelativeLayout.LayoutParams logoLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        logoLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        logoImageView.setLayoutParams(logoLayoutParams);
        logoImageView.setImageDrawable(loadingLogoDrawable);

        //环形圈
        mRoundImageView = new ImageView(getContext());
        RelativeLayout.LayoutParams roundLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        roundLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        mRoundImageView.setLayoutParams(roundLayoutParams);
        mRoundImageView.setImageDrawable(loadingRoundDrawable);

        //文字
        mTextView = new TextView(getContext());
        LinearLayout.LayoutParams textViewLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        textViewLayoutParams.gravity = Gravity.CENTER_VERTICAL;
        textViewLayoutParams.leftMargin = (int) mTextLeftMargin;
        mTextView.setLayoutParams(textViewLayoutParams);
        mTextView.setTextSize(mTextSize);
        mTextView.setText(mText);

        loadingContainer.addView(logoImageView);
        loadingContainer.addView(mRoundImageView);
        contentContainer.addView(loadingContainer);
        contentContainer.addView(mTextView);
        addView(contentContainer);
    }


    /**
     * 开始刷新
     */
    public void startRefresh(){
        if(mRoundImageView!=null){
            if(mRotateAnimation==null){
                mRotateAnimation = new RotateAnimation(0,
                        360,
                        Animation.RELATIVE_TO_SELF,
                        0.5f,
                        Animation.RELATIVE_TO_SELF,
                        0.5f);
                mRotateAnimation.setDuration(1000);
                mRotateAnimation.setInterpolator(new LinearInterpolator());
                mRotateAnimation.setRepeatCount(-1);
                mRotateAnimation.setRepeatMode(Animation.INFINITE);
            }
            mRoundImageView.clearAnimation();
            mRoundImageView.startAnimation(mRotateAnimation);
        }
    }

    /**
     * 结束刷新
     */
    public void finishRefresh(){
        if(mRoundImageView!=null && mRotateAnimation!=null){
            mRotateAnimation.cancel();
        }
    }

    public void setText(CharSequence text){
        mText = text;
        mTextView.setText(mText);
    }

    public void setTextSize(float size){
        mTextSize = size;
        mTextView.setTextSize(mTextSize);
    }

    public void setTextColor(int color){
        mTextView.setTextColor(color);
    }


}
