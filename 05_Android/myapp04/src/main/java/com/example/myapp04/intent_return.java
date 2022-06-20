package com.example.myapp04;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class intent_return extends AppCompatActivity {
    RadioGroup rdoGroup;
    Button btnResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_return);

        btnResult = findViewById(R.id.btnResult);
        EditText edtNum1 = findViewById(R.id.edtNum1);
        EditText edtNum2 = findViewById(R.id.edtNum2);
        rdoGroup = findViewById(R.id.rdoGroup);

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), intent_return_sub.class);
                intent.putExtra("num1", Integer.parseInt(edtNum1.getText().toString()));
                intent.putExtra("num2", Integer.parseInt(edtNum2.getText().toString()));
                intent.putExtra("op", rdoGroup.getCheckedRadioButtonId());
                startActivityForResult(intent, 0);

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        int result = -1;
        super.onActivityResult(requestCode, resultCode, data);
        if (RESULT_OK == resultCode) {
            result = data.getIntExtra("result", 0);
            Toast.makeText(getApplicationContext(), "result " + result, Toast.LENGTH_SHORT).show();

        }
        Toast.makeText(getApplicationContext(), "result " + result, Toast.LENGTH_SHORT).show();
    }
}