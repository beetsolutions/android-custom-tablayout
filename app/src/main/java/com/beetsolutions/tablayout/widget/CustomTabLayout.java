package com.beetsolutions.tablayout.widget;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

import com.beetsolutions.tablayout.CustomPagerAdapter;
import com.beetsolutions.tablayout.R;

/**
 * Custom TabLayout with Tex and Tinted Icons
 */
public class CustomTabLayout extends TabLayout {

    public CustomTabLayout(Context context) {
        super(context);
    }

    public CustomTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setupWithViewPager(ViewPager viewPager) {
        super.setupWithViewPager(viewPager);
        CustomPagerAdapter adapter = (CustomPagerAdapter) viewPager.getAdapter();
        this.removeAllTabs();
        int i = 0;
        for (int count = adapter.getCount(); i < count; ++i) {
            Tab tab = this.newTab();
            tab.setIcon(adapter.getPageIcon(i));
            tab.setText(adapter.getPageTitle(i));
            Drawable icon = tab.getIcon();
            if (icon != null && i == 0) {
                icon.setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_IN);
            }
            this.addTab(tab);
        }
    }
}
