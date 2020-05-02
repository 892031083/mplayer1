package com.example.mplayer1.mview;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.example.mplayer1.R;

import java.lang.ref.WeakReference;

public class UnlockButton extends LinearLayout {


    private Context context;

    public UnlockButton(Context context) {
        super(context);
        initView(context);
    }


    public UnlockButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public UnlockButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }
    boolean isT=true;
    ImageView img1,img2,img3;
    UnlockHandler handler;
    private void initView(final Context context) {
        this.context=context;
        final View view= LayoutInflater.from(context).inflate(R.layout.lockview,null);
        addView(view);
        handler=new UnlockHandler(this);
        img1=view.findViewById(R.id.img1);
        img2=view.findViewById(R.id.img2);
        img3=view.findViewById(R.id.img3);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (isT){

                    try {
                        handler.sendEmptyMessage(sd);
                        sd++;
                        if (sd>3){
                            sd=1;
                        }
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
    int sd=1;

    private static class UnlockHandler extends Handler{
        WeakReference<LinearLayout> weakReference;
        UnlockHandler(LinearLayout linearLayout){
            weakReference=new WeakReference<>(linearLayout);
        }
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            UnlockButton unlockButton=(UnlockButton)weakReference.get();
            unlockButton.img1.setImageResource(R.mipmap.icon_to);
            unlockButton.img2.setImageResource(R.mipmap.icon_to);
            unlockButton.img3.setImageResource(R.mipmap.icon_to);
            switch (msg.what){
                case 1:
                    unlockButton.img1.setImageResource(R.mipmap.icon_to1);
                    break;
                    case 2:
                        unlockButton.img2.setImageResource(R.mipmap.icon_to1);
                    break;
                case 3:
                    unlockButton.img3.setImageResource(R.mipmap.icon_to1);
                    break;
            }
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        isT=false;
        handler.removeCallbacksAndMessages(context);
    }
}
