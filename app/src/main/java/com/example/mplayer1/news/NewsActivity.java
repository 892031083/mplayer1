package com.example.mplayer1.news;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mplayer1.R;
import com.example.mplayer1.base.DateBaseActivity;

import static android.view.KeyEvent.KEYCODE_BACK;

public class NewsActivity extends AppCompatActivity {
    private WebView webView;
    private static String url="https://xw.qq.com/m/football?pgv_ref=3gqtb&ADTAG=3gqtb";
    private ProgressBar progressBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    protected void initView() {
        progressBar=findViewById(R.id.progressBar1);
        webView=findViewById(R.id.webview);
        webView.loadUrl(url);
        webView.setWebViewClient(new MyWebViewClient());
        //自适应屏幕
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webView.getSettings().setLoadWithOverviewMode(true);

        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient(){//监听加载进度

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progressBar.setVisibility(View.VISIBLE);
                progressBar.setProgress(newProgress);
                if (newProgress>=100){
                    progressBar.setVisibility(View.GONE);
                }
                super.onProgressChanged(view, newProgress);
            }
        });
    }


    protected void initDate() {

    }


    protected int getLayoutId() {
        return R.layout.activity_news;
    }
    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
//            if (Uri.parse(url).getHost().equals(url)) {
//
//                    // This is my website, so do not override; let my WebView load the  page **/
//
//                    return false;
//            }
            //  Otherwise, the link is not for a page on my site, so launch another  */

            //Activity that handles URLs
           // Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
           // startActivity(intent);
            return false;
        }
    }
}
