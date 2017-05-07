package com.w10group.completeimageview;

import android.app.Dialog;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by qiaoyuang on 2017/4/26.
 * ViewPager适配器
 */

class MyPagerAdapter extends PagerAdapter {

    private List<View> views;
    private Dialog dialog;

    MyPagerAdapter(List<View> views, Dialog dialog) {
        this.views = views;
        this.dialog = dialog;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(views.get(position));
        return views.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        if (position == 0 && views.size() == 0) {
            dialog.dismiss();
            return;
        }
        if (position == views.size()) {
            container.removeView(views.get(--position));
        } else {
            container.removeView(views.get(position));
        }
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

}