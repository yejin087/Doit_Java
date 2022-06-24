package com.example.myapp08;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyFragmentAdaper extends FragmentStateAdapter {
	
	private final int mCount;
	
	public MyFragmentAdaper(@NonNull FragmentActivity fragmentActivity, int mCount) {
		super(fragmentActivity);
		this.mCount = mCount;
	}
	
	@NonNull
	@Override
	public Fragment createFragment(int position) {
		int idx = getRealPosition(position);
		Log.d(">>>positon", "" + position);
		if (idx == 0) return new one_vp2();
		else if (idx == 1) return new two_vp2();
		else if (idx == 2) return new three_vp2();
//		else if (idx == 3) return new four_vp2();
		else return new four_vp2();
//		else return new four_vp2();
		
	}
	
	@Override
	public int getItemCount() {
		return 10;
	}
	
	public int getRealPosition(int position) {
		return position % mCount;
	}
}
