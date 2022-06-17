package com.example.myapp03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.os.Bundle;
import android.text.style.TabStopSpan;
import android.widget.TabHost;

public class tab2 extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab2);

        TabHost tabhost = getTabHost();

        TabHost.TabSpec tabSpecCat = tabhost.newTabSpec("cat").setIndicator("고양이");
        tabSpecCat.setContent(R.id.cat);
        tabhost.addTab(tabSpecCat);

        TabHost.TabSpec tabSpectDog = tabhost.newTabSpec("dog").setIndicator("강아지");
        tabSpectDog.setContent(R.id.dog);
        tabhost.addTab(tabSpectDog);

        TabHost.TabSpec tabSpecRabbit = tabhost.newTabSpec("rabbit").setIndicator("토끼");
        tabSpecRabbit.setContent(R.id.rabbit);
        tabhost.addTab(tabSpecRabbit);
    }
}