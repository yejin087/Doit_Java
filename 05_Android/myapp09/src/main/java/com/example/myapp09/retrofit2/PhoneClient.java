package com.example.myapp09.retrofit2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PhoneClient {
	
	private static Retrofit retrofit;
	
	static Retrofit getClient() {
		
		retrofit = new Retrofit.Builder()
				.baseUrl("http://10.100.102.30:8877/")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		
		return retrofit;
	}
}
