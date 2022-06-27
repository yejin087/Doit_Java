package com.example.myapp09.retrofit2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapp09.Movie;
import com.example.myapp09.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity_retro_phone extends AppCompatActivity {
	
	Button btnInsert;
	PhoneService phoneService;
	EditText edtName, edtTel;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_retro_phone);
		
		btnInsert = findViewById(R.id.btnInsert);
		edtName = findViewById(R.id.edtName);
		edtTel = findViewById(R.id.edtTel);
		
		btnInsert.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				phoneService = PhoneClient.getClient().create(PhoneService.class);
				Phone phone = new Phone(edtName.getText().toString(), edtTel.getText().toString());
				Log.d(">> phone", "" + phone.getName());
				Call<Phone> call = phoneService.save(phone);
				
				call.enqueue(new Callback<Phone>() {
					@Override
					public void onResponse(Call<Phone> call, Response<Phone> response) {
						Log.d(">> size", " " + call);
					}
					
					@Override
					public void onFailure(Call<Phone> call, Throwable t) {
						Log.d(">> size", " " + t.getLocalizedMessage());
					}
				});
			}
		});
	}
}