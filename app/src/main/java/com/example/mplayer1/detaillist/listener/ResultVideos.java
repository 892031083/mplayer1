package com.example.mplayer1.detaillist.listener;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultVideos {

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

        public String getTvDesc() {
                return tvDesc;
        }

        public void setTvDesc(String tvDesc) {
                this.tvDesc = tvDesc;
        }

        public String getDirector() {
                return director;
        }

        public void setDirector(String director) {
                this.director = director;
        }

        public String getHorHighPic() {
                return horHighPic;
        }

        public void setHorHighPic(String horHighPic) {
                this.horHighPic = horHighPic;
        }

        public String getVerHighPic() {
                return verHighPic;
        }

        public void setVerHighPic(String verHighPic) {
                this.verHighPic = verHighPic;
        }

        public String getMainActor() {
                return mainActor;
        }

        public void setMainActor(String mainActor) {
                this.mainActor = mainActor;
        }

        public String getVideo_name() {
                return video_name;
        }

        public void setVideo_name(String video_name) {
                this.video_name = video_name;
        }

        public long getAlbumId() {
                return albumId;
        }

        public void setAlbumId(long albumId) {
                this.albumId = albumId;
        }

        public String getTip() {
                return tip;
        }

        public void setTip(String tip) {
                this.tip = tip;
        }

        public double getScore() {
                return score;
        }

        public void setScore(double score) {
                this.score = score;
        }

        public long getCid() {
                return cid;
        }

        public void setCid(long cid) {
                this.cid = cid;
        }

        public int getTotal_video_count() {
                return total_video_count;
        }

        public void setTotal_video_count(int total_video_count) {
                this.total_video_count = total_video_count;
        }

        public int getLatest_video_count() {
                return latest_video_count;
        }

        public void setLatest_video_count(int latest_video_count) {
                this.latest_video_count = latest_video_count;
        }

        public String getUpdateNotification() {
                return updateNotification;
        }

        public void setUpdateNotification(String updateNotification) {
                this.updateNotification = updateNotification;
        }

        public String getUrl_high() {
                return url_high;
        }

        public void setUrl_high(String url_high) {
                this.url_high = url_high;
        }

        public String getUrl_super() {
                return url_super;
        }

        public void setUrl_super(String url_super) {
                this.url_super = url_super;
        }

        public String getUrl_nor() {
                return url_nor;
        }

        public void setUrl_nor(String url_nor) {
                this.url_nor = url_nor;
        }

        public long getTv_id() {
                return tv_id;
        }

        public void setTv_id(long tv_id) {
                this.tv_id = tv_id;
        }

        public long getVid() {
                return vid;
        }

        public void setVid(long vid) {
                this.vid = vid;
        }

        @Expose
        private long vid;
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


