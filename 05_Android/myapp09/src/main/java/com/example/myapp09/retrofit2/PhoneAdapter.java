package com.example.myapp09.retrofit2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp09.R;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhoneAdapter extends RecyclerView.Adapter<PhoneAdapter.ViewHolder> {
	List<Phone> phones;
	PhoneService phoneService = PhoneClient.getClient().create(PhoneService.class);
	
	public PhoneAdapter() {
		this.phones = new ArrayList<>();
	}
	
	public PhoneAdapter(List<Phone> phones) {
		this.phones = phones;
	}
	
	public void addItem(Phone phone) {
		phones.add(phone);
		notifyDataSetChanged();
	}
	
	public void removeItem(int position) {
		phones.remove(position);
//		notifyItemRemoved(position);
		notifyDataSetChanged();
	}
	
	public void updateItem(Phone phone, int position) {
		Phone newPhone = phones.get(position);
		newPhone.setName(phone.getName());
		newPhone.setTel(phone.getTel());
//		notifyItemChanged(position);
		notifyDataSetChanged();
	}
	
	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.retrofit_phone_item, parent, false);
		PhoneAdapter.ViewHolder viewHolder = new PhoneAdapter.ViewHolder(view);
		return viewHolder;
	}
	
	@Override
	public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
		
		Phone phone = phones.get(position);
		holder.onBind(phone);
		
		holder.itemView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				View viewDlg = View.inflate(view.getContext(), R.layout.retrofit_phone_dialog, null);
				EditText edtName = viewDlg.findViewById(R.id.etName);
				EditText edtTel = viewDlg.findViewById(R.id.etTel);
				
				edtName.setText(phone.getName());
				edtTel.setText(phone.getTel());
				
				AlertDialog.Builder Alertdlg = new AlertDialog.Builder(view.getContext());
				Alertdlg.setTitle("update");
				Alertdlg.setView(viewDlg);
				
				Alertdlg.setPositiveButton("update", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialogInterface, int i) {
						
						Phone phone1 = new Phone(edtName.getText().toString(), edtTel.getText().toString());
						
						Call<Phone> phoneCall = phoneService.update(phone.getId(), phone1);
						phoneCall.enqueue(new Callback<Phone>() {
							@Override
							public void onResponse(Call<Phone> call, Response<Phone> response) {
								
								
								updateItem(response.body(), position);
								Log.d("update res", "" + holder.getAdapterPosition() + ".." + position);
								
							}
							
							@Override
							public void onFailure(Call<Phone> call, Throwable t) {
								Log.d("update error", "" + t.getLocalizedMessage());
							}
						});
						
					}
				});
				Alertdlg.setNegativeButton("delete", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialogInterface, int i) {
						
						Call<Void> call = phoneService.deleteById(phone.getId());
						call.enqueue(new Callback<Void>() {
							@Override
							public void onResponse(Call<Void> call, Response<Void> response) {
								removeItem(holder.getAdapterPosition());
							}
							
							@Override
							public void onFailure(Call<Void> call, Throwable t) {
								Log.d("delete error", "" + t.getLocalizedMessage());
							}
						});
						
					}
				});
				Alertdlg.show();
			}
		});
	}
	
	@Override
	public int getItemCount() {
		return phones.size();
	}
	
	class ViewHolder extends RecyclerView.ViewHolder {
		
		TextView tvId, tvName, tvTel;
		
		public ViewHolder(@NonNull View itemView) {
			super(itemView);
			tvId = itemView.findViewById(R.id.tvId);
			tvName = itemView.findViewById(R.id.tvName);
			tvTel = itemView.findViewById(R.id.tvTel);
		}
		
		public void onBind(Phone phone) {
			tvId.setText(phone.getId().toString());
			tvName.setText(phone.getName());
			tvTel.setText(phone.getTel());
		}
	}
}
