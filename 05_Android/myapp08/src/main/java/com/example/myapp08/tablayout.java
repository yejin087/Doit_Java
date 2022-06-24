package com.example.myapp08;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class tablayout extends AppCompatActivity {
	
	private TabLayout tabt;
	private ViewPager2 vpcontent;
	private ContentPagerAdapter contentPagerAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tablayout);
		
		tabt = findViewById(R.id.tablayout);
		vpcontent = findViewById(R.id.vpcontent);
		
		contentPagerAdapter = new ContentPagerAdapter(this);
		vpcontent.setAdapter(contentPagerAdapter);
		
		List<String> tabElement = Arrays.asList("tab1", "tab2", "tab3");
		
		// tableLayout, viewPager 연결
		new TabLayoutMediator(tabt, vpcontent, new TabLayoutMediator.TabConfigurationStrategy() {
			@Override
			public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
				TextView textView = new TextView(tablayout.this);
				textView.setText(tabElement.get(position));
				tab.setCustomView(textView);
			}
		}).attach();
		
	}
	
}
