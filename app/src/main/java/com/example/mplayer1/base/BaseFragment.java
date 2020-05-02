package com.example.mplayer1.base;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public abstract class BaseFragment extends Fragment {
    protected View Resview;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Resview=inflater.inflate(getLayoutId(),null);
        initDate();
        initView();
        Log.e("BaseFragment","======");
        return Resview;

    }

    protected abstract void initDate();

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected <T extends View> T bindViewId(int resid){
        T t=Resview.findViewById(resid);
        return t;
    }

}
