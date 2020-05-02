package com.example.mplayer1.detaillist.listener;

import com.example.mplayer1.detaillist.bean.AlbumList;

import java.util.List;

public interface OnGetChannelAbnumListener {
//    void OnGetChannelAbnumSuccess(AlbumList alubms);
    void OnGetChannelAbnumSuccess(List<ResultAlubm> alubms);
    void OnGetChannelAbnumFailed(ErrorInfo info);

}
