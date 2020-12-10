package com.example.onlineeducation.courseIntroductionPage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.onlineeducation.R;
import com.example.onlineeducation.VideoPlayPage.VideoPlayActivity;
import com.example.onlineeducation.teacherHomepage.TeacherHomepageActivity;

public class CourseIntroductionPageActivity extends Activity {

    protected String TAG;

    TextView titleBar;

    TextView chapterOne;

    TextView chapterTwo;

    ImageView coursePicture;

    Button intoTeacherHomepage;

    Button intoCoursesCommentPage;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_introduction_page);

        titleBar = (TextView) findViewById(R.id.titleBarId);
        titleBar.setText("财政学");

        intoTeacherHomepage = (Button) findViewById(R.id.courseIntroIntoTeaHomepage);
        intoTeacherHomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TeacherHomepageActivity.class);
                startActivity(intent);
            }
        });

        coursePicture = (ImageView) findViewById(R.id.coursePicture);
        coursePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //进入视频播放界面
                Intent intent = new Intent(v.getContext(), VideoPlayActivity.class);
                startActivity(intent);
            }
        });

        chapterOne = (TextView) findViewById(R.id.chapter_one);
        chapterOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //进入视频播放界面
                Intent intent = new Intent(v.getContext(), VideoPlayActivity.class);
                startActivity(intent);

            }
        });

        intoCoursesCommentPage = (Button) findViewById(R.id.courseIntroJoinDiscussion);
        intoCoursesCommentPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CoursesCommentPage.class);
                v.getContext().startActivity(intent);
            }
        });

        chapterTwo = (TextView) findViewById(R.id.chaoper_two);
        chapterTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PaymentPage.class);
                startActivity(intent);
            }
        });

    }
}
