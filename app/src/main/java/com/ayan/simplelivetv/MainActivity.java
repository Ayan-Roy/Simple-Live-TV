package com.ayan.simplelivetv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView videoView;
    String[] str_permission = {"android.permission.INTERNET"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Hooks
        videoView = findViewById(R.id.video_view);


        CheckInternetPermission();
    }

    private void CheckInternetPermission() {
        requestPermissions(str_permission, 100);
    }
}