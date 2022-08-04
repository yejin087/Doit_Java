package com.example.myapp11.retrofit2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myapp11.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhoneAdapter extends RecyclerView.Adapter<PhoneAdapter.ViewHolder> {
	List<Phone> phones;
	PhoneService phoneService = PhoneClient.getClient().create(PhoneService.class);
	private OnItemClickListener onItemClickListener;
	
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
	
	public void addItems(List<Phone> phones) {
		this.phones.addAll(phones);
		notifyDataSetChanged();
	}
	
	public void removeItem(int position) {
		phones.remove(position);
		notifyDataSetChanged();
	}
	
	public void updateItem(Phone phone, int position) {
		Phone newPhone = phones.get(position);
		newPhone.setName(phone.getName());
		newPhone.setTel(phone.getTel());
		notifyDataSetChanged();
	}
	
	public Phone getItem(int position) {
		return phones.get(position);
	}
	
	public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
		this.onItemClickListener = onItemClickListener;
	}
	
	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.retrofit_phone_item, parent, false);
		ViewHolder viewHolder = new ViewHolder(view, onItemClickListener);
		
		
		return viewHolder;
	}
	
	@Override
	public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
		
		Phone phone = phones.get(position);
		holder.onBind(phone);
		
	}
	
	@Override
	public int getItemCount() {
		return phones.size();
	}
	
	public interface OnItemClickListener {
		void onItemClick(int pos);
	}
	
	class ViewHolder extends RecyclerView.ViewHolder {
		
		TextView tvId, tvName, tvTel;
		
		public ViewHolder(@NonNull View itemView, OnItemClickListener onItemClickListener) {
			super(itemView);
			tvId = itemView.findViewById(R.id.tvId);
			tvName = itemView.findViewById(R.id.tvName);
			tvTel = itemView.findViewById(R.id.tvTel);
			
			itemView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					int position = getAdapterPosition();
					onItemClickListener.onItemClick(position);
				}
			});
		}
		
		public void onBind(Phone phone) {
			tvId.setText(phone.getId().toString());
			tvName.setText(phone.getName());
			tvTel.setText(phone.getTel());
			
		}
	}
}
