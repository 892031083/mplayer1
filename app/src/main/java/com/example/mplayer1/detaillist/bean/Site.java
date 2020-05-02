package com.example.mplayer1.detaillist.bean;

import android.content.Context;

public class Site {
    public static final int LETV=1000;

    public int ChannelId;
    private int SiteId;
    private Context context;

    public Site(int siteId, Context context) {
        this.SiteId=siteId;
        this.context=context;
    }
}
