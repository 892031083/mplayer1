package com.example.mplayer1.detaillist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mplayer1.R;
import com.example.mplayer1.detaillist.bean.ViedoBeanTest;
import com.example.mplayer1.detaillist.listener.ResultAlubm;

import java.util.List;

public class DetaListAdapter extends RecyclerView.Adapter<DetaListAdapter.MyHolder> {


    private List<ResultAlubm> mList;//数据源
    private Context context;
    private OnClickItemISLitener onClickItemISLitener;

    public void setOnClickItemISLitener(OnClickItemISLitener onClickItemISLitener) {
        this.onClickItemISLitener = onClickItemISLitener;
    }

    DetaListAdapter(List<ResultAlubm> list, Context context) {
        mList = list;
        this.context=context;
    }

    public void setmList(List<ResultAlubm> mList) {
        this.mList = mList;
    }
    public void addData(List<ResultAlubm> list){
        mList.addAll(list);
    }

    //创建ViewHolder并返回，后续item布局里控件都是从ViewHolder中取出
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //将我们自定义的item布局R.layout.item_one转换为View

        return new MyHolder(LayoutInflater.from(context).inflate(R.layout.datelist_item_layout,null));
    }

    //通过方法提供的ViewHolder，将数据绑定到ViewHolder中
    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
            final int i=position;
            ResultAlubm resultAlubm=mList.get(position);
            holder.textView.setText(resultAlubm.getAlbumName());
            Glide.with(context).load(resultAlubm.getVerHighPic()).into(holder.imageView);//图片
            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickItemISLitener.onclick(mList.get(i));
                }
            });//定义item点击事件
            if (resultAlubm.getCid()==1){//电影
                holder.scoreText.setText(resultAlubm.getTip());
            }else {
                holder.tipText.setText(resultAlubm.getTip());
            }
    }

    //获取数据源总的条数
    @Override
    public int getItemCount() {
        return mList.size();
    }

    /**
     * 自定义的ViewHolder
     */
    class MyHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        TextView tipText;
        TextView scoreText;
        public MyHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.detalist_item_img);
            textView=itemView.findViewById(R.id.detalist_item_title);
            tipText=itemView.findViewById(R.id.tip);
            scoreText=itemView.findViewById(R.id.score);
        }
    }
    interface OnClickItemISLitener{//点击回掉
        void onclick(ResultAlubm resultAlubm);
    }
}
