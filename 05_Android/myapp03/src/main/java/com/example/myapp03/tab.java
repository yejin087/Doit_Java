package com.example.myapp03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

@SuppressWarnings("deprecation")
public class tab extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        TabHost tabhost = getTabHost();

        TabHost.TabSpec tabSpecSong = tabhost.newTabSpec("SONG").setIndicator("음악별");
        tabSpecSong.setContent(R.id.tabSong);
        tabhost.addTab(tabSpecSong);


        TabHost.TabSpec tabSpecArtist = tabhost.newTabSpec("ARTIST").setIndicator("가수별");
        tabSpecArtist.setContent(R.id.tabArtist);
        tabhost.addTab(tabSpecArtist);

        TabHost.TabSpec tabSpecAlbum = tabhost.newTabSpec("ALBUM").setIndicator("앨범별");
        tabSpecAlbum.setContent(R.id.tabAlbum);
        tabhost.addTab(tabSpecAlbum);

        tabhost.setCurrentTab(2);

    }
}