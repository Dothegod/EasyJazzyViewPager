package com.jfeinstein.test;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import com.gangwantech.easyjazzyviewpager.EasyJazzyViewPager;
import com.jfeinstein.jazzyviewpager.JazzyViewPager.TransitionEffect;

public class MainActivity extends Activity {

	private EasyJazzyViewPager mJazzy;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setupJazziness(TransitionEffect.Tablet);
		addView(1);
		addView(2);
		addView(3);
		addView(4);
		addView(5);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add("Toggle Fade");
		String[] effects = this.getResources().getStringArray(R.array.jazzy_effects);
		for (String effect : effects)
			menu.add(effect);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getTitle().toString().equals("Toggle Fade")) {
			mJazzy.setFadeEnabled(!mJazzy.getFadeEnabled());
		} else {
			TransitionEffect effect = TransitionEffect.valueOf(item.getTitle().toString());
			setupJazziness(effect);
		}
		return true;
	}

	private void setupJazziness(TransitionEffect effect) {
		mJazzy = (EasyJazzyViewPager) findViewById(R.id.jazzy_pager);
		mJazzy.setTransitionEffect(effect);
		mJazzy.setPageMargin(30);
	}

	private void addView(int id) {
		TextView text = new TextView(MainActivity.this);
		text.setGravity(Gravity.CENTER);
		text.setTextSize(30);
		text.setTextColor(Color.WHITE);
		text.setText("Page " + id);
		text.setPadding(30, 30, 30, 30);
		int bg = Color.rgb((int) Math.floor(Math.random()*128)+64,
				(int) Math.floor(Math.random()*128)+64,
				(int) Math.floor(Math.random()*128)+64);
		text.setBackgroundColor(bg);
		mJazzy.addViewEasily(text);
	}
}
