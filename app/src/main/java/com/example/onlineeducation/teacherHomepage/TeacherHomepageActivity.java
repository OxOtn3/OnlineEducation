package com.example.onlineeducation.teacherHomepage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.example.onlineeducation.R;
import com.example.onlineeducation.courseIntroductionPage.CourseIntroductionPageActivity;

public class TeacherHomepageActivity extends Activity {
    ImageView course1;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_homepage);

        course1 = (ImageView) findViewById(R.id.teacher_homepage_course1);
        course1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //打开课程介绍页面
                Intent intent = new Intent(v.getContext(), CourseIntroductionPageActivity.class);
                startActivity(intent);
            }
        });
    }
}
