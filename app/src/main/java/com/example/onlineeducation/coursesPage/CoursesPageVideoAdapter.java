package com.example.onlineeducation.coursesPage;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineeducation.R;
import com.example.onlineeducation.courseIntroductionPage.CourseIntroductionPageActivity;
import com.example.onlineeducation.homepage.HomePageVideoAdapter;
import com.example.onlineeducation.homepage.HomePageVideoItem;

import java.util.List;

public class CoursesPageVideoAdapter extends RecyclerView.Adapter<CoursesPageVideoAdapter.ViewHolder> {

    private List<CoursesPageVideoItem> videoItemList;

    public CoursesPageVideoAdapter(List<CoursesPageVideoItem> videoItemList) {
        this.videoItemList = videoItemList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.courses_page_video_item, parent, false);
        final CoursesPageVideoAdapter.ViewHolder holder = new CoursesPageVideoAdapter.ViewHolder(view);
        holder.videoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                CoursesPageVideoItem videoItem =  videoItemList.get(position);
                //点击事件
                Toast.makeText(v.getContext(), "courses视频区position为 " + position + " 的点击事件", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(parent.getContext(), CourseIntroductionPageActivity.class);
                parent.getContext().startActivity(intent);

            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CoursesPageVideoItem videoItem = videoItemList.get(position);
        holder.videoImage.setImageResource(videoItem.getImageId());
        holder.videoDescription.setText(videoItem.getDescription());
    }

    @Override
    public int getItemCount() {
        return videoItemList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        View videoView;
        ImageView videoImage;
        TextView videoDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            videoView = itemView;
            videoImage = itemView.findViewById(R.id.coursesPageVideoImage);
            videoDescription = itemView.findViewById(R.id.coursesPageVideoDescription);
        }
    }
}
