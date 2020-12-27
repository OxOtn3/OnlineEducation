package com.example.onlineeducation;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class LivePage extends Activity {

    ArrayList<View> viewList = new ArrayList<>();

    ViewPager viewPager;

    ArrayList<String> titleList = new ArrayList<>();

    EditText ms;

    TextView t;

    Button send;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.live_page);


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
