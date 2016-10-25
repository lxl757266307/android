package com.example.administrator.androidtest.task;

import android.os.AsyncTask;
import android.util.Log;

import com.example.administrator.androidtest.inter.OnLoadInfoListener;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2016/10/25.
 */

public class Task extends AsyncTask<String, Void, String> {


    OnLoadInfoListener loadInfoListener;

    public Task(OnLoadInfoListener loadInfoListener) {
        this.loadInfoListener = loadInfoListener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        String param = params[0];
        Log.e("---","param"+param);
        try {
            URL url = new URL(param);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            if (urlConnection.getResponseCode() == 200) {
                InputStream inputStream = urlConnection.getInputStream();
                byte[] bytes = new byte[2 * 1024];
                int length = 0;

                StringBuffer buffer = new StringBuffer();
                while (((length = inputStream.read(bytes)) != -1)) {
                    buffer.append(new String(bytes, 0, length));
                }

                return buffer.toString();


            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (s != null && loadInfoListener != null) {
            loadInfoListener.getInfo(s);
        }

    }


}
