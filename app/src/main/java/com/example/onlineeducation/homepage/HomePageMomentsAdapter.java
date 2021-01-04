package com.example.onlineeducation.homepage;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineeducation.MainActivity;
import com.example.onlineeducation.R;
import com.example.onlineeducation.coursesPage.CoursesPageActivity;
import com.example.onlineeducation.momentPage.MomentPage;

import java.util.List;

public class HomePageMomentsAdapter extends RecyclerView.Adapter<HomePageMomentsAdapter.ViewHolder> {

   private List<HomePageMomentsItem> mMomentsList;

    public HomePageMomentsAdapter(List<HomePageMomentsItem> mMomentsList) {
        this.mMomentsList = mMomentsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.homepage_moments_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.momentsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                //点击事件
                Toast.makeText(v.getContext(), "作业墙position为" + position + " 的点击事件", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(v.getContext(), MomentPage.class);
                v.getContext().startActivity(intent);

            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HomePageMomentsItem item = mMomentsList.get(position);
        holder.homePageMomentsItemImage.setImageResource(item.getTempImageId());

    }

    @Override
    public int getItemCount() {
        return mMomentsList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView homePageMomentsItemImage;
        View momentsView;

       public ViewHolder(@NonNull View itemView) {
           super(itemView);
           momentsView = itemView;
           homePageMomentsItemImage = itemView.findViewById(R.id.homePageMomentsItemImage);
       }
   }


}
