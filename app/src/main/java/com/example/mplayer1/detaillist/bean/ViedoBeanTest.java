package com.example.mplayer1.detaillist.bean;

import java.util.ArrayList;
import java.util.List;

public class ViedoBeanTest {
    String name;
    String imgurl;

    public ViedoBeanTest(String name, String imgurl) {
        this.name = name;
        this.imgurl = imgurl;
    }

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
    public static List<ViedoBeanTest> createTestB(){
        List<ViedoBeanTest> list=new ArrayList<>();
        for (int i=0;i<20;i++){
            list.add(new ViedoBeanTest("这里是标题"+i,""));
        }
        return list;
    }
}
