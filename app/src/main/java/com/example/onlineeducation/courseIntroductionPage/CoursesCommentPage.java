package com.example.onlineeducation.courseIntroductionPage;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.onlineeducation.R;

public class CoursesCommentPage extends Activity {

    TextView title;

    RatingBar ratingBar;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_comment_page);



        title = (TextView) findViewById(R.id.titleBarId);
        title.setText("课程评价");

       RatingBar ratingBar = (RatingBar)findViewById(R.id.rgb_ping);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(CoursesCommentPage.this,"评价了"+rating+"星",Toast.LENGTH_SHORT).show();
            }
        });
    }



}

