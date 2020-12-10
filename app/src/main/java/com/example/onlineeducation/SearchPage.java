package com.example.onlineeducation;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import scut.carson_ho.searchview.ICallBack;
import scut.carson_ho.searchview.SearchView;
import scut.carson_ho.searchview.bCallBack;

public class SearchPage extends Activity {

    private SearchView sv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_page);

        sv = findViewById(R.id.search_view);

        // 设置点击键盘上的搜索按键后的操作（通过回调接口）
        // 参数 = 搜索框输入的内容
        sv.setOnClickSearch(new ICallBack() {
            @Override
            public void SearchAciton(String string) {
                System.out.println("我收到了" + string);
            }
        });

        // 设置点击返回按键后的操作（通过回调接口）
        sv.setOnClickBack(new bCallBack() {
            @Override
            public void BackAciton() {
                finish();
            }
        });
    }
}
