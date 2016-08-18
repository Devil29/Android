package com.example.vishalkumar1.retrofit.rest;

import com.example.vishalkumar1.retrofit.constant.ProjectConst;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vishal.kumar1 on 18/08/16.
 */
public class ApiClient {
    public static final String BASE_URL= ProjectConst.Base_Url;
    private static Retrofit retrofit = null;

    public static Retrofit getClient(){
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit;
    }

}
