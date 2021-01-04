package com.example.onlineeducation.homepage;

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
import com.example.onlineeducation.VideoPlayPage.VideoPlayActivity;
import com.example.onlineeducation.classification.ClassificationItem;

import java.util.List;

public class HomePageVideoAdapter extends RecyclerView.Adapter<HomePageVideoAdapter.ViewHolder> {

    private List<HomePageVideoItem> videoItemList;

    public HomePageVideoAdapter(List<HomePageVideoItem> videoItemList) {
        this.videoItemList = videoItemList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        View videoView;
        ImageView videoImage;
        TextView videoName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            videoView = itemView;
            videoImage = itemView.findViewById(R.id.homePageVideoImage);
            videoName = itemView.findViewById(R.id.homePageVideoName);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.homepage_video_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.videoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                HomePageVideoItem videoItem =  videoItemList.get(position);
                //点击事件
                Toast.makeText(v.getContext(), "视频区position为 " + position + " 的点击事件", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(v.getContext(), VideoPlayActivity.class);
                v.getContext().startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HomePageVideoItem videoItem = videoItemList.get(position);
        holder.videoImage.setImageResource(videoItem.getImageId());
        holder.videoName.setText(videoItem.getName());


    }

    @Override
    public int getItemCount() {
        return videoItemList.size();
    }
}
