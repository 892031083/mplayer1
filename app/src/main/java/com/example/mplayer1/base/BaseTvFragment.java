package com.example.mplayer1.base;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.mplayer1.R;

public abstract class BaseTvFragment extends Fragment {
    protected SwipeRefreshLayout Resview;
    private boolean isReshing=false;//是否正在刷新
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Resview.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        Resview.addView(inflater.inflate(getLayoutId(),null));
        initDate();
        initView();
        initRefreshView();
        return Resview;

    }

    protected  void initRefreshView(){
        ((SwipeRefreshLayout) Resview).setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                OntoRefresh();
                isReshing=true;
            }
        });
    }

    protected  void RefreshEnd(){
        ((SwipeRefreshLayout)Resview).setRefreshing(false);
        isReshing=false;
    };//刷新完毕时调用

    protected abstract void OntoRefresh();//刷新时调用

    protected abstract void initDate();

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected <T extends View> T bindViewId(int resid){
        T t=Resview.findViewById(resid);
        return t;
    }

}