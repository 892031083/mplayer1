package com.example.mplayer1.recom;

import java.util.ArrayList;
import java.util.List;

public class ReBean {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getPlayurl() {
        return playurl;
    }

    public void setPlayurl(String playurl) {
        this.playurl = playurl;
    }

    public String name;
    public String imgurl;
    public String playurl;
    public int type=0;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ReBean(String name, String imgurl, String playurl) {
        this.name = name;
        this.imgurl = imgurl;
        this.playurl = playurl;
    }
    public ReBean(String name, String imgurl, String playurl ,int  type) {
        this.name = name;
        this.imgurl = imgurl;
        this.playurl = playurl;
        this.type=type;
    }

    public static List<ReBean> CreateListRe(){

        List<ReBean> list=new ArrayList<>();

        list.add(new ReBean(
                "勇敢者游戏2：再战巅峰",
                "http://pic6.iqiyipic.com/image/20200302/38/3c/v_145135929_m_601_m3_180_236.jpg",
                        "http://meinv.jingyu-zuida.com/20200301/12929_9d7db888/index.m3u8"
        ));


        // * * http://hong.tianzhen-zuida.com/20200209/19971_59b58144/index.m3u8 叶问4：完结篇 国语
        list.add(new ReBean(
                "叶问4：完结篇 国语",
                "http://pic8.iqiyipic.com/image/20200209/85/61/v_115505617_m_601_m25_180_236.jpg",
                "http://hong.tianzhen-zuida.com/20200209/19971_59b58144/index.m3u8"
        ));
        //* http://wuji.zhulong-zuida.com/20191010/10591_98f58691/index.m3u8  哪吒之魔童降世 线路1
        list.add(new ReBean(
                "哪吒之魔童降世",
                "http://pic1.iqiyipic.com/image/20200119/a7/c5/v_115686092_m_601_m10_180_236.jpg",
                "http://wuji.zhulong-zuida.com/20191010/10591_98f58691/index.m3u8"
        ));

        // http://bili.meijuzuida.com/20190830/21338_20353137/index.m3u8 X战警：黑凤凰
        list.add(new ReBean(
                "X战警：黑凤凰",
                "http://pic6.iqiyipic.com/image/20191007/61/57/v_113835866_m_601_m6_180_236.jpg",
                "http://bili.meijuzuida.com/20190830/21338_20353137/index.m3u8"
        ));
        // http://hong.tianzhen-zuida.com/20191203/15232_1a865c8f/index.m3u8  星际探索
        list.add(new ReBean(
                "星际探索",
                "http://pic4.iqiyipic.com/image/20200221/67/cc/v_119292847_m_601_m11_180_236.jpg",
                "http://hong.tianzhen-zuida.com/20191203/15232_1a865c8f/index.m3u8"
        ));
        //* http://wuji.zhulong-zuida.com/20190912/7981_c0d98637/index.m3u8 蜘蛛侠：英雄远征 英语
        list.add(new ReBean(
                "蜘蛛侠：英雄远征",
                "http://pic3.iqiyipic.com/image/20190911/da/a1/v_114411383_m_601_m9_180_236.jpg",
                "http://wuji.zhulong-zuida.com/20190912/7981_c0d98637/index.m3u8"
        ));
        //http://wuji.zhulong-zuida.com/20190816/5698_504abc66/index.m3u8 黑衣人：全球追缉 英语线路2
        list.add(new ReBean(
                "黑衣人：全球追缉 英语",
                "http://pic0.iqiyipic.com/image/20190815/48/d1/v_122792505_m_601_m13_180_236.jpg",
                "http://wuji.zhulong-zuida.com/20190816/5698_504abc66/index.m3u8"
        ));
        //http://xigua-cdn.haima-zuida.com/20200111/101_10876626/index.m3u8 决战中途岛
        list.add(new ReBean(
                "决战中途岛",
                "http://pic9.iqiyipic.com/image/20200219/3e/7d/v_144947117_m_601_m2_180_236.jpg",
                "http://xigua-cdn.haima-zuida.com/20200111/101_10876626/index.m3u8"
        ));
        //http://hong.tianzhen-zuida.com/20200301/21105_14d736d1/index.m3u8 废柴梦想家
        list.add(new ReBean(
                "废柴梦想家",
                "http://pic6.iqiyipic.com/image/20200303/49/16/v_145168114_m_601_m5_180_236.jpg",
                "http://hong.tianzhen-zuida.com/20200301/21105_14d736d1/index.m3u8"
        ));
        //http://hong.tianzhen-zuida.com/20200221/20610_2da3358d/index.m3u8 狄仁杰之深海龙宫
        list.add(new ReBean(
                "狄仁杰之深海龙宫",
                "http://puui.qpic.cn/vcover_vt_pic/0/9xmc61a1o3okc4b1575018102/260",
                "http://hong.tianzhen-zuida.com/20200221/20610_2da3358d/index.m3u8"
        ));
        //http://hong.tianzhen-zuida.com/20200221/20596_545a0e1c/index.m3u8 东海人鱼传
        list.add(new ReBean(
                "东海人鱼传",
                "http://pic0.iqiyipic.com/image/20200302/06/ff/v_145631458_m_601_m3_180_236.jpg",
                "http://hong.tianzhen-zuida.com/20200221/20596_545a0e1c/index.m3u8"
        ));
        //http://hong.tianzhen-zuida.com/20200218/20473_77641f81/index.m3u8  剑王朝之孤山剑藏
        list.add(new ReBean(
                "剑王朝之孤山剑藏",
                "http://pic0.iqiyipic.com/image/20200218/0e/93/v_144865838_m_601_m3_180_236.jpg",
                "http://hong.tianzhen-zuida.com/20200218/20473_77641f81/index.m3u8"
        ));
        //http://hong.tianzhen-zuida.com/20200227/20942_f74d3ae5/index.m3u8 战毒
        list.add(new ReBean(
                "战毒",
                "http://pic9.iqiyipic.com/image/20190808/30/91/v_50509539_m_601_m9_180_236.jpg",
                "http://hong.tianzhen-zuida.com/20200227/20942_f74d3ae5/index.m3u8"
        ));
        //http://hong.tianzhen-zuida.com/20191231/17476_322a34df/index.m3u8 星球大战9：天行者崛起
        list.add(new ReBean(
                "星球大战9：天行者崛起",
                "http://pic6.iqiyipic.com/image/20191227/11/20/v_129222432_m_601_m12_180_236.jpg",
                "http://hong.tianzhen-zuida.com/20191231/17476_322a34df/index.m3u8"
        ));
        //https://youku.cdn4-okzy.com/20191022/2183_10b23bad/index.m3u8 诛仙 Ⅰ
        list.add(new ReBean(
                "诛仙",
                "http://pic4.iqiyipic.com/image/20191025/ba/a6/v_124870939_m_601_m7_180_236.jpg",
                "http://youku.cdn4-okzy.com/20191022/2183_10b23bad/index.m3u8"
        ));
        // 巨鳄岛 线路1
        list.add(new ReBean(
                "巨鳄岛",
                "http://pic1.iqiyipic.com/image/20200305/95/00/v_144218189_m_601_m5_180_236.jpg",
                "http://xigua-cdn.haima-zuida.com/20200204/1908_8c00280a/index.m3u8"
        ));
        //http://meinv.jingyu-zuida.com/20200224/12917_0bd6a8ed/index.m3u8  一路疯逃
        list.add(new ReBean(
                "一路疯逃",
                "http://pic8.iqiyipic.com/image/20200224/2a/59/v_144865953_m_601_m2_180_236.jpg",
                "http://meinv.jingyu-zuida.com/20200224/12917_0bd6a8ed/index.m3u8"
        ));
        //http://feifei.feifeizuida.com/20190828/17140_0f0bcd97/index.m3u8'上海堡垒 线路1
        list.add(new ReBean(
                "上海堡垒",
                "http://pic8.iqiyipic.com/image/20190905/dd/4a/v_114257195_m_601_m7_180_236.jpg",
                "http://feifei.feifeizuida.com/20190828/17140_0f0bcd97/index.m3u8"
        ));
        return list;
    }

