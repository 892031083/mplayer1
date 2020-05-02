package com.example.mplayer1.detaillist.listener;

import java.util.List;

public interface OnGetVideosListener {
    void Onsuccess(List<ResultVideos> listResultVideos);
    void onError();
}
