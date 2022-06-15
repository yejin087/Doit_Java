package com.example.ch01_myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    EditText text;
    Button btnText, btnUrl;
    RadioGroup radio;
    ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        text = findViewById(R.id.text);
        btnText = findViewById(R.id.btnText);
        btnUrl = findViewById(R.id.btnUrl);
        radio = findViewById(R.id.radio);
        img = findViewById(R.id.img);
//        img.setImageResource(R.drawable.r);
        btnText.setBackgroundColor(Color.GREEN);

        btnText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), text.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        btnUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse(text.getText().toString()));
                startActivity(intentCall);
            }
        });

  radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(RadioGroup radioGroup, int i) {

          if (i == R.id.rdoQ){
              img.setVisibility(View.VISIBLE);
          }
          else{
              img.setVisibility(View.INVISIBLE);
          }
      }
  });

    }
}