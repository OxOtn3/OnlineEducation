package com.example.onlineeducation.mineFragmentPages;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.onlineeducation.R;

public class CoursesOperationPage extends Activity {

    Button openNewCourses;

    TextView title;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.courses_operation_page);

        openNewCourses = (Button) findViewById(R.id.openNewCourses);
        openNewCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), OpenNewCoursesPage.class);
                v.getContext().startActivity(intent);
            }
        });

        title = (TextView) findViewById(R.id.titleBarId);
        title.setText("课程操作");


    }
}
