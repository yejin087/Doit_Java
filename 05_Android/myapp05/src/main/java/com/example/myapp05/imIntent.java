package com.example.myapp05;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class imIntent extends AppCompatActivity {


    Button btnDial, btnWeb, btnGoogleMap, btnGoogleSearch, btnSms, btnPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_im_intent);

        btnDial = findViewById(R.id.btnDial);
        btnWeb = findViewById(R.id.btnWeb);
        btnGoogleMap = findViewById(R.id.btnGoogleMap);
        btnGoogleSearch = findViewById(R.id.btnGoogleSearch);
        btnSms = findViewById(R.id.btnSms);
        btnPhoto = findViewById(R.id.btnPhoto);


        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("tel: 010-2222-2222");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
            }
        });

        btnGoogleMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://maps.google.co.kt/maps");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        btnGoogleSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, "안드로이드");
                startActivity(intent);
            }
        });

        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.putExtra("sms_body", "hello");
                intent.setData(Uri.parse("smsto:" + Uri.encode("010-2222-2222")));
                startActivity(intent);
            }
        });

        btnPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
        });


    }
}