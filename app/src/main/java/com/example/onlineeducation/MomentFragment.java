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

import com.dou361.dialogui.DialogUIUtils;
import com.dou361.dialogui.listener.DialogUIItemListener;
import com.example.onlineeducation.VideoPlayPage.VideoPlayActivity;
import com.example.onlineeducation.courseIntroductionPage.CourseIntroductionPageActivity;
import com.example.onlineeducation.coursesPage.CoursesPageActivity;
import com.example.onlineeducation.momentPage.MomentPage;
import com.example.onlineeducation.momentUserPage.MomentUserPageActivity;
import com.example.onlineeducation.teacherHomepage.TeacherHomepageActivity;

public class MomentFragment extends BaseFragment{
    private TextView textView;

    private View mView;

    int sortSelection = 0;

    TextView picture;

    TextView description;

    TextView image;

    ImageView sortIcon;

    public MomentFragment() {
        this.TAG = "教师";
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.teachers_page, container, false);
        initData();


        image = (TextView) mView.findViewById(R.id.teachersPageImage);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TeacherHomepageActivity.class);
                startActivity(intent);
            }
        });

        sortIcon = (ImageView) mView.findViewById(R.id.teacherPageSortIcon);
        sortIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //排序功能
                String[] sorts = new String[]{"综合","教学评分", "课程访问量", "课程评分"};
                DialogUIUtils.showSingleChoose(getActivity(), "排序方式", sortSelection, sorts, true, true, new DialogUIItemListener() {
                    @Override
                    public void onItemClick(CharSequence text, int position) {
                        sortSelection = position;
                        //按照指定方式排序
                    }
                }).show();
            }
        });




//        picture = (TextView) mView.findViewById(R.id.livePic);
//        picture.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(mContext, LivePage.class);
//                mContext.startActivity(intent);
//            }
//        });

//        description = (TextView) mView.findViewById(R.id.liveDes);
//        description.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(mContext, CourseIntroductionPageActivity.class);
//                mContext.startActivity(intent);
//            }
//        });
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
