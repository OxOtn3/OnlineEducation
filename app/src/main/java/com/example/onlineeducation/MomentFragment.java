package com.example.onlineeducation;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.onlineeducation.VideoPlayPage.VideoPlayActivity;
import com.example.onlineeducation.courseIntroductionPage.CourseIntroductionPageActivity;
import com.example.onlineeducation.momentPage.MomentPage;
import com.example.onlineeducation.momentUserPage.MomentUserPageActivity;

public class MomentFragment extends BaseFragment{
    private TextView textView;

    private View mView;

    TextView picture;

    TextView description;

    public MomentFragment() {
        this.TAG = "直播";
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.activity_live, container, false);
        initData();

        picture = (TextView) mView.findViewById(R.id.livePic);
        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, VideoPlayActivity.class);
                mContext.startActivity(intent);
            }
        });

        description = (TextView) mView.findViewById(R.id.liveDes);
        description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, CourseIntroductionPageActivity.class);
                mContext.startActivity(intent);
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
    }


}
