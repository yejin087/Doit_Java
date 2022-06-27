package com.example.myapp09;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieClient {
	
	private static Retrofit retrofit;
	
	static Retrofit getClient() {
		retrofit = new Retrofit.Builder()
				.baseUrl("http://jsonplaceholder.typicode.com/")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		return retrofit;
	}
	
}
