package com.example.myapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    Button btnAdd,btnSub,btnMul,btnDiv;
    TextView result;
    EditText txt1,txt2;
    String num;



//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main3);
//
//        new View.OnClickListener() {
//            public void onClick(View v) {
//
//                int index = -1;
//
//                for (int i = 0; i < btn.length; i++) {
//                    if (v.getId() == btn[i]) {
//                        index = i;
//                        break;
//                    }
//                }
//            }
//        }
//        btnAdd = findViewById(R.id.btnAdd);
//        btnSub = findViewById(R.id.btnSub);
//        btnMul = findViewById(R.id.btnMul);
//        btnDiv = findViewById(R.id.btnDiv);
//        result = findViewById(R.id.result);
//
//        btnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                result.setText("qweqwe");
//            }
//        });
//
//    }
}