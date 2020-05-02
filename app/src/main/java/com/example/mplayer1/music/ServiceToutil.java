package com.example.mplayer1.music;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.net.Uri;

import java.io.IOException;

public class ServiceToutil{
    private MediaPlayer mediaPlayer;
    private static ServiceToutil serviceToutil;
    private ServiceToutil(){
        mediaPlayer=new MediaPlayer();
    }
    public static ServiceToutil getInstance(){
        if (serviceToutil==null){
            synchronized (ServiceToutil.class){
                if (serviceToutil==null){
                    serviceToutil=new ServiceToutil();
                }
            }
        }
        return serviceToutil;
    }

    public void setPlayerPross(int pross){
        if (mediaPlayer!=null){
            mediaPlayer.seekTo(pross);
        }
    }
    public ServiceToutil setPlayResource(Context context,int resid){
        if (mediaPlayer!=null){
            mediaPlayer.reset();
            mediaPlayer=mediaPlayer.create(context,resid);
        }
        return serviceToutil;
    }
    public ServiceToutil setPlayUrl(String url){
        if (mediaPlayer!=null){
            try {
                mediaPlayer.reset();
                mediaPlayer.setDataSource(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return serviceToutil;
    }
    public void setPlayFile(Uri uri, Context context){
        if (mediaPlayer!=null){
            mediaPlayer.reset();
            try {
                mediaPlayer.setDataSource(context,uri);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void play(){
        if (mediaPlayer!=null){
//            mediaPlayer.start();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mediaPlayer.start();
                }
            });
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mediaPlayer.start();
                    if (playerIngListener!=null){//已经开始播放监听
                        playerIngListener.OnPlaying();
                    }
                }
            });
        }
    }

    public void pasue(){
        if (mediaPlayer!=null){
            mediaPlayer.pause();
        }
    }
    public void stop() {
        if (mediaPlayer!=null){
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }
    private PlayerIngListener playerIngListener;

    public PlayerIngListener getPlayerIngListener() {
        return playerIngListener;
    }

    public void setPlayerIngListener(PlayerIngListener playerIngListener) {
        this.playerIngListener = playerIngListener;
    }

    interface PlayerIngListener{
        void OnPlaying();
    }
}
