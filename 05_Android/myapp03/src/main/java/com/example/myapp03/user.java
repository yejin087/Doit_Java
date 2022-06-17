package com.example.myapp03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class user extends AppCompatActivity {

    Button btn;
    LinearLayout dialogview;
    EditText dlgEdtEmail, dlgEdtName;
    TextView tvEmail, tvName;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        btn = findViewById(R.id.btn);
        dialogview = findViewById(R.id.dialogview);
        tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                View dialogView = View.inflate(user.this, R.layout.user_dialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(user.this);

                dlg.setTitle("info");
                dlg.setView(dialogView);
                dlg.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dlgEdtName = dialogView.findViewById(R.id.dlgEdtName);
                        dlgEdtEmail = dialogView.findViewById(R.id.dlgEdtEmail);

                        tvName.setText(dlgEdtName.getText().toString());
                        tvEmail.setText(dlgEdtEmail.getText().toString());
                    }
                });
                dlg.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                        Toast toast = new Toast(user.this);

                        View toastView = View.inflate(user.this, R.layout.user_toast, null);
                        toast.setView(toastView);

                        Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                        int xOffset = (int) (Math.random() * display.getWidth());
                        int yOffset = (int) (Math.random() * display.getHeight());
                        toast.setGravity(Gravity.TOP | Gravity.LEFT, xOffset, yOffset);
                        TextView toastText = toastView.findViewById(R.id.Tvtoast);
                        toastText.setText("cancel, cancel");

                        toast.show();
                    }
                });
                dlg.show();


            }
        });


    }
}