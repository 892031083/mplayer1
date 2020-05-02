package com.example.mplayer1.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListPopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mplayer1.GuideActivity;
import com.example.mplayer1.PlayerActivity;
import com.example.mplayer1.R;
import com.example.mplayer1.base.DateBaseActivity;
import com.example.mplayer1.detaillist.api.SiteApi;
import com.example.mplayer1.detaillist.listener.OnGetWebListener;
import com.example.mplayer1.recom.ChenrBean;
import com.example.mplayer1.recom.RecomItemAdapter;
import com.example.mplayer1.util.ImageUtil;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class WebpullActivity extends DateBaseActivity {
    @Override
    protected boolean isload() {
        return false;
    }
    public List<ChenrBean> list;
    int isbtn=0;
    private Button btn,xialaBtn;
    private EditText editText;
     TextView textView;
    private RecyclerView recyclerView;

    static class mHandler extends Handler{
        private final WeakReference<Activity> mactivity;
        mHandler(Activity activity){
            this.mactivity = new WeakReference<Activity>(activity);
        }
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            final WebpullActivity activity= (WebpullActivity) mactivity.get();
            GridLayoutManager gridLayoutManager=new GridLayoutManager(activity,2);
            RecyclerView recycler=activity.getRecyclerView();
            RecomItemAdapter recomItemAdapter=new RecomItemAdapter(activity.list, activity);
            recycler.setLayoutManager(gridLayoutManager);
            recycler.setAdapter(recomItemAdapter);
            recomItemAdapter.notifyDataSetChanged();
            activity.loadmk.setVisibility(View.GONE);
            activity.isbtn=0;
            recomItemAdapter.setOnClickItemISLitener(new RecomItemAdapter.OnClickItemISLitener() {
                @Override
                public void onclick(ChenrBean chenrBean) {
                    Log.e("CCCCCCCCC",chenrBean.getPlayUrl());

                    Intent intent=new Intent(activity, PlayerActivity.class);
                    intent.putExtra("playurl",chenrBean.getPlayUrl());

                    activity.startActivity(intent);
                }
            });
        }

    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }
    private mHandler handler;
     RelativeLayout loadmk;
    @Override
    protected void initView() {
        loadmk=findViewById(R.id.loadmk);
        handler=new mHandler(this);
        recyclerView=findViewById(R.id.recycler_view);
        btn=findViewById(R.id.web_btn);
        editText=findViewById(R.id.web_edit);

      btn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              String string=editText.getText().toString();
              if (string!=null&&!"".equals(string)&&isbtn!=1){
                  if (isWebUrl(string)){
                      Log.i("=====","aaaaaaa");
                      loadmk.setVisibility(View.VISIBLE);
                      isbtn=1;
                      toHttp(string);
                      return;
                  }
              }
                  ImageUtil.getErrorAlertDialog(WebpullActivity.this,"请输入正确网站 ");

          }
      });
      xialaBtn=findViewById(R.id.xiala);
      xialaBtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              showListPopulWindow();
          }
      });
    }

    private boolean isWebUrl(String str) {
        if (str.length()<10) return false;
        if (!str.substring(0,4).equals("http")) return false;
        return true;
    }

    private void toHttp(String url) {
        final SiteApi siteApi=new SiteApi();
        siteApi.onGetUrlWeb(url,new OnGetWebListener() {
            @Override
            public void OnSuccess(String html) {

                if (html==null ||html.length()<10||!checkHtmlStr(html)){
                    Log.i("=============","==========");
                    return;
                }
                String newstr=html.substring(html.indexOf("<ul>"),html.indexOf("</ul>"));
//
               getMainWeb(newstr);
               for (int i=0;i<list.size();i++){
                   try {
                       String tml=siteApi.onGetSnyUrlWeb(SiteApi.CHR_URL_WEB_MAIN+list.get(i).getWeburl());
                       // Log.i("API",tml);
                        list.get(i).setPlayUrl(getPlayWeb(tml));

                   } catch (IOException e) {
                       e.printStackTrace();
                   }
               }
                handler.sendEmptyMessage(0);
            }
        });
    }

    private boolean checkHtmlStr(String html) {
//        if (html.indexOf("<ul>")==-1
//        || html.indexOf("</ul>")==-1
//        ||html.indexOf("down_url")==-1
//        ||html.indexOf("com")==-1
//        ||html.indexOf("mp4")==-1
//        ||html.indexOf("<li>")==-1
//        ||html.indexOf("</li>")==-1
//        ||html.indexOf("src=")==-1
//        ||html.indexOf("<h3>")==-1
//        ||html.indexOf("href")==-1
//        ||html.indexOf("html")==-1){
//            return false;
//        }
        return true;
    }

    private String getPlayWeb(String tml) {
        String resstr="";
        tml=tml.substring(tml.indexOf("down_url"));
        tml=tml.substring(tml.indexOf("com")+3,tml.indexOf("mp4")+3);
//        if (tml.indexOf("https")!=-1){
//            tml="http"+tml.substring(5);
//        }
       // tml=tml
        //tml.replace("https","http");
        tml=SiteApi.CHR_URL_PLAY+tml;
        Log.i("APIS",tml);
        return tml;
    }

    private void getMainWeb(String newstr) {
        List<ChenrBean> mlist=new ArrayList<>();
        while (newstr.indexOf("<li>")!=-1){
            newstr=newstr.substring(newstr.indexOf("<li>")+3);
            //Log.i("APIS",newstr.substring(0,newstr.indexOf("</li>")));
            String imgurl=newstr.substring(newstr.indexOf("src=\"")+5,newstr.indexOf("/>")-2);
           // imgurl=imgurl.substring(imgurl.indexOf("com")+3);
            //imgurl=SiteApi.CHR_URL_PLAY+imgurl;
            Log.i("SSS",imgurl);
            mlist.add(new ChenrBean(
                    newstr.substring(newstr.indexOf("<h3>")+4,newstr.indexOf("</h3>")),
                    imgurl,
                    "",
                    newstr.substring(newstr.indexOf("href=")+6,newstr.indexOf("html")+4)
            ));
        }

        list=mlist;
    }
    private void showListPopulWindow() {
        final String[] list = {SiteApi.CHR_URL_WEB+"/Html/89/", SiteApi.CHR_URL_WEB+"/Html/87/",
                SiteApi.CHR_URL_WEB+"/Html/93/",SiteApi.CHR_URL_WEB+"/Html/90/",SiteApi.CHR_URL_WEB+"/Html/88/",SiteApi.CHR_URL_WEB+"/Html/91/"
        ,SiteApi.CHR_URL_WEB+"/Html/101/"};//要填充的数据
        final ListPopupWindow listPopupWindow;
        listPopupWindow = new ListPopupWindow(this);
        listPopupWindow.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, list));//用android内置布局，或设计自己的样式
        listPopupWindow.setAnchorView(editText);//以哪个控件为基准，在该处以mEditText为基准
        listPopupWindow.setModal(true);

        listPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() {//设置项点击监听
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                editText.setText(list[i]);//把选择的选项内容展示在EditText上
                listPopupWindow.dismiss();//如果已经选择了，隐藏起来
            }
        });
        listPopupWindow.show();//把ListPopWindow展示出来
    }

    @Override
    protected void initDate() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_webpull;
    }
}
