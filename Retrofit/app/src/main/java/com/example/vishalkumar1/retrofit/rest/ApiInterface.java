package com.example.vishalkumar1.retrofit.rest;

import com.example.vishalkumar1.retrofit.model.Data;
import com.example.vishalkumar1.retrofit.model.Users;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by vishal.kumar1 on 18/08/16.
 */
public interface ApiInterface {

    @GET("users/ffa")
    Call<Users> getGreet();

    @GET("movies/top_rated")
    Call<Data> getData(@Query("api_key") String apiKey);
}
