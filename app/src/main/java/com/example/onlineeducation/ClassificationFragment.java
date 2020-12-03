package com.example.onlineeducation;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineeducation.classification.ClassificationItem;
import com.example.onlineeducation.classification.ClassificationItemAdapter;
import com.example.onlineeducation.coursesPage.CoursesPageActivity;

import java.util.ArrayList;
import java.util.List;

public class ClassificationFragment extends BaseFragment{

    private View mView;
    private ViewGroup mContainer;
    private SearchView searchView;
    private List<ClassificationItem> itemList = new ArrayList<>();



    public ClassificationFragment() {
        this.TAG = "分类";
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.activity_classification, container, false);
        initData();
        RecyclerView recyclerView = (RecyclerView) mView.findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(mContext, 3);
        recyclerView.setLayoutManager(layoutManager);
        ClassificationItemAdapter adapter = new ClassificationItemAdapter(itemList);
        recyclerView.setAdapter(adapter);
        return mView;
    }


    @Override
    protected View initView() {

        return null;
    }

    @Override
    protected void initData() {
        super.initData();
        for(int i = 0; i < 10; i++){
            ClassificationItem video = new ClassificationItem("video", R.drawable.video);
            itemList.add(video);
            ClassificationItem history = new ClassificationItem("history", R.drawable.history);
            itemList.add(history);
            ClassificationItem photography = new ClassificationItem("photography", R.drawable.photography);
            itemList.add(photography);
        }

    }
}
