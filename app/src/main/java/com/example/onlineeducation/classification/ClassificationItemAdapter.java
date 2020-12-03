package com.example.onlineeducation.classification;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineeducation.MainActivity;
import com.example.onlineeducation.MineFragment;
import com.example.onlineeducation.R;
import com.example.onlineeducation.coursesPage.CoursesPageActivity;

import java.util.List;

public class ClassificationItemAdapter extends RecyclerView.Adapter<ClassificationItemAdapter.ViewHolder> {
    private List<ClassificationItem> mItemList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        View itemView;
        ImageView itemImage;
        TextView itemName;

        public ViewHolder(@NonNull View view) {
            super(view);
            itemView = view;
            itemImage = (ImageView) view.findViewById(R.id.classification_image);
            itemName = (TextView) view.findViewById(R.id.classification_name);
        }
    }

    public ClassificationItemAdapter(List<ClassificationItem> itemList){
        mItemList = itemList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.classification_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                ClassificationItem item = mItemList.get(position);
                //点击事件
                Toast.makeText(v.getContext(), item.getName() + "的点击事件", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(v.getContext(), CoursesPageActivity.class);
                v.getContext().startActivity(intent);
            }
        });
        return holder;
    }


    //当每个子项被滚动到屏幕内时执行
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ClassificationItem item = mItemList.get(position);
        holder.itemImage.setImageResource(item.getImageId());
        holder.itemName.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }
}
