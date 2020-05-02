package com.example.mplayer1.home.navfrag;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mplayer1.PlayerActivity;
import com.example.mplayer1.R;
import com.example.mplayer1.base.BaseFragment;
import com.example.mplayer1.base.DataBaseHelper;
import com.example.mplayer1.home.HomeActivity;
import com.example.mplayer1.mview.PullLoadRecyclerView;
import com.example.mplayer1.recom.ChenrBean;
import com.example.mplayer1.recom.ReBean;

import java.util.ArrayList;
import java.util.List;

public class InfoFragment extends BaseFragment{

    private static final String TITLE_TEXT="推荐";
    private PullLoadRecyclerView mPullview;
    private RecyclerView recyclerView;
    List<ReBean> mList;
    private InfoAdapter infoAdapter;
    private GridLayoutManager gridLayoutManager;

    @Override
    protected void initView() {
        mPullview=bindViewId(R.id.pullview);
        mList=new ArrayList<>();
        recyclerView=bindViewId(R.id.recycler_view);
        initSql(1);
        initPull();
        initAnim();
        if (HomeActivity.tylpsd==0){
            HomeActivity.tylpsd=1;
            initLoding();
        }

        gridLayoutManager=new GridLayoutManager(getActivity(),3);
        recyclerView.setLayoutManager(gridLayoutManager);
        infoAdapter=new InfoAdapter(mList,getActivity());

        recyclerView.setAdapter(infoAdapter);

        infoAdapter.setOnItemclickInfo(new InfoAdapter.OnItemclickInfo() {
            @Override
            public void onclick(int i) {
                GotoPlayer(i);
            }
        });
    }

    private void GotoPlayer(int i) {
        Intent intent=new Intent(getActivity(), PlayerActivity.class);
        intent.putExtra("playurl",mList.get(i).getPlayurl());
        startActivity(intent);
    }

    private void initAnim() {
        //tolodinganim
        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.rotate_anim);
        (bindViewId(R.id.tolodinganim)).startAnimation(animation);//開始动画
    }

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            (bindViewId(R.id.onloading)).setVisibility(View.GONE);
        }
    };

    private void initLoding() {
        (bindViewId(R.id.onloading)).setVisibility(View.VISIBLE);
        handler.postDelayed(new Runnable() {//这里用一个定时器
                        @Override
                        public void run() {
                            handler.sendEmptyMessage(100);
                        }
                    },1500);
    }

    private void initPull() {
        mPullview.setOnDateRefreshListener(new PullLoadRecyclerView.OnDateRefreshListener() {
            @Override
            public void onRefresh() {
                mPullview.setRefresh(false);
            }
        });
        mPullview.setOnDateLoadListener(new PullLoadRecyclerView.OnDateLoadListener() {
            @Override
            public void onLoad() {
                mPullview.setLoad(false);
            }
        });
    }

    private void initAdapter() {

    }

    private void initSql(int t) {
        DataBaseHelper dataBaseHelper=new DataBaseHelper(this.getActivity(),"hou_db",null,1);

        SQLiteDatabase db5 = dataBaseHelper.getWritableDatabase();
        //创建游标对象
//                Cursor cursor = db5.query("player",null, null, null, null, null, null);
        Cursor cursor=db5.rawQuery("select * from player where type="+t+" or type=40 order by type desc",null);
        List<ReBean> lists=new ArrayList<>();
        while(cursor.moveToNext()){
            String playurl = cursor.getString(cursor.getColumnIndex("playurl"));
            String name=cursor.getString(cursor.getColumnIndex("name"));
            String imgurl=cursor.getString(cursor.getColumnIndex("imgurl"));
            int type=cursor.getInt(cursor.getColumnIndex("type"));
            lists.add(new ReBean(name,imgurl,playurl,type));
        }
        mList=lists;

    }


    @Override
    protected void initDate() {
        ((HomeActivity)getActivity()).setTitleText(TITLE_TEXT);
       // ((HomeActivity)getActivity()).goneTitle(View.VISIBLE);
        ((HomeActivity)getActivity()).ThisTITLE_id=HomeActivity.INFO_FRAMENT_ID;
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_info;
    }
}
