package com.example.onlineeducation.coursesPage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.onlineeducation.R;
import com.example.onlineeducation.courseIntroductionPage.CourseIntroductionPageActivity;
import com.example.onlineeducation.homepage.HomePageVideoAdapter;
import com.example.onlineeducation.homepage.HomePageVideoItem;
import com.zhpan.bannerview.BannerViewPager;
import com.zhpan.indicator.enums.IndicatorStyle;

import java.util.ArrayList;
import java.util.List;

public class CoursesPageActivity extends Activity {

    View mView;

    List<coursesPageBannerViewItem> bannerViewItemList = new ArrayList<>();

    private List<CoursesPageVideoItem> videoItemsList = new ArrayList<>();

    private BannerViewPager<coursesPageBannerViewItem, coursesPageNetViewHolder> mViewPager;

    private ImageView sortIcon;


    class myCoursesPageBannerViewOnClickListener implements BannerViewPager.OnPageClickListener{

        @Override
        public void onPageClick(int position) {
            //点击事件
            Toast.makeText(CoursesPageActivity.this, "滑动广告position为 " + position + " 的点击事件", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(CoursesPageActivity.this, CourseIntroductionPageActivity.class);
            startActivity(intent);
        }
    }


    private void setUpViewPager(){
        mViewPager = findViewById(R.id.coursePageBannerView);
        mViewPager
                .setAutoPlay(true)
                .setScrollDuration(800)
                .setIndicatorStyle(IndicatorStyle.ROUND_RECT)
//                .setIndicatorSliderGap(getResources().getDimensionPixelOffset(R.dimen.dp_4))
//                .setIndicatorSliderWidth(getResources().getDimensionPixelOffset(R.dimen.dp_4), getResources().getDimensionPixelOffset(R.dimen.dp_10))
//                .setIndicatorSliderColor(getResources().getColor(R.color.white), getResources().getColor(R.color.black))
                .setIndicatorSliderGap(20)
                .setOrientation(ViewPager2.ORIENTATION_HORIZONTAL)
                .setInterval(3000)
                .setAdapter(new CoursesAdapter())
                .setOnPageClickListener(new myCoursesPageBannerViewOnClickListener())
                .registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
                    @Override
                    public void onPageSelected(int position) {
                        super.onPageSelected(position);
                        coursesPageBannerViewItem cpbvi = mViewPager.getData().get(position);
                    }
                }).create(bannerViewItemList);
        //异步创建方法:
        //.create()
        //成功读入数据后
        //mViewPager.refreshData(data)

    }



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initData();

        setContentView(R.layout.courses_page);
        setUpViewPager();
//        mViewPager.setLifecycleRegistry(getLifecycle());

        setUpRecyclerView();

        sortIcon = (ImageView) findViewById(R.id.coursePageSortIcon);
        sortIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //排序功能
                Toast.makeText(CoursesPageActivity.this, "排序功能!", Toast.LENGTH_SHORT).show();
            }
        });






    }


    private void setUpRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.coursesPageRecyclerView);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        CoursesPageVideoAdapter videoAdapter = new CoursesPageVideoAdapter(videoItemsList);
        recyclerView.setAdapter(videoAdapter);
    }


    private void initData() {
        for(int i = 0; i < 2; i++){
            coursesPageBannerViewItem item1 = new coursesPageBannerViewItem(R.drawable.photography, "ad1");
            bannerViewItemList.add(item1);
            coursesPageBannerViewItem item2 = new coursesPageBannerViewItem(R.drawable.photography, "ad2");
            bannerViewItemList.add(item2);
        }


        for(int i = 0; i < 5; i++){
            CoursesPageVideoItem vItem1 = new CoursesPageVideoItem("history", R.drawable.history, "history\n李四四 老师 \n教师评分4.0");
            videoItemsList.add(vItem1);
            CoursesPageVideoItem vItem2 = new CoursesPageVideoItem("photography", R.drawable.photography, "photography\n张三 老师 \n教师评分4.7");
            videoItemsList.add(vItem2);
            CoursesPageVideoItem vItem3 = new CoursesPageVideoItem("video", R.drawable.video, "video\n王五 老师 \n教师评分4.6");
            videoItemsList.add(vItem3);

        }

    }


}
