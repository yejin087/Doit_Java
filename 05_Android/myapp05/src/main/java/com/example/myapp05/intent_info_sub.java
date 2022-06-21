package com.example.myapp05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class intent_info_sub extends AppCompatActivity {

    EditText edtName, edtAge;
    Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_info_sub);

        edtAge = findViewById(R.id.edtAge);
        edtName = findViewById(R.id.edtName);
        btnReturn = findViewById(R.id.btnReturn);

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent outIntent = new Intent(getApplicationContext(), intent_info.class);

                if (edtName.getText().toString().equals("") || edtAge.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "이름, 나이 입력", Toast.LENGTH_SHORT).show();
                    return;
                }

                outIntent.putExtra("name", edtName.getText().toString());
                outIntent.putExtra("age", edtAge.getText().toString());
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });
    }
}