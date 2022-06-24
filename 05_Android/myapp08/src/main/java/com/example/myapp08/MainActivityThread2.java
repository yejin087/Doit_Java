package com.example.myapp08;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivityThread2 extends AppCompatActivity {
	
	ListView listViewMP3;
	Button btnStart, btnPause;
	TextView tvMP3, tvTime;
	ProgressBar pbMP3;
	
	ArrayList<String> mp3List;
	String selectedMP3;
	MediaPlayer mediaPlayer;
	
	String mp3Path;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_thread2);
		
		mp3Path = this.getResources() + "/";
		Log.d("????pathpath", "" + mp3Path);
		
		ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);
		mp3List = new ArrayList<>();
		
		File[] listFiles = new File(mp3Path).listFiles();
		String fileName, extName;
		
		
		for (File file : listFiles) {
			fileName = file.getName();
//			Log.d("????dsfasfd", "" + fileName);
			extName = fileName.substring(fileName.length() - 3);
			if (extName.equals("MUSIC")) {
				Log.d("????dsfasfd", "" + extName);
				mp3List.add(fileName);
			}
		}
		listViewMP3 = findViewById(R.id.lvMP3);
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, mp3List);
		listViewMP3.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		listViewMP3.setAdapter(arrayAdapter);
		listViewMP3.setItemChecked(0, true);
		
		listViewMP3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
				selectedMP3 = mp3List.get(i);
			}
		});
		
		selectedMP3 = mp3List.get(0);
		
		btnStart.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				try {
					
					mediaPlayer = new MediaPlayer();
					mediaPlayer.setDataSource(mp3Path + selectedMP3);
					mediaPlayer.start();
					btnStart.setClickable(false);
					btnPause.setClickable(true);
					tvMP3.setText("on music : " + selectedMP3);
					pbMP3.setVisibility(View.VISIBLE);
				} catch (IOException e) {
				
				}
				
			}
		});
		
		btnPause.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				mediaPlayer.stop();
				mediaPlayer.reset();
				btnStart.setClickable(true);
				btnPause.setClickable(false);
				tvMP3.setText("on musice :");
				pbMP3.setVisibility(View.INVISIBLE);
			}
		});
	}
	
	
}