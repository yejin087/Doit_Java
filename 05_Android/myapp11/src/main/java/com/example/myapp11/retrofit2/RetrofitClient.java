package com.example.myapp11.retrofit2;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
	private static RetrofitClient retrofitClient;
	private final PhoneService phoneService;
	
	public RetrofitClient() {
		
		Retrofit retrofitClient = new Retrofit.Builder()
				.baseUrl("http://10.100.102.30:8877/")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		
		phoneService = retrofitClient.create(PhoneService.class);
	}
	
	public static RetrofitClient getInstance() {
		if (retrofitClient == null) {
			retrofitClient = new RetrofitClient();
		}
		
		return retrofitClient;
	}
	
	public PhoneService getPhoneService() {
		return phoneService;
	}
}
