package com.example.onlineeducation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private RadioGroup mRg_main;
    private List<BaseFragment> mBaseFragment;

    private int position;
    private Fragment mContent;
    private SearchView searchView;
    private TextView titleBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        initFragment();
        setListener();
    }

    private void setListener() {
        mRg_main.setOnCheckedChangeListener(new MyOnCheckChangeListener());
        //设置默认选中首页界面
        mRg_main.check(R.id.homePage);
    }

    class MyOnCheckChangeListener implements RadioGroup.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.homePage:
                    position = 0;
                    break;
                case R.id.classification:
                    position = 1;
                    break;
                case R.id.moments:
                    position = 2;
                    break;
                case R.id.mine:
                    position = 3;
                    break;
                default:
                    position = 0;
                    break;
            }

            BaseFragment to = getFragment();
            switchFragment(mContent, to);
        }
    }

    /**
     *
     * @param from 刚显示的Fragment，将被隐藏
     * @param to 即将切换到的Fragment
     */
    private void switchFragment(Fragment from, BaseFragment to){
        if(from != to){
            mContent = to;
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();  //开启事务
            titleBar = (TextView) findViewById(R.id.titleBarId);
            titleBar.setText(to.TAG);
            //判断to有没有被添加
            if(!to.isAdded()){  //没有添加
                if(from != null){
                    ft.hide(from);
                }
                if(to != null){
                    ft.add(R.id.fl_content, to).commit();
                }
            }else{  //已经添加
                if(from != null){
                    ft.hide(from);
                }
                if(to != null){
                    ft.show(to).commit();
                }
            }

        }
    }

    private BaseFragment getFragment() {
        BaseFragment fragment = mBaseFragment.get(position);
        return fragment;
    }


    private void initFragment() {
        mBaseFragment = new ArrayList<>();
        mBaseFragment.add(new homePageFragment());
        mBaseFragment.add(new ClassificationFragment());
        mBaseFragment.add(new MomentFragment());
        mBaseFragment.add(new MineFragment());
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        mRg_main = (RadioGroup) findViewById(R.id.rg_main);

    }
}