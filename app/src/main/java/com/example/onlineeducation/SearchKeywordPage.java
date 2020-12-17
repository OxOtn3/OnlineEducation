package com.example.onlineeducation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.onlineeducation.coursesPage.CoursesPageActivity;

public class SearchKeywordPage extends Activity {

    TextView title;

    ImageView pic;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_keyword_page);

        title = (TextView) findViewById(R.id.titleBarId);
        title.setText("选择关键词");

        pic = (ImageView) findViewById(R.id.kwspPic);
        pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CoursesPageActivity.class);
                startActivity(intent);
            }
        });
    }
}
