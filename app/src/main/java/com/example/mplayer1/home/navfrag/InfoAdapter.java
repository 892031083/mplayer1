package com.example.mplayer1.home.navfrag;

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
import com.example.mplayer1.recom.ReBean;

import java.util.List;

public class InfoAdapter extends RecyclerView.Adapter <InfoAdapter.infoHodler>{

    private List<ReBean> mList;

    private Context context;

    private int type=1;//1电影 2推荐
    public InfoAdapter(List<ReBean> mList,Context context) {
        this.mList = mList;
        this.context = context;

    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @NonNull
    @Override
    public infoHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            if (type==1){
                return new infoHodler(LayoutInflater.from(context).inflate(R.layout.datelist_item_layout,null));
            }
        return new infoHodler(LayoutInflater.from(context).inflate(R.layout.recom_item,null));
    }

    @Override
    public void onBindViewHolder(@NonNull infoHodler holder,  int position) {
        holder.title.setText(mList.get(position).name);
        Glide.with(context).load(mList.get(position).getImgurl()).into(holder.imageView);
        if (mList.get(position).getType()==40){
            holder.teaser.setVisibility(View.VISIBLE);
        }else {
            holder.teaser.setVisibility(View.GONE);
        }
        final int p=position;
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemclickInfo.onclick(p);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class infoHodler extends RecyclerView.ViewHolder{
        TextView title;
        ImageView imageView;
        ImageView teaser;

        public infoHodler(@NonNull View itemView) {
            super(itemView);
            if (type==1){
                title=itemView.findViewById(R.id.detalist_item_title);
                imageView=itemView.findViewById(R.id.detalist_item_img);
                teaser=itemView.findViewById(R.id.teaser);
            }else{
                title=itemView.findViewById(R.id.image);
                imageView=itemView.findViewById(R.id.title);
            }
        }
    }
    private OnItemclickInfo onItemclickInfo;

    public void setOnItemclickInfo(OnItemclickInfo onItemclickInfo) {
        this.onItemclickInfo = onItemclickInfo;
    }

    interface OnItemclickInfo{
        void onclick(int i);
    }
}
