package com.example.mplayer1.home.bean;

import com.example.mplayer1.R;

import java.io.Serializable;

public class Channel implements Serializable {

    private int ChannelId=0;
    public static final int SHOW=1;//电视剧
    public static final int MOVIE=2;//电影
    public static final int COMIC=3;//动漫
    public static final int DOCUMENTRY=4;//纪录片
    public static final int MUSIC=5;//音乐
    public static final int VARIETY=6;//综艺
    public static final int LIVE=7;//直播
    public static final int JIZUO=8;//讲座
    public static final int ADULT=9;//你懂的0.0
    public static final int MAX_COUNT=9;//频道数量


    public Channel(int channelId) {
        ChannelId = channelId;
    }

    public int getChannelId() {
        return ChannelId;
    }

    public void setChannelId(int channelId) {
        ChannelId = channelId;
    }

    public static int getIconRes(int Id){
        int resId=0;
        switch (Id){
            case Channel.SHOW:
                resId= R.mipmap.icon_show;
                break;
            case Channel.MOVIE:
                resId= R.mipmap.icon_movie;
                break;
            case Channel.COMIC:
                resId= R.mipmap.icon_comic;
                break;
            case Channel.DOCUMENTRY:
                resId= R.mipmap.icon_documentry;
                break;
            case Channel.MUSIC:
                resId= R.mipmap.icon_music;
                break;
            case Channel.VARIETY:
                resId= R.mipmap.icon_variety;
                break;
            case Channel.LIVE:
                resId= R.mipmap.icon_live;
                break;
            case Channel.JIZUO:
                resId= R.drawable.icon_jizuo;
                break;
            case Channel.ADULT:
                resId= R.mipmap.icon_adult;
                break;
        }
        return resId;
    }
    public static int getTitleRes(int Id){
        int resId=0;
        switch (Id){
            case Channel.SHOW:
                resId= R.string.channel_show;
                break;
            case Channel.MOVIE:
                resId= R.string.channel_movie;
                break;
            case Channel.COMIC:
                resId= R.string.channel_comic;
                break;
            case Channel.DOCUMENTRY:
                resId= R.string.channel_DOCUMENTRY;
                break;
            case Channel.MUSIC:
                resId= R.string.channel_MUSIC;
                break;
            case Channel.VARIETY:
                resId= R.string.channel_VARIETY;
                break;
            case Channel.LIVE:
                resId= R.string.channel_LIVE;
                break;
            case Channel.JIZUO:
                resId= R.string.channel_JIZUO;
                break;
            case Channel.ADULT:
                resId= R.string.channel_ADULT;
                break;
        }
        return resId;
    }

}
