package com.example.mplayer1.live;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mplayer1.PlayerActivity;
import com.example.mplayer1.R;
import com.example.mplayer1.base.DateBaseActivity;
import com.example.mplayer1.base.HomeBaseActivity;

import java.util.ArrayList;
import java.util.List;

public class AlbumLiveListActivity extends DateBaseActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private GridLayoutManager mLayoutManager;
    List<LiveTest> mList;
    private TextView t1,t2;
    int playstatis=0;//标清 1高清
    @Override
    protected boolean isload() {
        return false;
    }

    @Override
    protected void initView() {

        setTitleText("电视频道");
        mList=new ArrayList<>();
        recyclerView = bindViewId(R.id.rectview);
        mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
        t1=findViewById(R.id.tt1);t1.setOnClickListener(this);
        t2=findViewById(R.id.tt2);t2.setOnClickListener(this);
        initList();

        recyclerView.setAdapter(new LiveAdapter(mList));
    }
    @Override
    public void onClick(View v) {
        Log.e("//////////",""+v.getId());
        switch (v.getId()){
            case R.id.tt1:
                t2.setTextColor(getResources().getColor(R.color.recom_text_clickno));
                t1.setTextColor(getResources().getColor(R.color.recom_text_click));
                t1.setBackgroundResource(R.drawable.defulpas);
                t2.setBackgroundResource(R.drawable.reno);
                playstatis=0;
                break;
            case R.id.tt2:
                t1.setTextColor(getResources().getColor(R.color.recom_text_clickno));
                t2.setTextColor(getResources().getColor(R.color.recom_text_click));
                t2.setBackgroundResource(R.drawable.defulpas);
                t1.setBackgroundResource(R.drawable.reno);
                playstatis=1;
                break;
        }
    }




    private void initList() {
        mList.add(new LiveTest("cctv1综合频道",CctvBean.CCTV1,CctvBean.PLAYURL_CCTV1,CctvBean.PLAYURL_CCTV1_SD));
        mList.add(new LiveTest("cctv2财经频道",CctvBean.CCTV2,CctvBean.PLAYURL_CCTV2,CctvBean.PLAYURL_CCTV2_SD));
        mList.add(new LiveTest("cctv3综艺频道",CctvBean.CCTV3,CctvBean.PLAYURL_CCTV3,CctvBean.PLAYURL_CCTV3_SD));
        mList.add(new LiveTest("cctv4亚洲频道",CctvBean.CCTV4,CctvBean.PLAYURL_CCTV4,CctvBean.PLAYURL_CCTV4_SD));
        mList.add(new LiveTest("cctv5体育频道",CctvBean.CCTV5,CctvBean.PLAYURL_CCTV5,CctvBean.PLAYURL_CCTV5_SD));
        mList.add(new LiveTest("cctv5+体育赛事",CctvBean.CCTV5_1,CctvBean.PLAYURL_CCTV5_1,CctvBean.PLAYURL_CCTV1_SD));
        mList.add(new LiveTest("cctv6电影频道",CctvBean.CCTV6,CctvBean.PLAYURL_CCTV6,CctvBean.PLAYURL_CCTV6_SD));
        mList.add(new LiveTest("cctv7国防军事",CctvBean.CCTV7,CctvBean.PLAYURL_CCTV7,CctvBean.PLAYURL_CCTV7_SD));
        mList.add(new LiveTest("cctv8电视剧",CctvBean.CCTV8,CctvBean.PLAYURL_CCTV8,CctvBean.PLAYURL_CCTV8_SD));
        mList.add(new LiveTest("cctv9纪录片",CctvBean.CCTV9,CctvBean.PLAYURL_CCTV9,CctvBean.PLAYURL_CCTV9_SD));
        mList.add(new LiveTest("cctv10科教频道",CctvBean.CCTV10,CctvBean.PLAYURL_CCTV10,CctvBean.PLAYURL_CCTV10_SD));
        mList.add(new LiveTest("cctv11戏曲频道",CctvBean.CCTV11,CctvBean.PLAYURL_CCTV11,CctvBean.PLAYURL_CCTV11_SD));
        mList.add(new LiveTest("cctv12社会与法",CctvBean.CCTV12,CctvBean.PLAYURL_CCTV12,CctvBean.PLAYURL_CCTV12_SD));
        mList.add(new LiveTest("cctv13新闻频道",CctvBean.CCTV13,CctvBean.PLAYURL_CCTV13,CctvBean.PLAYURL_CCTV13_SD));
        mList.add(new LiveTest("cctv14少儿频道",CctvBean.CCTV14,CctvBean.PLAYURL_CCTV14,CctvBean.PLAYURL_CCTV14_SD));
        mList.add(new LiveTest("cctv15音乐频道",CctvBean.CCTV15,CctvBean.PLAYURL_CCTV15,CctvBean.PLAYURL_CCTV15_SD));
        mList.add(new LiveTest("cctv17农村农业",CctvBean.CCTV17,CctvBean.PLAYURL_CCTV17,CctvBean.PLAYURL_CCTV17_SD));
    }


    private void GotoPlayer(int i) {
        LiveTest liveTest=mList.get(i);
        Intent intent =new Intent(this, PlayerActivity.class);
        intent.putExtra("isLive",true);
        intent.putExtra("playurl",playstatis==0?liveTest.getPlayurl_sd():liveTest.getPlayurl());
        startActivity(intent);
    }


    @Override
    protected void initDate() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_livelist;
    }

    class LiveAdapter extends RecyclerView.Adapter<LiveAdapter.LiveHodler> {
        List<LiveTest> list;

        LiveAdapter(List<LiveTest> list){
            this.list=list;
        }


        @NonNull
        @Override
        public LiveHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new LiveHodler(LayoutInflater.from(AlbumLiveListActivity.this).inflate(R.layout.live_item_layout,null));
        }

        @Override
        public void onBindViewHolder(@NonNull LiveHodler holder, final int position) {
            Glide.with(AlbumLiveListActivity.this).load(list.get(position).getImgurl()).into(holder.imageView);
            holder.name.setText(list.get(position).getName());
            View parView= (View) holder.imageView.getParent();
            parView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    GotoPlayer(position);

                }
            });
        }



        @Override
        public int getItemCount() {
            return list.size();
        }
        class LiveHodler extends RecyclerView.ViewHolder{

            ImageView imageView;
            TextView name;
            public LiveHodler(@NonNull View itemView) {
                super(itemView);
                imageView=itemView.findViewById(R.id.imagecctv);
                name=itemView.findViewById(R.id.livename);
            }
        }
    }



    class LiveTest{
        String name;
        String imgurl;
        String playurl;
        String playurl_sd;
        public LiveTest(String name, String imgurl, String playurl,String playurl_sd) {
            this.name = name;
            this.playurl_sd=playurl_sd;
            this.imgurl = imgurl;
            this.playurl = playurl;
        }

        public String getPlayurl_sd() {
            return playurl_sd;
        }

        public void setPlayurl_sd(String playurl_sd) {
            this.playurl_sd = playurl_sd;
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

        public String getPlayurl() {
            return playurl;
        }

        public void setPlayurl(String playurl) {
            this.playurl = playurl;
        }
    }
}
