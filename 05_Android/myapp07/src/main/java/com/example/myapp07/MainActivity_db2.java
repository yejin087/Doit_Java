package com.example.myapp07;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity_db2 extends AppCompatActivity {
	
	Button btnInitialize, btnInsert, btnSelect, btnTest, btnDelete, btnUpdate;
	EditText edtName, edtCount;
	TextView tvNameResult, tvCountResult;
	SQLiteDatabase sqLiteDatabase;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_db2);
		
		btnInitialize = findViewById(R.id.btnInitialize);
		btnInsert = findViewById(R.id.btnInsert);
		btnSelect = findViewById(R.id.btnSelect);
		btnTest = findViewById(R.id.btnTest);
		btnDelete = findViewById(R.id.btnDelete);
		btnUpdate = findViewById(R.id.btnUpdate);
		
		edtName = findViewById(R.id.edtName);
		edtCount = findViewById(R.id.edtCount);
		tvNameResult = findViewById(R.id.tvNameResult);
		tvCountResult = findViewById(R.id.tvCountResult);
		
		tvNameResult.setMovementMethod(new ScrollingMovementMethod());
		tvCountResult.setMovementMethod(new ScrollingMovementMethod());
		
		MyDBHelper myDBHelper = new MyDBHelper(this);
		
		btnInitialize.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				sqLiteDatabase = myDBHelper.getWritableDatabase();
				myDBHelper.onUpgrade(sqLiteDatabase, 1, 2);
				sqLiteDatabase.close();
				Log.d(">>", "initialize");
			}
		});
		
		btnInsert.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				
				
				sqLiteDatabase = myDBHelper.getWritableDatabase();
				// prepared Statement
				String sql = "insert into groupTBL values(?,?)";
				SQLiteStatement sqLiteStatement = sqLiteDatabase.compileStatement(sql);
				
				String name = edtName.getText().toString();
				String num = edtCount.getText().toString();
				
				sqLiteStatement.bindString(1, name);
				sqLiteStatement.bindString(2, num);
				
				sqLiteStatement.execute();
				
				
				// Statement
				/*String sql = "insert into groupTBL values ('" + edtName.getText().toString() + "' ," + edtCount.getText().toString() + ")";
				sqLiteDatabase.execSQL(sql);*/
				Log.d(">>>", "" + sql);
			}
		});
		
		
		btnSelect.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				tvNameResult.setText("");
				tvCountResult.setText("");
				
				sqLiteDatabase = myDBHelper.getReadableDatabase();
				
				String sql = "select * from groupTBL";
				Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
				
				for (int i = 0; i < cursor.getCount(); i++) {
					cursor.moveToNext();
					String name = cursor.getString(0);
					int count = cursor.getInt(1);
					tvNameResult.append(name + "\n");
					tvCountResult.append(count + "\n");
					
				}
				
				cursor.close();
				Log.d(">>>", sql);
			}
		});
		
		btnTest.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				String str = "hello";
				
				sqLiteDatabase = myDBHelper.getWritableDatabase();
				String sql = "insert into groupTBL(gName, gNumber) values(?,?)";
				SQLiteStatement sqLiteStatement = sqLiteDatabase.compileStatement(sql);
				
				for (int i = 20; i < 25; i++) {
					sqLiteStatement.bindString(1, str + i);
					sqLiteStatement.bindString(2, Integer.toString(i));
					sqLiteStatement.execute();
				}
				
				
			}
		});
		
		btnDelete.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				sqLiteDatabase = myDBHelper.getWritableDatabase();
				String sql = "delete from groupTBL where gName = ?";
				SQLiteStatement sqLiteStatement = sqLiteDatabase.compileStatement(sql);
				sqLiteStatement.bindString(1, edtName.getText().toString());
				sqLiteStatement.execute();
			}
		});
		
		btnUpdate.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				sqLiteDatabase = myDBHelper.getWritableDatabase();
				String sql = "update groupTBL  set gNumber = ?  where gName = ?";
				SQLiteStatement sqLiteStatement = sqLiteDatabase.compileStatement(sql);
				sqLiteStatement.bindString(1, edtCount.getText().toString());
				sqLiteStatement.bindString(2, edtName.getText().toString());
				sqLiteStatement.execute();
			}
		});
		
		
	}
	
	public class MyDBHelper extends SQLiteOpenHelper {
		
		public MyDBHelper(Context context) {
			super(context, "groupDB", null, 1);
		}
		
		@Override
		public void onCreate(SQLiteDatabase sqLiteDatabase) {
			sqLiteDatabase.execSQL("create table groupTBL ( gName char(20) primary key, gNumber integer)");
		}
		
		@Override
		public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
			sqLiteDatabase.execSQL("drop table if exists groupTBL");
			onCreate(sqLiteDatabase);
		}
	}
}