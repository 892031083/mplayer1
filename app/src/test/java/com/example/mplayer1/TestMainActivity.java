package com.example.mplayer1;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mplayer1.util.MyIjkMediaPlayer;

import java.io.IOException;

import tv.danmaku.ijk.media.player.IMediaPlayer;

public class TestMainActivity  extends AppCompatActivity {
    IMediaPlayer mIMediaPlayer=null;
    MyIjkMediaPlayer mPlayer;

    SurfaceView mSurfaceView;
    TextView mView;

    boolean hasStarted = false;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_main_test);
        initView();
    }

    SurfaceHolder.Callback surfaceCallback = new SurfaceHolder.Callback() {
        @Override
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            try {
                mPlayer.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

        }

        @Override
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (mSurfaceView != null) {
                mSurfaceView.getHolder().removeCallback(surfaceCallback);
                mSurfaceView = null;
            }

        }
    };


    protected void initView() {


        mPlayer = new MyIjkMediaPlayer(this);

        mSurfaceView = findViewById(R.id.sur);
        mSurfaceView.getHolder().addCallback(surfaceCallback);
        mPlayer.init(mSurfaceView);
        // mPlayer.setPath("rtmp://220.248.34.75:1935/live/camera_2");
        mPlayer.setPath("rtmp://58.200.131.2:1935/livetv/hunantv");

        mView = findViewById(R.id.tv);
        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("MyIjkMediaPlayer", "onClick: hasStarted-"+hasStarted);
                if (!hasStarted) {
                    mPlayer.start();
                    hasStarted = true;
                    mView.setText("pause");
                } else {
                    mPlayer.pause();
                    mView.setText("start");
                    hasStarted = false;
                }

            }
        });
    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPlayer.release();
    }
}
