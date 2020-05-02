package com.example.mplayer1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.mplayer1.home.HomeActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bt1,bt2,bt3,bt4,bt5,bt6,bt7;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1=findViewById(R.id.cctv1_btn);
        bt2=findViewById(R.id.cctv3_btn);
        bt3=findViewById(R.id.cctv5_btn);
        bt4=findViewById(R.id.cctv6_btn);
        bt5=findViewById(R.id.test_mp4);
        bt6=findViewById(R.id.test_mp4_1);
        bt7=findViewById(R.id.home);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);
        bt7.setOnClickListener(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        Log.e("SKDDSD","2222");


    }

    @Override
    public void onClick(View v) {
        String playUrl="";
        switch (v.getId()){
            case R.id.cctv1_btn:
                playUrl="http://ivi.bupt.edu.cn/hls/cctv1hd.m3u8";
                break;
            case R.id.cctv3_btn:
                playUrl="http://ivi.bupt.edu.cn/hls/cctv3hd.m3u8";
                break;
            case R.id.cctv5_btn:
                playUrl="http://ivi.bupt.edu.cn/hls/cctv5phd.m3u8";
                break;
            case R.id.cctv6_btn:
                playUrl="http://ivi.bupt.edu.cn/hls/cctv6hd.m3u8";
                break;
            case R.id.test_mp4:
                playUrl="http://vfx.mtime.cn/Video/2019/03/17/mp4/190317150237409904.mp4";
                break;
            case R.id.test_mp4_1:
                playUrl="https://yiqikan.wuyouzuida.com/20200219/3432_747cb733/index.m3u8";
//                playUrl="http://api.tv.sohu.com/v4/video/info/178697002.json?site=1&plat=6&poid=1&api_key=9854b2afa779e1a6bff1962447a09dbd"+
//                        "&sver=6.2.0&sysver=4.4.2&partner=47&aid=9623603";
                break;
            case R.id.home:
                startActivity(new Intent(MainActivity.this, HomeActivity.class));
                return;
        }
       // thunder://QUFodHRwczovL2QuODU1dHMuY29tLzIwMjAwMzA1LzkwLzIwMDU5LzIwMDU5Lm1wNFpa
        Intent intent=new Intent(MainActivity.this,PlayerActivity.class);
        intent.putExtra("playurl",playUrl);
        MainActivity.this.startActivity(intent);
    }
}
