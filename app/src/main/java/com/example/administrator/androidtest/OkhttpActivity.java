package com.example.administrator.androidtest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by Administrator on 2016/10/25.
 */

public class OkhttpActivity extends AppCompatActivity {

    TextView txt;
    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.abc);
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        txt = (TextView) findViewById(R.id.txt_msg);
        imageView = (ImageView) findViewById(R.id.img);
        String img = "http://pic51.nipic.com/file/20141022/19779658_171157758000_2.jpg";


         // 如果说 你要使用 OKHTTP
         /*
         * 1.导入包
         * 2.启动器
         * 3.请求 （请求体）
         * 4.获取 呼叫器
         * 5.开始呼叫
         *
         * */

        //启动器
        OkHttpClient client=new OkHttpClient();
        //注意此时使用POST 请求  所以 需要请求体

        // 构造器模式 构建 请求

        FormBody.Builder formBuilder = new FormBody.Builder();

        // 构建请求体  以键值对形式储存数据
        formBuilder.add("name","zs");
        formBuilder.add("password","123456");

        // 获取请求体  FormBody extends RequestBody 继承关系
        RequestBody requestBody = formBuilder.build();

        //构建请求  构造器模式

        Request.Builder requestBuilder = new Request.Builder();

        //通过构造器构建请求

        requestBuilder.url("地址");
        //使用构造器 将 请求体放入 请求中
        requestBuilder.post(requestBody);

        // 构建请求
        Request request = requestBuilder.build();

        // 获取 call模型

        Call call = client.newCall(request);

        //


    }

    private void sss() {
        // 如果说 你要使用 OKHTTP
         /*
         * 1.导入包
         * 2.启动器
         * 3.请求 （请求体）
         * 4.获取 呼叫器
         * 5.开始呼叫
         *
         * */

        // 启动器
        OkHttpClient client=new OkHttpClient();

        //请求　　考虑使用　ＧＥＴ　或者　ＰＯＳＴ　

        //先使用GET 请求

        // 使用构造器 模式 构建 请求

        Request.Builder builder = new Request.Builder();
        //构建地址
        builder.url("");
//        builder.addHeader()
        // 因为使用 GET 请求 所以此时不需要别的东西
        Request request = builder.build();

        //获取  call 呼叫器
        final Call call = client.newCall(request);

        // 开始呼叫  考虑使用同步还是异步

        /*
        * 1.注意此时 如果要使用 同步 需要注意 call 模型在 execute（）的时候
        *   还是必须在子线程中执行，否则 报 网络工作在主线程异常
        *  2.如果使用异步 则需要注意 我们enqueue(new CallBack) 在callBack 的、
         *   时候，它是在 后台线程==守护线程， 也就是子线程中回调 所以 不能直接使用，必须
         *   发送至 主线程才能使用，那么这里可以考虑使用 接口回调
        *
        * */

        // 同步
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //得到相应
                    Response response = call.execute();
                    /*
                    * 1.响应中包含了 响应的详细信息 所以
                    *   分部获取
                    *  2. 在获取到响应体之后 看你像要的是什么类型
                     *  的数据 你就使用 什么方法
                    *
                    * */

                    // 响应体
                    ResponseBody body = response.body();

                    //响应体 中 有各种数据类型的数据
                    //获取字符串
                    String string = body.string();
                    //获取输入流 如果此时你的URL 指向的是一张图片
                    // 那么你可以使用图片工厂模式 将一个流转换为Bitmap
                    InputStream inputStream = body.byteStream();

                    byte[] bytes = body.bytes();
                    Reader reader =
                            body.charStream();

                    long length = body.contentLength();

                    //媒体类型 "image/*"
                    MediaType mediaType = body.contentType();


                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();

        //异步执行 注意这里的回调全部在后台线程中
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                // 后台线程中
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                 // 后台线程中
                //此时获取响应内容 与同步获取内容一样

                // 使用 handle 或者 runonuiThread()
            }
        });
    }

    private void r(OkHttpClient client, Request request) {
        // call 模型 你可以认为 他是 呼叫器
        final Call call = client.newCall(request);

        // 执行请求
        //异步执行
        call.enqueue(new Callback() {
            // 请求失败
            @Override
            public void onFailure(Call call, IOException e) {

            }

            //请求成功
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //一定要注意 这里的回调 是在 子线程中


                //响应体
                ResponseBody responseBody = response.body();
                //再去拿响应体中的内容
//                String string = responseBody.string();
//
//                txt.setText(string);
                InputStream inputStream =
                        responseBody.byteStream();
                Bitmap bitmap =
                        BitmapFactory.decodeStream(inputStream);

                imageView.setImageBitmap(bitmap);
            }
        });
    }

    private void tonbu(final Call call) {
        //同步执行

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Response response = call.execute();

                    boolean successful = response.isSuccessful();
                    Log.e("---", successful + "");
                    if (successful) {
                        //响应体
                        ResponseBody body = response.body();
                        // 获取响应中的内容
                        String string = body.string();
                        Log.e("---", string);

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
