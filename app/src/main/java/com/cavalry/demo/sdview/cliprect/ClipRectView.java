package com.cavalry.demo.sdview.cliprect;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.cavalry.demo.R;

/**
 * Created by Cavalry on 2016/8/12.
 */
public class ClipRectView extends View {


    private Bitmap mScene;
    private Paint mPaint;
    private Bitmap mMusic;

    public ClipRectView(Context context) {
        this(context,null);
    }

    public ClipRectView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ClipRectView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mScene = BitmapFactory.decodeResource(getResources(),R.mipmap.scene);
        mMusic = BitmapFactory.decodeResource(getResources(),R.mipmap.music);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();//保存当前画布状态
        canvas.clipRect(100,100,600,800);//限定绘制区域
        canvas.drawBitmap(mScene,0,0,mPaint);
        canvas.restore();//恢复上一次保存的画布状态

        //restore之后,就会恢复到上一次保存的画布状态,也就不会有绘制区域的限定, 不会影响后续的绘制

        canvas.drawBitmap(mMusic,0,0,mPaint);
    }
}
