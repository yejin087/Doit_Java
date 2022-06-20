package com.example.myapp04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class file extends AppCompatActivity {

    Button btnWrite, btnRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        btnWrite = findViewById(R.id.btnWrite);
        btnRead = findViewById(R.id.btnRead);

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream fileOutputStream = openFileOutput("file.text", MODE_PRIVATE);
                    String str = "cook book android";
                    fileOutputStream.write(str.getBytes());
                    fileOutputStream.close();
                    Toast.makeText(getApplicationContext(), "make file", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream fileInputStream = openFileInput("file.text");
                    byte[] bytes = new byte[30];
                    fileInputStream.read(bytes);
                    String str = new String(bytes);
                    Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                } catch (IOException e) {

                    Toast.makeText(getApplicationContext(), "no file", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}