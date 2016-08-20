package com.example.vishalkumar1.moviesrating.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.vishalkumar1.moviesrating.R;
import com.example.vishalkumar1.moviesrating.model.Movie;

public class MoviePageActivity extends AppCompatActivity {

    Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_page);
        movie= (Movie) getIntent().getSerializableExtra("Data");
        settext();
    }

    private void settext(){
        TextView t=(TextView)findViewById(R.id.textView);
        t.setText(movie.getTitle());
    }
}
