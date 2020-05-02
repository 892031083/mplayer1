package com.example.mplayer1;

import android.text.format.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class PlayerModel {

    public static String getTime(long millSecond){
        Date time = new Date(millSecond);
        SimpleDateFormat formats = new SimpleDateFormat("mm:ss");
        return formats.format(time);
    }
    /*
     * 使用Calendar获取系统时间
     */



    public static String getTimeNow() {
        Calendar calendars;
        calendars = Calendar.getInstance();

        calendars.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));


        String year = String.valueOf(calendars.get(Calendar.YEAR));

        String month = String.valueOf(calendars.get(Calendar.MONTH));

        String day = String.valueOf(calendars.get(Calendar.DATE));

        String hour = String.valueOf(calendars.get(Calendar.HOUR));

        String min = String.valueOf(calendars.get(Calendar.MINUTE));

        String second = String.valueOf(calendars.get(Calendar.SECOND));

        Boolean isAm = calendars.get(Calendar.AM_PM)==1 ? true:false;

        String mWay = String.valueOf(calendars.get(Calendar.DAY_OF_WEEK));
        if("1".equals(mWay)){
            mWay ="天";
        }else if("2".equals(mWay)){
            mWay ="一";
        }else if("3".equals(mWay)){
            mWay ="二";
        }else if("4".equals(mWay)){
            mWay ="三";
        }else if("5".equals(mWay)){
            mWay ="四";
        }else if("6".equals(mWay)){
            mWay ="五";
        }else if("7".equals(mWay)){
            mWay ="六";
        }
        //Boolean is24 = DateFormat.is24HourFormat(getApplication()) ?true:false;

        //Log.i("md", " 年："+year+" 月： "+month+" 日："+day+" 时： "+hour+" 分： "+min+" 秒： "+second +" 是上午吗？ "+isAm+" 是24小时制吗？ ");
        return  month+"月"+day+"日"  +"星期"+mWay;

    }
}
