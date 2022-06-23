package com.example.myapp07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
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

public class Diary_db extends AppCompatActivity {
	
	DatePicker datePicker;
	EditText editText;
	Button btnWrite;
	SQLiteDatabase sqLiteDatabase;
	MyDBHelper myDBHelper = new MyDBHelper(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_diary_db);
		
		datePicker = findViewById(R.id.datePicker);
		editText = findViewById(R.id.editText);
		btnWrite = findViewById(R.id.btnWrite);

//		myDBHelper.onCreate(sqLiteDatabase);
		
		Calendar calendar = Calendar.getInstance();
		int cYear = calendar.get(Calendar.YEAR);
		int cMonth = calendar.get(Calendar.MONTH) + 1;
		int cDay = calendar.get(Calendar.DAY_OF_MONTH);
		
		datePicker.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
			
			@Override
			public void onDateChanged(DatePicker datePicker, int y, int m, int d) {
				String date = Integer.toString(y) + m + d;
				String content = readDiary(date);
				editText.setText(content);
				btnWrite.setEnabled(true);
			}
		});
		
		btnWrite.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				String content = editText.getText().toString();
				String date = Integer.toString(datePicker.getYear()) + datePicker.getMonth() + datePicker.getDayOfMonth();
				writeDiary(date, content);
			}
		});
		
		
	}
	
	String readDiary(String date) {
		String content = "no content";
		sqLiteDatabase = myDBHelper.getReadableDatabase();
		String sql = "select content from myDiary where diaryDate = " + date;
		
		
		Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
		
		if (cursor.getCount() > 0) {
			cursor.moveToNext();
			content = cursor.getString(0);
			cursor.close();
		}
		
		
		sqLiteDatabase.close();
		
		return content;
		
	}
	
	void writeDiary(String date, String content) {
		
		sqLiteDatabase = myDBHelper.getWritableDatabase();
		String sql = "insert into myDiary values (" + date + ",'" + content + "')";
		sqLiteDatabase.execSQL(sql);
	}
	
	public class MyDBHelper extends SQLiteOpenHelper {
		
		public MyDBHelper(Context context) {
			super(context, "myDB", null, 1);
		}
		
		@Override
		public void onCreate(SQLiteDatabase sqLiteDatabase) {
			sqLiteDatabase.execSQL("create table myDiary (diaryDate char(10) primary key, content varchar(500))");
		}
		
		@Override
		public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
			//sqLiteDatabase.execSQL("drop table if exists myDiary");
			onCreate(sqLiteDatabase);
		}
	}
}