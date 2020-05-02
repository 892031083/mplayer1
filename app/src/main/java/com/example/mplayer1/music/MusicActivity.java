package com.example.mplayer1.music;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.ColorStateList;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.AdapterView;
import android.widget.Button;

import android.widget.ImageView;
import android.widget.ListView;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mplayer1.R;
import com.example.mplayer1.base.BaseActivity;
import com.example.mplayer1.detaillist.AlbumDetailActivity;
import com.example.mplayer1.detaillist.DetailListActivity;
import com.example.mplayer1.detaillist.listener.ResultAlubm;
import com.example.mplayer1.home.bean.Channel;
import com.example.mplayer1.music.beaninfo.MusicBean;

import java.util.List;

public class MusicActivity extends BaseActivity implements View.OnClickListener {
    List<MusicBean> list;

    private ListView listView;
    private RecyclerView recyclerView;
    private MusicModel musicModel;
    private List<ResultAlubm> mList;
    private ServiceToutil serviceToutil;
    private Button playbtn,xiabtn,linbtn;
//    View mp;
    //ImageButton mpbtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView();
        initDate();
    }

    protected void initView() {
        //mpbtn=findViewById(R.id.mpbtn);

        list=MusicBean.getMusicList();
        recyclerView=findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);//横向滑动
        recyclerView.setLayoutManager(layoutManager);
        musicModel= ViewModelProviders.of(this).get(MusicModel.class);
        musicModel.getResource(0,10,new Channel(5),MusicModel.DOING_CREATE);
        musicModel.mutableLiveData.observe(this, new Observer<List<ResultAlubm>>() {
            @Override
            public void onChanged(List<ResultAlubm> list) {
                mList=list;
                recyclerView.setAdapter(new MusicAdapter(mList));
            }
        });

        listView=findViewById(R.id.listview);
        listView.setAdapter(new MusicList(list,this));
        //mp=findViewById(R.id.music_play);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                toPlayMs(list.get(position).getPlayurl());
                setListItemLayout(view);
            }
        });

        findViewById(R.id.toshem).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MusicActivity.this, DetailListActivity.class);
                intent.putExtra("channel_id",Channel.MUSIC);
                startActivity(intent);
            }
        });
        findViewById(R.id.outbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MusicActivity.this.onBackPressed();
            }
        });
        findViewById(R.id.bt_mk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mp.setVisibility(View.VISIBLE);
//                Animation animation=AnimationUtils.loadAnimation(MusicActivity.this,R.anim.anim_in_msview);
//                mp.setAnimation(animation);
//                animation.start();
                startActivity(new Intent(MusicActivity.this,MsplayActivity.class));
                overridePendingTransition(R.anim.anim_start_activity,R.anim.anim_out_activity);

            }
        });
