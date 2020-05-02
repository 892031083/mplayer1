package com.example.mplayer1.mview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import android.util.AttributeSet;
import android.widget.ImageView;

import androidx.annotation.Nullable;


public class DaoyiImage extends ImageView {
    public DaoyiImage(Context context) {
        super(context);
    }

    public DaoyiImage(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DaoyiImage(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public DaoyiImage(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Drawable drawable=getDrawable();
        if (drawable==null) return;
        Bitmap bitmap=((BitmapDrawable)drawable).getBitmap();
//        canvas.drawBitmap(bitmap,new Rect(0,0,bitmap.getWidth(),bitmap.getHeight()),
//                new Rect(0,0,getWidth(),getHeight()/2),null);//先绘制原图
        Matrix matrix=new Matrix();
        matrix.preScale(1,-1);
        //创建倒影图片,
        Bitmap daobit=Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,false);
        //创建最终的图片
        Bitmap newbit=Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight()+bitmap.getHeight()/2, Bitmap.Config.ARGB_8888);
        Canvas mcan=new Canvas(newbit);
        //在新图片上绘制原图
        mcan.drawBitmap(bitmap,0,0,null);
        //在新图片绘制倒影
        mcan.drawBitmap(daobit,0,bitmap.getHeight(),null);
        //设置渐变效果
        Paint paint=new Paint();
        LinearGradient shader=new LinearGradient(0,bitmap.getHeight(),newbit.getWidth(),newbit.getHeight(),
                0x70ffffff,0x00ffffff, Shader.TileMode.CLAMP);//渐变透明区域效果
        paint.setShader(shader);//设置透明渐变效果
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        mcan.drawRect(0,bitmap.getHeight(),newbit.getWidth(),newbit.getHeight(),paint);//绘制渐变透明

        canvas.drawBitmap(newbit,new Rect(0,0,newbit.getWidth(),newbit.getHeight()),
                new Rect(0,0,getWidth(),getHeight()),null);
    }
}




