package com.example.myapp09;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieInter {
	
	@GET("photos")
	Call<List<Movie>> doGetMovies();
	
	@GET("posts")
	Call<List<Post>> doGetPosts();
}
