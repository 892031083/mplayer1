package com.example.mplayer1.music.beaninfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.mplayer1.AppManager;
import com.example.mplayer1.music.LockScreenMusicAvtivity;
import com.example.mplayer1.music.MsplayActivity;
import com.example.mplayer1.music.ServiceToutil;


/**
 * @author master
 * @date 2018/1/23
 */

public class ScreenBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals(Intent.ACTION_SCREEN_OFF)) {
            if (!LockScreenMusicAvtivity.isStart&& ServiceToutil.getInstance().getMediaPlayer().isPlaying()) {
                //服务已经创建 并且 正在播放

                Intent intent1 = new Intent(context, LockScreenMusicAvtivity.class);
                intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                AppManager.getContext().startActivity(intent1);
            }
            } else if (action.equals(Intent.ACTION_SCREEN_ON)) {

        }else if(action.equals(Intent.ACTION_USER_PRESENT)){

           // LogUtil.e("开屏");
        }

    }


}
