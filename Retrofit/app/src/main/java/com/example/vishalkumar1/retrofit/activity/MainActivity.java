package com.example.vishalkumar1.retrofit.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.vishalkumar1.retrofit.R;
import com.example.vishalkumar1.retrofit.constant.ProjectConst;
import com.example.vishalkumar1.retrofit.model.Data;
import com.example.vishalkumar1.retrofit.rest.ApiClient;
import com.example.vishalkumar1.retrofit.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String API_KEY= ProjectConst.Api_Key;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(API_KEY.isEmpty()){
            Toast.makeText(getApplicationContext(),"Enter a API KEY" ,Toast.LENGTH_LONG).show();
            return;
        }

        ApiInterface apiservice = ApiClient.getClient().create(ApiInterface.class);
        Call<Data> call = apiservice.getData(API_KEY);
        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                Log.d("Data" ,response.body().toString());
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Log.d("Data", "Error");
            }
        });

    }

}
