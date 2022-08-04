package com.example.myapp11.retrofit2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp11.R;

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
	int position;
	Phone phone;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_retro_phone);
		
		btnInsert = findViewById(R.id.btnInsert);
		btnUpdate = findViewById(R.id.btnUpdate);
//		btnList = findViewById(R.id.btnList);
		btnDelete = findViewById(R.id.btnDelete);
		edtName = findViewById(R.id.edtName);
		edtTel = findViewById(R.id.edtTel);
		recycler = findViewById(R.id.recycler);
		
		LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity_retro_phone.this, RecyclerView.VERTICAL, false);
		recycler.setLayoutManager(linearLayoutManager);
		phoneAdapter = new PhoneAdapter();
		recycler.setAdapter(phoneAdapter);
		
		
		phoneAdapter.setOnItemClickListener(new PhoneAdapter.OnItemClickListener() {
			@Override
			public void onItemClick(int pos) {
				phone = phoneAdapter.getItem(pos);
				position = pos;
				Log.d(">>", "" + position);
				Toast.makeText(MainActivity_retro_phone.this, phone.getName() + "  selected", Toast.LENGTH_SHORT).show();
				edtName.setText(phone.getName());
				edtTel.setText(phone.getTel());
				btnUpdate.setEnabled(true);
				btnDelete.setEnabled(true);
			}
		});
		
		phoneService = RetrofitClient.getInstance().getPhoneService();
		Call<List<Phone>> listCall = phoneService.findAll();
		listCall.enqueue(new Callback<List<Phone>>() {
			@Override
			public void onResponse(Call<List<Phone>> call, Response<List<Phone>> response) {
				phoneAdapter.addItems(response.body());
			}
			
			@Override
			public void onFailure(Call<List<Phone>> call, Throwable t) {
				Log.d("list error ", "" + t.getLocalizedMessage());
			}
		});
		
		btnInsert.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Phone phone = new Phone(edtName.getText().toString(), edtTel.getText().toString());
				Call<Phone> call = phoneService.save(phone);
				
				call.enqueue(new Callback<Phone>() {
					@Override
					public void onResponse(Call<Phone> call, Response<Phone> response) {
						Log.d(">> insert res", " " + response);
						phoneAdapter.addItem(response.body());
					}
					
					@Override
					public void onFailure(Call<Phone> call, Throwable t) {
						Log.d(">> insert error", " " + t.getLocalizedMessage());
					}
				});
			}
		});
		
		btnDelete.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				phoneService = PhoneClient.getClient().create(PhoneService.class);
				Call<Void> call = phoneService.deleteById(phone.getId());
				call.enqueue(new Callback<Void>() {
					@Override
					public void onResponse(Call<Void> call, Response<Void> response) {
						phoneAdapter.removeItem(position);
						edtName.setText("");
						edtTel.setText("");
						btnUpdate.setEnabled(false);
						btnDelete.setEnabled(false);
					}
					
					@Override
					public void onFailure(Call<Void> call, Throwable t) {
					
					}
				});
			}
		});
		
		btnUpdate.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				phoneService = PhoneClient.getClient().create(PhoneService.class);
				Phone nphone = new Phone(edtName.getText().toString(), edtTel.getText().toString());
				Call<Phone> phoneCall = phoneService.update(phone.getId(), nphone);
				phoneCall.enqueue(new Callback<Phone>() {
					@Override
					public void onResponse(Call<Phone> call, Response<Phone> response) {
						phoneAdapter.updateItem(response.body(), position);
						edtName.setText("");
						edtTel.setText("");
						
					}
					
					@Override
					public void onFailure(Call<Phone> call, Throwable t) {
					
					}
				});
			}
		});
		
		
	}
}