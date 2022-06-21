package com.example.myapp05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class adpater extends AppCompatActivity {


    EditText edtItem;
    Button btnAdd;
    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> strings = new ArrayList<>(Arrays.asList("string1", "string2", "string3", "string4", "string5"));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adpater);

        setTitle("list view");

        listView = findViewById(R.id.listView1);
        edtItem = findViewById(R.id.edtItem);
        btnAdd = findViewById(R.id.btnAdd);

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, strings);
        listView.setAdapter(arrayAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                strings.add(edtItem.getText().toString());
//                arrayAdapter.notifyDataSetChanged();
                arrayAdapter.setNotifyOnChange(true);
                arrayAdapter.add(edtItem.getText().toString());
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                strings.remove(i);
                arrayAdapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}