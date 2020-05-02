package com.example.mplayer1.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

public abstract class HomeBaseActivity extends BaseActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initDate();
        initView();
    }

    protected abstract void initView();

    protected abstract void initDate();

    protected abstract int getLayoutId();

    protected <T extends View> T bindViewId(int ResId){

        return (T)findViewById(ResId);
    }

    protected void setSupportActionBar(){
        
    }
}
