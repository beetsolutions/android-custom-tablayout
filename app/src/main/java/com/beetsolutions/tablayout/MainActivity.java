package com.beetsolutions.tablayout;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.beetsolutions.tablayout.widget.CustomTabLayout;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements CustomTabLayout.OnTabSelectedListener {

    @Bind(R.id.container)
    ViewPager mViewPager;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.tabs)
    CustomTabLayout mCustomTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        mViewPager.setAdapter(new CustomPagerAdapter(this));
        mCustomTabLayout.setupWithViewPager(mViewPager);
        mCustomTabLayout.setOnTabSelectedListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        Drawable icon = tab.getIcon();
        if(icon != null) {
            icon.setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_IN);
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        Drawable icon = tab.getIcon();
        if(icon != null) {
            icon.setColorFilter(null);
        }
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
    }
}
