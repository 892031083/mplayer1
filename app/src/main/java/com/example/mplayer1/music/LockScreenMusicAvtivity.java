package com.example.mplayer1.music;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Bundle;
import android.transition.Transition;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.mplayer1.PlayerModel;
import com.example.mplayer1.R;
import com.example.mplayer1.base.BaseActivity;

public class LockScreenMusicAvtivity extends Activity implements View.OnClickListener {
    public static boolean isStart=false;
    private RelativeLayout dingview;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD | WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
                WindowManager.LayoutParams. FLAG_FULLSCREEN );

        isStart=true;
        setContentView(R.layout.activity_lockscreen);
        ((TextView)findViewById(R.id.table)).setText(PlayerModel.getTime(System.currentTimeMillis()));
        ((TextView)findViewById(R.id.date)).setText(PlayerModel.getTimeNow());
        dingview=findViewById(R.id.dingview);
        initBtn();
    }

    private void initBtn() {
        setBtn();
        findViewById(R.id.mpbtn).setOnClickListener(this);
        findViewById(R.id.upm).setOnClickListener(this);
        findViewById(R.id.downm).setOnClickListener(this);
    }

    private void setBtn() {
        if (ServiceToutil.getInstance().getMediaPlayer().isPlaying()){
            ((ImageButton)findViewById(R.id.mpbtn)).setImageResource(R.mipmap.icon_paus_ms);

        }else{
            ((ImageButton)findViewById(R.id.mpbtn)).setImageResource(R.mipmap.play_play10);
        }
    }

    PointF pointF=new PointF();
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (isAnim) return false;
        //继承了Activity的onTouchEvent方法，直接监听点击事件
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN://手指落下
                Log.i("eeeee",event.getX()+"");
                pointF.set(event.getX(),event.getY());//保存初始点
                //    matrixstart.set(circleImageView.getImageMatrix());//获取初始矩阵
                //   matrix.set(matrixstart);
             //   Log.i("========","KKK");
                break;
            case MotionEvent.ACTION_MOVE://移动
                Log.i("eeeee1",event.getX()+":::::"+pointF.x+"''''''"+dingview.getX());

                float dx=event.getX()-pointF.x;//X轴移动的距离
                pointF.x=event.getX();
                float dy=event.getY()-pointF.y;//Y轴移动的距离
                //     matrix.set(matrixstart);
                //    matrix.postTranslate(dx, dy);//设置平移
                dingview.setX(dingview.getX()+(int)dx);
               // dingview.setY(dingview.getY()+dy);
                break;

            case MotionEvent.ACTION_UP:
                 if (dingview.getX()>dingview.getWidth()/2){
                    startAnim(dingview.getWidth());
                 }else{
                     if (dingview.getX()<150){
                         dingview.setX(0);
                     }else {
                         startAnim(0);
                     }

                   //  dingview.setX(0);
                 }
                break;
        }

        return super.onTouchEvent(event);

    }
    boolean isAnim=false;
    private void startAnim(final int toX) {
        ObjectAnimator objectAnimatorX = ObjectAnimator.ofFloat(dingview,"translationX", toX);
        objectAnimatorX.setDuration(300);
        isAnim=true;
        objectAnimatorX.start();
        objectAnimatorX.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                isAnim=false;
                if (toX!=0){
                    LockScreenMusicAvtivity.this.finish();
                }

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isStart=false;
        ServiceToutil.getInstance().setPlayerIngListener(null);
    }
    private void playorpause(){

            if (ServiceToutil.getInstance().getMediaPlayer().isPlaying()){
                ServiceToutil.getInstance().pasue();
                setBtn();
            }else{
                ServiceToutil.getInstance().getMediaPlayer().start();
                setBtn();

        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mpbtn:
                playorpause();
                break;
            case R.id.upm:
                playReset();
                break;
            case R.id.downm:
                playReset();
                break;
        }
    }

    private void playReset() {
       // findViewById(R.id.mpbtn).setEnabled(false);
        ((ImageButton)findViewById(R.id.mpbtn)).setImageResource(R.mipmap.play_play10);
//        ServiceToutil.getInstance().setPlayerIngListener(new ServiceToutil.PlayerIngListener() {
//            @Override
//            public void OnPlaying() {
//                //正在播放
//                findViewById(R.id.mpbtn).setEnabled(true);
//                ((ImageButton)findViewById(R.id.mpbtn)).setImageResource(R.mipmap.icon_paus_ms);
//            }
//        });
        ServiceToutil.getInstance().setPlayResource(this,R.raw.betf).play();
        ((ImageButton)findViewById(R.id.mpbtn)).setImageResource(R.mipmap.icon_paus_ms);
    }


}
