package com.example.mplayer1.detaillist.listener;

import com.google.gson.annotations.Expose;

public class ResultItemData  {
    @Expose
    private long status;
    @Expose
    private String statusText;
    @Expose
    private ResultAlubmData data;

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

    public ResultAlubmData getData() {
        return data;
    }

    public void setData(ResultAlubmData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultItemData{" +
                "status=" + status +
                ", statusText='" + statusText + '\'' +
                ", data=" + data +
                '}';
    }
}
