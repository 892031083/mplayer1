package com.example.mplayer1.mview;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.Nullable;


public class ScrollTextView extends TextView{

    int rawWidth;
    int width;
    int textWidth;

    public ScrollTextView(Context context) {
        super(context);
        init();
    }

    public ScrollTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ScrollTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    Handler handler=new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            ScrollTextView.this.setPadding(padleft,ScrollTextView.this.getPaddingTop(),ScrollTextView.this.getPaddingRight(),
                    ScrollTextView.this.getPaddingBottom());
        }
    };
    int padleft=0;

    public void init(){
      new Thread(){
          @Override
          public void run() {
              while (true){

                  if (padleft*-1==width){


                      padleft=width+1;
                  }
                  padleft--;
                    handler.sendEmptyMessage(1);
                  try {
                      sleep(10);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
              }
          }
      }.start();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width=getMeasuredWidth();//控件宽度


    }
}
