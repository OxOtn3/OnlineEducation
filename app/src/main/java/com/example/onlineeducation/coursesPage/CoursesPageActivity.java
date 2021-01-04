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

import com.dou361.dialogui.DialogUIUtils;
import com.dou361.dialogui.listener.DialogUIItemListener;
import com.example.onlineeducation.R;
import com.example.onlineeducation.courseIntroductionPage.CourseIntroductionPageActivity;
import com.example.onlineeducation.homepage.HomePageVideoAdapter;
import com.example.onlineeducation.homepage.HomePageVideoItem;
import com.zhpan.bannerview.BannerViewPager;
import com.zhpan.indicator.enums.IndicatorStyle;

import java.util.ArrayList;
import java.util.List;

import static com.dou361.dialogui.DialogUIUtils.showToast;

public class CoursesPageActivity extends Activity {

    int sortSelection = 0;

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
                String[] sorts = new String[]{"综合","课程评分", "课程访问量", "教师评分"};
                DialogUIUtils.showSingleChoose(CoursesPageActivity.this, "排序方式", sortSelection, sorts, true, true, new DialogUIItemListener() {
                    @Override
                    public void onItemClick(CharSequence text, int position) {
                        sortSelection = position;
                        //按照指定方式排序
                    }
                }).show();
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
        for(int i = 0; i < 1; i++){
            coursesPageBannerViewItem item1 = new coursesPageBannerViewItem(R.drawable.ad2, "ad1");
            bannerViewItemList.add(item1);
            coursesPageBannerViewItem item2 = new coursesPageBannerViewItem(R.drawable.ad03, "ad2");
            bannerViewItemList.add(item2);
            coursesPageBannerViewItem item3 = new coursesPageBannerViewItem(R.drawable.ad01, "ad2");
            bannerViewItemList.add(item3);
            coursesPageBannerViewItem item4 = new coursesPageBannerViewItem(R.drawable.ad4, "ad2");
            bannerViewItemList.add(item4);
        }


        for(int i = 0; i < 2; i++){
            CoursesPageVideoItem vItem1 = new CoursesPageVideoItem("history", R.drawable.c04, "模拟电子技术基础\n李四四 老师 \n教师评分4.3");
            videoItemsList.add(vItem1);
            CoursesPageVideoItem vItem2 = new CoursesPageVideoItem("photography", R.drawable.c03, "逻辑学导论\n张山 老师 \n教师评分4.7");
            videoItemsList.add(vItem2);
            CoursesPageVideoItem vItem3 = new CoursesPageVideoItem("video", R.drawable.c01, "电气工程基础(上)\n李凯明 老师 \n教师评分4.6");
            videoItemsList.add(vItem3);
            CoursesPageVideoItem vItem4 = new CoursesPageVideoItem("video", R.drawable.c02, "工程电磁场\n李乌 老师 \n教师评分4.6");
            videoItemsList.add(vItem4);
            CoursesPageVideoItem vItem5 = new CoursesPageVideoItem("video", R.drawable.c06, "微信小程序开发\n丁海 老师 \n教师评分4.8");
            videoItemsList.add(vItem5);
            CoursesPageVideoItem vItem6 = new CoursesPageVideoItem("video", R.drawable.c07, "Java程序设计\n王凯 老师 \n教师评分4.7");
            videoItemsList.add(vItem6);
            CoursesPageVideoItem vItem7 = new CoursesPageVideoItem("video", R.drawable.c05, "Python数据分析\n张磊磊 老师 \n教师评分4.9");
            videoItemsList.add(vItem7);

        }

    }


}
