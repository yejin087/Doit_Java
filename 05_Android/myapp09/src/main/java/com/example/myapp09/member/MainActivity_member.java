package com.example.myapp09.member;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapp09.R;
import com.example.myapp09.retrofit2.MainActivity_retro_phone;
import com.example.myapp09.retrofit2.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity_member extends AppCompatActivity {
	
	Member member;
	int pos;
	EditText edtName, edtPhone;
	Button btnInsert, btnDelete, btnUpdate;
	RecyclerView recyclerMem;
	MemberService memberService = RetrofitClient2.getInstance().getMemberService();
	MemberAdapter memberAdapter = new MemberAdapter();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_member);
		
		edtName = findViewById(R.id.edtName);
		edtPhone = findViewById(R.id.edtPhone);
		
		btnInsert = findViewById(R.id.btnInsert);
		btnDelete = findViewById(R.id.btnDelete);
		btnUpdate = findViewById(R.id.btnUpdate);
		
		recyclerMem = findViewById(R.id.recyclerMem);
		
		Call<List<Member>> listCall = memberService.findAll();
		listCall.enqueue(new Callback<List<Member>>() {
			@Override
			public void onResponse(Call<List<Member>> call, Response<List<Member>> response) {
				
				memberAdapter.addItems(response.body());
				Log.d(">> 1", "" + memberAdapter);
				recyclerMem.setLayoutManager(new LinearLayoutManager(MainActivity_member.this,
						RecyclerView.VERTICAL, false));
				recyclerMem.setAdapter(memberAdapter);
				
			}
			
			@Override
			public void onFailure(Call<List<Member>> call, Throwable t) {
			
			}
		});
		
		memberAdapter.setMemberListener(new MemberListener() {
			
			@Override
			public void onItemClick(int position) {
				member = memberAdapter.getItem(position);
				edtName.setText(member.getName());
				edtPhone.setText(member.getPhone());
				pos = position;
			}
			
		});
		
		btnInsert.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Member member = new Member();
				member.setName(edtName.getText().toString());
				member.setPhone(edtPhone.getText().toString());
				Call<Member> call = memberService.save(member);
				call.enqueue(new Callback<Member>() {
					@Override
					public void onResponse(Call<Member> call, Response<Member> response) {
						memberAdapter.addItem(response.body());
					}
					
					@Override
					public void onFailure(Call<Member> call, Throwable t) {
					
					}
				});
			}
		});
		
		
		btnUpdate.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				
				Member member1 = new Member();
				member1.setName(edtName.getText().toString());
				member1.setPhone(edtPhone.getText().toString());
				
				Call<Member> call = memberService.update(member.getNum(), member1);
				call.enqueue(new Callback<Member>() {
					@Override
					public void onResponse(Call<Member> call, Response<Member> response) {
						memberAdapter.updateItem(response.body(), pos);
						Log.d("update res", "" + pos);
					}
					
					@Override
					public void onFailure(Call<Member> call, Throwable t) {
						Log.d("update error", "" + t.getLocalizedMessage());
					}
				});
			}
		});
		
		btnDelete.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Call<Void> call = memberService.deleteById(member.getNum());
				call.enqueue(new Callback<Void>() {
					@Override
					public void onResponse(Call<Void> call, Response<Void> response) {
						memberAdapter.removeItem(pos);
					}
					
					@Override
					public void onFailure(Call<Void> call, Throwable t) {
						Log.d("delete error", "" + t.getLocalizedMessage());
					}
				});
			}
		});
		
		
	}
}