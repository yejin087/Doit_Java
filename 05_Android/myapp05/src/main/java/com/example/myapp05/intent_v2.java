package com.example.myapp05;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class intent_v2 extends AppCompatActivity {

    RadioGroup rdoGroup;
    Button btnResult;
    EditText edtNum1, edtNum2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_v2);

        btnResult = findViewById(R.id.btnResult);
        edtNum1 = findViewById(R.id.edtNum1);
        edtNum2 = findViewById(R.id.edtNum2);
        rdoGroup = findViewById(R.id.rdoGroup);

        ActivityResultLauncher<Intent> intentActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent intent = result.getData();
                    int opResult = intent.getIntExtra("opResult", 0);
                    Toast.makeText(getApplicationContext(), "result : " + opResult, Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), intent_v2_sub.class);
                intent.putExtra("num1", Integer.parseInt(edtNum1.getText().toString()));
                intent.putExtra("num2", Integer.parseInt(edtNum2.getText().toString()));
                intent.putExtra("op", rdoGroup.getCheckedRadioButtonId());
                intentActivityResultLauncher.launch(intent);
            }
        });


    }


}