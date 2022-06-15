package com.example.ch01_myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnNaver, btn119, btnGal, btnEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNaver = (Button)findViewById(R.id.btnNaver);
        btn119 = (Button)findViewById(R.id.btn119);
        btnGal = (Button)findViewById(R.id.btnGal);
        btnEnd = (Button)findViewById(R.id.btnEnd);


        btnNaver.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent intentNaver = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
                startActivity(intentNaver);
            }
        });

        btn119.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
               Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:/119"));
               startActivity(intentCall);
            }
        });

        btnGal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"btnGal",Toast.LENGTH_SHORT).show();
            }
        });

        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
}
}