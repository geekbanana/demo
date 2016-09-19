package com.cavalry.demo.sdview.relativemedicine;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.cavalry.demo.R;
import com.cavalry.demo.utils.DisplayUtils;
import com.cavalry.demo.utils.ResourcesUtils;

import java.util.List;

/**
 * Created by Cavalry on 2016/8/8.
 */
public class RelativeMedicineView extends LinearLayout {
    private final String TAG = "RelativeMedicineView";
    private final int DEFAULT_LOOK_MORE_SIZE = 2;
    private List<RelativeMedicineBean> mData;
    private RelativeMedicineBean mDataType1;
    private RelativeMedicineBean mDataType2;
    private boolean hasLookMore;
    private boolean hasDivider;
    private LinearLayout containerTop;
    private LinearLayout containerBottom;
    private LinearLayout containerCenter;
    private TextView tvLookMore;
    private View divider;
    private LayoutInflater mLayoutInflater;

    public RelativeMedicineView(Context context) {
        this(context,null);
    }

    public RelativeMedicineView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public RelativeMedicineView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(VERTICAL);
        initViews(context);
    }

    private void initViews(Context context) {
        mLayoutInflater = LayoutInflater.from(context);

        containerTop = new LinearLayout(context);
        containerTop.setOrientation(VERTICAL);
//        containerTop.setLayoutParams(new LayoutParams(400,300));
        containerTop.setBackgroundColor(Color.RED);
        containerTop.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));

        containerBottom = new LinearLayout(context);
        containerBottom.setOrientation(VERTICAL);
        containerBottom.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
        containerBottom.setBackgroundColor(Color.BLUE);

        containerCenter = new LinearLayout(context);
        containerCenter.setOrientation(VERTICAL);
        containerCenter.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
        containerCenter.setBackgroundColor(Color.GREEN);

        tvLookMore = new TextView(context);
        tvLookMore.setText("查看更多");
        tvLookMore.setTextSize(DisplayUtils.sp2px(14));
        tvLookMore.setTextColor(ResourcesUtils.getColor(R.color.colorPrimary));
        tvLookMore.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
        tvLookMore.setGravity(Gravity.CENTER);
        tvLookMore.setPadding(0,DisplayUtils.dip2px(8),0,DisplayUtils.dip2px(8));

        divider = new View(context);
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        params.height = DisplayUtils.dip2px(8);
        divider.setLayoutParams(params);
        divider.setBackgroundColor(Color.BLACK);

        containerCenter.addView(tvLookMore);
        containerCenter.addView(divider);
    }

    public void setData(List<RelativeMedicineBean> data){
        mData = data;
        orderData();
        setViews();
        fillViews();
    }




    private void orderData(){
        Log.e(TAG,"orderData  mData="+mData);
        if(mData!=null){
            for(RelativeMedicineBean bean : mData){
                if("1".equals(bean.type)){
                    mDataType1 = bean;
                }else if("2".equals(bean.type)){
                    mDataType2 = bean;
                }
            }
            if(mDataType1!=null && mDataType1.products!=null && mDataType1.products.size()>DEFAULT_LOOK_MORE_SIZE){
                hasLookMore = true;
            }
            if(mDataType1!=null && mDataType2!=null){
                hasDivider = true;
            }
        }
        Log.e(TAG,"orderData  mDataType1="+mDataType1);
    }

    private void setViews() {

        if(mDataType1!=null){
            addView(containerTop);
        }
        if(mDataType1!=null && mDataType2!=null){
            addView(containerCenter);
        }
        if(mDataType2!=null){
            addView(containerBottom);
        }
        Log.e(TAG,"setViews");

    }

    private void fillViews() {
        Log.e(TAG,"fillViews  mDataType1="+mDataType1);
        if(mDataType1!=null){
                List<RelativeMedicineBean.ProductsBean> products = mDataType1.products;
                int size = products.size();
                if(hasLookMore){
                    size = DEFAULT_LOOK_MORE_SIZE;
                }
                View fuyaoView;
                for(int i=0;i<size;i++){
                    fuyaoView = mLayoutInflater.inflate(R.layout.item_relative_medicine_fuyao, containerTop, false);
                    ((TextView)fuyaoView.findViewById(R.id.tv_symptom)).setText("伴随症状:  "+products.get(i).symptom);
                    ((TextView)fuyaoView.findViewById(R.id.tv_fu_yao)).setText("辅药:  "+products.get(i).commons);
                    ((TextView)fuyaoView.findViewById(R.id.tv_main_push)).setText("本期主推:  "+products.get(i).recommStr);
                    ((TextView)fuyaoView.findViewById(R.id.tv_reason)).setText("组合理由:  "+products.get(i).reason);
                    ((TextView)fuyaoView.findViewById(R.id.tv_provider)).setText("提  供  方:  "+products.get(i).provider);

                    Log.e(TAG,"fillViews  辅药 width="+fuyaoView.getLayoutParams().width+"    ,height="+fuyaoView.getLayoutParams().height);
                    containerTop.addView(fuyaoView);
                }
        }

        if(mDataType1!=null && mDataType2!=null){
            divider.setVisibility(View.VISIBLE);
        }else {
            divider.setVisibility(View.GONE);
        }

        if(hasLookMore){
            tvLookMore.setVisibility(View.VISIBLE);
        }else{
            tvLookMore.setVisibility(View.GONE);
        }

        if(mDataType2!=null){
                List<RelativeMedicineBean.ProductsBean> products = mDataType2.products;
                int size = products.size();
                if(hasLookMore){
                    size = DEFAULT_LOOK_MORE_SIZE;
                }
                View feiyaoView;
                for(int i=0;i<size;i++){
                    feiyaoView = mLayoutInflater.inflate(R.layout.item_relative_medicine_feiyao, containerTop, false);
                    ((TextView)feiyaoView.findViewById(R.id.tv_fei_yao)).setText("伴随症状:  "+products.get(i).symptom);
                    ((TextView)feiyaoView.findViewById(R.id.tv_reason)).setText("组合理由:  "+products.get(i).reason);
                    ((TextView)feiyaoView.findViewById(R.id.tv_provider)).setText("提  供  方:  "+products.get(i).provider);
                    Log.e(TAG,"fillViews  非药 width="+feiyaoView.getLayoutParams().width+"    ,height="+feiyaoView.getLayoutParams().height);
                    containerBottom.addView(feiyaoView);
                }
        }

        Log.e(TAG,"fillViews");
    }

    public void unfold(){
        hasLookMore = false;
        fillViews();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.e(TAG,"onMeasure");
        measureChildren(widthMeasureSpec,heightMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Log.e(TAG,"onLayout");
        super.onLayout(changed, l, t, r, b);
    }
}
