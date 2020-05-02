package com.example.mplayer1.mview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.example.mplayer1.R;

import static com.example.mplayer1.detaillist.DetailListActivity.TAG;

public class ScrollListView extends ScrollView {
    private Context context;
    private LayoutInflater inflater;
    public ScrollListView(Context context) {
        super(context);
        initView(context);
    }

    public ScrollListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public ScrollListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }
    private ListView listView;
    private boolean isListScroll=false;
    private LinearLayout listhead;
    private void initView(Context context) {
        this.context=context;
        inflater= LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.scroll_list_layout,null);
        this.addView(view);
        listView=view.findViewById(R.id.listview);
        listhead=view.findViewById(R.id.listhead);
        setVerticalScrollBarEnabled(false);
        listView.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
              //  float posX=0,posY=0,curPosX=0,curPosY=0;
                if(ScrollListView.this.getScrollY() + ScrollListView.this.getHeight() - ScrollListView.this.getPaddingTop() - ScrollListView.this.getPaddingBottom() ==
                        ScrollListView.this.getChildAt(0).getHeight()) {

                    ScrollListView.this.requestDisallowInterceptTouchEvent(true);
                }
                return false;
            }
        });

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                //判断ScrollView是否不滑动了，判断ListView是否已显示第一个Item了
                if(scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE && view.getFirstVisiblePosition() == 0){
                    //允许即使在ListView滑动，ScrollView也可以滑动
                    ScrollListView.this.requestDisallowInterceptTouchEvent(false);
                    //scrollView滑动，滑动距离为ListView滑动距离
                    ScrollListView.this.smoothScrollBy(listView.getScrollX(), listView.getScrollY());
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
//        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(AbsListView view, int scrollState) {
//                //判断ScrollView是否不滑动了，判断ListView是否已显示第一个Item了
//
//            }
//
//            @Override
//            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//                //empty
//
////                if( view.getFirstVisiblePosition() == 0){
//////                    if (listView.getChildCount() > 0 && listView.getFirstVisiblePosition() == 0 && listView.getChildAt(0).getTop() >= listView.getPaddingTop()) {
////
////
////                        //允许即使在ListView滑动，ScrollView也可以滑动
////                        ScrollListView.this.requestDisallowInterceptTouchEvent(false);
////                        //scrollView滑动，滑动距离为ListView滑动距离
////                        ScrollListView.this.smoothScrollBy(listView.getScrollX(), listView.getScrollY());
////
////                }
//
//                listView.setOnScrollListener(new AbsListView.OnScrollListener() {
//                    @Override
//                    public void onScrollStateChanged(AbsListView view, int scrollState) {
//
//                    }
//
//                    @Override
//                    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//                        //empty
//                        //判断ScrollView是否不滑动了，判断ListView是否已显示第一个Item了
//                        if(firstVisibleItem==0&&isListScroll){
//                            //允许即使在ListView滑动，ScrollView也可以滑动
//                            ScrollListView.this.requestDisallowInterceptTouchEvent(false);
//                            //scrollView滑动，滑动距离为ListView滑动距离
//                            ScrollListView.this.smoothScrollBy(listView.getScrollX(), listView.getScrollY());
//                        }
//                    }
//                });
//            }
//        });



        this.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
//                if (listhead.getX()==head.getHeight()){
//                    isListScroll=true;
//                    return false;
//                }
//                isListScroll=false;
       //     listView.requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
    }


}
