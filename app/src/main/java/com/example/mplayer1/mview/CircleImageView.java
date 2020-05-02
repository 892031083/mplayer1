package com.example.mplayer1.mview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class CircleImageView extends ImageView {

    Context context;

    public CircleImageView(Context context) {
        super(context);
        this.context=context;
    }

    public CircleImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
    }

    public CircleImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
    }

    /**
     * 创建一个空白的bitmap  将之前的bitmap附着到paint上 然后绘制这个新的空白bitmap
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
//        Drawable drawable=getDrawable();//获取已加载的图片
//        if (drawable==null || getWidth()==0 || getHeight()==0) return;
//        Bitmap bitmap=((BitmapDrawable)drawable).getBitmap();//转换成bitmap
//        Bitmap newmap=Bitmap.createBitmap(getWidth(),getWidth(), Bitmap.Config.ARGB_8888);
//        Canvas newCan=new Canvas(newmap);//创建一个 newmap的canvas
//        //开始绘制newmap
//        Paint paint=new Paint();
//        paint.setAntiAlias(true);
//        newCan.drawCircle(getWidth()/2,getHeight()/2,getWidth()/2,paint);//绘制一个圆形
//        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));//将图片填入圆中
//        Rect rect=new Rect(0,0,getWidth(),getHeight());//创建一个矩形
//        newCan.drawBitmap(bitmap,rect,rect,paint);//给新的圆形空白图片 绘制 图像
//
//        canvas.drawBitmap(newmap,0,0,null);//将新图片绘制到控件

//
//        Drawable drawable=getDrawable();//获取加载的图片
//        if (drawable==null) drawable=context.getDrawable(android.R.mipmap.sym_def_app_icon);
//        Bitmap bitmap=((BitmapDrawable)drawable).getBitmap();//转换
//        bitmap=bitmap.copy(Bitmap.Config.ARGB_8888,true);
//        Bitmap newmap=Bitmap.createBitmap(getWidth(),getHeight(),Bitmap.Config.ARGB_8888);
//        Canvas can=new Canvas(newmap);//定义一个新图片的画布
//        Paint paint=new Paint();//画笔
//        can.drawCircle(getWidth()/2,getWidth()/2,getWidth()/2,paint);
//        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));//图片填入画笔
//        Rect rect=new Rect(0,0,getWidth(),getWidth());
//        can.drawBitmap(bitmap,new Rect(0,0,bitmap.getWidth(),bitmap.getHeight()),rect,paint);
//
//        canvas.drawBitmap(newmap ,0,0,null);

        Drawable drawable=getDrawable();
        Bitmap bitmap=((BitmapDrawable)drawable).getBitmap();//获取图片

        Bitmap newbit=Bitmap.createBitmap(getWidth(),getHeight(),Bitmap.Config.ARGB_8888);
        Canvas can=new Canvas(newbit);
        Paint paint=new Paint();
        can.drawCircle(newbit.getWidth()/2,newbit.getHeight()/2,newbit.getWidth()/2,paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        can.drawBitmap(bitmap,new Rect(0,0,bitmap.getWidth(),bitmap.getHeight()),
                new Rect(0,0,newbit.getWidth(),newbit.getHeight()),paint);
        canvas.drawBitmap(newbit,0,0,null);
    }
}
