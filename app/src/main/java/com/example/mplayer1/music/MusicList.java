package com.example.mplayer1.music;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mplayer1.R;
import com.example.mplayer1.music.beaninfo.MusicBean;

import java.util.List;

public class MusicList extends BaseAdapter {
    List<MusicBean> list;
    Context context;

    public  MusicList(List<MusicBean> list,Context context){
        this.context=context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Viewholder viewholder;
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.music_item,null);
            viewholder=new Viewholder(convertView);
            convertView.setTag(viewholder);

        }else{
            viewholder=(Viewholder) convertView.getTag();
        }
        viewholder.msName.setText(list.get(position).getName());
        viewholder.msZZ.setText(list.get(position).getMusicInfo().getArtist());
        return convertView;
    }

    class Viewholder{
        TextView msName,msZZ;
        Viewholder(View view){
            msName=view.findViewById(R.id.msName);
            msZZ=view.findViewById(R.id.msZZ);
        }
    }

}
