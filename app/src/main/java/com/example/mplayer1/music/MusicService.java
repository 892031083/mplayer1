package com.example.mplayer1.music;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.example.mplayer1.AppManager;
import com.example.mplayer1.music.beaninfo.ScreenBroadcastReceiver;

import java.io.IOException;

public class MusicService extends Service {

    private ServiceToutil serviceToutil;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }
    public class MyBinder extends Binder {
        MusicService getService() {
            return MusicService.this;
        }
    }

    @Override
    public void onCreate() {
        serviceToutil=ServiceToutil.getInstance();
        super.onCreate();
        ScreenBroadcastReceiver receiver=new ScreenBroadcastReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.addAction(Intent.ACTION_USER_PRESENT);
        AppManager.getContext().registerReceiver(receiver, filter);
    }

    @Override
    public void onDestroy() {
        serviceToutil.stop();
        super.onDestroy();
    }
}
