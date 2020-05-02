package com.example.mplayer1.home.navfrag;

import android.os.Handler;
import android.os.Message;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mplayer1.detaillist.api.SiteApi;
import com.example.mplayer1.detaillist.bean.Site;

import java.util.List;

public class HomeViewModel extends ViewModel {
    //数据
    protected MutableLiveData<List<String[]>> mutableLiveData;
    private SiteApi siteApi;

    Handler handle=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    private void getLoopImgData(){
        //siteApi.onGetChannelAlbums();
    }

    public HomeViewModel(){
        mutableLiveData=new MutableLiveData<>();
    }

    public MutableLiveData<List<String[]>> getMutableLiveData() {
        return mutableLiveData;
    }

    public void setMutableLiveData(MutableLiveData<List<String[]>> mutableLiveData) {
        this.mutableLiveData = mutableLiveData;
    }
}
