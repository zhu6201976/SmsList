package com.example.administrator.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * 短信大全
 * 1.listview展示所有短信
 * 2.点击条目后跳转发短信页面将内容填充上去
 * 3.因7.0手机不熟悉,用4.1.2测试
 * Created by My on 2017/12/10.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lv = (ListView) findViewById(R.id.lv);
        final String[] res = {"今天的风儿轻柔无比，今天的花儿香飘万里；今天的鸟儿十分欢喜，今天的云儿满载笑意；" +
                "今天的事儿万分顺利，今天的人儿如此甜蜜。所有美...", "丫头，生活是你自己的，你哭它就对你哭，" +
                "你笑它就对你笑。转眼，又是一年，你的生日即将来到。今年，还是少不了我对你的祝福，我忍不住...",
                "世界上最动听的声音，是妈妈声声的呼唤；世界上最温暖的笑容，是妈妈温暖的笑脸。妈妈，" +
                        "原谅生日时我不能陪在您身边，在这个日子里，我...", "今天是你的生日，祝你：发财势头如快马加鞭，" +
                "一日千里；发展速度如滔滔江水，势不可挡；好事发生如雨后春笋，络绎不绝；祝福发送如比赛..."};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, res);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String content = res[position];
                // 打开发短信页面将内容填充进去
                /*<intent - filter >
                    <action android:name = "android.intent.action.SEND" / >
                    <category android:name = "android.intent.category.DEFAULT" / >
                    <data android:mimeType = "text/plain" / >
                </intent - filter >*/
                Intent intent = new Intent();
                intent.setAction("android.intent.action.SEND");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setType("text/plain");
                intent.putExtra("sms_body", content);
                startActivity(intent);
            }
        });
    }
}
