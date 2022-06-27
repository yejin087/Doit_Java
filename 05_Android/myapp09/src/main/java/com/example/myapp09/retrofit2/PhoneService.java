package com.example.myapp09.retrofit2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PhoneService {
	// CRUD
	
	@GET("list")
	Call<List<Phone>> findAll();
	
	@POST("insert")
	Call<Phone> save(@Body Phone phone);
	
	@PUT("update/{id}")
	Call<Phone> update(@Path("id") Long id, @Body Phone phone);
	
	@DELETE("delete/{id}")
	Call<Void> deleteById(@Path("id") Long id);
}
