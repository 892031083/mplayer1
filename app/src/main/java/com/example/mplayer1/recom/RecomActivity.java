package com.example.mplayer1.recom;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mplayer1.GuaActivity;
import com.example.mplayer1.PlayerActivity;
import com.example.mplayer1.R;
import com.example.mplayer1.base.DataBaseHelper;
import com.example.mplayer1.base.DateBaseActivity;

import java.util.ArrayList;
import java.util.List;

public class RecomActivity extends DateBaseActivity implements View.OnClickListener {

    private  RecyclerView recyclerView;
    private List<ChenrBean> mList;
    private TextView t1,t2;
    RecomItemAdapter adapter;
    private int type=0;

    @Override
    protected boolean isload() {
        return false;
    }

    @Override
    protected void initView() {
        //initSqlinsert();
        setTitleText("成人频道");
        mList=ChenrBean.OncreateCrLive(type);
        recyclerView=findViewById(R.id.rectview);
        t1=findViewById(R.id.tt1);t1.setOnClickListener(this);
        t2=findViewById(R.id.tt2);t2.setOnClickListener(this);

        adapter=new RecomItemAdapter(mList,this);
        //recyclerView.setAdapter();
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
        adapter.setOnClickItemISLitener(new RecomItemAdapter.OnClickItemISLitener() {
            @Override
            public void onclick(ChenrBean chenrBean) {
                GotoPlayer(chenrBean);
            }
        });
       InitTestSQl(3);
    }


    private void GotoPlayer(ChenrBean chenrBean) {
        Intent intent=new Intent(this, PlayerActivity.class);
        intent.putExtra("playurl",chenrBean.getPlayUrl());
        startActivity(intent);
    }

    @Override
    protected void initDate() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_recom;
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
                InitTestSQl(3);
                break;
            case R.id.tt2:
                t1.setTextColor(getResources().getColor(R.color.recom_text_clickno));
                t2.setTextColor(getResources().getColor(R.color.recom_text_click));
                t2.setBackgroundResource(R.drawable.defulpas);
                t1.setBackgroundResource(R.drawable.reno);
                InitTestSQl(4);
                break;
        }
    }

    private void setDateList(int t) {
     //   Log.e("//////////","3333333333333");
        if (type!=t){
            type=t;
            mList=ChenrBean.OncreateCrLive(type);
           // InitTestSQl(4);
            adapter.setmList(mList);
            adapter.notifyDataSetChanged();
        }
    }



    private void InitTestSQl(int t) {


        DataBaseHelper dataBaseHelper=new DataBaseHelper(this,"hou_db",null,1);

        SQLiteDatabase db5 = dataBaseHelper.getWritableDatabase();
        //创建游标对象
//                Cursor cursor = db5.query("player",null, null, null, null, null, null);
        Cursor cursor=db5.rawQuery("select * from player where type="+t ,null);
        List<ChenrBean> lists=new ArrayList<>();
        while(cursor.moveToNext()){
            String playurl = cursor.getString(cursor.getColumnIndex("playurl"));
            String name=cursor.getString(cursor.getColumnIndex("name"));
            String imgurl=cursor.getString(cursor.getColumnIndex("imgurl"));
            lists.add(new ChenrBean(name,imgurl,playurl));
        }
        mList=lists;

        adapter.setmList(mList);
        adapter.notifyDataSetChanged();
        //TODO
//        for (int i=0;i<mList.size();i++){
//            ContentValues values = new ContentValues();
//            //像ContentValues中存放数据
//            values.put("name", mList.get(i).getPlayNmae());
//            values.put("imgurl", mList.get(i).getPlayImg());
//            values.put("playurl", mList.get(i).getPlayUrl());
//
//            values.put("type",t);
//            DataBaseHelper dataBaseHelper=new DataBaseHelper(this,"hou_db",null,1);
//            SQLiteDatabase db3 = dataBaseHelper.getWritableDatabase();
//            //数据库执行插入命令
//            db3.insert("player", null, values);
//        }

    }

    private void initSqlinsert(){
        List<ReBean> list=ReBean.CreateListRe();
        for (int i=0;i<list.size();i++){
            ContentValues values = new ContentValues();
            //像ContentValues中存放数据
            values.put("name", list.get(i).getName());
            values.put("imgurl", list.get(i).getImgurl());
            values.put("playurl", list.get(i).getPlayurl());

            values.put("type",1);
            DataBaseHelper dataBaseHelper=new DataBaseHelper(this,"hou_db",null,1);
            SQLiteDatabase db3 = dataBaseHelper.getWritableDatabase();
            //数据库执行插入命令
            db3.insert("player", null, values);
        }
    }
}
