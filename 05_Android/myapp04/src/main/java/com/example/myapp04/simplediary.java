package com.example.myapp04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class simplediary extends AppCompatActivity {
    DatePicker datePicker;
    EditText editText;
    Button btnWrite;
    String fileName;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simplediary);

        setTitle("simple diary");

        datePicker = findViewById(R.id.datePicker);
        editText = findViewById(R.id.editText);
        btnWrite = findViewById(R.id.btnWrite);

        Calendar calendar = Calendar.getInstance();
        int cYear = calendar.get(Calendar.YEAR);
        int cMonth = calendar.get(Calendar.MONTH) + 1;
        int cDay = calendar.get(Calendar.DAY_OF_MONTH);

        datePicker.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int yaer, int month, int dayOfMonth) {
                fileName = yaer + "_" + (month + 1) + "_" + dayOfMonth + ".txt";
                String str = readDiary(fileName);
                editText.setText(str);
                btnWrite.setEnabled(true);

            }
        });


        btnWrite.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream fileOutputStream = openFileOutput(fileName, MODE_PRIVATE);
                    fileOutputStream.write(editText.getText().toString().getBytes());
                    fileOutputStream.close();
                    Toast.makeText(getApplicationContext(), "file saved", Toast.LENGTH_SHORT).show();

                } catch (IOException e) {
                }
            }
        });

    }

    private String readDiary(String fName) {
        String diaryStr = null;
        FileInputStream fileInputStream;

        try {
            fileInputStream = openFileInput(fName);
            byte[] bytes = new byte[500];
            fileInputStream.read(bytes);
            fileInputStream.close();
            diaryStr = (new String(bytes).trim());
            btnWrite.setText("edit");

        } catch (IOException e) {
            editText.setHint("no diary");
            btnWrite.setText("save new");
        }

        return diaryStr;
    }

}