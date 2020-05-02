package com.example.mplayer1.detaillist.listener;

import com.google.gson.annotations.Expose;

public class Result {
    @Expose
    private long status;
    @Expose
    private String statusText;
    @Expose
    private Data data;

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "status=" + status +
                ", statusText='" + statusText + '\'' +
                ", data=" + data.toString() +
                '}';
    }
}
