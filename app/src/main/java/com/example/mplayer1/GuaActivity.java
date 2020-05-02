package com.example.mplayer1;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mplayer1.base.DataBaseHelper;

public class GuaActivity extends AppCompatActivity {
    EditText name,img,play,type;
    Button add,get;
    TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gua);
        name=findViewById(R.id.name_gua);
        img=findViewById(R.id.imgurl_gua);
        play=findViewById(R.id.play_gua);
        add=findViewById(R.id.add_gua);
        get=findViewById(R.id.get_gua);
        type=findViewById(R.id.type_gua);
textView=findViewById(R.id.ccc);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText()!=null&&img.getText()!=null&&play.getText()!=null){
                    //创建存放数据的ContentValues对象
                    ContentValues values = new ContentValues();
                    //像ContentValues中存放数据
                    values.put("name", String.valueOf(name.getText()));
                    values.put("imgurl", String.valueOf(img.getText()));
                    values.put("playurl", String.valueOf(play.getText()));

                    values.put("type", new Integer(String.valueOf(type.getText())));
                    DataBaseHelper dataBaseHelper=new DataBaseHelper(GuaActivity.this,"hou_db",null,1);
                    SQLiteDatabase db3 = dataBaseHelper.getWritableDatabase();
                    //数据库执行插入命令
                    db3.insert("player", null, values);
                }
            }
        });

        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBaseHelper dataBaseHelper=new DataBaseHelper(GuaActivity.this,"hou_db",null,1);

                SQLiteDatabase db5 = dataBaseHelper.getWritableDatabase();
                //创建游标对象
//                Cursor cursor = db5.query("player",null, null, null, null, null, null);
                Cursor cursor=db5.rawQuery("select * from player",null);
                //利用游标遍历所有数据对象
               String str="";
                while(cursor.moveToNext()){
                    String playurl = cursor.getString(cursor.getColumnIndex("playurl"));
                    str+=":";
                    str+=playurl;
                }
                textView.setText(str);

            }
        });
    }
}