    public static List<ReBean> CreateListRe2(){
        List<ReBean> list=new ArrayList<>();
        list.add(new ReBean(
                "驯龙高手3：预告片",
                "http://pic5.iqiyipic.com/image/20190810/a8/7b/v_112874535_m_601_m9_180_236.jpg",
                "http://vfx.mtime.cn/Video/2019/02/04/mp4/190204084208765161.mp4"
        ));

        list.add(new ReBean(
                "紧急救援:预告",
                "http://pic5.iqiyipic.com/image/20200206/93/47/v_127016760_m_601_m14_180_236.jpg",
                "http://vfx.mtime.cn/Video/2019/03/21/mp4/190321153853126488.mp4"
        ));
        list.add(new ReBean(
                "玩具总动员",
                "http://pic7.iqiyipic.com/image/20190809/f7/fa/v_110439176_m_601_m5_180_236.jpg",
                "http://vfx.mtime.cn/Video/2019/03/19/mp4/190319222227698228.mp4"
        ));
        list.add(new ReBean(
                "《叶问4》先行预告甄子丹过招",
                "http://pic4.iqiyipic.com/image/20200210/0f/e6/v_144729004_m_601_m4_180_236.jpg",
                "http://vfx.mtime.cn/Video/2019/03/18/mp4/190318231014076505.mp4"
        ));
        list.add(new ReBean(
                "扫毒预告",
                "http://pic2.iqiyipic.com/image/20190826/ee/48/v_115689683_m_601_m7_180_236.jpg",
                "http://vfx.mtime.cn/Video/2019/03/18/mp4/190318214226685784.mp4"
        ));
        list.add(new ReBean(
                "明日战纪",
                "http://pic2.iqiyipic.com/image/20171201/dd/83/v_114132146_m_601_180_236.jpg",
                "http://vfx.mtime.cn/Video/2019/03/17/mp4/190317150237409904.mp4"
        ));
        list.add(new ReBean(
                "雷霆沙赞！",
                "http://pic1.iqiyipic.com/image/20190810/99/83/v_114015565_m_601_m5_180_236.jpg",
                " http://vfx.mtime.cn/Video/2019/03/14/mp4/190314102306987969.mp4"
        ));
        return list;

    }
}
