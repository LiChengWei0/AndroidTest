package com.example.androidtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.androidtest.util.ScreenInfo;

public class MainActivity extends AppCompatActivity {

    private TextView tv_results;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_results = findViewById(R.id.tv_result);

        int width = ScreenInfo.getScreenWidth(this);
        tv_results.setText("这个手机的屏幕尺寸是sssssssssssssssssssssssssssssssssssssssssss"+width);
    }



}
