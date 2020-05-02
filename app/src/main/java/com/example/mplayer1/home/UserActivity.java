package com.example.mplayer1.home;

import com.example.mplayer1.R;
import com.example.mplayer1.base.DateBaseActivity;

public class UserActivity extends DateBaseActivity {
    @Override
    protected boolean isload() {
        return false;
    }

    @Override
    protected void initView() {
        setTitleText("信息");
    }

    @Override
    protected void initDate() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_user;
    }
}
