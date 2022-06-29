package com.example.myapp10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static android.Manifest.permission.READ_CALL_LOG;


public class MainActivity_provider extends AppCompatActivity {
	
	Button btnCall;
	EditText edtCall;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_provider);
//
//		ActivityCompat.requestPermissions(this,
//				new String[]{READ_CALL_LOG},
//				MODE_PRIVATE);
//
		btnCall = findViewById(R.id.btnCall);
		edtCall = findViewById(R.id.edtCall);
		
		btnCall.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				edtCall.setText(getCallHistory());
			}
		});
		
	}
	
	
	private String getCallHistory() {
		
		String[] phoneList = new String[]{
				CallLog.Calls.DATE,
				CallLog.Calls.TYPE,
				CallLog.Calls.NUMBER,
				CallLog.Calls.DURATION
		};
		
		Cursor cursor = getContentResolver().query(CallLog.Calls.CONTENT_URI, phoneList, null, null, null);
		if (cursor == null) {
			return "no phoneList";
		}
		
		StringBuffer callStringBuffer = new StringBuffer();
		callStringBuffer.append("\n date : div : phoneNum : duration");
		cursor.moveToFirst();
		
		do {
			Long callDate = cursor.getLong(0);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String strDate = simpleDateFormat.format(callDate);
			callStringBuffer.append(strDate + ":");
			
			if (cursor.getInt(1) == CallLog.Calls.INCOMING_TYPE) {
				callStringBuffer.append("착신 :");
			} else {
				callStringBuffer.append("발신 :");
			}
			
			callStringBuffer.append(cursor.getString(2) + ":");
			callStringBuffer.append(cursor.getString(3) + "min");
			
		} while (cursor.moveToNext());
		
		return callStringBuffer.toString();
	}
}