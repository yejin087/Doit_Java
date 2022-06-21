package com.example.myapp05;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class intent_stu_main extends AppCompatActivity {

    Button btnOutput, btnInput, btnInputStu;
    Student student1 = new Student();
    Student student2 = new Student();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_stu_main);

        btnInput = findViewById(R.id.btnInput);
        btnOutput = findViewById(R.id.btnOutput);
        btnInputStu = findViewById(R.id.btnInputStu);

        ActivityResultLauncher<Intent> intentActivityResultLauncher1 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                Intent intent = result.getData();
                student2 = (Student) intent.getSerializableExtra("stuObj");
                student1.setAge(intent.getStringExtra("age"));
                student1.setName(intent.getStringExtra("name"));
                student1.setTel(intent.getStringExtra("tel"));
            }
        });

        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentInput = new Intent(getApplicationContext(), intent_stu_input.class);
                intentActivityResultLauncher1.launch(intentInput);
            }
        });

        btnOutput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent outIntent = new Intent(getApplicationContext(), intent_stu_output.class);
                outIntent.putExtra("stu1", student1);
                outIntent.putExtra("stu2", student2);
                startActivity(outIntent);


            }
        });

        btnInputStu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), intent_stu_inputStu.class);
                intentActivityResultLauncher1.launch(intent);
            }
        });


    }
}