package com.example.mplayer1.home.navfrag;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.example.mplayer1.R;
import com.example.mplayer1.base.BaseFragment;
import com.example.mplayer1.detaillist.DetailListActivity;
import com.example.mplayer1.home.HomeActivity;
import com.example.mplayer1.home.bean.Channel;
import com.example.mplayer1.live.AlbumLiveListActivity;
import com.example.mplayer1.music.MusicActivity;
import com.example.mplayer1.news.NewsActivity;
import com.example.mplayer1.recom.RecomActivity;
import com.example.mplayer1.util.ImageUtil;
import com.itheima.loopviewpager.LoopViewPager;

import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.DatatypeFactory;

import cn.refactor.lib.colordialog.ColorDialog;

public class HomeFragment extends BaseFragment {
    private static final String TITLE_TEXT="首页";
    HomeViewModel homeViewModel;
    private LoopViewPager loopViewPager;
    private GridView gridView;
    int[] lists;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        homeViewModel= ViewModelProviders.of(this).get(HomeViewModel.class);

    }

    @Override
    protected void initDate() {
        ((HomeActivity)getActivity()).setTitleText(TITLE_TEXT);
        ((HomeActivity)getActivity()).ThisTITLE_id=HomeActivity.HOME_FRAMENT_ID;
       // ((HomeActivity)getActivity()).goneTitle(View.VISIBLE);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        lists=new int[]{
                Channel.SHOW, Channel.MOVIE, Channel.COMIC, Channel.DOCUMENTRY,Channel.MUSIC,Channel.VARIETY,Channel.LIVE,Channel.JIZUO, Channel.ADULT,};
        loopViewPager = Resview.findViewById(R.id.lvp_pager);
        loopViewPager.setImgData(imgListString());
        loopViewPager.setTitleData(titleListString());
        loopViewPager.start();

        gridView=Resview.findViewById(R.id.gv_channel);
        gridView.setAdapter(new ChannelAdapter(lists));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                gotoActivity(position);
            }
        });
    }

    private void gotoActivity(int position) {

        if (position==6){//去直播界面
            Intent intent=new Intent(getActivity(), AlbumLiveListActivity.class);
            startActivity(intent);
        }
        else if (position==8){//成人
            gotoChr();
            //Intent intent=new Intent(getActivity(), RecomActivity.class);
           // startActivity(intent);
        }else if (position==7){
            startActivity(new Intent(getActivity(), NewsActivity.class));
        }else if (position==4){
            startActivity(new Intent(getActivity(), MusicActivity.class));
        }
        else{
            Intent intent=new Intent(getActivity(),DetailListActivity.class);
            intent.putExtra("channel_id",lists[position]);

            startActivity(intent);
        }

    }

    private void gotoChr() {
        //PopupWindow popupWindow = new PopupWindow();
        final View view=LayoutInflater.from(getActivity()).inflate(R.layout.torecome_dialog,null);
//        popupWindow.setContentView(R.layout.channelview);
//        ColorDialog colorDialog=new ColorDialog(getActivity());
//        colorDialog.setContentView(R.layout.torecome_dialog);

//        popupWindow.setContentView(view);
 //       popupWindow.showAtLocation(getActivity().getWindow().getDecorView(), Gravity.CENTER, 0, 0);
//               popupWindow.setE
        final Dialog dialog=new Dialog(getActivity());
        dialog.setTitle("需要验证");
        dialog.setContentView(view);

        view.findViewById(R.id.passbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView=view.findViewById(R.id.te);
                EditText editText=view.findViewById(R.id.pass);
                if (editText.getText().toString().equals(getString(R.string.chr_pass))){
                    dialog.cancel();
                    Intent intent=new Intent(getActivity(), RecomActivity.class);
                     startActivity(intent);
                }else{
                    textView.setVisibility(View.VISIBLE);
                }
            }
        });
        dialog.show();
    }


    private List<Bitmap> test() {
        List<Bitmap> imageData = new ArrayList<>();
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(), R.mipmap.startup);
        imageData.add(bitmap);
        imageData.add(bitmap);
        imageData.add(bitmap);
        imageData.add(bitmap);
        imageData.add(bitmap);
//       imageData.add(ImageUtil.getLayoutView(R.layout.activity_startup,getActivity()));
//        imageData.add(ImageUtil.getLayoutView(R.layout.activity_startup,getActivity()));
//        imageData.add(ImageUtil.getLayoutView(R.layout.activity_startup,getActivity()));
//        imageData.add(ImageUtil.getLayoutView(R.layout.activity_startup,getActivity()));
//        imageData.add(ImageUtil.getLayoutView(R.layout.activity_startup,getActivity()));
        return imageData;
    }



    private List<String> imgListString() {
        List<String> imageData = new ArrayList<>();
//        imageData.add("http://d.hiphotos.baidu.com/image/h%3D200/sign=72b32dc4b719ebc4df787199b227cf79/58ee3d6d55fbb2fb48944ab34b4a20a44723dcd7.jpg");
//        imageData.add("http://pic.4j4j.cn/upload/pic/20130815/31e652fe2d.jpg");
//        imageData.add("http://pic.4j4j.cn/upload/pic/20130815/5e604404fe.jpg");
//        imageData.add("http://pic.4j4j.cn/upload/pic/20130909/681ebf9d64.jpg");
//        imageData.add("http://d.hiphotos.baidu.com/image/pic/item/54fbb2fb43166d22dc28839a442309f79052d265.jpg");
        imageData.add("http://i0.hdslb.com/bfs/bangumi/image/35d2f9951cf99f38dce232637bae21014819ce6d.jpg@2320w_664h.jpg");
        imageData.add("http://i0.hdslb.com/bfs/archive/c2f5f3f406cde625d61bc8be651e21210b4e99ba.jpg@620w_220h.webp");
        imageData.add("http://i0.hdslb.com/bfs/archive/e78f12c6ee2281a8fcd32a0d1b8c0e1543b04476.png@620w_220h.webp");
        imageData.add("http://i0.hdslb.com/bfs/archive/1425caed30650d7092060d4977ea9835c57cc023.jpg@620w_220h.webp");
        imageData.add("http://i0.hdslb.com/bfs/archive/753f3a3032e477f576b87160e4080efa10563029.jpg@620w_220h.webp");
        return imageData;
    }

    private List<String> titleListString() {
        List<String> titleData = new ArrayList<>();
        titleData.add("第四次我们一起活动");
        titleData.add("强森带队勇闯绝境");
        titleData.add("刷N遍依然感动的高分韩剧");
        titleData.add("我们的存在本身就是谋逆");
        titleData.add("游园日记最终");
        return titleData;
    }

    class ChannelAdapter extends BaseAdapter{
        int[] list;
        LayoutInflater inflater;
        ChannelAdapter(int[] list){
            inflater=LayoutInflater.from(HomeFragment.this.getActivity());
            this.list=list;
        }
        @Override
        public int getCount() {
            return list.length;
        }

        @Override
        public Object getItem(int position) {
            return list[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView=inflater.inflate(R.layout.channelview,null);
        }
            ImageView imageView=convertView.findViewById(R.id.img);
            TextView textView=convertView.findViewById(R.id.text);
            imageView.setImageResource(Channel.getIconRes(list[position]));
            textView.setText(Channel.getTitleRes(list[position]));
            return convertView;
        }
    }

}
