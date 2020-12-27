package com.example.onlineeducation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.dou361.dialogui.DialogUIUtils;
import com.dou361.dialogui.bean.BuildBean;

public class SignUpInfomationCollectionPage extends Activity {



    TextView title;

    TextView uploadTeaPic;

    TextView uploadTeaPicText;

    TextView grade;

    EditText gd;

    int stuOrTea;

    RadioGroup gender;

    Button submit;

    int genders;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_information_collecting_page);

        title = (TextView) findViewById(R.id.titleBarId);
        title.setText("注册信息填写");

        uploadTeaPic = (TextView) findViewById(R.id.uploadTeaVeriPhoto);

        uploadTeaPicText = (TextView) findViewById(R.id.uploadTeaVeriPhotoText);

        grade = (TextView) findViewById(R.id.grade);

        gd = (EditText) findViewById(R.id.gradeText);

        gender = (RadioGroup)findViewById(R.id.gender);
        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.male){
                    genders = 0;
                }else if(checkedId == R.id.female){
                    genders = 1;
                }
            }
        });

        Intent intent = getIntent();
        stuOrTea = intent.getIntExtra("stuOrTea", 0);


        if(stuOrTea == 0) {
            //是学生用户
            uploadTeaPic.setVisibility(View.GONE);
            uploadTeaPicText.setVisibility(View.GONE);
        }else if (stuOrTea == 1){
            //是教师用户
            grade.setVisibility(View.GONE);
            gd.setVisibility(View.GONE);
        }

        submit = (Button) findViewById(R.id.userInfoColPageSubmit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText nn = (EditText)findViewById(R.id.nickname);
                String nickname = nn.getText().toString();
                EditText pw = (EditText)findViewById(R.id.password);
                String password = pw.getText().toString();
                EditText wc = (EditText)findViewById(R.id.wechatAccount);
                String wechat = wc.getText().toString();
                EditText sc = (EditText)findViewById(R.id.school);
                String school = sc.getText().toString();
                EditText gr = (EditText)findViewById(R.id.gradeText);
                String grade = gr.getText().toString();

                Toast.makeText(v.getContext(), "为" + stuOrTea + "类型用户注册(0为学生,1为教师)\n"
                        + "昵称为:" + nickname + "\n"
                        + "密码为:" + password + "\n"
                        + "微信为:" + wechat + "\n"
                        + "性别为(0为男,1为女):" + genders + "\n"
                        + "学校为:" + school + "\n"
                        + "(仅学生)年级为:" + grade + "\n"
                        , Toast.LENGTH_LONG).show();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //将用户信息录入数据库


                    }
                }).start();


                DialogUIUtils.showLoading(v.getContext(), "发送中", true, true, true, true).show();

            }
        });




    }
}
