package com.example.myapp10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.Image;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity_borad extends AppCompatActivity {
	
	ImageView ivBattery;
	EditText edtBattery;
	BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			
			if (action.equals(Intent.ACTION_BATTERY_CHANGED)) {
				int bLevel = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
				edtBattery.setText("remain " + bLevel);
				
				if (bLevel > 90) {
					ivBattery.setImageResource(R.drawable.battery_100);
				} else if (bLevel >= 70) {
					ivBattery.setImageResource(R.drawable.battery_80);
				} else if (bLevel >= 50) {
					ivBattery.setImageResource(R.drawable.battery_60);
				} else if (bLevel >= 10) {
					ivBattery.setImageResource(R.drawable.battery_20);
				} else {
					ivBattery.setImageResource(R.drawable.battery_0);
				}
			}
			
			int plug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, 0);
			switch (plug) {
				case 0:
					edtBattery.append("no adapter");
					break;
				case BatteryManager.BATTERY_PLUGGED_AC:
					edtBattery.append("adapter append");
					break;
				case BatteryManager.BATTERY_PLUGGED_USB:
					edtBattery.append("usb");
					break;
			}
		}
	};
	
	@Override
	protected void onPause() {
		super.onPause();
		unregisterReceiver(broadcastReceiver);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
		registerReceiver(broadcastReceiver, intentFilter);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_borad);
		
		setTitle("broadcast Battery");
		
		ivBattery = findViewById(R.id.ivBattery);
		edtBattery = findViewById(R.id.edtBattery);
		
		
	}
}