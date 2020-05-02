package com.example.mplayer1.detaillist;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.mplayer1.PlayerActivity;
import com.example.mplayer1.R;
import com.example.mplayer1.base.BaseActivity;
import com.example.mplayer1.base.DateBaseActivity;
import com.example.mplayer1.base.HomeBaseActivity;
import com.example.mplayer1.detaillist.api.SiteApi;
import com.example.mplayer1.detaillist.listener.ResultAlubmData;
import com.example.mplayer1.detaillist.listener.ResultVideos;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class AlbumDetailActivity extends DateBaseActivity implements View.OnClickListener {
    private static final String _TITLE="详情";

    private static final int SUPER=2;//超清
    private static final int HEGH=1;//高清
    private static final int NOR=0;//标清
    private int Sharpness=1;

    private Button btn1,btn2,btn3;
    private TextView albumName,album_ator,album_mainator,album_score,album_total;
    private ImageView album_image;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private long albumID=0;
    private int channel_id;
    private GridView gridView;
    List<View> mlist;
    private List<ResultVideos> mresvides;//视频列表
    private AlbumDetailViewModel albumDetailViewModel;

    @Override
    protected boolean isload() {
        return true;
    }

    @Override
    protected void initView() {
        setTitleText(_TITLE);
      initPager();
      initButton();
      initText();
      albumID=getIntent().getLongExtra("albumID",0);
      channel_id=getIntent().getIntExtra("chnnel_id",0);
      Log.e("aaaaaaa",albumID+"");
      albumDetailViewModel= ViewModelProviders.of(this).get(AlbumDetailViewModel.class);//获取model
      albumDetailViewModel.getResource(albumID);
      albumDetailViewModel.getVideoRes(albumID,0,100);
      albumDetailViewModel.getMutableLiveData().observe(this, new Observer<ResultAlubmData>() {
          @Override
          public void onChanged(ResultAlubmData resultAlubmData) {
              setData(resultAlubmData);
          }
      });

      albumDetailViewModel.getMutablelist().observe(this, new Observer<List<ResultVideos>>() {//监听视频列表
          @Override
          public void onChanged(List<ResultVideos> resultVideos) {
              mresvides=resultVideos;
              IsOnloading(false);
              setVideosData();
          }
      });

      albumDetailViewModel.getPlayurl().observe(this, new Observer<String>() {
          @Override
          public void onChanged(String s) {
              Intent intent=new Intent(AlbumDetailActivity.this, PlayerActivity.class);
              intent.putExtra("playurl",s);
              startActivity(intent);
          }
      });

    }



    private void initText() {
        albumName=bindViewId(R.id.album_Name);
        album_ator=bindViewId(R.id.album_ator);
        album_mainator=bindViewId(R.id.album_mainator);
        album_score=bindViewId(R.id.album_score);
        album_total=bindViewId(R.id.album_total);
        album_image=bindViewId(R.id.album_image);
    }

    private void setData(ResultAlubmData resultAlubmData) {
//        Log.e("****************",resultAlubmData.toString());
        albumName.setText(resultAlubmData.getAlbumName());

        album_ator.setText(resultAlubmData.getDirector()==null?"导演:未知":"导演:"+resultAlubmData.getDirector());
        album_mainator.setText(resultAlubmData.getMainActor()==null?"演员:未知":"演员:"+resultAlubmData.getMainActor());
        album_score.setText("评分:"+resultAlubmData.getScore()+"");
        album_total.setText(resultAlubmData.getUpdateNotification()==null?"":resultAlubmData.getUpdateNotification());
        Glide.with(this).load(resultAlubmData.getVerHighPic()).into(album_image);

        //设置简介
        textView.setPadding(30,30,30,0);
        textView.setText(resultAlubmData.getTvDesc());
        bindViewId(R.id.onloadingtext).setVisibility(View.GONE);
    }

    private void setVideosData() {
        gridView.setNumColumns(6);
        gridView.setVerticalSpacing(10);
        if (channel_id==4||channel_id==6||channel_id==5){
            gridView.setNumColumns(1);
        }
        gridView.setAdapter(new BaseAdapter() {

            @Override
            public int getCount() {
                return mresvides.size();
            }

            @Override
            public Object getItem(int position) {
                return position+1;
            }

            @Override
            public long getItemId(int position) {
                return position+1;
            }

            @Override
            public View getView(final int position, View convertView, ViewGroup parent) {
                Button button=new Button(AlbumDetailActivity.this);
                if (channel_id==4||channel_id==6||channel_id==5){
                    button.setText(mresvides.get(position).getVideo_name());
                }else if(channel_id==2){
                    button.setText("正片");
                }else {
                    //button.setBackgroundResource(R.drawable.deta_batn_background2);
                    button.setText((position+1)+"");
                }

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        GotoPlayer(position);
                    }
                });
                //button.setTag(1,list.get(position).get);
                return button;
            }
        });
    }

    private void GotoPlayer(int position) {
        albumDetailViewModel.getVideoPlayerUrl(mresvides.get(position).getAlbumId(),mresvides.get(position).getVid());
//        去播放界面
//        albumDetailViewModel.getPlayerUrl(mresvides.get(position).getAlbumId(),mresvides.get(position).getVid());

    }


    private void initButton() {
        Log.e("******","********");
        btn1=bindViewId(R.id.bq);
        btn2=bindViewId(R.id.gq);
        btn3=bindViewId(R.id.cq);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Log.e("******","********");
//       btn1.setEnabled(false);
//        btn2.setEnabled(false);
//        btn3.setEnabled(false);
        btn1.setBackgroundResource(R.drawable.deta_batn_background2);
        btn2.setBackgroundResource(R.drawable.deta_batn_background2);
        btn3.setBackgroundResource(R.drawable.deta_batn_background2);

        switch (v.getId()){
            case R.id.bq:
                Sharpness=AlbumDetailActivity.NOR;
                btn1.setBackgroundResource(R.drawable.deta_btn_background);
                break;
            case R.id.gq:
                Sharpness=AlbumDetailActivity.HEGH;
                btn2.setBackgroundResource(R.drawable.deta_btn_background);
                break;
            case R.id.cq:
                Sharpness=AlbumDetailActivity.SUPER;
                btn3.setBackgroundResource(R.drawable.deta_btn_background);
                break;
        }
    }
    private TextView textView;
    private void initPager() {
        viewPager=bindViewId(R.id.pagers);
        tabLayout=bindViewId(R.id.tabs);
        mlist=new ArrayList<>();

        gridView=new GridView(this);
        textView=new TextView(this);
        gridView.setNumColumns(6);

        mlist.add(gridView);
        mlist.add(textView);


        viewPager.setAdapter(new PagerAdapter() {//适配
            @Override
            public int getCount() {
                if (mlist!=null){
                    return mlist.size();
                }
                return 0;
            }
            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                if (mlist!=null)
                {
                    container.removeView(mlist.get(position));
                }
            }
            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                container.addView(mlist.get(position));

                return mlist.get(position);
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                if (position==0){
                    return "剧集";
                }else {
                    return "简介";
                }
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == object;
            }
        });


        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void initDate() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_detail;
    }


}
