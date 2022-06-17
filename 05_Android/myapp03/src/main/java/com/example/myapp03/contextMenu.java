package com.example.myapp03;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class contextMenu extends AppCompatActivity {

    Button btn1, btn2;
    LinearLayout baseLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        baseLayout = findViewById(R.id.baseLayout);

        registerForContextMenu(btn1);
        registerForContextMenu(btn2);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();

        if (v == btn1) {
            menu.setHeaderTitle("change background");
            menuInflater.inflate(R.menu.menu1, menu);
        }

        if (v == btn2) {
            menu.setHeaderTitle("rotate");
            menuInflater.inflate(R.menu.contextmenu, menu);
        }

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.itemRed:
                baseLayout.setBackgroundColor(Color.RED);
                return true;
            case R.id.itemGreen:
                baseLayout.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.itemBlue:
                baseLayout.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.subRotate:
                btn2.setRotation(45);
                return true;
            case R.id.subSize:
                btn2.setTextScaleX(2);
                return true;
        }

        return false;
    }
}