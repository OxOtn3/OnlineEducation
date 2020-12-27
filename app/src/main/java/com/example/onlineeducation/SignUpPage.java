package com.example.onlineeducation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.android.material.textfield.TextInputLayout;

import java.io.IOException;
import java.util.Objects;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SignUpPage extends Activity {

    RadioButton stu;

    RadioButton tea;

    RadioGroup stuOrTea;

    TextView title;

    TextView phone;

    String phoneNum;

    String code;

    TextView veriCode;

    Button send;

    Button signIn;

    int sOrT;  //0为student,1为teacher

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_page);

        title = (TextView) findViewById(R.id.titleBarId);
        title.setText("手机号验证登录");

        stu = (RadioButton) findViewById(R.id.signUpAsStu);



        tea = (RadioButton) findViewById(R.id.signUpAsTea);

        send = (Button) findViewById(R.id.signUpPageSendVeriCode);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //发送验证码
                if(stu.isChecked()) {
                    Toast.makeText(v.getContext(), "为学生用户，向" + phoneNum + "发送验证码", Toast.LENGTH_SHORT).show();
                    sOrT = 0;
                }else{
                    Toast.makeText(v.getContext(), "为教师用户，向" + phoneNum + "发送验证码", Toast.LENGTH_SHORT).show();
                    sOrT = 1;
                }

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //发送验证码
                        OkHttpClient client = new OkHttpClient();
                        Log.i("1233","ok");
                        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
                        RequestBody body = RequestBody.create(mediaType, "phone_id=" + phoneNum);
                        Request request = new Request.Builder()
                                .url("http://20.20.20.133:8080/api/Student/checkByPhoneId")
                                .post(body)
                                .addHeader("Content-Type","application/x-www-form-urlencoded")
                                .build();

                        try {
                            Response response = client.newCall(request).execute();
                            String string = Objects.requireNonNull(response.body()).string();
                            Log.i("123", string);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }).start();



            }
        });

        signIn = (Button) findViewById(R.id.signUpPageSignIn) ;
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //尝试登录
                Toast.makeText(v.getContext(), "输入验证码为" + code + ", 进行核验", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(v.getContext(), SignUpInfomationCollectionPage.class);
                intent.putExtra("stuOrTea", sOrT);
                startActivity(intent);
            }
        });

        phone = (TextView) findViewById(R.id.signUpPagePhone);
        phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                checkPhone(s.toString());
            }
        });

        veriCode = (TextView) findViewById(R.id.signUpPageVeriCode);
        veriCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                checkCode(s.toString());
            }
        });

        stuOrTea = (RadioGroup) findViewById(R.id.stuOrTea);
        stuOrTea.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.signUpAsStu){

                }else if(checkedId == R.id.signUpAsTea){

                }
            }
        });




    }

    private void checkCode(String s) {
        if(s.length() < 4){

        }else{
            code = s;
        }
    }


    private void checkPhone(String s) {
        if(s.length() < 11){
//            Toast.makeText(this, "phone < 11", Toast.LENGTH_SHORT).show();
            phoneNum = s;
        }else{
            phoneNum = s;
        }
    }
}
