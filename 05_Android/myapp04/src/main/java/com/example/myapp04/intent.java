package com.example.myapp04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class intent extends AppCompatActivity {

    Button btnNewActivity;
    RadioButton second, third;
    RadioGroup rdoGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        btnNewActivity = findViewById(R.id.btnNewActivity);
        second = findViewById(R.id.second);
        third = findViewById(R.id.third);
        rdoGroup = findViewById(R.id.rdoGroup);


        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//            rdoGroup.getCheckedRadioButtonId();
                if (second.isChecked()) {
                    Intent intent = new Intent(getApplicationContext(), intent_second.class);
                    startActivity(intent);
                }

                if (third.isChecked()) {
                    Intent intent = new Intent(getApplicationContext(), intent_third.class);
                    startActivity(intent);
                }

            }
        });


        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), intent_third.class);
                startActivity(intent);
            }
        });

        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), intent_second.class);
                startActivity(intent);
            }
        });
    }
}