package com.example.onlineeducation;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class SignUpPage extends Activity {

    TextView title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_page);

        title = (TextView) findViewById(R.id.titleBarId);
        title.setText("手机号验证登录");
    }
}
