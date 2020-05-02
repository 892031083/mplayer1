package com.example.mplayer1.home;

import android.content.Intent;
import android.util.Log;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mplayer1.R;
import com.example.mplayer1.base.DateBaseActivity;
import com.example.mplayer1.detaillist.AlbumDetailActivity;
import com.example.mplayer1.detaillist.DetailListViewModel;
import com.example.mplayer1.detaillist.listener.ResultAlubm;
import com.example.mplayer1.home.bean.Channel;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends DateBaseActivity implements HistoryAdapter.OnItemClick {
    RecyclerView recyclerView;
    private DetailListViewModel viewModel;
    List<ResultAlubm> mList;
    private HistoryAdapter historyAdapter;
    private GridLayoutManager gridLayoutManager;
    private static String TAG="历史纪录";


    @Override
    protected boolean isload() {
        return true;
    }

    @Override
    protected void initView() {
        setTitleText(TAG);
        mList=new ArrayList<>();
        recyclerView=findViewById(R.id.recycler_view);
        gridLayoutManager=new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(gridLayoutManager);
        viewModel= ViewModelProviders.of(this).get(DetailListViewModel.class);
        viewModel.getResource(0,10,new Channel(2),DetailListViewModel.DOING_CREATE);
        viewModel.getMutableLiveData().observe(this, new Observer<List<ResultAlubm>>() {
            @Override
            public void onChanged(List<ResultAlubm> resultAlubms) {
                mList=resultAlubms;
                historyAdapter=new HistoryAdapter(HistoryActivity.this,mList);
                recyclerView.setAdapter(historyAdapter);
                historyAdapter.setOnItemClick(HistoryActivity.this);
                IsOnloading(false);
            }
        });
    }

    @Override
    protected void initDate() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_history;
    }


    @Override
    public void onClick(int i) {
        Intent intent=new Intent(this, AlbumDetailActivity.class);
        //Log.e("*******=======****",resultAlubm.getAlbumId()+"");
        ResultAlubm resultAlubm=mList.get(i);
        intent.putExtra("albumID",resultAlubm.getAlbumId());
        intent.putExtra("chnnel_id",3);

        startActivity(intent);
    }
}
