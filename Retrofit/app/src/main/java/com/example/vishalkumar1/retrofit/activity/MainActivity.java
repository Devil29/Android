package com.example.vishalkumar1.retrofit.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.vishalkumar1.retrofit.R;
import com.example.vishalkumar1.retrofit.constant.ProjectConst;
import com.example.vishalkumar1.retrofit.model.User;
import com.example.vishalkumar1.retrofit.model.Users;
import com.example.vishalkumar1.retrofit.rest.ApiClient;
import com.example.vishalkumar1.retrofit.rest.ApiInterface;
import com.google.gson.JsonObject;

import java.io.File;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String API_KEY= ProjectConst.Api_Key;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //checkApi();
        apiCalls();
    }

    private void checkApi(){
        if(API_KEY.isEmpty()){
            Toast.makeText(getApplicationContext(),"Enter a API KEY" ,Toast.LENGTH_LONG).show();
            return;
        }
    }

    private void apiCalls(){
        ApiInterface apiservice = ApiClient.getClient().create(ApiInterface.class);


        Call<User> call = apiservice.getUser("ffa");
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.d("Data" ,response.body().getName());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d("Data", "Error");
            }
        });



        Call<Users> callUsers = apiservice.getAllUsers();
        callUsers.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                Log.d("Data", " " + response.body().getName().size());
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                Log.d("Data", "Error1");
            }
        });



        Call<JsonObject> callGreet = apiservice.getGreet();
        callGreet.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                Log.d("Data", response.body().toString());
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.d("Data", "Error2");
            }
        });


        Calendar c = Calendar.getInstance();
        User user=new User(""+ c.get(Calendar.SECOND));
        Call<JsonObject> postUser = apiservice.CreateUser(user);
        postUser.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                Log.d("Data", response.body().toString());
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.d("Data", "Error3");
            }
        });


        MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");
        File file = new File("/storage/emulated/0/Pictures/MyApp/test.png");
        RequestBody requestBody = RequestBody.create(MEDIA_TYPE_PNG, file);
        Call<JsonObject> postPic = apiservice.uploadImage("test", requestBody);
        postPic.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                Log.d("Data", response.body().toString());
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.d("Data", "Error4");
                t.printStackTrace();
            }
        });

    }

}
