package com.example.administrator.androidtest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/25.
 */

public class VolleyActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abc);

    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        final ImageView imageView = (ImageView) findViewById(R.id.img);
//        compile 'com.github.erd:android-volley:1.0.0'
        String uri = "http://192.168.3.129:8080/start/servlet/Login?";
        String img = "http://pic51.nipic.com/file/20141022/19779658_171157758000_2.jpg";
        // 获取请求列队
//        JSONObject jsonObject = new JSONObject();
//        try {
//            jsonObject.put("name", "zs");
//            jsonObject.put("password", "123456");
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
        RequestQueue requestQueue = Volley.newRequestQueue(this);


        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, uri, new JSONObject(), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                   Log.e("---","=="+response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            public byte[] getBody() {
                return "name=zs&password=123456".getBytes();
            }
        };


//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, uri, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                Log.e("---", response.toString());
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.e("---", error.getMessage());
//            }
//        });
//        JsonRequest request = new JsonRequest<Object>(Request.Method.POST, uri, "name=zs&password=123456", new Response.Listener<Object>() {
//            @Override
//            public void onResponse(Object response) {
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        }) {
//
//            @Override
//            protected Response<Object> parseNetworkResponse(NetworkResponse response) {
//                return null;
//            }
//        };

        requestQueue.add(request);
        // 获取请求
        //字符串请求
//        JsonArrayRequest request=new JsonArrayRequest();
        //图片请求
//        ImageRequest request = new ImageRequest(img, new Response.Listener<Bitmap>() {
//            @Override
//            public void onResponse(Bitmap response) {
//                imageView.setImageBitmap(response);
//            }
//        }, 200, 200, Bitmap.Config.ARGB_8888, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.e("---", error.getMessage());
//            }
//        });
        //添加到消息列队


    }

    @NonNull
    private JsonObjectRequest getJsonObjectRequest(String uri) {
        JSONObject object = new JSONObject();
        return new JsonObjectRequest(Request.Method.POST, uri, object, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.e("---", response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("---", error.getMessage());
            }
        }) {
            @Override
            public byte[] getBody() {
                return "name=zs&password=123456".getBytes();
            }
        };
    }

    @NonNull
    private StringRequest getStringRequest2(final String uri) {
        return new StringRequest(Request.Method.POST, uri, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("---", "---" + response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("name", "zs");
                map.put("password", "123456");
                return map;
            }
        };
    }

    @NonNull
    private StringRequest getStringRequest(String uri) {
        return new StringRequest(Request.Method.GET, uri, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //请求成功

                Log.e("--", "====" + response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // 请求失败

                Log.e("---", "===" + error.getMessage());
            }
        });
    }


//    public
}
