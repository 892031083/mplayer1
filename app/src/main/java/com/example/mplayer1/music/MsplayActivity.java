package com.example.mplayer1.music;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSeekBar;

import com.example.mplayer1.PlayerModel;
import com.example.mplayer1.R;
import com.example.mplayer1.base.BaseActivity;

import java.lang.ref.WeakReference;

public class MsplayActivity extends BaseActivity implements View.OnClickListener {

    private int pross;
    TextView sumTimeview,TimeView;
    ImageButton mpbtn;
    String url;
    private AppCompatSeekBar seekBar;
    private ServiceToutil serviceToutil;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.music_play_layout);
        initView();
        initDate();
    }

    private void initDate() {

        isplay=serviceToutil.getMediaPlayer().isPlaying();
        if (isplay) seekBar.setEnabled(true);
        setBtnBg(isplay);
        handler.postDelayed(new Runnable() {//监听播放进度
            @Override
            public void run() {
                if (serviceToutil.getMediaPlayer().isPlaying()) {


                    handler.sendEmptyMessage(serviceToutil.getMediaPlayer().getCurrentPosition());
                }
                handler.postDelayed(this,200);
            }
        },200);
    }

    private void initView() {
        mpbtn=findViewById(R.id.mpbtn);
        seekBar=findViewById(R.id.play_seekbar);
        seekBar.setEnabled(false);
        sumTimeview=findViewById(R.id.playsumtime);

        TimeView=findViewById(R.id.playTime);
        pross=getIntent().getIntExtra("porss", 0);
        url=getIntent().getStringExtra("url");
        serviceToutil=ServiceToutil.getInstance();
        sumTimeview.setText(PlayerModel.getTime(serviceToutil.getMediaPlayer().getDuration()));
        TimeView.setText(PlayerModel.getTime(serviceToutil.getMediaPlayer().getCurrentPosition()));
        seekBar.setMax(serviceToutil.getMediaPlayer().getDuration());
        seekBar.setProgress(serviceToutil.getMediaPlayer().getCurrentPosition());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            //当拖动条发生变化时调用该方法
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override //当用户开始滑动滑块时调用该方法（即按下鼠调用一次）
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override//当用户结束对滑块滑动时,调用该方法（即松开鼠标）
            public void onStopTrackingTouch(SeekBar seekBar) {
                serviceToutil.getMediaPlayer().seekTo(seekBar.getProgress());
            }
        });
        findViewById(R.id.outbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MsplayActivity.this.finish();
            }
        });
        mpbtn.setOnClickListener(this);
        findViewById(R.id.upm).setOnClickListener(this);
        findViewById(R.id.downm).setOnClickListener(this);
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
        //findViewById(R.id.mpbtn).setEnabled(false);
//        ((ImageButton)findViewById(R.id.mpbtn)).setImageResource(R.mipmap.play_play10);
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
    static class MusicHandler extends Handler {
        private WeakReference<Activity> weakReference;
        MusicHandler(Activity activity){
            this.weakReference=new WeakReference<>(activity);
        }
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            MsplayActivity activity= (MsplayActivity) weakReference.get();
            activity.seekBar.setProgress(msg.what);
            activity.TimeView.setText(PlayerModel.getTime(msg.what));
        }
    }
    private  MusicHandler handler=new MusicHandler(this);
    private void playorpause(){
        if (!isplay){
            toPlayMs("");
        }else{
            if (serviceToutil.getMediaPlayer().isPlaying()){
                serviceToutil.pasue();
                setBtnBg(false);
            }else{
                serviceToutil.getMediaPlayer().start();
                setBtnBg(true);
            }
        }
    }
    boolean isplay;
    private void toPlayMs(String url) {
        serviceToutil.setPlayResource(this,R.raw.betf);

        serviceToutil.getMediaPlayer().setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                serviceToutil.getMediaPlayer().start();
                int sumtime=serviceToutil.getMediaPlayer().getDuration();//获取音乐时长
                setBtnBg(true);
                isplay=true;
                 seekBar.setEnabled(true);//可拖到
                 seekBar.setMax(sumtime);//设置最大值
                sumTimeview.setText(PlayerModel.getTime(sumtime));
            }
        });

    }

    public void setBtnBg(boolean is){
        if (is){
            //playbtn.setBackgroundResource(R.mipmap.ic_paus_ms);
             mpbtn.setImageResource(R.mipmap.icon_paus_ms);
        }else {
            //playbtn.setBackgroundResource(R.mipmap.icon_play_ms);
            mpbtn.setImageResource(R.mipmap.play_play10);
        }
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.anim_start_activity,R.anim.anim_out_activity);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ServiceToutil.getInstance().setPlayerIngListener(null);
        handler.removeCallbacksAndMessages(null);
    }
}
