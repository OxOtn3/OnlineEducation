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
import android.widget.Toast;

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

import scut.carson_ho.searchview.ICallBack;
import scut.carson_ho.searchview.bCallBack;

public class ClassificationFragment extends BaseFragment{

    private View mView;
    private ViewGroup mContainer;
    private SearchView searchView;
    private List<ClassificationItem> itemList = new ArrayList<>();
    private scut.carson_ho.searchview.SearchView sv;


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

        searchView = (SearchView) mView.findViewById(R.id.classificationSearchView);
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mView.getContext(), SearchPage.class);
                mView.getContext().startActivity(intent);
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
            ClassificationItem i1 = new ClassificationItem("计算机", R.drawable.i01);
            itemList.add(i1);
            ClassificationItem i2= new ClassificationItem("经管", R.drawable.i02);
            itemList.add(i2);
            ClassificationItem i3 = new ClassificationItem("心理学", R.drawable.i03);
            itemList.add(i3);
            ClassificationItem i4 = new ClassificationItem("经济学", R.drawable.i04);
            itemList.add(i4);
            ClassificationItem i5 = new ClassificationItem("金融", R.drawable.i05);
            itemList.add(i5);
            ClassificationItem i6 = new ClassificationItem("会计", R.drawable.i06);
            itemList.add(i6);
            ClassificationItem i7 = new ClassificationItem("金融考证", R.drawable.i07);
            itemList.add(i7);
            ClassificationItem i8 = new ClassificationItem("管理", R.drawable.i08);
            itemList.add(i8);
            ClassificationItem i9 = new ClassificationItem("数学", R.drawable.i09);
            itemList.add(i9);
            ClassificationItem i10 = new ClassificationItem("物理", R.drawable.i10);
            itemList.add(i10);
            ClassificationItem i11 = new ClassificationItem("化学", R.drawable.i11);
            itemList.add(i11);
            ClassificationItem i12 = new ClassificationItem("地理", R.drawable.i12);
            itemList.add(i12);
            ClassificationItem i13 = new ClassificationItem("生物", R.drawable.i13);
            itemList.add(i13);
            ClassificationItem i14 = new ClassificationItem("电气信息", R.drawable.i14);
            itemList.add(i14);
            ClassificationItem i15 = new ClassificationItem("土木", R.drawable.i15);
            itemList.add(i15);
            ClassificationItem i16 = new ClassificationItem("写作翻译", R.drawable.i16);
            itemList.add(i16);
            ClassificationItem i17 = new ClassificationItem("四六级", R.drawable.i17);
            itemList.add(i17);
            ClassificationItem i18 = new ClassificationItem("听力口语", R.drawable.i18);
            itemList.add(i18);
            ClassificationItem i19 = new ClassificationItem("程序设计", R.drawable.i19);
            itemList.add(i19);
            ClassificationItem i20 = new ClassificationItem("网络安全", R.drawable.i20);
            itemList.add(i20);
            ClassificationItem i21 = new ClassificationItem("其它", R.drawable.i21);
            itemList.add(i21);
        }

    }
}
