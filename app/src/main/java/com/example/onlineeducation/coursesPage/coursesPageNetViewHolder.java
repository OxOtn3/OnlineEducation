package com.example.onlineeducation.coursesPage;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.onlineeducation.R;
import com.example.onlineeducation.homepage.HomePageBannerViewItem;
import com.zhpan.bannerview.BaseViewHolder;

public class coursesPageNetViewHolder extends BaseViewHolder<coursesPageBannerViewItem>{


        public coursesPageNetViewHolder(@NonNull View itemView) {
            super(itemView);
            ImageView imageView = findView(R.id.banner_image);
//        imageView.setRoundCorner(BannerUtils.dp2px(0));

        }



        @Override
        public void bindData(coursesPageBannerViewItem data, int position, int pageSize) {
            ImageView imageView = findView(R.id.banner_image);
            //placeholder:默认占位图
            Glide.with(imageView).load(data.getImageId()).placeholder(R.drawable.placeholder).into(imageView);
        }

        @Override
        protected void setOnClickListener(int viewId, View.OnClickListener clickListener) {
            super.setOnClickListener(viewId, clickListener);
        }


}
