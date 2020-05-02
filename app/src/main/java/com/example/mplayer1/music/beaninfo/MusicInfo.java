package com.example.mplayer1.music.beaninfo;

import java.io.Serializable;

public class MusicInfo implements Serializable {

    private  int _id = - 1;       //音乐标识码
    private  int duration = -1 ;   //音乐时常
    private String artist = null ;    //音乐作者
    private String musicName= null ; //音乐名字
    private String album = null ;   //音乐文件专辑
    private String title = null ;  //音乐文件标题
    private int size  ;   //音乐文件的大小  返回byte大小
    private String data ;  //获取文件的完整路径
    private String album_id ; //实际存储为音乐专辑

    public MusicInfo(int _id, String artist) {
        this._id = _id;
        this.artist = artist;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(String album_id) {
        this.album_id = album_id;
    }

    public MusicInfo(int _id, int duration, String artist, String musicName, String album, String title, int size, String data, String album_id) {
        this._id = _id;
        this.duration = duration;
        this.artist = artist;
        this.musicName = musicName;
        this.album = album;
        this.title = title;
        this.size = size;
        this.data = data;
        this.album_id = album_id;
    }
}
