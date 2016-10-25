package com.example.administrator.androidtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.administrator.androidtest.entity.News;
import com.example.administrator.androidtest.inter.OnLoadInfoListener;
import com.example.administrator.androidtest.task.Task;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Created by Administrator on 2016/10/24.
 */

public class TestActivity extends AppCompatActivity implements OnLoadInfoListener {


    String path = "http://118.244.212.82:9092/newsClient/path/news_list?ver=1&subid=1&dir=1&nid=1&stamp=20140321&cnt=20";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abc);

    }

    Gson gson;

    @Override
    public void onContentChanged() {
        super.onContentChanged();
//        String path = "{'name':'ok','age':'1'}";

        gson = new Gson();

        Task task = new Task(this);

        // 启动异步任务
        task.execute(path);

    }

    @Override
    public void getInfo(String msg) {
        News news = gson.fromJson(msg, new TypeToken<News>() {
        }.getType());
        String message = news.getMessage();
        String status = news.getStatus();
        Log.e("---", "news=" + news.toString());

//        compile 'com.github.erd:android-volley:1.0.0'

    }
}
