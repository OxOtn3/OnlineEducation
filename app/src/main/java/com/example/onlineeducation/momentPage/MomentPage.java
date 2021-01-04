package com.example.onlineeducation.momentPage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.onlineeducation.R;
import com.example.onlineeducation.momentUserPage.MomentUserPageActivity;

public class MomentPage extends Activity {

    ImageView userImag;

    TextView title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moment_page);

        title = findViewById(R.id.titleBarId);
        title.setText("作业墙展示");

        userImag = (ImageView) findViewById(R.id.momentPageUserImage);
        userImag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MomentUserPageActivity.class);
                startActivity(intent);
            }
        });
    }
}
