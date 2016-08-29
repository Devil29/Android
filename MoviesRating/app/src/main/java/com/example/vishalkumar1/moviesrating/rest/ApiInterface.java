package com.example.vishalkumar1.moviesrating.rest;

import com.example.vishalkumar1.moviesrating.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by vishal.kumar1 on 18/08/16.
 */
public interface ApiInterface {
    @GET("movie/top_rated")
    Call<MovieResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("movie/upcoming")
    Call<MovieResponse> getUpcomingMovies(@Query("api_key") String apikey);

    @GET("movie/popular")
    Call<MovieResponse> getPopularMovies(@Query("api_key") String apiKey);

    @GET("movie/now_playing")
    Call<MovieResponse> getNowPlayingMovies(@Query("api_key") String apiKey);

    @GET("movie/{id}")
    Call<MovieResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);

    //http://api.themoviedb.org/3/search/movie?api_key=a9527b459a546d9eaff269d395c98a9e&query=batman
    @GET("search/movie")
    Call<MovieResponse> searchMovies(@Query("api_key") String apiKey,@Query("query") String query);

}

