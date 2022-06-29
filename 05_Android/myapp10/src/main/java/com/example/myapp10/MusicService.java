package com.example.myapp10;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MusicService extends Service {
	
	MediaPlayer mp;
	
	@Nullable
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override
	public void onCreate() {
		Log.d(">> service test", "onCreate()");
		super.onCreate();
	}
	
	@Override
	public void onDestroy() {
		mp.stop();
		Log.d(">> service stop", "onDestroy()");
		super.onDestroy();
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d(">>start command", "onStartCommand()");
		mp = MediaPlayer.create(this, R.raw.song1);
		mp.setLooping(true);
		mp.start();
		return super.onStartCommand(intent, flags, startId);
	}
}
