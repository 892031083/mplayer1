package com.example.mplayer1.recom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mplayer1.R;
import com.example.mplayer1.detaillist.DetaListAdapter;
import com.example.mplayer1.detaillist.listener.ResultAlubm;

import java.util.List;

public class RecomItemAdapter extends RecyclerView.Adapter<RecomItemAdapter.MyHolder> {


    private List<ChenrBean> mList;//数据源
    private Context context;
    private OnClickItemISLitener onClickItemISLitener;

    public void setOnClickItemISLitener(OnClickItemISLitener onClickItemISLitener) {
        this.onClickItemISLitener = onClickItemISLitener;
    }

    public RecomItemAdapter(List<ChenrBean> list, Context context) {
        mList = list;
        this.context=context;
    }

    public void setmList(List<ChenrBean> mList) {
        this.mList = mList;
    }
    public void addData(List<ChenrBean> list){
        mList.addAll(list);
    }

    //创建ViewHolder并返回，后续item布局里控件都是从ViewHolder中取出
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //将我们自定义的item布局R.layout.item_one转换为View

        return new MyHolder(LayoutInflater.from(context).inflate(R.layout.recom_item,null));
    }

    //通过方法提供的ViewHolder，将数据绑定到ViewHolder中
    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {
            final int i=position;
            ChenrBean chenrBean=mList.get(position);
            holder.textView.setText(chenrBean.getPlayNmae());
            Glide.with(context).load(chenrBean.getPlayImg()).into(holder.imageView);//图片
            View pview= (View) holder.imageView.getParent();
            pview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickItemISLitener.onclick(mList.get(position));
                }
            });

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

        public MyHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image);
            textView=itemView.findViewById(R.id.title);

        }
    }
   public interface OnClickItemISLitener{//点击回掉
        void onclick(ChenrBean chenrBean);
    }
}
