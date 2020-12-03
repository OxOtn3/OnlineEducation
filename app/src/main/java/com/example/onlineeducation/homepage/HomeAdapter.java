package com.example.onlineeducation.homepage;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.onlineeducation.R;
import com.zhpan.bannerview.BaseBannerAdapter;

import java.util.List;

public class HomeAdapter extends BaseBannerAdapter<HomePageBannerViewItem, NetViewHolder> {

    @Override
    protected void onBind(NetViewHolder holder, HomePageBannerViewItem data, int position, int pageSize) {
        holder.bindData(data, position, pageSize);
    }

    @Override
    public void onBindViewHolder(@NonNull NetViewHolder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);

    }

    @Override
    public NetViewHolder createViewHolder(@NonNull ViewGroup parent, View itemView, int viewType) {
        return new NetViewHolder(itemView);
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.bannerview_item;
    }
}
