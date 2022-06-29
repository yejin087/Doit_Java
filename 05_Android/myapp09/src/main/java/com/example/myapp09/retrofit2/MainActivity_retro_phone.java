package com.example.myapp09.retrofit2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
	
	Button btnInsert, btnList, btnDelete, btnUpdate;
	PhoneService phoneService;
	EditText edtName, edtTel;
	PhoneAdapter phoneAdapter;
	RecyclerView recycler;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_retro_phone);
		
		btnInsert = findViewById(R.id.btnInsert);
		btnUpdate = findViewById(R.id.btnUpdate);
		btnList = findViewById(R.id.btnList);
		btnDelete = findViewById(R.id.btnDelete);
		edtName = findViewById(R.id.edtName);
		edtTel = findViewById(R.id.edtTel);
		recycler = findViewById(R.id.recycler);
		
		phoneService = RetrofitClient.getInstance().getPhoneService();
		Call<List<Phone>> listCall = phoneService.findAll();
		listCall.enqueue(new Callback<List<Phone>>() {
			@Override
			public void onResponse(Call<List<Phone>> call, Response<List<Phone>> response) {
				
				
				recycler.setLayoutManager(new LinearLayoutManager(MainActivity_retro_phone.this,
						RecyclerView.VERTICAL, false));
				phoneAdapter = new PhoneAdapter(response.body());
				recycler.setAdapter(phoneAdapter);
			}
			
			@Override
			public void onFailure(Call<List<Phone>> call, Throwable t) {
				Log.d("list error ", "" + t.getLocalizedMessage());
			}
		});
		
		btnInsert.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
//				phoneService = PhoneClient.getClient().create(PhoneService.class);
				Phone phone = new Phone(edtName.getText().toString(), edtTel.getText().toString());
				Log.d(">> phone", "" + phone.getName());
				
				Call<Phone> call = phoneService.save(phone);
				
				call.enqueue(new Callback<Phone>() {
					@Override
					public void onResponse(Call<Phone> call, Response<Phone> response) {
						Log.d(">> phone res", " " + response);
						phoneAdapter.addItem(response.body());
						
					}
					
					@Override
					public void onFailure(Call<Phone> call, Throwable t) {
						Log.d(">> phone error", " " + t.getLocalizedMessage());
					}
				});
			}
		});
		
		
	}
}