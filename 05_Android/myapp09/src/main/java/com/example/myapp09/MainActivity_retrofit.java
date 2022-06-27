package com.example.myapp09;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity_retrofit extends AppCompatActivity {
	
	
	Button btn, btn2;
	RecyclerView recyclerView;
	MovieAdapter movieAdapter;
	PostAdapter postAdapter;
	ArrayList<Movie> movies = new ArrayList<>();
	ArrayList<Post> posts = new ArrayList<>();
	MovieInter apiInterface;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_retrofit);
		
		recyclerView = findViewById(R.id.recycler);
		movieAdapter = new MovieAdapter(movies);
		recyclerView.setAdapter(movieAdapter);
		LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity_retrofit.this, RecyclerView.VERTICAL, false);
		recyclerView.setLayoutManager(linearLayoutManager);
		
		btn = findViewById(R.id.btn);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				apiInterface = MovieClient.getClient().create(MovieInter.class);
				Call<List<Movie>> call = apiInterface.doGetMovies();
				call.enqueue(new Callback<List<Movie>>() {
					
					
					@Override
					public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
						
						for (Movie movie : response.body()) {
							movies.add(movie);
						}
						Log.d(">> size", " " + movies.size());
						movieAdapter.notifyDataSetChanged();
					}
					
					@Override
					public void onFailure(Call<List<Movie>> call, Throwable t) {
					
					}
				});
				
			}
		});
		
		btn2 = findViewById(R.id.btn2);
		postAdapter = new PostAdapter(posts);
		recyclerView.setAdapter(postAdapter);
//		recyclerView.setLayoutManager(linearLayoutManager);
		
		btn2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				
				
				apiInterface = MovieClient.getClient().create(MovieInter.class);
				Call<List<Post>> call = apiInterface.doGetPosts();
				call.enqueue(new Callback<List<Post>>() {
					
					@Override
					public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
						for (Post post : response.body()) {
							posts.add(post);
						}
						Log.d(">> size", " " + posts.size());
						postAdapter.notifyDataSetChanged();
					}
					
					@Override
					public void onFailure(Call<List<Post>> call, Throwable t) {
					
					}
				});
			}
		});
	}
	
	
}