package com.example.onlineeducation.mineFragmentPages;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.onlineeducation.R;
import com.example.onlineeducation.courseIntroductionPage.CourseIntroductionPageActivity;

public class BoughtCoursesPageActivity extends Activity {

    private TextView title;

    private ImageView course1;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bought_courses_page);

        title = (TextView) findViewById(R.id.titleBarId);
        title.setText("已购买的课程");

        course1 = (ImageView) findViewById(R.id.bought_course1);
        course1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CourseIntroductionPageActivity.class);
                startActivity(intent);
            }
        });

    }
}
