package com.gangwantech.easyjazzyviewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.jfeinstein.jazzyviewpager.JazzyViewPager;
import com.nineoldandroids.view.ViewHelper;

/**
 * Created by HighFun on 2015/7/15.
 */
public class EasyJazzyViewPager extends JazzyViewPager {
    private SimplePagerAdapter simplePagerAdapter = new SimplePagerAdapter(this);
    public EasyJazzyViewPager(Context context) {
        super(context);
        init();
    }

    public EasyJazzyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setAdapter(simplePagerAdapter);
    }

    public void addViewEasily(View view){
        simplePagerAdapter.addView(view);
    }

    public void setTransitionEffect(TransitionEffect effect) {
        super.setTransitionEffect(effect);
        reset();
    }

    public void reset() {
        resetPrivate();
        int curr = getCurrentItem();
        onPageScrolled(curr, 0.0f, 0);
    }

    private void resetPrivate() {
        if (simplePagerAdapter == null){
            return;
        }
        for (int i = 0; i < simplePagerAdapter.getCount(); i++) {
            View v = simplePagerAdapter.getView(i);
            //			ViewHelper.setRotation(v, -ViewHelper.getRotation(v));
            //			ViewHelper.setRotationX(v, -ViewHelper.getRotationX(v));
            //			ViewHelper.setRotationY(v, -ViewHelper.getRotationY(v));
            //
            //			ViewHelper.setTranslationX(v, -ViewHelper.getTranslationX(v));
            //			ViewHelper.setTranslationY(v, -ViewHelper.getTranslationY(v));

            ViewHelper.setRotation(v, 0);
            ViewHelper.setRotationX(v, 0);
            ViewHelper.setRotationY(v, 0);

            ViewHelper.setTranslationX(v, 0);
            ViewHelper.setTranslationY(v, 0);

            ViewHelper.setAlpha(v, 1.0f);

            ViewHelper.setScaleX(v, 1.0f);
            ViewHelper.setScaleY(v, 1.0f);

            ViewHelper.setPivotX(v, 0);
            ViewHelper.setPivotY(v, 0);

        }
    }


}
