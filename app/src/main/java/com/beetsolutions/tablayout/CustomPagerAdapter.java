package com.beetsolutions.tablayout;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CustomPagerAdapter extends PagerAdapter {

    private Context mContext;

    public CustomPagerAdapter(Context context) {
        mContext = context;
    }

    @Override
    public Object instantiateItem(ViewGroup viewGroup, int position) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        CustomPagerEnum customPagerEnum = CustomPagerEnum.values()[position];
        ViewGroup layout = (ViewGroup) inflater.inflate(customPagerEnum.getLayoutResId(), viewGroup, false);
        viewGroup.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return CustomPagerEnum.values().length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        CustomPagerEnum customPagerEnum = CustomPagerEnum.values()[position];
        return mContext.getString(customPagerEnum.getTitleResId());
    }

    public int getPageIcon(int position) {
        CustomPagerEnum customPagerEnum = CustomPagerEnum.values()[position];
        return customPagerEnum.getIconResId();
    }
}