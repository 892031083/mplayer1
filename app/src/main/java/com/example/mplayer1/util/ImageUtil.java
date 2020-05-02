package com.example.mplayer1.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.example.mplayer1.R;
import com.example.mplayer1.home.HomeActivity;

import cn.refactor.lib.colordialog.ColorDialog;
import cn.refactor.lib.colordialog.PromptDialog;

public class ImageUtil  {

    public static ImageView getImageView(int ResId, Context context){
        ImageView imageView=new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(ResId);
        return imageView;
    }

    public static View getLayoutView(int ResId, Context context){
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        return  layoutInflater.inflate(ResId,null);
    }

    public static void getErrorAlertDialog(@NonNull Context context, String title){

        new PromptDialog(context)
                .setDialogType(PromptDialog.DIALOG_TYPE_WRONG)
                .setAnimationEnable(true)
                .setTitleText("error")
                .setContentText(title)
                .setPositiveListener("确定", new PromptDialog.OnPositiveListener() {
                    @Override
                    public void onClick(PromptDialog promptDialog) {
                            promptDialog.dismiss();
                    }
                })
                .show();

    }
}
