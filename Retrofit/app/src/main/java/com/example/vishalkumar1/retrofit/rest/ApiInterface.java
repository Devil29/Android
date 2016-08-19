package com.example.vishalkumar1.retrofit.rest;

import com.example.vishalkumar1.retrofit.model.Data;
import com.example.vishalkumar1.retrofit.model.User;
import com.example.vishalkumar1.retrofit.model.Users;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by vishal.kumar1 on 18/08/16.
 */
public interface ApiInterface {

    @GET("users/{name}")
    Call<User> getUser(@Path("name") String name);

    @GET("users")
    Call<Users> getAllUsers();

    @GET("hello")
    Call<JsonObject> getGreet();

    @POST("users")
    Call<JsonObject> CreateUser(@Body User user);


    @GET("movies/top_rated")
    Call<Data> getData(@Query("api_key") String apiKey);
}
