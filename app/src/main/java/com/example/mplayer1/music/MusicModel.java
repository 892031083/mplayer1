package com.example.mplayer1.music;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mplayer1.detaillist.api.SiteApi;
import com.example.mplayer1.detaillist.listener.ErrorInfo;
import com.example.mplayer1.detaillist.listener.OnGetChannelAbnumListener;
import com.example.mplayer1.detaillist.listener.ResultAlubm;
import com.example.mplayer1.home.bean.Channel;

import java.util.ArrayList;
import java.util.List;


public class MusicModel extends ViewModel {

    public static final int DOING_CREATE=1001;//初始加载
    public static final int DOING_LOAD=1002;//加载更多
    public static final int DOING_RESH=1003;//刷新
    //数据
    protected MutableLiveData<List<ResultAlubm>> mutableLiveData;
    List<ResultAlubm> list;
    public int doings=0;

    SiteApi siteApi;

    private int pageOn=0;

    public MusicModel(){
        mutableLiveData=new MutableLiveData<>();
        list=new ArrayList<>();
        siteApi=new SiteApi();
    }

    public void getResource(int pageOn,int pagesize,Channel channel,int GetType) {
        //TODO test
        GetData( pageOn, pagesize, channel, GetType);
    }

    public int getDoings() {
        return doings;
    }

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            doings=msg.what;
            updateMutableLiveDate();
        }
    };

    public void updateMutableLiveDate(){
        mutableLiveData.setValue(list);
        Log.d("Mude",list.size()+"");
       // mutableLiveData.
    }

    public MutableLiveData<List<ResultAlubm>> getMutableLiveData() {
        return mutableLiveData;
    }

    public void setMutableLiveData(MutableLiveData<List<ResultAlubm>> mutableLiveData) {
        this.mutableLiveData = mutableLiveData;
    }



    private void GetData(int pageOn, int pagesize, Channel channel, final int GetType){//去请求

        siteApi.onGetChannelAlbums(pageOn, pagesize, channel, new OnGetChannelAbnumListener() {
            @Override
            public void OnGetChannelAbnumSuccess(List<ResultAlubm> alubms) {//成功时
                if (alubms!=null&&alubms.size()>0){
                    if (GetType== MusicModel.DOING_LOAD){
                        list.addAll(alubms);
                    }else {
                        list = alubms;
                    }
                    handler.sendEmptyMessage(GetType);
                }

            }

            @Override
            public void OnGetChannelAbnumFailed(ErrorInfo info) {

            }
        });
    }
}
