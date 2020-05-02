package com.example.mplayer1.recom;

import android.os.Handler;
import android.os.Message;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class RecomViewModel extends ViewModel {
    MutableLiveData<List<ChenrBean>> mutableLiveData;
    List<ChenrBean> list;

    public RecomViewModel() {
        mutableLiveData=new MutableLiveData<>();
        list=new ArrayList<>();
    }

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };




    public MutableLiveData<List<ChenrBean>> getMutableLiveData() {
        return mutableLiveData;
    }

    public void setMutableLiveData(MutableLiveData<List<ChenrBean>> mutableLiveData) {
        this.mutableLiveData = mutableLiveData;
    }
}
