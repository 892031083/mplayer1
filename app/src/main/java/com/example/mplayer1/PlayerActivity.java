package com.example.mplayer1;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSeekBar;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;

import android.graphics.PointF;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.mplayer1.widget.media.AndroidMediaController;
import com.example.mplayer1.widget.media.IjkVideoView;

import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;

public class PlayerActivity extends AppCompatActivity implements View.OnClickListener {

    private IjkVideoView mIjkVideoView;
    AndroidMediaController mediaController;
    private static final String  TAG = "PlayerActivity";
    private boolean isLive=false;//是否是直播
    private boolean isGonePro=false;//是否隐藏进度条模块的VIEW
    private int PlayerWdith;
    private int PlayerHeight;
    private String playUrl;
    private int PlayStatus=0;//播放状态 0 1 2  1播放中 0加载中 2暂停 3失败 4完毕
    private RelativeLayout playHeader;//视频模块的布局
    private RelativeLayout playbottom;//视频底部的布局
    private RelativeLayout play_bottom_layout;//播放地步
    private LinearLayout playloading;//加载的view

    private Button playStartOrPauseBtn;//播放暂停
    private Button ScreenPlayBtn;//全屏按钮

    private AppCompatSeekBar progressBar;
    private TextView playTimeView;//当前播放的时间
    private TextView playSumView;//总时间
    // IjkMediaPlayer ijkMediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        initDate();
        initView();
    }

    private void initDate() {
//        Display defaultDisplay = getWindowManager().getDefaultDisplay();
//        Point point = new Point();
//        defaultDisplay.getSize(point);
//        int ScreenWidth = point.x;
//        int ScreenHeight = point.y;
//
//        PlayerWdith=ScreenWidth;
//        PlayerHeight=PlayerWdith/(ScreenHeight/ScreenWidth);
        //Log.i(TAG, "x = " + x + ",y = " + y);
        playUrl=getIntent().getStringExtra("playurl");
        isLive=getIntent().getBooleanExtra("isLive",false);
        Log.e("APISsS",playUrl);
        progressBar= findViewById(R.id.play_seekbar);
        if (isLive){
            progressBar.setVisibility(View.GONE);//隐藏进度条
        }
//        Log.d("pPPPPPP",playUrl);
    }



    private void initView(){
        //        mIjkVideoView.showMediaInfo();

        playHeader=findViewById(R.id.playhead);
        playbottom=findViewById(R.id.playbottom);
        playHeader.setOnClickListener(this);
        playStartOrPauseBtn=findViewById(R.id.play_sp);
        ScreenPlayBtn=findViewById(R.id.play_screen);
        playStartOrPauseBtn.setOnClickListener(this);
        ScreenPlayBtn.setOnClickListener(this);
        play_bottom_layout=findViewById(R.id.bottom_layout);//视频底部进度条等等
        playloading=findViewById(R.id.playloading);
        playTimeView=findViewById(R.id.playTime);
        playSumView=findViewById(R.id.playsumtime);
        mIjkVideoView=findViewById(R.id.ijk);
        mIjkVideoView.setIszb(isLive);
        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");
        mIjkVideoView.setHudView((TableLayout) findViewById(R.id.table));
        //http://vjs.zencdn.net/v/oceans.mp4
        //rtmp://58.200.131.2:1935/livetv/hunantv
        //mIjkVideoView.setOnClickListener(this);
        //mIjkVideoView.setVideoURI(Uri.parse("http://vfx.mtime.cn/Video/2019/03/19/mp4/190319104618910544.mp4"));

        mIjkVideoView.setVideoURI(Uri.parse(playUrl));

        mIjkVideoView.setOnPreparedListener(new IMediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(IMediaPlayer mp) {

                mIjkVideoView.start();
                Log.e("*****************",mIjkVideoView.getDuration()+"");
                if (!isLive) {
                    initProgress(mIjkVideoView.getDuration());
                }
            }
        });

        mIjkVideoView.setOnInfoListener(new IMediaPlayer.OnInfoListener() {//播放状态监听
            @Override
            public boolean onInfo(IMediaPlayer mp, int what, int extra) {

                switch (what) {
                    case IMediaPlayer.MEDIA_INFO_VIDEO_TRACK_LAGGING:
                         Log.d(TAG+"====", "MEDIA_INFO_VIDEO_TRACK_LAGGING:");
                        break;
                    case IMediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START:
                        loadOk();
                        Log.d(TAG+"====", "MEDIA_INFO_VIDEO_RENDERING_START:");
                        break;
                    case IMediaPlayer.MEDIA_INFO_BUFFERING_START://加载
                        playloading.setVisibility(View.VISIBLE);
                        //PlayStatus=0;
                        isLoadProgress=false;
                        Log.d(TAG+"====", "MEDIA_INFO_BUFFERING_START:");
                        break;
                    case IMediaPlayer.MEDIA_INFO_BUFFERING_END://加载完成
                        playloading.setVisibility(View.GONE);
                        //PlayStatus=1;
                        if (PlayStatus==1){//播放状态为正在播放时可以自动加载进度条
                            isLoadProgress=true;
                        }
                        Log.d(TAG+"====", "MEDIA_INFO_BUFFERING_END:");
                        break;
                    case IMediaPlayer.MEDIA_INFO_NETWORK_BANDWIDTH:
                        Log.d(TAG+"====", "MEDIA_INFO_NETWORK_BANDWIDTH: " );
                        break;
                    case IMediaPlayer.MEDIA_INFO_BAD_INTERLEAVING:
                        Log.d(TAG+"====", "MEDIA_INFO_BAD_INTERLEAVING:");
                        break;
                    case IMediaPlayer.MEDIA_INFO_NOT_SEEKABLE:
                        Log.d(TAG+"====", "MEDIA_INFO_NOT_SEEKABLE:");
                        break;
                    case IMediaPlayer.MEDIA_INFO_METADATA_UPDATE:
                        Log.d(TAG+"====", "MEDIA_INFO_METADATA_UPDATE:");
                        break;
                    case IMediaPlayer.MEDIA_INFO_UNSUPPORTED_SUBTITLE:
                        Log.d(TAG+"====", "MEDIA_INFO_UNSUPPORTED_SUBTITLE:");
                        break;
                    case IMediaPlayer.MEDIA_INFO_SUBTITLE_TIMED_OUT:
                        Log.d(TAG+"====", "MEDIA_INFO_SUBTITLE_TIMED_OUT:");
                        break;
                    case IMediaPlayer.MEDIA_INFO_VIDEO_ROTATION_CHANGED:
                        // mVideoRotationDegree = arg2;

                        break;
                    case IMediaPlayer.MEDIA_INFO_AUDIO_RENDERING_START:
                        Log.d(TAG+"====", "MEDIA_INFO_AUDIO_RENDERING_START:");
                        break;
                }
                return false;
            }
        });

    }
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (isLoadProgress){

//                playTimeView.setBase(playTimeView.getBase()+1);
                progressBar.setProgress(progressBar.getProgress()+1000);
                playTimeView.setText(PlayerModel.getTime(progressBar.getProgress()));
            }

        }
    };

    private boolean isPro=false;//用户是否在操作进度条
    private boolean isLoadProgress=true;//是否允许加载进度条
    private TextView jindutext;
    private PointF pointF;
    private void initProgress(long max) {//设置进度条
        //playTimeView.set;
        progressBar.setMax((int) max);
        //playTimeView.setText();
        jindutext=findViewById(R.id.jindutext);//滑动时显示的时间text
        pointF=new PointF();//定义一个点
        playSumView.setText(PlayerModel.getTime(max));
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
                handler.postDelayed(this,1000);
            }
        },0);

        progressBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            //当拖动条发生变化时调用该方法
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (isPro){
                    mIjkVideoView.seekTo(progress);
                    playTimeView.setText(PlayerModel.getTime(progressBar.getProgress()));
                    Log.e("**","sss");
                   // playTimeView.setBase(progress/1000);
                }
            }

            @Override //当用户开始滑动滑块时调用该方法（即按下鼠调用一次）
            public void onStartTrackingTouch(SeekBar seekBar) {
                isPro=true;
            }

            @Override//当用户结束对滑块滑动时,调用该方法（即松开鼠标）
            public void onStopTrackingTouch(SeekBar seekBar) {
                mIjkVideoView.seekTo(progressBar.getProgress());
                playTimeView.setText(PlayerModel.getTime(progressBar.getProgress()));
                isPro=false;
            }
        });

        mIjkVideoView.setOnTouchListener(new View.OnTouchListener() {
            long thistime;//开始时间
            long loadtime;//加载的时间 = x移动的像素/10
            long startTime;//按下时的时间 毫秒
            long upTime;//松开时的时间 毫秒  //按下的时间小于100毫秒是为点击事件
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Log.i("========",event.getY()+":"+play_bottom_layout.getY());
                if (event.getY()>=play_bottom_layout.getY()){
                    return false;
                }
                switch (event.getAction() & MotionEvent.ACTION_MASK){
                    case MotionEvent.ACTION_DOWN://手指落下
                        pointF.set(event.getX(),event.getY());//保存初始点
                        thistime=progressBar.getProgress();
                        Log.i("========","KKK");
                        startTime=System.currentTimeMillis();

                        break;
                    case MotionEvent.ACTION_MOVE://移动
                        upTime=System.currentTimeMillis();
                        if (upTime-startTime>200){
                            jindutext.setVisibility(View.VISIBLE);//时间进度的文本
                            float dx=event.getX()-pointF.x;//X轴移动的距离
                            loadtime= (long) (dx/10*1000);//需要跳转的时间（毫秒）
                            String str=PlayerModel.getTime(thistime+loadtime)+"/"
                                    +PlayerModel.getTime(progressBar.getMax());
                            jindutext.setText(str);
                           // Log.e("OOOOOOOOOO",(int)dx+"");
                          //  mIjkVideoView.seekTo((int) (startTime+loadtime));
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        upTime=System.currentTimeMillis();
                        if (upTime-startTime>200) {
                            progressBar.setProgress((int) (thistime + loadtime));
                            playTimeView.setText(PlayerModel.getTime(progressBar.getProgress()));
                            jindutext.setVisibility(View.GONE);
                            Log.e("OOOOOOOOOO",progressBar.getProgress()+":seekto");
                            mIjkVideoView.seekTo(progressBar.getProgress());
                        }else{//视为点击
                            toBottomBtnChange(!isGonePro);
                        }
                        break;
                }
                return true;
            }

        });
    }



    private void loadOk(){
        PlayStatus=1;
        playStartOrPauseBtn.setBackgroundResource(R.mipmap.play_pasue5);
        toBottomBtnChange(true);
        playloading.setVisibility(View.GONE);
    }

    private void toBottomBtnChange(boolean b){//是否隐藏
        if (b){
            play_bottom_layout.setVisibility(View.GONE);
        }else{
            play_bottom_layout.setVisibility(View.VISIBLE);
        }
        isGonePro=b;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.play_sp:
                setStartOrPasue();
                break;
            case R.id.play_screen:
                setLandscapeOrPortrait();
                break;
            case R.id.playhead:
               toBottomBtnChange(!isGonePro);
                break;
        }
    }

    private void setStartOrPasue() {
        Log.e(TAG,PlayStatus+"");
        if (PlayStatus==0){//未播放
            isLoadProgress=false;
        }else if (PlayStatus==1){//正在播放时
            mIjkVideoView.pause();
            PlayStatus=2;
            isLoadProgress=false;
            playStartOrPauseBtn.setBackgroundResource(R.mipmap.play_play3);
        }else if (PlayStatus==2){
            mIjkVideoView.start();
            PlayStatus=1;
            isLoadProgress=true;
            playStartOrPauseBtn.setBackgroundResource(R.mipmap.play_pasue5);
        }
    }

    private void setLandscapeOrPortrait() {
        if(getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            //切换竖屏
            RelativeLayout.LayoutParams layoutParams= (RelativeLayout.LayoutParams) playHeader.getLayoutParams();
            layoutParams.height=((int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200, getResources().getDisplayMetrics()));
            PlayerActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            //更换图标
            ScreenPlayBtn.setBackgroundResource(R.mipmap.play_screen);
        }else{
            //切换横屏
            //RelativeLayout.LayoutParams layoutParams= (RelativeLayout.LayoutParams) playHeader.getLayoutParams();
            playHeader.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            PlayerActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            //更换图标
            ScreenPlayBtn.setBackgroundResource(R.mipmap.play_screenout);
        }



    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }

    }

    @Override
    public void onBackPressed() {
        if (getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            setLandscapeOrPortrait();//设置横竖屏

        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        int orientation = newConfig.orientation;

        //切换竖屏
//            MainActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//            MainActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//
        if (orientation == ORIENTATION_LANDSCAPE){
            Log.i("Mmmmmm", "-------------横屏-------------");
        }else {
            Log.i("Mmmmmm", "-------------竖屏-------------");
        }
        Log.i("Mmmmmm", "onConfigurationChanged: "+orientation);
    }


    @Override
    protected void onRestart() {
        mIjkVideoView.start();
        PlayStatus=1;
        super.onRestart();
    }

    @Override
    protected void onPause() {
        if (mIjkVideoView!=null){
            mIjkVideoView.pause();
            PlayStatus=2;
        }
        super.onPause();
    }

    @Override
    protected void onStop() {
        if (mIjkVideoView!=null){
            mIjkVideoView.stopPlayback();

        }
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        if (mIjkVideoView!=null){
            mIjkVideoView.stopBackgroundPlay();
        }
        super.onDestroy();
    }


}
