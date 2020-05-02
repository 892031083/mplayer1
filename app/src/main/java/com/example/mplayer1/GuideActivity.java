package com.example.mplayer1;

import android.content.Intent;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.mplayer1.base.BaseActivity;
import com.example.mplayer1.home.HomeActivity;
import com.example.mplayer1.util.ImageUtil;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends BaseActivity {

    private static final String TAG="GuideActivitiy";
    private ViewPager mViewPager;

    private List<View> mlist;
    private ImageView[] imageViews;
    private int mListPosition=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
        initViewPager();
        initDots();
    }

    private void initDots() {
        imageViews=new ImageView[]{
        findViewById(R.id.dot1),
        findViewById(R.id.dot2),
        findViewById(R.id.dot3)
        };
        imageViews[1].setEnabled(false);
        imageViews[2].setEnabled(false);
    }
    private void setCurrentDotPosition(int position){
        if (position==mListPosition) return;
        imageViews[position].setEnabled(true);
        imageViews[mListPosition].setEnabled(false);
        mListPosition=position;
    }

    private void initView() {
        mlist=new ArrayList<>();
        mlist.add(ImageUtil.getImageView(R.mipmap.startup1,this));
        mlist.add(ImageUtil.getImageView(R.mipmap.startup,this));
        mlist.add(ImageUtil.getLayoutView(R.layout.view_on3,this));
    }


    private void initViewPager() {
        mViewPager=findViewById(R.id.viewpager);

        mViewPager.setAdapter(new PagerAdapter() {//适配
            @Override
            public int getCount() {
                if (mlist!=null){
                    return mlist.size();
                }
                return 0;
            }
            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                if (mlist!=null)
                {
                    container.removeView(mlist.get(position));
                }
            }
            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                container.addView(mlist.get(position));
                if (position==mlist.size()-1){
                    ImageView imageView=mlist.get(position).findViewById(R.id.goHome);
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startHomeActivity();
                        }
                    });
                }
                return mlist.get(position);
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == object;
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.e(TAG,"onPageScrolled");
            }

            @Override
            public void onPageSelected(int position) {
                Log.e(TAG,"onPageSelected");
                setCurrentDotPosition(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.e(TAG,"onPageScrollStateChanged");
            }
        });
    }

    private void startHomeActivity() {
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }

}
