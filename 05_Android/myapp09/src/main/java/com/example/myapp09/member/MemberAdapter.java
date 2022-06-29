package com.example.myapp09.member;

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
import com.example.myapp09.retrofit2.Phone;
import com.example.myapp09.retrofit2.PhoneAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.ViewHolder> {
	
	List<Member> members;
	MemberService memberService = RetrofitClient2.getInstance().getMemberService();
	View parentView;
	private MemberListener memberListener;
	
	public MemberAdapter() {
		this.members = new ArrayList<>();
	}
	
	public void addItems(List<Member> members) {
		this.members.addAll(members);
		Log.d(">>", "" + members.size());
		notifyDataSetChanged();
	}
	
	public void addItem(Member member) {
		members.add(member);
		notifyDataSetChanged();
	}
	
	public void removeItem(int position) {
		members.remove(position);
		notifyDataSetChanged();
	}
	
	public void updateItem(Member member, int position) {
		Member nMember = members.get(position);
		nMember.setName(member.getName());
		nMember.setPhone(member.getPhone());
		notifyDataSetChanged();
	}
	
	public Member getItem(int position) {
		Member member = members.get(position);
		return member;
	}
	
	public void setMemberListener(MemberListener memberListener) {
		this.memberListener = memberListener;
	}
	
	
	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.retrofit_member_item, parent, false);
		MemberAdapter.ViewHolder viewHolder = new MemberAdapter.ViewHolder(view);
		parentView = parent;
		return viewHolder;
	}
	
	@Override
	public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
		Member member = members.get(position);
		holder.onBind(member);
		
		
		/*holder.itemView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				View viewDlg = View.inflate(view.getContext(), R.layout.retrofit_phone_dialog, null);
				
				EditText edtName = viewDlg.findViewById(R.id.etName);
				EditText edtTel = viewDlg.findViewById(R.id.etTel);
				
				edtName.setText(member.getName());
				edtTel.setText(member.getPhone());
				
				AlertDialog.Builder dlg = new AlertDialog.Builder(view.getContext());
				dlg.setTitle("DLG");
				dlg.setView(viewDlg);
				
				dlg.setPositiveButton("update", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialogInterface, int i) {
						Member member1 = new Member();
						member1.setName(edtName.getText().toString());
						member1.setPhone(edtTel.getText().toString());
						Call<Member> call = memberService.update(member.getNum(), member1);
						call.enqueue(new Callback<Member>() {
							@Override
							public void onResponse(Call<Member> call, Response<Member> response) {
								updateItem(response.body(), position);
								Log.d("update res", "" + holder.getAdapterPosition() + ".." + position);
								
							}
							
							@Override
							public void onFailure(Call<Member> call, Throwable t) {
								Log.d("update error", "" + t.getLocalizedMessage());
							}
						});
					}
				});
				
				dlg.setNegativeButton("delete", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialogInterface, int i) {
						
						Call<Void> call = memberService.deleteById(member.getNum());
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
				
				dlg.show();
			}
		});*/
		
		
	}
	
	@Override
	public int getItemCount() {
		return members.size();
	}
	
	class ViewHolder extends RecyclerView.ViewHolder {
		TextView tvName, tvPhone, tvId;
		
		public ViewHolder(@NonNull View itemView) {
			super(itemView);
			tvName = itemView.findViewById(R.id.tvName);
			tvPhone = itemView.findViewById(R.id.tvPhone);
			tvId = itemView.findViewById(R.id.tvId);
			itemView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					Log.d(">>", "click " + getAdapterPosition());
					int position = getAdapterPosition();
					memberListener.onItemClick(position);
//					EditText edt = parentView.findViewById(R.id.edtName);
//					edt.setText(tvName.getText().toString());
				}
			});
		}
		
		public void onBind(Member member) {
			tvId.setText(member.getNum().toString());
			tvName.setText(member.getName());
			tvPhone.setText(member.getPhone());
			
		}
	}
}
