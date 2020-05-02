package com.example.mplayer1.mview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

public class MListView extends ListView {
    public MListView(Context context) {
        super(context);
    }

    public MListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // 设计一个较大的值和AT_MOST模式
        int newHeightMeasureSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        // 调用原方法测量
        super.onMeasure(widthMeasureSpec, newHeightMeasureSpec);
    }
}
