package com.example.onlineeducation.courseIntroductionPage;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.onlineeducation.R;

public class CoursesCommentPage extends Activity {

    TextView title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_comment_page);

        title = (TextView) findViewById(R.id.titleBarId);
        title.setText("课程评价");
    }
}
