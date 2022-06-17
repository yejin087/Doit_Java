package com.example.myapp03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1, btn2;
    CheckBox chk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chk = findViewById(R.id.chk);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        chk.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if (view == chk)
            Toast.makeText(getApplicationContext(), "check", Toast.LENGTH_SHORT).show();

        if (view == btn1) {
            Toast.makeText(getApplicationContext(), "btn1", Toast.LENGTH_SHORT).show();
        }

        if (view == btn2) {
            Toast.makeText(getApplicationContext(), "btn2", Toast.LENGTH_SHORT).show();
        }
    }


}