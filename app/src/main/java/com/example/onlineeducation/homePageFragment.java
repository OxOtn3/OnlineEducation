package com.example.onlineeducation;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.onlineeducation.courseIntroductionPage.CourseIntroductionPageActivity;
import com.example.onlineeducation.homepage.HomeAdapter;
import com.example.onlineeducation.homepage.HomePageBannerViewItem;
import com.example.onlineeducation.homepage.HomePageMomentsAdapter;
import com.example.onlineeducation.homepage.HomePageMomentsItem;
import com.example.onlineeducation.homepage.HomePageVideoAdapter;
import com.example.onlineeducation.homepage.HomePageVideoItem;
import com.example.onlineeducation.homepage.NetViewHolder;
import com.zhpan.bannerview.BannerViewPager;
import com.zhpan.indicator.enums.IndicatorStyle;

import java.util.ArrayList;
import java.util.List;

public class homePageFragment extends BaseFragment{
    private TextView homePageBannerViewText;
    View mView;
    List<HomePageBannerViewItem> bannerViewItemList = new ArrayList<>();

    private RecyclerView recyclerView0;

    private ImageView keywordSearch;

    private List<HomePageMomentsItem> momentsItemList = new ArrayList<>();

    private BannerViewPager<HomePageBannerViewItem, NetViewHolder> mViewPager;

    private TextView dttj;

    private Button searchByTeacher;

    private List<HomePageVideoItem> videoItemsList = new ArrayList<>();

    public homePageFragment() {
        this.TAG = "首页";
    }

    class myHomePageBannerViewOnClickListener implements BannerViewPager.OnPageClickListener{

        @Override
        public void onPageClick(int position) {
            //点击事件
            Toast.makeText(getContext(), "滑动广告position为 " + position + " 的点击事件", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(getContext(), CourseIntroductionPageActivity.class);
            getContext().startActivity(intent);


        }
    }


    private void setUpViewPager(){
        mViewPager = mView.findViewById(R.id.homePageBannerView);
        homePageBannerViewText = mView.findViewById(R.id.banner_description);
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
                .setAdapter(new HomeAdapter())
                .setOnPageClickListener(new myHomePageBannerViewOnClickListener())
                .registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
                    @Override
                    public void onPageSelected(int position) {
                        super.onPageSelected(position);
                        HomePageBannerViewItem hpbvi = mViewPager.getData().get(position);
//                        homePageBannerViewText.setText("updated text");
                    }
                }).create(bannerViewItemList);
                //异步创建方法:
                //.create()
                //成功读入数据后
                //mViewPager.refreshData(data)

    }






    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.activity_homepage, container, false);
        initData();
        setUpViewPager();
        mViewPager.setLifecycleRegistry(getLifecycle());

//        dttj = (TextView) mView.findViewById(R.id.dongtaituijian);

//        searchByTeacher = (Button) mView.findViewById(R.id.homePageSearchByTeacher);
//        searchByTeacher.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(mContext, TeachersPage.class);
//                mContext.startActivity(intent);
//            }
//        });

        keywordSearch = (ImageView) mView.findViewById(R.id.homePageKeywordSearch);
        keywordSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, SearchKeywordPage.class);
                mContext.startActivity(intent);
            }
        });

        recyclerView0 = (RecyclerView) mView.findViewById(R.id.homePageRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView0.setLayoutManager(layoutManager);
        HomePageMomentsAdapter momentsAdapter = new HomePageMomentsAdapter(momentsItemList);
        recyclerView0.setAdapter(momentsAdapter);

        RecyclerView recyclerView1 = (RecyclerView) mView.findViewById(R.id.homePageRecyclerView2);
        GridLayoutManager layoutManager1 = new GridLayoutManager(mContext, 2);
        recyclerView1.setLayoutManager(layoutManager1);
        HomePageVideoAdapter videoAdapter = new HomePageVideoAdapter(videoItemsList);
        recyclerView1.setAdapter(videoAdapter);
        recyclerView1.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if(dy > 0){
                    mViewPager.setVisibility(View.GONE);
//                    dttj.setVisibility(View.GONE);
                    //-------------------********---------------------------
                    //-------------------********---------------------------
                    //-------------------********---------------------------
//                    recyclerView0.setVisibility(View.GONE);
                }else{
                    mViewPager.setVisibility(View.VISIBLE);
//                    dttj.setVisibility(View.VISIBLE);
//                    recyclerView0.setVisibility(View.VISIBLE);
                }
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

        for(int i = 0; i < 1; i++){
            HomePageBannerViewItem item1 = new HomePageBannerViewItem(R.drawable.ad01, "ad1");
            bannerViewItemList.add(item1);
            HomePageBannerViewItem item2 = new HomePageBannerViewItem(R.drawable.ad2, "ad2");
            bannerViewItemList.add(item2);
            HomePageBannerViewItem item3 = new HomePageBannerViewItem(R.drawable.ad03, "ad3");
            bannerViewItemList.add(item3);
            HomePageBannerViewItem item4 = new HomePageBannerViewItem(R.drawable.ad4, "ad4");
            bannerViewItemList.add(item4);
        }

        for(int i = 0; i < 5; i++){
            HomePageMomentsItem tempItem1 = new HomePageMomentsItem(R.drawable.video);
            momentsItemList.add(tempItem1);
            HomePageMomentsItem tempItem2 = new HomePageMomentsItem(R.drawable.history);
            momentsItemList.add(tempItem2);
        }

        for(int i = 0; i < 3; i++){
            HomePageVideoItem vItem1 = new HomePageVideoItem("电气工程基础(上)", R.drawable.c01);
            videoItemsList.add(vItem1);
            HomePageVideoItem vItem2 = new HomePageVideoItem("工程电磁场", R.drawable.c02);
            videoItemsList.add(vItem2);
            HomePageVideoItem vItem3 = new HomePageVideoItem("逻辑学导论", R.drawable.c03);
            videoItemsList.add(vItem3);
            HomePageVideoItem vItem4 = new HomePageVideoItem("模拟电子技术基础", R.drawable.c04);
            videoItemsList.add(vItem4);
            HomePageVideoItem vItem5 = new HomePageVideoItem("数据分析", R.drawable.c05);
            videoItemsList.add(vItem5);
            HomePageVideoItem vItem6 = new HomePageVideoItem("微信小程序开发", R.drawable.c06);
            videoItemsList.add(vItem6);
            HomePageVideoItem vItem7 = new HomePageVideoItem("Java程序设计", R.drawable.c07);
            videoItemsList.add(vItem7);

        }
    }
}
