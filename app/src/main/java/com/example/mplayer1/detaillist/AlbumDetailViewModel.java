package com.example.mplayer1.detaillist;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mplayer1.detaillist.api.SiteApi;
import com.example.mplayer1.detaillist.listener.OnGetAlbumInfoListener;
import com.example.mplayer1.detaillist.listener.OnGetPlayerUrlListener;
import com.example.mplayer1.detaillist.listener.OnGetVideosListener;
import com.example.mplayer1.detaillist.listener.ResultAlubmData;
import com.example.mplayer1.detaillist.listener.ResultVideos;

import java.util.ArrayList;
import java.util.List;

public class AlbumDetailViewModel extends ViewModel {

    private MutableLiveData<ResultAlubmData> mutableLiveData;
    SiteApi siteApi;
    ResultAlubmData mresultAlubmData;

    private MutableLiveData<List<ResultVideos>> mutablelist;
    List<ResultVideos> mListVideos;
    String playurlstr="";
    private MutableLiveData<String> playurl;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1://专辑信息
                    mutableLiveData.setValue(mresultAlubmData);
                    break;
                case 2://视频列表
                    mutablelist.setValue(mListVideos);
                    break;
                case 3:
                    playurl.setValue(playurlstr);
                    break;
            }

        }
    };

    public void getResource(long AlbumId){//获取专辑数据
        siteApi.onGetAlbumInfo(AlbumId, new OnGetAlbumInfoListener() {
            @Override
            public void success(ResultAlubmData resultAlubmData) {
                Log.e("*****************","*****************");
                if (resultAlubmData!=null){
                    mresultAlubmData=resultAlubmData;
                    handler.sendEmptyMessage(1);
                }

            }
        });
    }

    public void getVideoRes(long albumId, int pageOn, int pageSize){//获取视频列表
        siteApi.onGetVideos(albumId, pageOn, pageSize, new OnGetVideosListener() {
            @Override
            public void Onsuccess(List<ResultVideos> listResultVideos) {
                if (listResultVideos!=null&&listResultVideos.size()>0){
                    mListVideos=listResultVideos;
                    handler.sendEmptyMessage(2);
                    Log.e("88888888888888","===============");
                }
            }
            @Override
            public void onError() {

            }
        });
    }


    public void getVideoPlayerUrl(long aid,long vid){
        siteApi.onGetPlayerUrl(vid, aid, new OnGetPlayerUrlListener() {
            @Override
            public void OnSuccess(String url) {
                playurlstr=url;
                Log.e("kkkkkkkk",url);
                handler.sendEmptyMessage(3);
            }
        });
    }



    public AlbumDetailViewModel(){
        mutableLiveData=new MutableLiveData<>();
        mutablelist=new MutableLiveData<>();
        siteApi=new SiteApi();
        mListVideos=new ArrayList<>();
        playurl=new MutableLiveData<>();
    }

    public MutableLiveData<ResultAlubmData> getMutableLiveData() {
        return mutableLiveData;
    }

    public void setMutableLiveData(MutableLiveData<ResultAlubmData> mutableLiveData) {
        this.mutableLiveData = mutableLiveData;
    }


    public MutableLiveData<List<ResultVideos>> getMutablelist() {
        return mutablelist;
    }

    public void setMutablelist(MutableLiveData<List<ResultVideos>> mutablelist) {
        this.mutablelist = mutablelist;
    }

    public MutableLiveData<String> getPlayurl() {
        return playurl;
    }

    public void setPlayurl(MutableLiveData<String> playurl) {
        this.playurl = playurl;
    }
}
