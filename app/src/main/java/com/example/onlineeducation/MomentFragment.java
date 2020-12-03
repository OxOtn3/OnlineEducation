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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.onlineeducation.momentPage.MomentPage;
import com.example.onlineeducation.momentUserPage.MomentUserPageActivity;

public class MomentFragment extends BaseFragment{
    private TextView textView;

    private View mView;

    ImageView moment1;

    ImageView userIcon1;

    public MomentFragment() {
        this.TAG = "动态";
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.activity_moment, container, false);
        initData();

        moment1 = (ImageView) mView.findViewById(R.id.moment1);
        moment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mView.getContext(), MomentPage.class);
                v.getContext().startActivity(intent);
            }
        });

        userIcon1 = (ImageView) mView.findViewById(R.id.moment_user_icon1);
        userIcon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mView.getContext(), MomentUserPageActivity.class);
                mView.getContext().startActivity(intent);
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
