package com.example.mplayer1.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.mplayer1.R;

public abstract class DateBaseActivity extends BaseActivity {

    ImageView outbtn;
    private LinearLayout onload;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater=getLayoutInflater();
        ViewGroup view= (ViewGroup) inflater.inflate(R.layout.top_toolbar2,null);//头
        view.addView(inflater.inflate(getLayoutId(),null));
        setContentView(view);
        onload=view.findViewById(R.id.onloading);
        IsOnloading(isload());
        initDate();
        initView();
        initThisView();

    }

    protected void IsOnloading(boolean is){
        if (is){
            initAnim();
            onload.setVisibility(View.VISIBLE);
        }else {
            onload.setVisibility(View.GONE);
        }
    }
    protected abstract boolean isload();
    private void initAnim() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
        (findViewById(R.id.tolodinganim)).startAnimation(animation);//開始动画
    }

    protected  void initThisView(){
        outbtn=findViewById(R.id.outbtn);
        outbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    protected void setTitleText(String title){
        ((TextView)findViewById(R.id.titleText)).setText(title);
    }


    protected abstract void initView();

    protected abstract void initDate();

    protected abstract int getLayoutId();

    protected <T extends View> T bindViewId(int ResId){

        return (T)findViewById(ResId);
    }

}
