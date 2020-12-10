package com.example.onlineeducation.mineFragmentPages;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.onlineeducation.R;

public class OpenNewCoursesPage extends Activity {

    TextView title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.open_new_courses_page);

        title = (TextView)findViewById(R.id.titleBarId);
        title.setText("开设新课");
    }
}
