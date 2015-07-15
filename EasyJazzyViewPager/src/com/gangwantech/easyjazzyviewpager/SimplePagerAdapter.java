package com.gangwantech.easyjazzyviewpager;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.jfeinstein.jazzyviewpager.JazzyViewPager;
import com.jfeinstein.jazzyviewpager.OutlineContainer;

import java.util.ArrayList;

/**
 * Created by HighFun on 2015/7/15.
 */
public class SimplePagerAdapter extends PagerAdapter {
    private ArrayList<View> viewList = new ArrayList<View>();
    private JazzyViewPager viewPager ;

    public SimplePagerAdapter(JazzyViewPager viewPager){
         this.viewPager = viewPager;
    }

    public void addView(View view){
        viewList.add(view);
    }

    public View getView(int index){
        return viewList.get(index);
    }
    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        container.addView(viewList.get(position), ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        viewPager.setObjectForPosition(viewList.get(position), position);
        return viewList.get(position);
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object obj) {
        container.removeView(viewList.get(position));
    }
    @Override
    public int getCount() {
        return viewList.size();
    }
    @Override
    public boolean isViewFromObject(View view, Object obj) {
        if (view instanceof OutlineContainer) {
            return ((OutlineContainer) view).getChildAt(0) == obj;
        } else {
            return view == obj;
        }
    }
}
