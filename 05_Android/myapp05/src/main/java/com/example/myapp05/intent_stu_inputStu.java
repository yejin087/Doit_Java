package com.example.myapp05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class intent_stu_inputStu extends AppCompatActivity {

    Button btnGoMain_InputStu;
    EditText edtId, edtMajor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_stu_input_stu);

        btnGoMain_InputStu = findViewById(R.id.btnGoMain_InputStu);
        edtId = findViewById(R.id.edtId);
        edtMajor = findViewById(R.id.edtMajor);

        btnGoMain_InputStu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Intent intent = new Intent(getApplicationContext(), intent_stu_main.class);
//                intent.putExtra("id", edtId.getText().toString());
//                intent.putExtra("major", edtMajor.getText().toString());
//                setResult(RESULT_OK, intent);
                Student stu = new Student();
                stu.setId(edtId.getText().toString());
                stu.setMajor(edtMajor.getText().toString());
                Intent intent = new Intent();
                intent.putExtra("stuObj", stu);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}