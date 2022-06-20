package com.example.myapp04;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.function.Function;
import java.util.function.Supplier;

public class intent_return_sub extends Activity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_return_sub);

        Button btnBack = findViewById(R.id.btnReturn);
        Intent intent = getIntent();
        final int op = intent.getIntExtra("op", 0);
//        final int result;
        Supplier<Integer> result = () -> {
            switch (op) {
                case R.id.rdoAdd:
                    return intent.getIntExtra("num1", 0) + intent.getIntExtra("num2", 0);
                case R.id.rdoSub:
                    return intent.getIntExtra("num1", 0) - intent.getIntExtra("num2", 0);
                case R.id.rdoMul:
                    return intent.getIntExtra("num1", 0) * intent.getIntExtra("num2", 0);
                case R.id.rdoDiv:
                    return intent.getIntExtra("num1", 0) / intent.getIntExtra("num2", 0);
                default:
                    return -1;
            }
        };


        btnBack.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                Intent reIntent = new Intent(getApplicationContext(), intent_return.class);
                reIntent.putExtra("result", result.get());
                setResult(RESULT_OK, reIntent);
                finish();
            }
        });


    }
}
