package com.example.vishalkumar1.moviesrating.activity;

import android.graphics.Bitmap;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vishalkumar1.moviesrating.R;
import com.example.vishalkumar1.moviesrating.constant.ProjectConst;
import com.example.vishalkumar1.moviesrating.model.Movie;
import com.example.vishalkumar1.moviesrating.utils.ImageUtils;

public class MoviePageActivity extends AppCompatActivity {

    Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_page);
        movie= (Movie) getIntent().getSerializableExtra("Data");
        setData();
    }

    private void setData(){
        setTitle();
        setPoster();
        setRating();
        setLang();
        setAdult();
    }


    private void setTitle(){
        TextView t=(TextView)findViewById(R.id.txt_title);
        t.setText(movie.getTitle());
    }

    private void setRating(){
        TextView t=(TextView)findViewById(R.id.txt_imdb);
        t.setText(movie.getVoteAverage().toString());
    }

    private void setLang(){
        TextView t=(TextView)findViewById(R.id.txt_lang);
        t.setText(movie.getOriginalLanguage());
    }

    private void setAdult(){
        TextView t=(TextView)findViewById(R.id.txt_adult);
        if(movie.isAdult()){
            t.setText("Yes");
        }
        else{
            t.setText("No");
        }
    }

    private void setPoster(){
        String path=ProjectConst.Base_Image_URl + movie.getPosterPath();
        Bitmap bitmap= ImageUtils.getBitmapFromURL(path);
        //Bitmap bitmap=ImageUtils.getBitmap(path);
        Log.d("Data", "Got Bitmap");
        ImageView imageView=(ImageView)findViewById(R.id.posterpic);
        imageView.setImageBitmap(bitmap);
    }

}
