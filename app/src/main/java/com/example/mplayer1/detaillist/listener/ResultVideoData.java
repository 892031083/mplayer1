package com.example.mplayer1.detaillist.listener;

import com.google.gson.annotations.Expose;

import java.util.List;

public class ResultVideoData {

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

    public class Data{
         @Expose
         private int count;
         @Expose
         private int page;
         @Expose
         private List<ResultVideos> videos;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public List<ResultVideos> getVideos() {
            return videos;
        }

        public void setVideos(List<ResultVideos> videos) {
            this.videos = videos;
        }
    }

    @Override
    public String toString() {
        return "ResultVideoData{" +
                "status=" + status +
                ", statusText='" + statusText + '\'' +
                ", data=" + data +
                '}';
    }
}
