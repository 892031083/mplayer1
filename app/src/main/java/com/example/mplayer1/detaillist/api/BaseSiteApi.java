package com.example.mplayer1.detaillist.api;

import com.example.mplayer1.detaillist.listener.OnGetChannelAbnumListener;
import com.example.mplayer1.home.bean.Channel;

public abstract class BaseSiteApi {
    abstract void onGetChannelAlbums(Channel channel, int pageNo, int pagesize, OnGetChannelAbnumListener onGetChannelAbnumListener);

}
