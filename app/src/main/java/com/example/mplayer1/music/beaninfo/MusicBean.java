package com.example.mplayer1.music.beaninfo;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MusicBean implements Serializable {
        private String playurl;
        private String name;
        private  String imgurl;
        private MusicInfo musicInfo;

    public MusicInfo getMusicInfo() {
        return musicInfo;
    }

    public void setMusicInfo(MusicInfo musicInfo) {
        this.musicInfo = musicInfo;
    }

    public MusicBean(String playurl, String name, String imgurl) {
        this.playurl = playurl;
        this.name = name;
        this.imgurl = imgurl;
    }

    public String getPlayurl() {
        return playurl;
    }

    public void setPlayurl(String playurl) {
        this.playurl = playurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public MusicBean(String playurl, String name, String imgurl, MusicInfo musicInfo) {
        this.playurl = playurl;
        this.name = name;
        this.imgurl = imgurl;
        this.musicInfo = musicInfo;
    }

    public static List<MusicBean> getMusicList(){
        List<MusicBean> list=new ArrayList<>();
        list.add(new MusicBean("http://m10.music.126.net/20200328005602/4d4bd56787ad8fa57cc9856deddfeac0/ymusic/515e/550f/035c/f4a246e4dcbea38e608c46cf8a1413a1.mp3",
                                        "Panama ","",new MusicInfo(0,"Panama")));

        list.add(new MusicBean("http://m10.music.126.net/20200328014112/b95ae4370d831356d8543e5dedd829ee/ymusic/4c4a/c092/b004/8f997fb80dfd6f649563983365ecba9f.mp3",
                "Beautiful Now ","",new MusicInfo(0,"Zedd&Jon Bellion")));

        list.add(new MusicBean("http://m10.music.126.net/20200328014112/b95ae4370d831356d8543e5dedd829ee/ymusic/4c4a/c092/b004/8f997fb80dfd6f649563983365ecba9f.mp3",
                "Beautiful Now ","",new MusicInfo(0,"Zedd&Jon Bellion")));
        list.add(new MusicBean("http://m10.music.126.net/20200328014112/b95ae4370d831356d8543e5dedd829ee/ymusic/4c4a/c092/b004/8f997fb80dfd6f649563983365ecba9f.mp3",
                "Beautiful Now ","",new MusicInfo(0,"Zedd&Jon Bellion")));
        list.add(new MusicBean("http://m10.music.126.net/20200328014112/b95ae4370d831356d8543e5dedd829ee/ymusic/4c4a/c092/b004/8f997fb80dfd6f649563983365ecba9f.mp3",
                "Beautiful Now ","",new MusicInfo(0,"Zedd&Jon Bellion"))); list.add(new MusicBean("http://m10.music.126.net/20200328014112/b95ae4370d831356d8543e5dedd829ee/ymusic/4c4a/c092/b004/8f997fb80dfd6f649563983365ecba9f.mp3",
                "Beautiful Now ","",new MusicInfo(0,"Zedd&Jon Bellion"))); list.add(new MusicBean("http://m10.music.126.net/20200328014112/b95ae4370d831356d8543e5dedd829ee/ymusic/4c4a/c092/b004/8f997fb80dfd6f649563983365ecba9f.mp3",
                "Beautiful Now ","",new MusicInfo(0,"Zedd&Jon Bellion")));
        list.add(new MusicBean("http://m10.music.126.net/20200328014112/b95ae4370d831356d8543e5dedd829ee/ymusic/4c4a/c092/b004/8f997fb80dfd6f649563983365ecba9f.mp3",
                "Beautiful Now ","",new MusicInfo(0,"Zedd&Jon Bellion"))); list.add(new MusicBean("http://m10.music.126.net/20200328014112/b95ae4370d831356d8543e5dedd829ee/ymusic/4c4a/c092/b004/8f997fb80dfd6f649563983365ecba9f.mp3",
                "Beautiful Now ","",new MusicInfo(0,"Zedd&Jon Bellion"))); list.add(new MusicBean("http://m10.music.126.net/20200328014112/b95ae4370d831356d8543e5dedd829ee/ymusic/4c4a/c092/b004/8f997fb80dfd6f649563983365ecba9f.mp3",
                "Beautiful Now ","",new MusicInfo(0,"Zedd&Jon Bellion"))); list.add(new MusicBean("http://m10.music.126.net/20200328014112/b95ae4370d831356d8543e5dedd829ee/ymusic/4c4a/c092/b004/8f997fb80dfd6f649563983365ecba9f.mp3",
                "Beautiful Now ","",new MusicInfo(0,"Zedd&Jon Bellion"))); list.add(new MusicBean("http://m10.music.126.net/20200328014112/b95ae4370d831356d8543e5dedd829ee/ymusic/4c4a/c092/b004/8f997fb80dfd6f649563983365ecba9f.mp3",
                "Beautiful Now ","",new MusicInfo(0,"Zedd&Jon Bellion"))); list.add(new MusicBean("http://m10.music.126.net/20200328014112/b95ae4370d831356d8543e5dedd829ee/ymusic/4c4a/c092/b004/8f997fb80dfd6f649563983365ecba9f.mp3",
                "Beautiful Now ","",new MusicInfo(0,"Zedd&Jon Bellion")));
        return list;
    }
}
