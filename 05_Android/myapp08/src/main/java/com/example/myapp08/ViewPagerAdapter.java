package com.example.myapp08;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewHolder> {
	
	private final ArrayList<DataPage> dataPages;
	
	public ViewPagerAdapter(ArrayList<DataPage> dataPages) {
		this.dataPages = dataPages;
	}
	
	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		
		Context context = parent.getContext();
		View view = LayoutInflater.from(context).inflate(R.layout.viewpager_item, parent, false);
		
		return new ViewHolder(view);
	}
	
	@Override
	public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
		DataPage dataPage = dataPages.get(position);
		// holder에서 bind
		holder.onBind(dataPage);
	}
	
	@Override
	public int getItemCount() {
		return dataPages.size();
	}
	
	// 기억할 Layout
	class ViewHolder extends RecyclerView.ViewHolder {
		
		private final TextView tvTitle;
		private final RelativeLayout rLayout;
		private DataPage dataPage;
		
		public ViewHolder(@NonNull View itemView) {
			super(itemView);
			tvTitle = itemView.findViewById(R.id.tvTitle);
			rLayout = itemView.findViewById(R.id.rLayout);
		}
		
		public void onBind(DataPage dataPage) {
			this.dataPage = dataPage;
			tvTitle.setText(dataPage.getTitle());
			rLayout.setBackgroundColor(dataPage.getColor());
		}
	}
}
