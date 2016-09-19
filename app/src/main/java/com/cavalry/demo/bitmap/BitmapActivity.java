package com.cavalry.demo.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.cavalry.demo.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BitmapActivity extends AppCompatActivity {
    private final String TAG = "BitmapActivity";

    @Bind(R.id.iv)
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        iv.post(new Runnable() {
            @Override
            public void run() {
                int reqWidth = iv.getWidth();
                int reqHeight = iv.getHeight();
                Bitmap bitmap = decodeSampledBitmapFromResource(getResources(),R.mipmap.brvah,reqWidth,reqHeight);
                iv.setImageBitmap(bitmap);
            }
        });

    }

    private Bitmap decodeSampledBitmapFromResource(Resources resources, int resId, int reqWidth, int reqHeight) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, resId, options);
        options.inSampleSize = calculateInSampleSize(options,reqWidth,reqHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, resId, options);
    }

    private int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        final int width = options.outWidth;
        final int height = options.outHeight;

        int inSampleSize = 1;

        if(width>reqWidth && height>reqHeight){
            int halfWidth = width/2;
            int halfHeight = height/2;
            while(halfWidth/inSampleSize>=reqWidth && halfHeight/inSampleSize>=reqHeight){
                inSampleSize *= 2;
            }
        }

        Log.e(TAG,"calculateInSampleSize    reqWidth="+reqWidth+"   reqHeight="+reqHeight+"     width="+width+"     height="+height+"   inSampleSize="+inSampleSize);

        return inSampleSize;
    }
}
