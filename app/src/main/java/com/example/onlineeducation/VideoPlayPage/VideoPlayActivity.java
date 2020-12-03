package com.example.onlineeducation.VideoPlayPage;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.onlineeducation.R;

import java.io.File;

public class VideoPlayActivity extends Activity implements View.OnClickListener{

    private VideoView videoView;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_play_page);

        videoView = (VideoView) findViewById(R.id.videoView);
        Button play = (Button) findViewById(R.id.playButton);
        Button stop = (Button) findViewById(R.id.stopButton);
        Button replay = (Button) findViewById(R.id.replayButton);

        play.setOnClickListener(this);
        stop.setOnClickListener(this);

        if(ContextCompat.checkSelfPermission(VideoPlayActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(VideoPlayActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);

        }else {
            Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" +R.raw.caizhengxue);
            videoView.setVideoURI(uri);
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.playButton:
                if(!videoView.isPlaying()){
                    videoView.start();
                }
                break;

            case R.id.stopButton:
                if(videoView.isPlaying()){
                    videoView.pause();
                }

                break;
        }
    }
}
