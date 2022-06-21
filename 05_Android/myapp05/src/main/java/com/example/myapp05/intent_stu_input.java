package com.example.myapp05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class intent_stu_input extends AppCompatActivity {

    EditText edtName, edtAge, edtTel;
    Button btnGoMain_Input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_stu_input);

        edtName = findViewById(R.id.edtName);
        edtAge = findViewById(R.id.edtAge);
        edtTel = findViewById(R.id.edtTel);
        btnGoMain_Input = findViewById(R.id.btnGoMain_Input);

        btnGoMain_Input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent outIntent = new Intent(getApplicationContext(), intent_stu_main.class);
                outIntent.putExtra("name", edtName.getText().toString());
                outIntent.putExtra("age", edtAge.getText().toString());
                outIntent.putExtra("tel", edtTel.getText().toString());
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });

    }
}