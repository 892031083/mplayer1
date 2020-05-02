package com.example.mplayer1;

import android.Manifest;
import android.app.Activity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.mplayer1.base.BaseActivity;
import com.example.mplayer1.base.DataBaseHelper;
import com.example.mplayer1.home.HomeActivity;
import com.example.mplayer1.music.ServiceToutil;
import com.example.mplayer1.recom.ReBean;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class StartupActivity extends BaseActivity {

    mHandler mHandler=new mHandler(this);

    static class mHandler extends Handler{
        private final WeakReference<Activity> mactivity;
        mHandler(Activity activity){
            this.mactivity = new WeakReference<Activity>(activity);
        }
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Activity activity=mactivity.get();
            if (ServiceToutil.getInstance().getMediaPlayer().isPlaying()){
                activity.startActivity(new Intent(activity, HomeActivity.class));
            }else {
                activity.startActivity(new Intent(activity, GuideActivity.class));
            }
            activity.finish();
        }
    }

    private void start() {

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mHandler.sendEmptyMessage(100);
            }
        },1800);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //无title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //全屏
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,
                WindowManager.LayoutParams. FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_startup);
//        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){
//            //透明状态栏
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        //透明导航栏
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//        }

        if (Build.VERSION.SDK_INT >= 23) {//6.0才用动态权限
            initPermission();
        }

        //initSql();

    }

    private void initSql() {
            List<ReBean> mList=ReBean.CreateListRe2();
            for (int i=0;i<mList.size();i++){
            ContentValues values = new ContentValues();
            //像ContentValues中存放数据
            values.put("name", mList.get(i).getName());
            values.put("imgurl", mList.get(i).getImgurl());
            values.put("playurl", mList.get(i).getPlayurl());

            values.put("type",40);
            DataBaseHelper dataBaseHelper=new DataBaseHelper(this,"hou_db",null,1);
            SQLiteDatabase db3 = dataBaseHelper.getWritableDatabase();
            //数据库执行插入命令
            db3.insert("player", null, values);
        }
    }


    //申请两个权限，录音和文件读写
    //1、首先声明一个数组permissions，将需要的权限都放在里面
    String[] permissions = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE};
    //2、创建一个mPermissionList，逐个判断哪些权限未授予，未授予的权限存储到mPerrrmissionList中
    List<String> mPermissionList = new ArrayList<>();

    private final int mRequestCode = 100;//权限请求码


    //权限判断和申请
    private void initPermission() {

        mPermissionList.clear();//清空没有通过的权限

        //逐个判断你要的权限是否已经通过
        for (int i = 0; i < permissions.length; i++) {
            if (ContextCompat.checkSelfPermission(this, permissions[i]) != PackageManager.PERMISSION_GRANTED) {
                mPermissionList.add(permissions[i]);//添加还未授予的权限
            }
        }

        //申请权限
        if (mPermissionList.size() > 0) {//有权限没有通过，需要申请
            ActivityCompat.requestPermissions(this, permissions, mRequestCode);
        }else{
            //说明权限都已经通过，可以做你想做的事情去
            start();
        }
    }


    //请求权限后回调的方法
    //参数： requestCode  是我们自己定义的权限请求码
    //参数： permissions  是我们请求的权限名称数组
    //参数： grantResults 是我们在弹出页面后是否允许权限的标识数组，数组的长度对应的是权限名称数组的长度，数组的数据0表示允许权限，-1表示我们点击了禁止权限
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        boolean hasPermissionDismiss = false;//有权限没有通过
        Log.e("StartupActivity",grantResults+"");
        if (mRequestCode == requestCode) {
            for (int i = 0; i < grantResults.length; i++) {
                Log.e("StartupActivity",grantResults[i]+"");
                if (grantResults[i] == -1) {
                    hasPermissionDismiss = true;
                }
            }

            //如果有权限没有被允许
            if (hasPermissionDismiss) {
                showPermissionDialog();//跳转到系统设置权限页面，或者直接关闭页面，不让他继续访问
            }else{
                //全部权限通过，可以进行下一步操作。。。
                start();
            }
        }

    }


    /**
     * 不再提示权限时的展示对话框
     */
    AlertDialog mPermissionDialog;
    String mPackName = "com.huawei.liwenzhi.weixinasr";

    private void showPermissionDialog() {
        if (mPermissionDialog == null) {
            mPermissionDialog = new AlertDialog.Builder(this)
                    .setMessage("已禁用权限，请手动授予")
                    .setPositiveButton("设置", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            cancelPermissionDialog();

                            Uri packageURI = Uri.parse("package:" + mPackName);
                            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, packageURI);
                            startActivity(intent);
                        }
                    })
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //关闭页面或者做其他操作
                            cancelPermissionDialog();

                        }
                    })
                    .create();
        }
        mPermissionDialog.show();
    }

    //关闭对话框
    private void cancelPermissionDialog() {
        mPermissionDialog.cancel();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
    }

    @Override
    protected void onPause() {
        super.onPause();
     //   mHandler.removeCallbacksAndMessages(null);
    }

    /**
     * 全屏操作
     * @param hasFocus
     */
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }

    }

    @Override
    public void onBackPressed() {

    }
}
