package com.example.myapp05;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class intent_info extends AppCompatActivity {

    TextView tvName, tvAge;
    Button btnGo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_info);

        tvName = findViewById(R.id.tvName);
        tvAge = findViewById(R.id.tvAge);
        btnGo = findViewById(R.id.btnGo);

        ActivityResultLauncher<Intent> intentActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                Intent inIntent = result.getData();
                tvName.setText(inIntent.getStringExtra("name"));
                tvAge.setText(inIntent.getStringExtra("age"));
            }
        });


        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), intent_info_sub.class);
                intentActivityResultLauncher.launch(intent);
            }
        });
    }
}