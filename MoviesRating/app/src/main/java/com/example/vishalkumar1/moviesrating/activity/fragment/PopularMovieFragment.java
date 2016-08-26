package com.example.vishalkumar1.moviesrating.activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.vishalkumar1.moviesrating.R;
import com.example.vishalkumar1.moviesrating.activity.MainActivity;
import com.example.vishalkumar1.moviesrating.activity.TopMovieActivity;
import com.example.vishalkumar1.moviesrating.adapter.MoviesAdapter;
import com.example.vishalkumar1.moviesrating.constant.ProjectConst;
import com.example.vishalkumar1.moviesrating.listener.RecyclerTouchListener;
import com.example.vishalkumar1.moviesrating.model.Movie;
import com.example.vishalkumar1.moviesrating.model.MovieResponse;
import com.example.vishalkumar1.moviesrating.rest.ApiClient;
import com.example.vishalkumar1.moviesrating.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by vishal.kumar1 on 26/08/16.
 */
public class PopularMovieFragment extends BaseFragment {

    private static final String API_KEY= ProjectConst.Api_Key;
    List<Movie> movies;
    View view;

    public PopularMovieFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view=inflater.inflate(R.layout.fragment_top_rated,container,false);
        callApi();
        return view;
    }

    private void callApi(){
        if(API_KEY.isEmpty()){
            Toast.makeText(getActivity(),"Get a API Key",Toast.LENGTH_LONG).show();;
            return;
        }

        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.movies_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new TopMovieActivity.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Movie movie = movies.get(position);
                Toast.makeText(getActivity(), movie.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
//                Intent intent=new Intent(getActivity(), MoviePageActivity.class);
//                intent.putExtra("Data", movie);
//                startActivity(intent);
                ((MainActivity)getActivity()).moviePage(movie);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<MovieResponse> call= apiService.getPopularMovies(API_KEY);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                movies=response.body().getResults();
                recyclerView.setAdapter(new MoviesAdapter(movies, R.layout.list_item_movie, getActivity()));
                Log.d("Number of Movies", "" + movies.size());
            }
            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.d("Error" , "Error");
            }
        });
    }

    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }
}
