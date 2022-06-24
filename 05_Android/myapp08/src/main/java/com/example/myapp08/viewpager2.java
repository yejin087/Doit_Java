package com.example.myapp08;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;

import me.relex.circleindicator.CircleIndicator3;

public class viewpager2 extends AppCompatActivity {
	
	private final int numPage = 4;
	private ViewPager2 viewPager2;
	private FragmentStateAdapter fragmentStateAdapter;
	private CircleIndicator3 circleIndicator3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_viewpager2);
		
		//adapter
		viewPager2 = findViewById(R.id.viewpager2);
		fragmentStateAdapter = new MyFragmentAdaper(this, numPage);
		viewPager2.setAdapter(fragmentStateAdapter);
		
		//indicator
		circleIndicator3 = findViewById(R.id.indicator);
		circleIndicator3.setViewPager(viewPager2);
		circleIndicator3.createIndicators(numPage, 0);
		
		//viewpage settings
		viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
		viewPager2.setCurrentItem(0);
		viewPager2.setOffscreenPageLimit(3);
		
		viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
				super.onPageScrolled(position, positionOffset, positionOffsetPixels);

//				Log.d(">>>", "" + positionOffset);
//				if (positionOffset == 0) {
//					viewPager2.setCurrentItem(0);
//				}
			}
			
			@Override
			public void onPageSelected(int position) {
				super.onPageSelected(position);
				circleIndicator3.animatePageSelected(position % numPage);
				
			}
		});
		
	}
}