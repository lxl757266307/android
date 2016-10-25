package com.example.administrator.androidtest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.androidtest.mvp.MyPresonter;
import com.example.administrator.androidtest.mvp.MyView;
import com.hannesdorfmann.mosby.mvp.MvpActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends MvpActivity<MyView, MyPresonter> {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.img_menu)
    ImageView menu;
    @Bind(R.id.img_logo)
    ImageView logo;
    @Bind(R.id.txt_title)
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        setSupportActionBar(toolbar);
        menu = (ImageView) findViewById(R.id.img_menu);
        logo = (ImageView) findViewById(R.id.img_logo);
//        toolbar.inflateMenu(R.menu.menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                Log.e("---", "----");
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.ss);
                animation.setDuration(1000);
                logo.startAnimation(animation);
                View view = getLayoutInflater().inflate(R.layout.item, null, false);
                PopupWindow popupWindow = new PopupWindow(view, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);

                popupWindow.setFocusable(true);
                popupWindow.setTouchable(true);
                popupWindow.setContentView(view);
                popupWindow.setOutsideTouchable(true);
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
                popupWindow.setBackgroundDrawable(new BitmapDrawable());

                popupWindow.showAsDropDown(toolbar, 0, 0, Gravity.RIGHT);
            }
        });

    }

    @NonNull
    @Override
    public MyPresonter createPresenter() {
        return null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        switch (featureId) {
            case R.id.i1:
                Toast.makeText(this, "i1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.i2:
                Toast.makeText(this, "i2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.i3:
                Toast.makeText(this, "i3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.i4:
                Toast.makeText(this, "i4", Toast.LENGTH_SHORT).show();
                break;
            case R.id.i5:
                Toast.makeText(this, "i5", Toast.LENGTH_SHORT).show();
                break;


        }

        return super.onMenuOpened(featureId, menu);
    }
}
