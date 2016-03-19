package com.beetsolutions.tablayout;

public enum  CustomPagerEnum {

    CONTACT_LESS(R.string.home_label, R.drawable.ic_home_white_24dp, R.layout.fragment_home),
    QR_CODE(R.string.map_label, R.drawable.ic_map_white_24dp, R.layout.fragment_map);

    private int mTitleResId;
    private int mIconResId;
    private int mLayoutResId;

    CustomPagerEnum(int titleResId, int iconResId, int layoutResId) {
        mTitleResId = titleResId;
        mIconResId = iconResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getIconResId() {
        return mIconResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }
}
