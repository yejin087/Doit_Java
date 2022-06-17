package com.example.myapp03;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity2 extends AppCompatActivity {

    DatePicker dataPicker1;
    TimePicker timePicker1;
    Chronometer chronometer;
    RadioGroup rdoGroup;
    RadioButton rdoDate, rdoTime;
    TextView tvYear, tvMonth, tvDay, tvHour, tvMin;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        dataPicker1 = findViewById(R.id.dataPicker1);
        timePicker1 = findViewById(R.id.timePicker1);
        chronometer = findViewById(R.id.chronometer);
        rdoGroup = findViewById(R.id.rdoGroup);
        rdoDate = findViewById(R.id.rdoDate);
        rdoTime = findViewById(R.id.rdoTime);
        tvYear = findViewById(R.id.tvYear);
        tvMonth = findViewById(R.id.tvMonth);
        tvDay = findViewById(R.id.tvDay);
        tvHour = findViewById(R.id.tvHour);
        tvMin = findViewById(R.id.tvMin);

        dataPicker1.setVisibility(View.INVISIBLE);
        timePicker1.setVisibility(View.INVISIBLE);

        chronometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                chronometer.setTextColor(Color.RED);
            }
        });

        rdoGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.rdoDate) {
                    dataPicker1.setVisibility(View.VISIBLE);
                    timePicker1.setVisibility(View.INVISIBLE);
                }

                if (i == R.id.rdoTime) {
                    dataPicker1.setVisibility(View.INVISIBLE);
                    timePicker1.setVisibility(View.VISIBLE);
                }
            }
        });

        tvYear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                chronometer.stop();
                tvYear.setText(Integer.toString(dataPicker1.getYear()));
                tvMonth.setText(Integer.toString(dataPicker1.getMonth() + 1));
                tvDay.setText(Integer.toString(dataPicker1.getDayOfMonth()));
                tvHour.setText(Integer.toString(timePicker1.getCurrentHour()));
                tvMin.setText(Integer.toString(timePicker1.getCurrentMinute()));
                return false;
            }
        });


    }
}