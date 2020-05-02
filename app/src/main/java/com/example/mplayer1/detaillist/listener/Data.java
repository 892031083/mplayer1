package com.example.mplayer1.detaillist.listener;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
    @Expose
    private int count;
    @Expose
    private boolean isClassific;


    @SerializedName("videos")
    @Expose
    private List<ResultAlubm> alubms;



    public boolean isClassific() {
        return isClassific;
    }

    public void setClassific(boolean classific) {
        isClassific = classific;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<ResultAlubm> getAlubms() {
        return alubms;
    }

    public void setAlubms(List<ResultAlubm> alubms) {
        this.alubms = alubms;
    }

    @Override
    public String toString() {
        String str= "Data{" +
                "count=" + count +
                ", isClassific=" + isClassific +
                ", alubms=" +
                '}';
        if (alubms!=null){
            for (int i=0;i<alubms.size();i++){
                str+=alubms.get(i).toString();
            }
        }


        return str;
    }
}
