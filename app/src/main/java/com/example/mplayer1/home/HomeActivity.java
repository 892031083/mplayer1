package com.example.mplayer1.home;

import android.content.Intent;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.mplayer1.GuaActivity;
import com.example.mplayer1.R;
import com.example.mplayer1.base.HomeBaseActivity;
import com.example.mplayer1.home.navfrag.HomeFragment;
import com.example.mplayer1.music.MsplayActivity;
import com.example.mplayer1.music.MusicService;
import com.example.mplayer1.music.ServiceToutil;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;


public class HomeActivity extends HomeBaseActivity implements View.OnClickListener {

    public static final int HOME_FRAMENT_ID=1;
    public static final int INFO_FRAMENT_ID=2;
    public static final int ME_FRAMENT_ID=3;
    private TextView test;
    public static int tylpsd=0;
    public int ThisTITLE_id=1;
    private DrawerLayout mDrawerLayout;
    private ImageView titleAvatar;
    private NavigationView navigationView;
    private MenuItem mMenuItem;
    private FragmentManager fragmentManager;
    private BottomNavigationView navView;//底部按钮
    private HomeFragment mResulrFragment;
    @Override
    protected void initView() {
        
        mDrawerLayout=bindViewId(R.id.drawer);
        navigationView=bindViewId(R.id.nav_view);
        titleAvatar=bindViewId(R.id.avatar);
        titleAvatar.setOnClickListener(this);
        mMenuItem=navigationView.getMenu().getItem(0);
        mMenuItem.setCheckable(true);

        navView = findViewById(R.id.btn_view);
        handlenavigationViewItem();
        initFragment();
//        navigationView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(HomeActivity.this,UserActivity.class));
//
//            }
//        });
//        findViewById(R.id.imageView).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                lalalalalalalalalalalalalalalalalalalalalalalalalalalalalala
//            }
//        });
    }


    long backtime=0;//上次点击返回键的时间
    //两次返回键退出
    @Override
    public void onBackPressed() {
        if (ThisTITLE_id==1) {
            if (System.currentTimeMillis() - backtime < 2000) {
                if (!ServiceToutil.getInstance().getMediaPlayer().isPlaying()) {
                    stopService(new Intent(this, MusicService.class));
                }
                finish();
            } else {
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                backtime = System.currentTimeMillis();
            }
        }
    }
//    @Override
//    public void onBackPressed() {
//        Toast toast= Toast.makeText(this,"Toast提示消息",Toast.LENGTH_SHORT);
//        if (ThisTITLE_id==1){
//
//            ColorDialog colorDialog= new ColorDialog(this);
//            colorDialog.setTitle("通知");
//            colorDialog.setContentText("即将要退出此应用，您确定要这么做吗?");
//            colorDialog.setAnimationEnable(true);
//
//            colorDialog.setPositiveListener("确定", new ColorDialog.OnPositiveListener() {
//                @Override
//                public void onClick(ColorDialog dialog) {
//                    HomeActivity.super.onBackPressed();
//                    dialog.dismiss();
//                }
//            })
//                    .setNegativeListener("取消", new ColorDialog.OnNegativeListener() {
//                        @Override
//                        public void onClick(ColorDialog dialog) {
//
//                            dialog.dismiss();
//                        }
//                    }).show();
//        }else {
//            super.onBackPressed();
//        }
//
//
//    }

    private void initFragment() {
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();


        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
  //      NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
//        mResulrFragment= FragmentManagerWrapper.getInstance().createFragment(HomeFragment.class,true);
 //       mResulrFragment=new HomeFragment();

    }

    private void handlenavigationViewItem(){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                if (mMenuItem!=null){
                    mMenuItem.setCheckable(false);
                }

                Log.e("sssssssssss",""+menuItem.getTitle());

                String title= (String) menuItem.getTitle();
                if (title!=null&&!"".equals(title)){
                    if (title.equals(getString(R.string.menu_home))){//首页

                    }else if(title.equals(getString(R.string.menu_history))){//历史记录
                        startActivity(new Intent(HomeActivity.this,HistoryActivity.class));
                    }else if (title.equals(getString(R.string.menu_keep))){//收藏

                    }else if (title.equals(getString(R.string.menu_gaymy))){//应用信息
                        startActivity(new Intent(HomeActivity.this,UserActivity.class));
                    }else if (title.equals("设置")){//参数设置
                        startActivity(new Intent(HomeActivity.this,UserActivity.class));
                    }else{
                        startActivity(new Intent(HomeActivity.this,WebpullActivity.class));
                    }
                }

                //TODO
                mDrawerLayout.closeDrawer(Gravity.LEFT);

                mMenuItem=menuItem;

                return false;
            }
        });
    }

    @Override
    protected void initDate() {
        //TODO test
        findViewById(R.id.addbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("SSS","SSS");
                //TODO
                HomeActivity.this.startActivity(new Intent(HomeActivity.this, GuaActivity.class));

            }
        });
        //如果正在播放音乐
        if (ServiceToutil.getInstance().getMediaPlayer().isPlaying()){
            startActivity(new Intent(this, MsplayActivity.class));
        }
    }
    public void setTitleText(String titleText){
        ((TextView)findViewById(R.id.titleText)).setText(titleText);
    }
    public void goneTitle(int Res){
        (findViewById(R.id.inc)).setVisibility(Res);
    }
    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.avatar:
                mDrawerLayout.openDrawer(Gravity.LEFT);
                break;
        }
    }
}
