package com.example.myapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {


    TextView txt1, txt2;
    Switch switchAgree;
    RadioGroup rdoGroup;
    RadioButton rdoCat, rdoDog, rdoRabbit;
    ImageView imgPet;
    Button exit, init;

    RadioButton[] radioButtons = new RadioButton[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txt1 = findViewById(R.id.txt1);
        txt2 =findViewById(R.id.txt2);
        switchAgree = findViewById(R.id.switchAgree);
        rdoGroup = findViewById(R.id.rdoGroup);
        imgPet = findViewById(R.id.ImgPet);
        exit = findViewById(R.id.exit);
        init = findViewById(R.id.init);

        radioButtons[0] =  findViewById(R.id.rdoCat);
        radioButtons[1] =  findViewById(R.id.rdoDog);
        radioButtons[2] =  findViewById(R.id.rdoRabbit);

        switchAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if( switchAgree.isChecked() ){
                    txt2.setVisibility(View.VISIBLE);
                    rdoGroup.setVisibility(View.VISIBLE);
                    imgPet.setVisibility(View.VISIBLE);
                    exit.setVisibility(View.VISIBLE);
                    init.setVisibility(View.VISIBLE);
                }
                else{
                    txt2.setVisibility(View.INVISIBLE);
                    rdoGroup.setVisibility(View.INVISIBLE);
                    imgPet.setVisibility(View.INVISIBLE);
                    exit.setVisibility(View.INVISIBLE);
                    init.setVisibility(View.INVISIBLE);
                }
            }
        });


//        rdoGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//                switch(i){
//                    case R.id.rdoCat:
//                        imgPet.setImageResource(R.drawable.cat);
//                        break;
//                    case R.id.rdoDog:
//                        imgPet.setImageResource(R.drawable.dog);
//                        break;
//                    case R.id.rdoRabbit:
//                        imgPet.setImageResource(R.drawable.rabbit);
//                        break;
//                }
//            }
//        });

        // for 이용 ClickEvent
        int imgs[] ={R.drawable.dog, R.drawable.cat, R.drawable.rabbit};

        for (int i = 0 ; i < radioButtons.length ; i++){
            final int idx = i;
            radioButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    imgPet.setImageResource(imgs[idx]);
                }
            });
        }

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        init.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rdoGroup.clearCheck();
                switchAgree.setChecked(false);
                imgPet.setImageResource(0);

            }
        });

    }
}