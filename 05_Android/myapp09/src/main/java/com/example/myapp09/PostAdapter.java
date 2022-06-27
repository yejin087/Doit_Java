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

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
	
	
	private ArrayList<Post> posts = new ArrayList<>();
	
	public PostAdapter(ArrayList<Post> posts) {
		this.posts = posts;
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
		Post post = posts.get(position);
		
		holder.onBind(post);
	}
	
	@Override
	public int getItemCount() {
		return posts == null ? 0 : posts.size();
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
		
		void onBind(Post post) {
			
			tvId.setText("" + post.getId());
			tvTitle.setText(post.getTitle());
			tvUrl.setText(post.getBody());
		}
	}
}
