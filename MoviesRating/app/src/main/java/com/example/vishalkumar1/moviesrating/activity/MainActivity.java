package com.example.vishalkumar1.moviesrating.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.vishalkumar1.moviesrating.R;
import com.example.vishalkumar1.moviesrating.adapter.MoviesAdapter;
import com.example.vishalkumar1.moviesrating.constant.ProjectConst;
import com.example.vishalkumar1.moviesrating.model.Movie;
import com.example.vishalkumar1.moviesrating.model.MovieResponse;
import com.example.vishalkumar1.moviesrating.rest.ApiClient;
import com.example.vishalkumar1.moviesrating.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String API_KEY= ProjectConst.Api_Key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(API_KEY.isEmpty()){
            Toast.makeText(getApplicationContext(),"Get a API Key",Toast.LENGTH_LONG).show();;
            return;
        }

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<MovieResponse> call= apiService.getTopRatedMovies(API_KEY);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                List<Movie> movies=response.body().getResults();
                recyclerView.setAdapter(new MoviesAdapter(movies, R.layout.list_item_movie, getApplicationContext()));
                Log.d("Number of Movies", "" + movies.size());
            }
            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.d("Error" , "Error");
            }
        });
    }
}
