package com.example.mplayer1.detaillist.listener;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultPlayer {


    @Expose
    private long status;
    @Expose
    private String statusText;
    @Expose
    private ResultPlayer.Data data;

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public  class Data{
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
        private String url_high;//高清路径

        @Expose
        private String url_super;//超清路径
        @Expose
        private String url_nor;//标清路径
        @Expose
        private long tv_id;
        @Expose
        private long vid;

        @Expose
        private String second_cate_name;
        @Expose
        private String time_length_format;

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

        public String getSecond_cate_name() {
            return second_cate_name;
        }

        public void setSecond_cate_name(String second_cate_name) {
            this.second_cate_name = second_cate_name;
        }

        public String getTime_length_format() {
            return time_length_format;
        }

        public void setTime_length_format(String time_length_format) {
            this.time_length_format = time_length_format;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "director='" + director + '\'' +
                    ", horHighPic='" + horHighPic + '\'' +
                    ", verHighPic='" + verHighPic + '\'' +
                    ", mainActor='" + mainActor + '\'' +
                    ", video_name='" + video_name + '\'' +
                    ", albumId=" + albumId +
                    ", tip='" + tip + '\'' +
                    ", score=" + score +
                    ", cid=" + cid +
                    ", total_video_count=" + total_video_count +
                    ", latest_video_count=" + latest_video_count +
                    ", url_high='" + url_high + '\'' +
                    ", url_super='" + url_super + '\'' +
                    ", url_nor='" + url_nor + '\'' +
                    ", tv_id=" + tv_id +
                    ", vid=" + vid +
                    ", second_cate_name='" + second_cate_name + '\'' +
                    ", time_length_format='" + time_length_format + '\'' +
                    '}';
        }
    }

    /**
     * {
     *     "status": 200,
     *     "statusText": "OK",
     *     "data": {
     *         "aid": 9623603,
     *         "album_name": "勇敢者游戏2：再战巅峰（普通话版）",
     *         "area": "美国",
     *         "area_id": 2,
     *         "caption_ver": 1,
     *         "cate_code": "100102;100106",
     *         "cid": 1,
     *         "clips_bytes_high": "25978724,18117180,19350106,32576345,37744624,29172386,29267370,36774937,22760193,24238003,19487652,23937032,24951459,46105681,50953244,32590877,33337573,26013752,24687899,38304406,37685721,27361745,20184379,24236102",
     *         "clips_bytes_nor": "9869873,6819212,7302053,12314864,14437017,10484509,11060740,13626699,8263141,8866009,6930423,8348723,8877807,18053795,20320945,12131141,12287160,9079752,8754366,13130898,12783491,10358369,7640827,11358004",
     *         "clips_bytes_original": "65665158,46235242,52302713,86586250,99947958,73901871,73345887,88591333,58291922,58937225,48144009,58279844,62066019,116711289,122859549,88146478,88777953,65777870,62723891,91949143,91915438,72711008,52504143,68656966",
     *         "clips_bytes_super": "33456963,23961852,25317881,43007688,49279618,38195295,37086520,46695507,29758568,31490115,26044419,31770378,32793524,59815029,65891629,42231476,43116879,34289983,32205512,49779451,49872711,35461489,26358265,30409792",
     *         "clips_duration_high": "300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,475.321",
     *         "clips_duration_nor": "300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,475.321",
     *         "clips_duration_original": "300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,475.323",
     *         "clips_duration_super": "300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,300.002,475.323",
     *         "create_time": 1582817543000,
     *         "crid": 0,
     *         "data_type": 50,
     *         "director": "杰克·卡斯丹",
     *         "end_time": 0,
     *         "fee": 2,
     *         "file_size_blue": 3088045442,
     *         "file_size_high": 705787849,
     *         "file_size_high_265": 463287427,
     *         "file_size_mobile": 235404653,
     *         "file_size_nor": 263070776,
     *         "file_size_nor_265": 240625854,
     *         "file_size_original": 1795000115,
     *         "file_size_original_265": 1130433826,
     *         "file_size_super": 918261500,
     *         "file_size_super_265": 569784970,
     *         "first_cate_name": "电影",
     *         "has_caption": 1,
     *         "hor_big_pic": "http://photocdn.tv.sohu.com/img/20200228/vrsa_ver_1582853603525_178697002_wN19S_pic7.jpg",
     *         "hor_high_pic": "http://photocdn.tv.sohu.com/img/20200228/vrsa_hor_1582088127271_178697002_C85el_pic2.jpg",
     *         "hor_w16_pic": "http://photocdn.tv.sohu.com/img/20200228/vrsa_hor_1582088127271_178697002_4z3z9_pic22.jpg",
     *         "hor_w8_pic": "http://photocdn.tv.sohu.com/img/20200228/vrsa_hor_1582088127271_178697002_n24EL_pic24.jpg",
     *         "ip_limit": 1,
     *         "isScreencapUrlExist": 1,
     *         "isSohu": 0,
     *         "is_original_code": 1,
     *         "is_titbits": 0,
     *         "is_trailer": 0,
     *         "isai": 0,
     *         "keyword": "勇敢者游戏2;再战巅峰;勇敢者游戏2;再战巅峰高清;勇敢者游戏2;再战巅峰完整版;勇敢者游戏2;再战巅峰;喜剧片;动作片;",
     *         "latest_video_count": 1,
     *         "longTitle": "",
     *         "main_actor": "道恩·强森,凯伦·吉兰,杰克·布莱克,凯文·哈特",
     *         "origin_album_id": 9623603,
     *         "original_video_url": "http://tv.sohu.com/v/MjAyMDAyMjcvbjYwMDgxODIxNC5zaHRtbA==.html",
     *         "pay_type": [
     *             2
     *         ],
     *         "period": "",
     *         "play_count": 34321,
     *         "play_count_format": "34,321",
     *         "precisionTitle": "",
     *         "publish_time": "2020-02-27",
     *         "publish_user_name": "张晔",
     *         "score": 7.4,
     *         "second_cate_name": "喜剧片;动作片",
     *         "serious": false,
     *         "site": 1,
     *         "small_pic": "http://photocdn.tv.sohu.com/img/20200228/vrsa_ver_1582853603525_178697002_lY21y_pic9.jpg",
     *         "start_time": 0,
     *         "time_length_format": "02:02:56",
     *         "tip": "122分56秒",
     *         "total_duration": 7375.367,
     *         "total_video_count": 1,
     *         "tvIsVr": 0,
     *         "tvLastTranEndTime": 1582101122000,
     *         "tvPic": "http://photocdn.tv.sohu.com/img/20200219/vrsa_hor_1582088127271_178697002.jpg",
     *         "tvPlayType": 0,
     *         "tvPreviewPic": "http://photocdn.tv.sohu.com/img/Sample2/BackUp_Sample2/images/svc/20200219/178697002_6110274_tv_H_161523_24765/178697002_6110274_tv_H_161523_24765_big_160_66_15.jpg",
     *         "tv_id": 178697002,
     *         "update_date": 1582817543000,
     *         "uploadFrom": 0,
     *         "url_56_html5": "http://m.56.com/pa/v6110274.shtml",
     *         "url_blue": "http://hot.vrs.sohu.com/m3u8v3/6110280_4794517854820_9321501.m3u8?plat=6&ssl=2",
     *         "url_high": "http://hot.vrs.sohu.com/m3u8v3/6110274_4794517854820_9321595.m3u8?plat=6&ssl=2",
     *         "url_high_265": "http://hot.vrs.sohu.com/m3u8v3/6110282_4794517854820_9321503.m3u8?plat=6&ssl=2",
     *         "url_html5": "http://m.tv.sohu.com/v6110274.shtml",
     *         "url_nor": "http://hot.vrs.sohu.com/m3u8v3/6110275_4794517854820_9321596.m3u8?plat=6&ssl=2",
     *         "url_nor_265": "http://hot.vrs.sohu.com/m3u8v3/6110283_4794517854820_9321504.m3u8?plat=6&ssl=2",
     *         "url_original": "http://hot.vrs.sohu.com/m3u8v3/6110279_4794517854820_9321590.m3u8?plat=6&ssl=2",
     *         "url_original_265": "http://hot.vrs.sohu.com/m3u8v3/6110285_4794517854820_9321506.m3u8?plat=6&ssl=2",
     *         "url_super": "http://hot.vrs.sohu.com/m3u8v3/6110278_4794517854820_9321599.m3u8?plat=6&ssl=2",
     *         "url_super_265": "http://hot.vrs.sohu.com/m3u8v3/6110284_4794517854820_9321505.m3u8?plat=6&ssl=2",
     *         "ver_big_pic": "http://photocdn.tv.sohu.com/img/20200228/vrsa_ver_1582853603525_178697002_wN19S_pic7.jpg",
     *         "ver_high_pic": "http://photocdn.tv.sohu.com/img/20200228/vrsa_ver_1582853603525_178697002_TQ626_pic3.jpg",
     *         "ver_small_pic": "http://photocdn.tv.sohu.com/img/20200228/vrsa_ver_1582853603525_178697002_lY21y_pic9.jpg",
     *         "ver_w12_pic": "http://photocdn.tv.sohu.com/img/20200219/vrsa_hor_1582088127271_178697002.jpg",
     *         "vid": 6110274,
     *         "vid_blue": 6110280,
     *         "vid_high": 6110274,
     *         "vid_high_265": 6110282,
     *         "vid_nor": 6110275,
     *         "vid_nor_265": 6110283,
     *         "vid_original": 6110279,
     *         "vid_original_265": 6110285,
     *         "vid_super": 6110278,
     *         "vid_super_265": 6110284,
     *         "video_big_pic": "http://photocdn.tv.sohu.com/img/20200228/vrsa_ver_1582853603525_178697002_wN19S_pic7.jpg",
     *         "video_desc": "　四名勇敢者再次穿越回到险象环生的游戏世界中，开启全新冒险。与上次不同的是，变身勇石博士 (道恩·强森 饰) 的是斯潘瑟的外公，外公的好友则变身为语言学家 (凯文· 哈特 饰)，高大威猛的弗里奇变成了中年发福地质学家 (杰克·布莱克 饰)，只有学霸玛莎依旧化身性感打女 (凯伦·吉兰 饰)，斯潘瑟和贝瑟尼却不知所踪。为营救消失的伙伴，四人必须进入全面失控的未知世界，面对难度爆表危险重重的致命关卡，强森领队挑战极限玩命闯关。山崩石裂的险境中命悬一线，与突如其来的凶猛野兽死战到底，他们唯有绷紧神经并肩作战，才能通过生死考验逃出生天。一场惊险刺激又充满惊喜的冒险之旅即将展开！",
     *         "video_is_fee": 0,
     *         "video_length_type": 1,
     *         "video_name": "勇敢者游戏2：再战巅峰（普通话版）",
     *         "video_order": 1,
     *         "video_sub_name": "",
     *         "video_type": 1,
     *         "vs": {
     *             "blue_format": "2945.0MB",
     *             "high_265_format": "441.8MB",
     *             "high_format": "673.1MB",
     *             "mobile_format": "224.5MB",
     *             "nor_265_format": "229.5MB",
     *             "nor_format": "250.9MB",
     *             "original_265_format": "1078.1MB",
     *             "original_format": "1711.8MB",
     *             "super_265_format": "543.4MB",
     *             "super_format": "875.7MB"
     *         },
     *         "year": "2019"
     *     }
     * }
     */
}
