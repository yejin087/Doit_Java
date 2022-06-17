package com.example.myapp03;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class dialog extends AppCompatActivity {
    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(dialog.this);
                dlg.setTitle("title");
                dlg.setMessage("msg");
                dlg.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(dialog.this, " click ok", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(dialog.this, "click cancel", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();


            }


        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String[] versionArray = {"pie", "q", "r"};
                boolean[] checkArray = new boolean[]{false, false, false};
                AlertDialog.Builder dlg2 = new AlertDialog.Builder(dialog.this);

                dlg2.setTitle("version");
                dlg2.setMultiChoiceItems(versionArray, checkArray, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        btn2.setText(versionArray[i]);
                    }
                });

                dlg2.setPositiveButton("close", null);
                dlg2.show();
            }
        });
    }
}