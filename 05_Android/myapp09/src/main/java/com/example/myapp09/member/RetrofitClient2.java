package com.example.myapp09.member;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient2 {
	
	private static RetrofitClient2 retrofitClient;
	private final MemberService memberService;
	
	public RetrofitClient2() {
		Retrofit retrofitClient = new Retrofit.Builder()
				.baseUrl("http://10.100.102.30:8877/")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		
		memberService = retrofitClient.create(MemberService.class);
	}
	
	public static RetrofitClient2 getInstance() {
		if (retrofitClient == null) {
			retrofitClient = new RetrofitClient2();
		}
		
		return retrofitClient;
	}
	
	public MemberService getMemberService() {
		return memberService;
	}
}
