package com.example.myapp05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class intent_v2_sub extends AppCompatActivity {

    Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_v2_sub);

        Intent inIntent = getIntent();
        int num1 = inIntent.getIntExtra("num1", 0);
        int num2 = inIntent.getIntExtra("num2", 0);
        int op = inIntent.getIntExtra("op", 0);

        btnReturn = findViewById(R.id.btnReturn);

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int opResult = 0;
                switch (op) {
                    case R.id.rdoAdd:
                        opResult = num1 + num2;
                        break;
                    case R.id.rdoSub:
                        opResult = num1 - num2;
                        break;
                    case R.id.rdoMul:
                        opResult = num1 * num2;
                        break;
                    case R.id.rdoDiv:
                        opResult = num1 / num2;
                        break;
                    default:
                        break;
                }

                Intent outIntent = new Intent(getApplicationContext(), intent_v2.class);
                outIntent.putExtra("opResult", opResult);
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });


    }
}