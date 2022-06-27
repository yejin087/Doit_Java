package com.example.myapp09;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
	
	
	private ArrayList<Movie> movies = new ArrayList<>();
	
	public MovieAdapter(ArrayList<Movie> movies) {
		this.movies = movies;
	}
	
	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		
		Context context = parent.getContext();
		View view = LayoutInflater.from(context).inflate(R.layout.recycle_item, parent, false);
		
		return new ViewHolder(view);
	}
	
	@Override
	public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
		Movie movie = movies.get(position);
		movie.setAlbumId(R.drawable.ic_launcher_background);
		holder.onBind(movie);
	}
	
	@Override
	public int getItemCount() {
		return movies == null ? 0 : movies.size();
	}
	
	class ViewHolder extends RecyclerView.ViewHolder {
		
		TextView tvId, tvTitle, tvUrl;
		ImageView iv;
		
		
		public ViewHolder(@NonNull View itemView) {
			super(itemView);
			tvId = itemView.findViewById(R.id.tvId);
			tvTitle = itemView.findViewById(R.id.tvTitle);
			tvUrl = itemView.findViewById(R.id.tvUrl);
			iv = itemView.findViewById(R.id.iv);
		}
		
		void onBind(Movie movie) {
			iv.setImageResource(movie.getAlbumId());
			tvId.setText("" + movie.getId());
			tvTitle.setText(movie.getTitle());
			tvUrl.setText(movie.getUrl());
		}
	}
}
