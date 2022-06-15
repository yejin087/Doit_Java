package com.example.ch01_myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    EditText num1, num2;
    Button add, sub, mul, div;
    TextView result;
    String n1, n2;
    Double r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);

        result = findViewById(R.id.result);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n1 = num1.getText().toString();
                n2 =  num2.getText().toString();

                if(n1.trim().equals("") || n2.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "입력 값이 비었습니다.", Toast.LENGTH_SHORT).show();
                    return ;
                }


                r = Double.parseDouble(n1) + Double.parseDouble(n2);

                result.setText(r.toString());
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n1 = num1.getText().toString();
                n2 =  num2.getText().toString();

                if(n1.trim().equals("") || n2.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "입력 값이 비었습니다.", Toast.LENGTH_SHORT).show();
                    return ;
                }


                r = Double.parseDouble(n1) - Double.parseDouble(n2);

                result.setText(r.toString());
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n1 = num1.getText().toString();
                n2 =  num2.getText().toString();

                if(n1.trim().equals("") || n2.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "입력 값이 비었습니다.", Toast.LENGTH_SHORT).show();
                    return ;
                }


                r = Double.parseDouble(n1) * Double.parseDouble(n2);

                result.setText(r.toString());
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n1 = num1.getText().toString();
                n2 =  num2.getText().toString();

                if(n1.trim().equals("") || n2.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "입력 값이 비었습니다.", Toast.LENGTH_SHORT).show();
                    return ;
                }

                if( n2.trim().equals("0")){
                    Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다", Toast.LENGTH_LONG).show();
                    return;
                }

                r = Double.parseDouble(n1) / Double.parseDouble(n2);

                result.setText(r.toString());
            }
        });





    }
}