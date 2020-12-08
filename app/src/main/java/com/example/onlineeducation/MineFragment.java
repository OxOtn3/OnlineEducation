package com.example.onlineeducation;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.onlineeducation.VideoPlayPage.VideoPlayActivity;
import com.example.onlineeducation.mineFragmentPages.BoughtCoursesPageActivity;
import com.example.onlineeducation.mineFragmentPages.CoursesOperationPage;

public class MineFragment extends BaseFragment{

    private View mView;

    private ViewGroup mContainer;

    private TextView textView;

    private ImageView course1;

    private Button boughtCourses;

    private Button coursesOperation;

    public MineFragment() {
        this.TAG = "我的";
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.activity_mine, container, false);
        initData();

        boughtCourses = (Button) mView.findViewById(R.id.mine_bought_courses);
        boughtCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), BoughtCoursesPageActivity.class);
                v.getContext().startActivity(intent);
            }
        });

        coursesOperation = (Button) mView.findViewById(R.id.mine_courses_oper);
        coursesOperation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mView.getContext(), CoursesOperationPage.class);
                mView.getContext().startActivity(intent);
            }
        });

        course1 = (ImageView) mView.findViewById(R.id.mine_page_course1);
        course1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), VideoPlayActivity.class);
                v.getContext().startActivity(intent);
            }
        });



        return mView;
    }

    @Override
    protected View initView() {

        return null;
    }

    @Override
    protected void initData() {
        super.initData();
//        textView.setText("我的");
    }
}
