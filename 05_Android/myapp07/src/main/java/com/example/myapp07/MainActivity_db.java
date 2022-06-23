package com.example.myapp07;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity_db extends AppCompatActivity {
	
	EditText edtDBName, edtTName;
	Button btnDBName, btnTCreate, btnInsert, btnFindData, btnSelect;
	TextView textview;
	SQLiteDatabase sqLiteDatabase;
	String tableName;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_db);
		
		edtDBName = findViewById(R.id.edtDBName);
		edtTName = findViewById(R.id.edtTName);
		btnDBName = findViewById(R.id.btnDBName);
		btnTCreate = findViewById(R.id.btnTCreate);
		btnInsert = findViewById(R.id.btnInsert);
		btnFindData = findViewById(R.id.btnFindData);
		btnSelect = findViewById(R.id.btnSelect);
		textview = findViewById(R.id.textview);
		
		btnDBName.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				sqLiteDatabase = openOrCreateDatabase(edtDBName.getText().toString(), MODE_PRIVATE, null);
				outputStr("database name : " + edtDBName.getText().toString());
			}
		});
		
		btnTCreate.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				textview.setText("");
				tableName = edtTName.getText().toString();
				
				if (sqLiteDatabase == null) {
					outputStr("no database ");
					return;
				}
				
				String sql = "create table if not exists " + tableName + "(" + "id integer primary key autoincrement," + " name text," + " age integer, " + " phone text)";
				
				sqLiteDatabase.execSQL(sql);
				outputStr("success create table :: " + tableName);
				
				
			}
		});
		
		btnSelect.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				textview.setText("");
				
				if (sqLiteDatabase == null) {
					outputStr("no database ");
					return;
				}
				
				if (tableName == null) {
					outputStr("no table");
					return;
				}
				outputStr("list data ");
				String sql = "select * from " + tableName;
				Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
				for (int i = 0; i < cursor.getCount(); i++) {
					cursor.moveToNext();
					int id = cursor.getInt(0);
					String name = cursor.getString(1);
					int age = cursor.getInt(2);
					outputStr("selected :: " + id + name + age);
				}
			}
		});
		
		btnInsert.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				outputStr("insert data ");
				
				String sql = "insert into " + tableName + " (name, age, phone) values ('android', 22 ,'020 - 22222 - 22')";
				sqLiteDatabase.execSQL(sql);
			}
		});
		
		
	}
	
	private void outputStr(String str) {
		textview.append(str + "\n");
	}
}