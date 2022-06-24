package com.example.myapp08;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Switch;

public class multimedia_audio extends AppCompatActivity {
	MediaPlayer mediaPlayer;
	SeekBar seekBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_multimedia_audio);
		
		final Switch aSwitch = findViewById(R.id.switch1);
		seekBar = findViewById(R.id.seekBar1);
		
		
		aSwitch.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (aSwitch.isChecked()) {
					mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.song1);
					mediaPlayer.start();
					makeThread();
				} else {
					mediaPlayer.stop();
				}
			}
		});
		
		seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
				if (b) {
					mediaPlayer.seekTo(i);
				}
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
			
			}
		});
		
	}
	
	
	void makeThread() {
		new Thread() {
			public void run() {
				// 음악이 재생중
				while (mediaPlayer.isPlaying()) {
					// 음악의 시간을 최대로 설정
					seekBar.setMax(mediaPlayer.getDuration());
					// 현재 위치 지정
					seekBar.setProgress(mediaPlayer.getCurrentPosition());
					SystemClock.sleep(100);
				}
				
				seekBar.setProgress(0);
			}
		}.start();
	}
	
	
}