package com.example.mplayer1.detaillist.listener;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * 真正的搜狐数据结构
 */
public class ResultAlubm {
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

    @SerializedName("main_actor")
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
