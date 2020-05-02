package com.example.mplayer1.detaillist.api;

import android.util.Log;

import com.example.mplayer1.AppManager;
import com.example.mplayer1.detaillist.bean.AlbumList;
import com.example.mplayer1.detaillist.bean.VedioBean;
import com.example.mplayer1.detaillist.listener.OnGetAlbumInfoListener;
import com.example.mplayer1.detaillist.listener.OnGetChannelAbnumListener;
import com.example.mplayer1.detaillist.listener.OnGetPlayerUrlListener;
import com.example.mplayer1.detaillist.listener.OnGetVideosListener;
import com.example.mplayer1.detaillist.listener.OnGetWebListener;
import com.example.mplayer1.detaillist.listener.Result;
import com.example.mplayer1.detaillist.listener.ResultItemData;
import com.example.mplayer1.detaillist.listener.ResultPlayer;
import com.example.mplayer1.detaillist.listener.ResultVideoData;
import com.example.mplayer1.detaillist.listener.ResultVideos;
import com.example.mplayer1.home.bean.Channel;
import com.example.mplayer1.utils.OkHttpUtils;
import com.google.gson.JsonObject;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.UUID;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class SiteApi {

    private static final int SHOW_CHANNELID_MOVIE=1;//电影
    private static final int SHOW_CHANNELID_SERIES=2;//电视剧
    private static final int SHOW_CHANNELID_VARIETY=7;//综艺
    private static final int SHOW_CHANNELID_DOCUMENTRY=8;//记录片
    private static final int SHOW_CHANNELID_COMIC=16;//动漫
    private static final int SHOW_CHANNELID_MUSIC=24;//音乐频道

    public static String API_CHANNEL_ALBUM_FROMAT = "http://api.tv.sohu.com/v4/search/channel.json?cid=%s&o=1&plat=6&poid=1&api_key=9854b2afa779e1a6bff1962447a09dbd&sver=6.2" +
            ".0&partenr=47&page=%s&page_size=%s";

     public static String API_KAY="plat=6&poid=1&9854b2afa779e1a6bff1962447a09dbd&sver=6.2.0&partenr=47";
     public static String API_ALBUM_INFO="http://api.tv.sohu.com/v4/album/info/";

     public static String API_ALBUM_VIDEOS_FROMAT ="http://api.tv.sohu.com/v4/album/videos/%s.json?page=%s&page_size=%s&order=0&site=1&with_trailer=3&plat=6&poid=1&" +
             "api_key=9854b2afa779e1a6bff1962447a09dbd&sver=6.2.0&sysver=4.4.2&partner=47";

     public static String API_VIDEO_PLAY_URL_FORMAT="http://api.tv.sohu.com/v4/video/info/%s.json?site=1&plat=6&poid=1&api_key=9854b2afa779e1a6bff1962447a09dbd" +
             "&sver=6.2.0&sysver=4.4.2&partner=47&aid=%s";
    public static String CHR_URL_WEB_MAIN="https://www.651ts.com";
    public static String CHR_URL_PLAY="http://d.855ts.com";
    public static String CHR_URL_WEB="https://www.651ts.com";
    public String  onGetSnyUrlWeb(String url) throws IOException {
       Response response= OkHttpUtils.Synexcute(url);
       String html=response.body().string();
       return html;
    }
    public void onGetUrlWeb(String url ,final OnGetWebListener onGetWebListener){
        OkHttpUtils.excute(url, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.isSuccessful()){

                    String str=response.body().string();
                    onGetWebListener.OnSuccess(str);
                    //TODO
                    // AlbumList alubmList=new AlbumList();
                    // listener.Onsuccess(result.getData());

                }
            }
        });
    }

    public void onGetPlayerUrl(long Vid, long aid, final OnGetPlayerUrlListener listener){
        String url=String.format(API_VIDEO_PLAY_URL_FORMAT,Vid,aid);

        OkHttpUtils.excute(url, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Log.e("SITEAPIFFFFFFFFFF","00000000");
                if (response.isSuccessful()){

                    String str=response.body().string();
                    ResultPlayer result= AppManager.getGson().fromJson(str,ResultPlayer.class);
                    ResultPlayer.Data resultData=result.getData();
                    listener.OnSuccess(resultData.getUrl_super()+"&uid="+getUUID()+"&pt=5&prod=app&pg=1");
                    Log.e("SITEAPIFFFFFFFFFF",resultData.toString());
                    //TODO
                    // AlbumList alubmList=new AlbumList();
                    // listener.Onsuccess(result.getData());

                }
            }
        });
    }


    public String  geturltest(String url){
        return url+"uid="+getUUID()+"&pt=5&prod=app&pg=1";
    }

     //请求专辑的视频列表
    public void onGetVideos(long albumId, int pageOn, int pageSize, final OnGetVideosListener listener){
        //TODO
        String url=String.format(API_ALBUM_VIDEOS_FROMAT,albumId,pageOn,pageSize);
        OkHttpUtils.excute(url, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                //Log.e("SITEAPIEEEEEEEEEEEEEEEE","............");
                if (response.isSuccessful()){

                    String str=response.body().string();
                    ResultVideoData result= AppManager.getGson().fromJson(str,ResultVideoData.class);

                    listener.Onsuccess(result.getData().getVideos());
                   // Log.e("SITEAPIEEEEEEEEEEEEEEEE",result.toString());
                    //TODO
                    // AlbumList alubmList=new AlbumList();
                   // listener.Onsuccess(result.getData());

                }
            }
        });
    }

     //请求专辑详情
     public void onGetAlbumInfo(long albumId, final OnGetAlbumInfoListener listener){
        String url=API_ALBUM_INFO+albumId+".json"+"?"+API_KAY;
         OkHttpUtils.excute(url, new Callback() {
             @Override
             public void onFailure(@NotNull Call call, @NotNull IOException e) {

             }

             @Override
             public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                 if (response.isSuccessful()){

                     String str=response.body().string();
                     ResultItemData result= AppManager.getGson().fromJson(str,ResultItemData.class);
                    // Log.e("SITEAPI",result.toString());
                     //TODO
                     // AlbumList alubmList=new AlbumList();
                     listener.success(result.getData());
                 }
             }
         });
     }

     public void onGetChannelAlbums(int pageOn, int pageSize, Channel channel, OnGetChannelAbnumListener onGetChannelAbnumListener){//请求专辑列表
        String url=getAlbumsUrl(channel,pageOn,pageSize);//替换字符串
        doGetChannelByurl(url,onGetChannelAbnumListener);
    }

    private void doGetChannelByurl(String url, final OnGetChannelAbnumListener listener) {
      //TODO网络请求
        OkHttpUtils.excute(url, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.isSuccessful()){

                    String str=response.body().string();
                    Log.e("sssssssss",str);
                    Result result= AppManager.getGson().fromJson(str,Result.class);

                    Log.e("SITEAPI",result.toString());
                        //TODO
                        // AlbumList alubmList=new AlbumList();
                        listener.OnGetChannelAbnumSuccess(result.getData().getAlubms());

                }
            }
        });
     }




    private String getAlbumsUrl(Channel channel, int pageOn, int pageSize) {

     return String.format(API_CHANNEL_ALBUM_FROMAT,toCon(channel),pageOn,pageSize);
     }
    //自定义频道ID与真实频道ID转换
    private int toCon(Channel channel) {
        int channelId=-1;//无效值
        switch (channel.getChannelId()){
            case Channel.SHOW:
                channelId=SHOW_CHANNELID_SERIES;
                break;
            case Channel.MOVIE:
                channelId=SHOW_CHANNELID_MOVIE;
                break;
            case Channel.COMIC:
                channelId=SHOW_CHANNELID_COMIC;
                break;
            case Channel.DOCUMENTRY:
                channelId=SHOW_CHANNELID_DOCUMENTRY;
                break;
            case Channel.MUSIC:
                channelId=SHOW_CHANNELID_MUSIC;
                break;
            case Channel.VARIETY:
                channelId=SHOW_CHANNELID_VARIETY;
                break;
            case Channel.LIVE:
                break;
            case Channel.JIZUO:
                break;
            case Channel.ADULT:
                break;
        }
        return  channelId;
    }

    /**
     * s视频路径拼接 url_nor  +="uid=getUUID()+"&pt=5 prod=app pg=1"
     * url_super//超清
     * hurl_high//高清
     * @return
     */

    private String getUUID(){

        UUID uuid=UUID.randomUUID();
        return uuid.toString().replace("-","");
    }

}
