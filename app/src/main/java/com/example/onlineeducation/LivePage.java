package com.example.onlineeducation;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

import cn.nodemedia.NodePlayer;
import cn.nodemedia.NodePlayerView;
import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class LivePage extends Activity {

    ArrayList<View> viewList = new ArrayList<>();

    ViewPager viewPager;

    ArrayList<String> titleList = new ArrayList<>();

    EditText ms;

    TextView t;

    Button send;

    NodePlayer nodePlayer;

    NodePlayerView nodePlayerView;

    SurfaceView surfaceView;

    SurfaceHolder surfaceHolder;

//    VideoView videoView = null;

    String path;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        if (!LibsChecker.checkVitamioLibs(this)) {
//            Toast.makeText(LivePage.this, "Vitamio未初始化", Toast.LENGTH_SHORT).show();
//            return;
//        }

        setContentView(R.layout.live_page);

//        surfaceView = (SurfaceView) findViewById(R.id.surface);
//        surfaceHolder = surfaceView.getHolder();
//        surfaceHolder.addCallback(this);



//        Vitamio.isInitialized(this);



//        videoView = (VideoView) findViewById(R.id.video_view_vitamio);
//        path = "rtmp://47.102.122.250:9000/rtmplive/12345";  //rtmp地址
//        videoView.setVideoPath(path);
//        videoView.setMediaController(new MediaController(this));
//        videoView.requestFocus();
//
//        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mp) {
//                mp.setPlaybackSpeed(1.0f);
//            }
//        });



        LayoutInflater lf = getLayoutInflater().from(this);
        View intro = lf.inflate(R.layout.live_page_introduction, null);
        View dis = lf.inflate(R.layout.live_page_discussion, null);
        View aud = lf.inflate(R.layout.live_page_audience, null);
        viewList.add(intro);
        viewList.add(dis);
        viewList.add(aud);

        titleList.add("课程介绍");
        titleList.add("实时讨论");
        titleList.add("在线观众");


        viewPager = (ViewPager)findViewById(R.id.livePageViewPager);
        PagerAdapter pagerAdapter = new PagerAdapter() {
            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                container.addView(viewList.get(position), 0);
                return viewList.get(position);
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView(viewList.get(position));
            }

            @Override
            public int getCount() {
                return viewList.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == object;
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return titleList.get(position);
            }
        };
        viewPager.setAdapter(pagerAdapter);

        ms = (EditText) viewList.get(1).findViewById(R.id.livePageMyMessage);

        t = (TextView)viewList.get(1).findViewById(R.id.discussionText);

        send = (Button) viewList.get(1).findViewById(R.id.livePageDiscussionSend);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = ms.getText().toString();
                t.append("\n我：" + message);
                ms.setText("");
            }
        });


    }
}
