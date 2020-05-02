package com.example.mplayer1.detaillist.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Video {
    @SerializedName("video_desc")//表示jion对应的字段
    @Expose
    private String tvDesc;

    @Expose
    private String director;//导演

    @SerializedName("hor_high_pic")
    @Expose
    private String horHighPic;//横图

    @SerializedName("ver_high_pic")
    @Expose
    private String verHighPic;//试图

    @SerializedName("actor")
    @Expose
    private String mainActor;//主演

    @Expose
    private String video_name;//专辑名称

    @SerializedName("aid")
    @Expose
    private long albumId;
    @Expose
    private String tip;
    @Expose
    private double score;
    @Expose
    private long cid;

    @Expose
    private int total_video_count;//总集数
    @Expose
    private int latest_video_count;//已经更新的级数

    @Expose
    private String updateNotification;
    @Expose
    private String url_high;//高清路径

    @Expose
    private String url_super;//超清路径
    @Expose
    private String url_nor;//标清路径
    @Expose
    private long tv_id;
    /**
     *  "aid": 9623603,
     *                 "bgCover169": "http://photocdn.tv.sohu.com/img/20200228/vrsa_hor_1582088127271_178697002_crV5m_pic23.jpg",
     *                 "cate_code": "100102;100106",
     *                 "cid": 1,
     *                 "create_date": 1582817543000,
     *                 "crid": 0,
     *                 "data_type": 50,
     *                 "download_url": "http://data.vod.itc.cn/?k=tWaizEIsWDAHRYAHbAW7fJbbuKKDuhNXhJ1Wzh6UyAcObJXUyYk&a=XfGFjpCUhWqbzHJUhRamOHPINT1CvmfdyL8GgVPARD6sfY6sfJoUgt8ISCBs3hvkvhvofbCkUB6SasdJSl6OWJDskO9EwGTJZOdSAOU49xIWh1sfJA4RhWtRY",
     *                 "end_time": 0,
     *                 "has_ep": 0,
     *                 "hor_big_pic": "http://photocdn.tv.sohu.com/img/20200228/vrsa_hor_1582088127271_178697002_crV5m_pic23.jpg",
     *                 "hor_high_pic": "http://photocdn.tv.sohu.com/img/20200228/vrsa_hor_1582088127271_178697002_7s99T_pic36.jpg",
     *                 "hor_w16_pic": "http://photocdn.tv.sohu.com/img/20200228/vrsa_hor_1582088127271_178697002_4z3z9_pic22.jpg",
     *                 "hor_w8_pic": "http://photocdn.tv.sohu.com/img/20200228/vrsa_hor_1582088127271_178697002_n24EL_pic24.jpg",
     *                 "is_act": 0,
     *                 "isai": 0,
     *                 "origin_album_id": 9623603,
     *                 "period": "",
     *                 "play_count": 274,
     *                 "play_count_format": "274",
     *                 "publish_user_name": "张晔",
     *                 "site": 1,
     *                 "start_time": 0,
     *                 "time_length_format": "122:56",
     *                 "tip": "122分55秒",
     *                 "total_duration": 7376,
     *                 "tvIsVr": 0,
     *                 "tvPlayType": 0,
     *                 "tvSType": 1,
     *                 "tv_id": 178697002,
     *                 "url_56_html5": "http://m.56.com/pa/v6110274.shtml",
     *                 "url_blue": "http://hot.vrs.sohu.com/m3u8v3/6110280_4794512976028_9321501.m3u8?plat=6&ssl=2",
     *                 "url_high": "http://hot.vrs.sohu.com/m3u8v3/6110274_4794512976028_9321595.m3u8?plat=6&ssl=2",
     *                 "url_high_265": "http://hot.vrs.sohu.com/m3u8v3/6110282_4794512976028_9321503.m3u8?plat=6&ssl=2",
     *                 "url_html5": "http://m.tv.sohu.com/v6110274.shtml",
     *                 "url_nor": "http://hot.vrs.sohu.com/m3u8v3/6110275_4794512976028_9321596.m3u8?plat=6&ssl=2",
     *                 "url_nor_265": "http://hot.vrs.sohu.com/m3u8v3/6110283_4794512976028_9321504.m3u8?plat=6&ssl=2",
     *                 "url_original": "http://hot.vrs.sohu.com/m3u8v3/6110279_4794512976028_9321590.m3u8?plat=6&ssl=2",
     *                 "url_original_265": "http://hot.vrs.sohu.com/m3u8v3/6110285_4794512976028_9321506.m3u8?plat=6&ssl=2",
     *                 "url_super": "http://hot.vrs.sohu.com/m3u8v3/6110278_4794512976028_9321599.m3u8?plat=6&ssl=2",
     *                 "url_super_265": "http://hot.vrs.sohu.com/m3u8v3/6110284_4794512976028_9321505.m3u8?plat=6&ssl=2",
     *                 "ver_big_pic": "http://photocdn.tv.sohu.com/img/20200228/vrsa_ver_1582853603525_178697002_wN19S_pic7.jpg",
     *                 "ver_high_pic": "http://photocdn.tv.sohu.com/img/20200228/vrsa_ver_1582853603525_178697002_TQ626_pic3.jpg",
     *                 "vid": 6110274,
     *                 "video_desc": "　四名勇敢者再次穿越回到险象环生的游戏世界中，开启全新冒险。与上次不同的是，变身勇石博士 (道恩·强森 饰) 的是斯潘瑟的外公，外公的好友则变身为语言学家 (凯文· 哈特 饰)，高大威猛的弗里奇变成了中年发福地质学家 (杰克·布莱克 饰)，只有学霸玛莎依旧化身性感打女 (凯伦·吉兰 饰)，斯潘瑟和贝瑟尼却不知所踪。为营救消失的伙伴，四人必须进入全面失控的未知世界，面对难度爆表危险重重的致命关卡，强森领队挑战极限玩命闯关。山崩石裂的险境中命悬一线，与突如其来的凶猛野兽死战到底，他们唯有绷紧神经并肩作战，才能通过生死考验逃出生天。一场惊险刺激又充满惊喜的冒险之旅即将展开！",
     *                 "video_first_name": "勇敢者游戏2：再战巅峰（普通话版）",
     *                 "video_is_fee": 0,
     *                 "video_name": "勇敢者游戏2：再战巅峰（普通话版）",
     *                 "video_order": 1,
     *                 "video_sub_name": ""
     *             }
     */
}
