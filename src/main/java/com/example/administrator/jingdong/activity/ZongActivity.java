package com.example.administrator.jingdong.activity;

import android.graphics.Color;

import com.example.administrator.jingdong.R;
import com.example.administrator.jingdong.activity.BaseActivity;
import com.example.administrator.jingdong.fragment.ClassifyFragment;
import com.example.administrator.jingdong.fragment.DiscoverFragment;
import com.example.administrator.jingdong.fragment.HomeFragment;
import com.example.administrator.jingdong.fragment.MyFragment;
import com.example.administrator.jingdong.fragment.ShoppingFragment;
import com.hjm.bottomtabbar.BottomTabBar;

public class ZongActivity extends BaseActivity {
    private BottomTabBar mBottomTabBar;
    @Override
    protected int getLayout() {
        return R.layout.zong_;
    }

    @Override
    protected void initView() {
        mBottomTabBar = (BottomTabBar) findViewById(R.id.bottom_tab_bar);
    }

    @Override
    protected void initData() {
        mBottomTabBar.init(getSupportFragmentManager())
                .setImgSize(50,50)
                .setFontSize(8)
                .setTabPadding(4,6,10)
                .setChangeColor(Color.RED,Color.DKGRAY)
                .addTabItem("首页",R.drawable.home, HomeFragment.class)
                .addTabItem("分类",R.drawable.fenlei, ClassifyFragment.class)
                .addTabItem("发现",R.drawable.faxian, DiscoverFragment.class)
                .addTabItem("购物车",R.drawable.gouwuche, ShoppingFragment.class)
                .addTabItem("我的",R.drawable.wode, MyFragment.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });
    }

}
