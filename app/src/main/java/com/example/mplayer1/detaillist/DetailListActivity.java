package com.example.mplayer1.detaillist;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mplayer1.R;
import com.example.mplayer1.base.BaseActivity;
import com.example.mplayer1.base.DateBaseActivity;
import com.example.mplayer1.base.HomeBaseActivity;
import com.example.mplayer1.detaillist.bean.ViedoBeanTest;
import com.example.mplayer1.detaillist.listener.ResultAlubm;
import com.example.mplayer1.home.bean.Channel;
import com.example.mplayer1.mview.PullLoadRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DetailListActivity extends DateBaseActivity  implements DetaListAdapter.OnClickItemISLitener {
    public static final String TAG="DetailListActivity";
    public static final int PAGE_SIZE=21;
    private int chnnel_id;
    private Channel channel;
    private RecyclerView recyclerView;
    GridLayoutManager mLayoutManager;
    PullLoadRecyclerView pullLoadRecyclerView;
    private DetailListViewModel detailListViewModel;
    private DetaListAdapter detaListAdapter;
    private List<ResultAlubm> list;//元数据
    private int pageOn=0;

    @Override
    protected boolean isload() {
        return true;
    }

    //    Handler handler=new Handler(){
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            DetailListActivity.this.bindViewId(R.id.onloading).setVisibility(View.GONE);
//        }
//    };
    @Override
    protected void initView() {
        chnnel_id=getIntent().getIntExtra("channel_id",0);
        channel=new Channel(chnnel_id);//初始化Channel

        setTitleText(getString(Channel.getTitleRes(chnnel_id)));//设置标题
        //((TextView)bindViewId(R.id.ttt)).setText(Channel.getTitleRes(getIntent().getIntExtra("channel",0)));
        pullLoadRecyclerView=bindViewId(R.id.pull_load_view);
        recyclerView=findViewById(R.id.recycler_view);
        mLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(mLayoutManager);
        list=new ArrayList<>();
        detaListAdapter=new DetaListAdapter(list,this);
        recyclerView.setAdapter(detaListAdapter);

        //处理model的数据
        detailListViewModel= ViewModelProviders.of(this).get(DetailListViewModel.class);//创建
        detailListViewModel.getResource(pageOn,DetailListActivity.PAGE_SIZE,channel,DetailListViewModel.DOING_CREATE);
        detailListViewModel.getMutableLiveData().observe(this, new Observer<List<ResultAlubm>>() {//监听数据变化时
            @Override
            public void onChanged(List<ResultAlubm> mResultAlubm) {

                list=mResultAlubm;
                detaListAdapter.setmList(list);
                detaListAdapter.notifyDataSetChanged();
                //验证操作 通知空间刷新完毕
                if (detailListViewModel.getDoings()==DetailListViewModel.DOING_LOAD){//上啦加载 完毕时
                    pullLoadRecyclerView.setLoad(false);
                }else if(detailListViewModel.getDoings()==DetailListViewModel.DOING_RESH){//下拉刷新完毕时 通知
                    pullLoadRecyclerView.setRefresh(false);
                }else if (detailListViewModel.getDoings()==DetailListViewModel.DOING_CREATE){//第一次加载完成，隐藏正在加载的文本
//                    handler.postDelayed(new Runnable() {//这里用一个定时器
//                        @Override
//                        public void run() {
//                            handler.sendEmptyMessage(100);
//                        }
//                    },1000);
                  //  DetailListActivity.this.bindViewId(R.id.onloading).setVisibility(View.GONE);
                    IsOnloading(false);
                }
            }
        });


        pullLoadRecyclerView.setOnDateLoadListener(new PullLoadRecyclerView.OnDateLoadListener() {//下拉加载
            @Override
            public void onLoad() {
                //加载更多
                Log.e(TAG,"**********");
                pageOn+=DetailListActivity.PAGE_SIZE;//页数增加
                detailListViewModel.getResource(pageOn,DetailListActivity.PAGE_SIZE,channel,DetailListViewModel.DOING_LOAD);
            }
        });

        pullLoadRecyclerView.setOnDateRefreshListener(new PullLoadRecyclerView.OnDateRefreshListener() {//下拉刷新
            @Override
            public void onRefresh() {
                Log.e(TAG,"**********5");
                pageOn=0;
                detailListViewModel.getResource(pageOn,DetailListActivity.PAGE_SIZE,channel,DetailListViewModel.DOING_RESH);

            }
        });

        detaListAdapter.setOnClickItemISLitener(this);
    }



    @Override
    protected void initDate() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_detaillist;
    }

    public static void toDetaillisetActivity(Context context){

        context.startActivity(new Intent(context,DetailListActivity.class));
    }

    @Override
    public void onclick(ResultAlubm resultAlubm) {//此处处理item点击事件
        //TODO
        Intent intent=new Intent(this,AlbumDetailActivity.class);
        Log.e("*******=======****",resultAlubm.getAlbumId()+"");

        intent.putExtra("albumID",resultAlubm.getAlbumId());
        intent.putExtra("chnnel_id",chnnel_id);
        startActivity(intent);
    }
}
