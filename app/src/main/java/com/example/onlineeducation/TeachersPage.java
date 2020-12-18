package com.example.onlineeducation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.onlineeducation.teacherHomepage.TeacherHomepageActivity;

public class TeachersPage extends Activity {

    TextView title;

    TextView image;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teachers_page);

        title = (TextView) findViewById(R.id.titleBarId);
        title.setText("所有教师");


        image = (TextView) findViewById(R.id.teachersPageImage);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TeacherHomepageActivity.class);
                startActivity(intent);
            }
        });
    }
}
