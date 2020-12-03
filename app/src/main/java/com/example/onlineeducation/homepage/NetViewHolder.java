package com.example.onlineeducation.homepage;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.onlineeducation.R;
import com.zhpan.bannerview.BaseViewHolder;
import com.zhpan.bannerview.utils.BannerUtils;


public class NetViewHolder extends BaseViewHolder<HomePageBannerViewItem>{

    public NetViewHolder(@NonNull View itemView) {
        super(itemView);
        ImageView imageView = findView(R.id.banner_image);
//        imageView.setRoundCorner(BannerUtils.dp2px(0));

    }



    @Override
    public void bindData(HomePageBannerViewItem data, int position, int pageSize) {
        ImageView imageView = findView(R.id.banner_image);
        //placeholder:默认占位图
        Glide.with(imageView).load(data.getImageId()).placeholder(R.drawable.placeholder).into(imageView);
    }

    @Override
    protected void setOnClickListener(int viewId, View.OnClickListener clickListener) {
        super.setOnClickListener(viewId, clickListener);
    }
}