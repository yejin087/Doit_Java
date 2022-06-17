package com.example.myapp03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class practice6 extends AppCompatActivity {

    RadioButton rdoDog, rdoCat, rdoRabbit;
    Button btnShow;
    ImageView imgPet;
    RadioGroup rdoGroup;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice6);

        rdoCat = findViewById(R.id.rdoCat);
        rdoDog = findViewById(R.id.rdoDog);
        rdoRabbit = findViewById(R.id.rdoRabbit);
        btnShow = findViewById(R.id.btnShow);
        rdoGroup = findViewById(R.id.rdoGroup);

        btnShow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                if (rdoGroup.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(practice6.this, "check radio", Toast.LENGTH_SHORT).show();
                } else {
                    View dialogView = View.inflate(practice6.this, R.layout.prc6_dialog, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(practice6.this);

                    dlg.setView(dialogView);
                    dlg.setNegativeButton("close", null);

                    if (rdoCat.isChecked()) {
                        dlg.setTitle("Cat");
                        imgPet = dialogView.findViewById(R.id.dlgImg);
                        imgPet.setImageResource(R.drawable.cat);
                    }

                    if (rdoDog.isChecked()) {
                        dlg.setTitle("Dog");
                        imgPet = dialogView.findViewById(R.id.dlgImg);
                        imgPet.setImageResource(R.drawable.dog);
                    }

                    if (rdoRabbit.isChecked()) {
                        dlg.setTitle("Rabbit");
                        imgPet = dialogView.findViewById(R.id.dlgImg);
                        imgPet.setImageResource(R.drawable.rabbit);
                    }


                    dlg.show();
                }


            }
        });
    }
}