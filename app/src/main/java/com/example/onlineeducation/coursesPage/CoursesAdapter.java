package com.example.onlineeducation.coursesPage;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.onlineeducation.R;
import com.zhpan.bannerview.BaseBannerAdapter;

import java.util.List;

public class CoursesAdapter extends BaseBannerAdapter<coursesPageBannerViewItem, coursesPageNetViewHolder> {

    @Override
    protected void onBind(coursesPageNetViewHolder holder, coursesPageBannerViewItem data, int position, int pageSize) {
        holder.bindData(data, position, pageSize);
    }

    @Override
    public void onBindViewHolder(@NonNull coursesPageNetViewHolder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);

    }

    @Override
    public coursesPageNetViewHolder createViewHolder(@NonNull ViewGroup parent, View itemView, int viewType) {
        return new coursesPageNetViewHolder(itemView);
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.bannerview_item;
    }
}


