package com.example.mplayer1.detaillist.listener;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultAlubmData {
    @SerializedName("album_desc")//表示jion对应的字段
    @Expose
    private String tvDesc;

    @Expose
    private String director;//导演

    @SerializedName("hor_high_pic")
    @Expose
    private String horHighPic;//横图

    @SerializedName("ver_high_pic")
    @Expose
    private String verHighPic;//试图

    @SerializedName("actor")
    @Expose
    private String mainActor;//主演

    @SerializedName("album_name")
    @Expose
    private String albumName;//专辑名称

    @SerializedName("aid")
    @Expose
    private long albumId;
    @Expose
    private String tip;
    @Expose
    private double score;
    @Expose
    private long cid;

    @Expose
    private int total_video_count;//总集数
    @Expose
    private int latest_video_count;//已经更新的级数

    @Expose
    private String updateNotification;

    public String getUpdateNotification() {
        return updateNotification;
    }

    public void setUpdateNotification(String updateNotification) {
        this.updateNotification = updateNotification;
    }

    public int getTotal_video_count() {
        return total_video_count;
    }

    public void setTotal_video_count(int total_video_count) {
        this.total_video_count = total_video_count;
    }

    public int getLatest_video_count() {
        return latest_video_count;
    }

    public void setLatest_video_count(int latest_video_count) {
        this.latest_video_count = latest_video_count;
    }



    public long getCid() {
        return cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
    }




    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getTvDesc() {
        return tvDesc;
    }

    public void setTvDesc(String tvDesc) {
        this.tvDesc = tvDesc;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getHorHighPic() {
        return horHighPic;
    }

    public void setHorHighPic(String horHighPic) {
        this.horHighPic = horHighPic;
    }

    public String getVerHighPic() {
        return verHighPic;
    }

    public void setVerHighPic(String verHighPic) {
        this.verHighPic = verHighPic;
    }

    public String getMainActor() {
        return mainActor;
    }

    public void setMainActor(String mainActor) {
        this.mainActor = mainActor;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }

    @Override
    public String toString() {
        return "ResultAlubm{" +
                "tvDesc='" + tvDesc + '\'' +
                ", director='" + director + '\'' +
                ", horHighPic='" + horHighPic + '\'' +
                ", verHighPic='" + verHighPic + '\'' +
                ", mainActor='" + mainActor + '\'' +
                ", albumName='" + albumName + '\'' +
                ", albumId='" + albumId + '\'' +
                ", tip='" + tip + '\'' +
                '}';
    }
}
