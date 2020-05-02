package com.example.mplayer1.detaillist.bean;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.mplayer1.AppManager;

public class Album implements Parcelable {
    private String AlubmId;//专辑ID
    private int videoTotal;//集数
    private String title;//专辑名称
    private String subTitle;//专辑子标题
    private String director;//导演
    private String mainActor;//主演
    private String verImageUrl;//专辑竖图
    private String horImageUrl;//专辑横图
    private Site site;//网站
    private String tip;//提示
    private boolean isCompleted;//专辑是否更新完
    private String letyStyle;//乐视特殊 字段


    public static final Parcelable.Creator<Album> CREATOR = new Creator<Album>() {
        @Override
        public Album createFromParcel(Parcel source) {
            return new Album(source);
        }

        @Override
        public Album[] newArray(int size) {
            return new Album[size];
        }
    };

    @Override
    public String toString() {
        return "Album{" +
                "AlubmId='" + AlubmId + '\'' +
                ", videoTotal=" + videoTotal +
                ", title='" + title + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", director='" + director + '\'' +
                ", mainActor='" + mainActor + '\'' +
                ", verImageUrl='" + verImageUrl + '\'' +
                ", horImageUrl='" + horImageUrl + '\'' +
                ", site=" + site +
                ", tip='" + tip + '\'' +
                ", isCompleted=" + isCompleted +
                ", letyStyle='" + letyStyle + '\'' +
                '}';
    }

    public Album(int siteId, Context context){
            site=new Site(siteId,context);
    }

    public Album(Parcel in) {
        AlubmId = in.readString();
        videoTotal = in.readInt();
        title = in.readString();
        subTitle = in.readString();
        director = in.readString();
        mainActor = in.readString();
        verImageUrl = in.readString();
        horImageUrl = in.readString();

        tip = in.readString();
        isCompleted = in.readByte() != 0;
        letyStyle = in.readString();
    }

    public static final Creator<Album> CREA= new Creator<Album>() {
        @Override
        public Album createFromParcel(Parcel in) {
            return new Album(in);
        }

        @Override
        public Album[] newArray(int size) {
            return new Album[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(AlubmId);
        dest.writeInt(videoTotal);
        dest.writeString(title);
        dest.writeString(subTitle);
        dest.writeString(director);
        dest.writeString(mainActor);
        dest.writeString(verImageUrl);
        dest.writeString(horImageUrl);
//        dest.writeInt(site);
        dest.writeString(tip);
        dest.writeByte((byte) (isCompleted ? 1 : 0));
        dest.writeString(letyStyle);
    }

    public String getAlubmId() {
        return AlubmId;
    }

    public void setAlubmId(String alubmId) {
        AlubmId = alubmId;
    }

    public int getVideoTotal() {
        return videoTotal;
    }

    public void setVideoTotal(int videoTotal) {
        this.videoTotal = videoTotal;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getMainActor() {
        return mainActor;
    }

    public void setMainActor(String mainActor) {
        this.mainActor = mainActor;
    }

    public String getVerImageUrl() {
        return verImageUrl;
    }

    public void setVerImageUrl(String verImageUrl) {
        this.verImageUrl = verImageUrl;
    }

    public String getHorImageUrl() {
        return horImageUrl;
    }

    public void setHorImageUrl(String horImageUrl) {
        this.horImageUrl = horImageUrl;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getLetyStyle() {
        return letyStyle;
    }

    public void setLetyStyle(String letyStyle) {
        this.letyStyle = letyStyle;
    }

    public static Creator<Album> getCREATOR() {
        return CREATOR;
    }

    public String toJSON(){
        String ret= AppManager.getGson().toJson(this);

        return ret;
    }

    public Album fromJSON(String json){
        Album alubm=AppManager.getGson().fromJson(json, Album.class);
        return alubm;
    }
}
