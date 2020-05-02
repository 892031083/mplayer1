package com.example.mplayer1.home.navfrag;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mplayer1.PlayerActivity;
import com.example.mplayer1.R;
import com.example.mplayer1.base.BaseFragment;
import com.example.mplayer1.base.DataBaseHelper;
import com.example.mplayer1.home.HistoryActivity;
import com.example.mplayer1.home.HomeActivity;
import com.example.mplayer1.home.UserActivity;
import com.example.mplayer1.recom.ReBean;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MeFragment extends BaseFragment {
    private NavigationView navigationView;
    private static final String TITLE_TEXT="我的";

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    @Override
    protected void initDate() {
        ((HomeActivity)getActivity()).setTitleText(TITLE_TEXT);
        //((HomeActivity)getActivity()).goneTitle(View.GONE);
        ((HomeActivity)getActivity()).ThisTITLE_id=HomeActivity.ME_FRAMENT_ID;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_me;
    }
    //TODO
    InfoAdapter infoAdapter;
    @Override
    protected void initView() {
        recyclerView=bindViewId(R.id.rectview);
        layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);//横向滑动
        recyclerView.setLayoutManager(layoutManager);
        navigationView=bindViewId(R.id.nav_view);
        initSql(1);
        infoAdapter=new InfoAdapter(mList,getActivity());

        recyclerView.setAdapter(infoAdapter);

        infoAdapter.setOnItemclickInfo(new InfoAdapter.OnItemclickInfo() {
            @Override
            public void onclick(int i) {
                GotoPlayer(i);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                String title= (String) menuItem.getTitle();
                if (title!=null&&!"".equals(title)){
                    if (title.equals(getString(R.string.menu_home))){//首页

                    }else if(title.equals(getString(R.string.menu_history))){//历史记录
                        startActivity(new Intent(getActivity(), HistoryActivity.class));
                    }else if (title.equals(getString(R.string.menu_keep))){//收藏

                    }else if (title.equals(getString(R.string.menu_gaymy))){//应用信息
                        startActivity(new Intent(getActivity(), UserActivity.class));
                    }else {//参数设置

                    }
                }
                return false;
            }
        });
    }

    private void GotoPlayer(int i) {
        Intent intent=new Intent(getActivity(), PlayerActivity.class);
        intent.putExtra("playurl",mList.get(i).getPlayurl());
        startActivity(intent);
    }
    List<ReBean> mList;
    private void initSql(int t) {
        mList=new ArrayList<>();
        DataBaseHelper dataBaseHelper=new DataBaseHelper(this.getActivity(),"hou_db",null,1);

        SQLiteDatabase db5 = dataBaseHelper.getWritableDatabase();
        //创建游标对象
//                Cursor cursor = db5.query("player",null, null, null, null, null, null);
        Cursor cursor=db5.rawQuery("select * from player where  type=40 order by type desc",null);
        List<ReBean> lists=new ArrayList<>();
        while(cursor.moveToNext()){
            String playurl = cursor.getString(cursor.getColumnIndex("playurl"));
            String name=cursor.getString(cursor.getColumnIndex("name"));
            String imgurl=cursor.getString(cursor.getColumnIndex("imgurl"));
            int type=cursor.getInt(cursor.getColumnIndex("type"));
            lists.add(new ReBean(name,imgurl,playurl,type));
            Log.e("=========",imgurl);
        }
        mList=lists;

    }
}
