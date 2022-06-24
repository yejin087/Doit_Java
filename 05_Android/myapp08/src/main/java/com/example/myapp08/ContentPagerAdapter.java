package com.example.myapp08;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ContentPagerAdapter extends FragmentStateAdapter {
	
	private final int pageCount = 3;
	
	public ContentPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
		super(fragmentActivity);
	}
	
	@NonNull
	@Override
	public Fragment createFragment(int position) {
		
		switch (position) {
			case 0:
				tab1 tab1 = new tab1();
				return tab1;
			case 1:
				tab2 tab2 = new tab2();
				return tab2;
			case 2:
				tab3 tab3 = new tab3();
				return tab3;
			default:
				return null;
		}
		
	}
	
	@Override
	public long getItemId(int position) {
		return super.getItemId(position);
	}
	
	@Override
	public int getItemCount() {
		return pageCount;
	}
}
