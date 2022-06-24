package com.example.myapp08;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class viewpager extends AppCompatActivity {
	
	ViewPager2 viewPager2;
	Button btnToggle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_viewpager);
		
		viewPager2 = findViewById(R.id.viewpager2);
		btnToggle = findViewById(R.id.btnToggle);
		
		ArrayList<DataPage> dataPages = new ArrayList<>();
		dataPages.add(new DataPage(Color.BLUE, "1"));
		dataPages.add(new DataPage(Color.BLACK, "2"));
		dataPages.add(new DataPage(Color.YELLOW, "3"));
		dataPages.add(new DataPage(Color.RED, "4"));
		dataPages.add(new DataPage(Color.GREEN, "5"));
		
		ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(dataPages);
		viewPager2.setAdapter(viewPagerAdapter);
		
		btnToggle.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (viewPager2.getOrientation() == ViewPager2.ORIENTATION_VERTICAL) {
					btnToggle.setText("horizental slide");
					viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
				} else {
					btnToggle.setText("vertical slide");
					viewPager2.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
				}
			}
		});
		
	}
}