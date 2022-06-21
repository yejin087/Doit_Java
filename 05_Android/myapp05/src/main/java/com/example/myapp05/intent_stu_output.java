package com.example.myapp05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class intent_stu_output extends AppCompatActivity {

    Button btnGoMain_Output;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_stu_output);

        TextView tvDisplay1 = findViewById(R.id.tvDisplay1);
        TextView tvDisplay2 = findViewById(R.id.tvDisplay2);


        // 객체 있을 떄만 넣는 방법은 ?
        Intent intent = getIntent();

        Student stu1 = (Student) intent.getSerializableExtra("stu1");
        Student stu2 = (Student) intent.getSerializableExtra("stu2");


        tvDisplay1.setText(stu1.toString());
        tvDisplay2.setText(stu2.toString());

        btnGoMain_Output = findViewById(R.id.btnGoMain_Output);
        btnGoMain_Output.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}