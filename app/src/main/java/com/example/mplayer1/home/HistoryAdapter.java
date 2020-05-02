package com.example.mplayer1.home;

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
import com.example.mplayer1.detaillist.listener.ResultAlubm;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.mHolder> {

    private mHolder holder;
    private int position;
    private OnItemClick onItemClick;
    Context context;
    List<ResultAlubm> list;
    HistoryAdapter(Context context,List<ResultAlubm> list){
        this.context=context;
        this.list=list;
    }

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public mHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_history,null);
        return new mHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull mHolder holder, final int position) {
        holder.title.setText(list.get(position).getAlbumName());
        holder.rq.setText(list.get(position).getDirector());
        holder.score.setText(list.get(position).getScore()+"分");
        Glide.with(context).load(list.get(position).getHorHighPic()).into(holder.imageView);
        ((ViewGroup)holder.title.getParent().getParent()).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClick!=null)
                onItemClick.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class mHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title,rq,score;
        public mHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.img);
            title=itemView.findViewById(R.id.title);
            rq=itemView.findViewById(R.id.rq);
            score=itemView.findViewById(R.id.score_);
        }
    }

    interface OnItemClick{
        void onClick(int i);
    }
}