//        mp.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return true;
//            }
//        });


        initPlayBtn();

    }
    View thisviewl;
    boolean isFirstClick=true;
    ColorStateList colorStateList;
    //item点击后的央视
    private void setListItemLayout(View view) {
        ImageView imageView=view.findViewById(R.id.img);
        TextView msname=view.findViewById(R.id.msName);
        TextView mszz=view.findViewById(R.id.msZZ);
        if (isFirstClick) {
            colorStateList = mszz.getTextColors();
            isFirstClick=false;
        }
        msname.setTextColor(getResources().getColor(R.color.recom_text_click));
        mszz.setTextColor(getResources().getColor(R.color.recom_text_click));
//        imageView.animate().rotation()
//        ObjectAnimator rotate = ObjectAnimator.ofFloat(imageView, "rotation", 0f, 360f).setDuration(500);
//        rotate.setInterpolator(new BounceInterpolator());
//        rotate.start();
//        rotate.setRepeatCount(ValueAnimator.INFINITE);//无限循环
        if (thisviewl!=null) {
            thisviewl.findViewById(R.id.img).clearAnimation();
            ((TextView)thisviewl.findViewById(R.id.msZZ)).setTextColor(colorStateList);
            ((TextView)thisviewl.findViewById(R.id.msName)).setTextColor(colorStateList);
//            thisviewl.animate().cancel();
            thisviewl.setRotation(0);
        }
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
        imageView.startAnimation(animation);

        thisviewl=view;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (serviceToutil!=null&&serviceToutil.getMediaPlayer()!=null){
            setBtnBg(serviceToutil.getMediaPlayer().isPlaying());
        }

    }

    private void initPlayBtn() {
        playbtn=findViewById(R.id.ms_btn_play);
        xiabtn=findViewById(R.id.ms_btn_xia);
        linbtn=findViewById(R.id.ms_btn_mls);
       // mpbtn.setOnClickListener(this);
        playbtn.setOnClickListener(this);
        xiabtn.setOnClickListener(this);
        linbtn.setOnClickListener(this);
      //  findViewById(R.id.ms_btn_xia).setOnClickListener(this);

    }
    boolean isplay=false;
    private void toPlayMs(String url) {
        serviceToutil.setPlayResource(this,R.raw.betf);

        serviceToutil.getMediaPlayer().setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                serviceToutil.getMediaPlayer().start();
                int sumtime=serviceToutil.getMediaPlayer().getDuration();//获取音乐时长
                setBtnBg(true);
                isplay=true;
               // seekBar.setEnabled(true);//可拖到
               // seekBar.setMax(sumtime);//设置最大值
                //sumTimeview.setText(PlayerModel.getTime(sumtime));
            }
        });

    }

    protected void toplaylerLayout(int i){
//        Intent intent=new Intent(this, PlayerActivity.class);
        Intent intent=new Intent(this, AlbumDetailActivity.class);
//        Log.e("*******=======****",resultAlubm.getAlbumId()+"");

        intent.putExtra("albumID",mList.get(i).getAlbumId());
        intent.putExtra("chnnel_id",5);
        startActivity(intent);
    }



    protected void initDate() {
        startService(new Intent(this,MusicService.class));
        serviceToutil=ServiceToutil.getInstance();
        setBtnBg(serviceToutil.getMediaPlayer().isPlaying());

    }

    MusicService.MyBinder binder = null;

    @Override
    public void onBackPressed() {
//        if (mp.getVisibility() == View.VISIBLE) {
////            mp.setVisibility(View.GONE);
////            Animation animationa=AnimationUtils.loadAnimation(this,R.anim.anim_out_activity);
////            mp.setAnimation(animationa);
////            animationa.start();
//        } else {
            super.onBackPressed();
//        }
    }

    protected int getLayoutId() {
        return R.layout.activity_music;
    }


    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ms_btn_play:
                playorpause();
                break;
            case R.id.ms_btn_xia:
                break;
            case R.id.ms_btn_mls:
                break;
            case R.id.mpbtn:
                playorpause();
                break;

        }
    }

    private void playorpause(){
        if (!isplay){
            toPlayMs("");
        }else{
            if (serviceToutil.getMediaPlayer().isPlaying()){
                serviceToutil.pasue();
                if (thisviewl!=null){
                    thisviewl.findViewById(R.id.img).clearAnimation();
                    thisviewl.findViewById(R.id.img).setRotation(0);
                }
                setBtnBg(false);
            }else{
                serviceToutil.getMediaPlayer().start();
                setBtnBg(true);
            }
        }
    }

    public void setBtnBg(boolean is){
        if (is){
            playbtn.setBackgroundResource(R.mipmap.ic_paus_ms);
           // mpbtn.setImageResource(R.mipmap.play_pasue2);
        }else {
            playbtn.setBackgroundResource(R.mipmap.icon_play_ms);
            //mpbtn.setImageResource(R.mipmap.play_play10);
        }
    }
    class MyServiceConn implements ServiceConnection {
        // 服务被绑定成功之后执行
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //service为onBind方法返回的Service实例
            binder = (MusicService.MyBinder) service;
        }

        // 服务奔溃或者被杀掉执行
        @Override
        public void onServiceDisconnected(ComponentName name) {
            binder = null;
        }
    }


    class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.Mholder> {
        List<ResultAlubm> alubms;
//        Context context;
        MusicAdapter(List<ResultAlubm> alubms){
            this.alubms=alubms;
        }

        @NonNull
        @Override
        public Mholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new Mholder(LayoutInflater.from(MusicActivity.this).inflate(R.layout.music_play_item,null));
        }

        @Override
        public void onBindViewHolder(@NonNull Mholder holder, final int position) {
            holder.textView.setText(alubms.get(position).getAlbumName());
            Glide.with(MusicActivity.this).load(alubms.get(position).getHorHighPic()).into(holder.imageView);
            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MusicActivity.this.toplaylerLayout(position);
                }
            });
        }



        @Override
        public int getItemCount() {
            return alubms.size();
        }
        class Mholder extends RecyclerView.ViewHolder{
            ImageView imageView;
            TextView textView;
            public Mholder(@NonNull View itemView) {
                super(itemView);
                imageView=itemView.findViewById(R.id.img);
                textView=itemView.findViewById(R.id.title);
            }
        }
    }
}
