package com.example.myapp08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivityThread extends AppCompatActivity {
	
	ProgressBar progressBar;
	Button btnInc, btnDec, btnStartThread;
	SeekBar seekBar1, seekBar2;
	TextView tvSeek1, tvSeek2;
	
	@Override
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_thread);
		
		progressBar = findViewById(R.id.progressBar);
		btnInc = findViewById(R.id.btnInc);
		btnDec = findViewById(R.id.btnDec);
		seekBar1 = findViewById(R.id.seekBar1);
		seekBar2 = findViewById(R.id.seekBar2);
		tvSeek1 = findViewById(R.id.tvSeek1);
		tvSeek2 = findViewById(R.id.tvSeek2);
		btnStartThread = findViewById(R.id.btnStartThread);
		
		
		btnInc.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				progressBar.incrementProgressBy(10);
			}
		});
		
		btnDec.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				progressBar.incrementProgressBy(-10);
			}
		});
		
		seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
//				tvSeek1.setText("progress : " + seekBar.getProgress() + " :: " + i);
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
			
			}
		});
		
		btnStartThread.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				new Thread() {
					public void run() {
						for (int i = seekBar1.getProgress(); i < 100; i += 5) {
//							Log.d("??", "" + i);
							seekBar1.setProgress(i);
							tvSeek1.setText("seek1 progress : " + seekBar1.getProgress());
							SystemClock.sleep(100);
						}
					}
					
				}.start();
				
				new Thread() {
					public void run() {
						for (int i = seekBar2.getProgress(); i < 100; i += 5) {
							Log.d("??", "" + i);
							seekBar2.setProgress(i);
							tvSeek2.setText("seek2 progress : " + seekBar2.getProgress());
							SystemClock.sleep(100);
						}
					}
					
				}.start();
			}
			
		});
	}
}