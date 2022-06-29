package com.example.myapp10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity_service extends AppCompatActivity {
	
	Button btnStart, btnStop;
	MusicService musicService;
	Intent intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_service);
		
		btnStart = findViewById(R.id.btnStart);
		btnStop = findViewById(R.id.btnStop);
		intent = new Intent(this, MusicService.class);
		btnStart.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Log.d(">>", "Start");
				startService(intent);
			}
		});
		
		btnStop.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Log.d(">>", "End");
				stopService(intent);
			}
		});
	}
}