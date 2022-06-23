package com.example.myapp07;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class fragment_main2 extends AppCompatActivity implements View.OnClickListener {

Button btnSong, btnAlbum, btnArtist;

@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_fragment_main2);
	
	btnSong = findViewById(R.id.btnSong);
	btnAlbum = findViewById(R.id.btnAlbum);
	btnArtist = findViewById(R.id.btnArtist);
	
	btnSong.setOnClickListener(this);
	btnAlbum.setOnClickListener(this);
	btnArtist.setOnClickListener(this);
}

@Override
public void onClick(View view) {
	Fragment fragment = null;
	
	switch (view.getId()) {
		case R.id.btnSong:
			fragment = new SongFragment();
			break;
		
		case R.id.btnAlbum:
			fragment = new AlbumFragment();
			break;
		
		case R.id.btnArtist:
			fragment = new ArtistFragment();
			break;
		default:
			fragment = new SongFragment();
			break;
	}
	
	// fragment 등록을 위한 fragment manager
	FragmentManager fragmentManager = getSupportFragmentManager();
	FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
	// fragmenttranscation을 통해 id 위치에 fragment 배치
	fragmentTransaction.replace(R.id.fragmentContainter, fragment);
	fragmentTransaction.addToBackStack(null);
	fragmentTransaction.commit();

//	getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainter, fragment).addToBackStack(null).commit();
}
}