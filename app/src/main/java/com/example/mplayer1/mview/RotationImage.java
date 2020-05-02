package com.example.mplayer1.mview;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.Nullable;


public class RotationImage extends ImageView {
    public RotationImage(Context context) {
        super(context);
    }

    public RotationImage(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RotationImage(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    int ro=0;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        final Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.i("222","3333333");
                RotationImage.this.setRotationY(ro++);
                handler.postDelayed(this,100);
            }
        },100);
    }
}
