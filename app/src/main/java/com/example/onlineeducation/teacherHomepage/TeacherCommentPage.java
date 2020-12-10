package com.example.onlineeducation.teacherHomepage;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.onlineeducation.R;

public class TeacherCommentPage extends Activity {

    TextView title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_comment_page);

        title = (TextView) findViewById(R.id.titleBarId);
        title.setText("写评价");
    }
}
