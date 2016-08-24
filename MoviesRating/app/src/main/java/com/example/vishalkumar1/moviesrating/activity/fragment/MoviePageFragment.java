package com.example.vishalkumar1.moviesrating.activity.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vishalkumar1.moviesrating.R;
import com.example.vishalkumar1.moviesrating.constant.ProjectConst;
import com.example.vishalkumar1.moviesrating.model.Movie;
import com.example.vishalkumar1.moviesrating.utils.ImageUtils;

/**
 * Created by vishal.kumar1 on 24/08/16.
 */
public class MoviePageFragment extends BaseFragment {

    View view;
    Movie movie;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        movie= (Movie)getArguments().getSerializable("Data");
        View view=inflater.inflate(R.layout.fragment_movie_page,container,false);
        //TextView t=(TextView)view.findViewById(R.id.txt_title);
        //t.setText(movie.getTitle());
        setData(view);
        return view;
    }
    private void setData(View view){
        setTitle(view);
        setPoster(view);
        setRating(view);
        setLang(view);
        setAdult(view);
        setOverview(view);
        setYear(view);
        setPopularity(view);
    }


    private void setTitle(View view){
        TextView t=(TextView)view.findViewById(R.id.txt_title);
        t.setText(movie.getTitle());
    }

    private void setRating(View view){
        TextView t=(TextView)view.findViewById(R.id.txt_imdb);
        t.setText(movie.getVoteAverage().toString());
    }

    private void setLang(View view){
        TextView t=(TextView)view.findViewById(R.id.txt_lang);
        t.setText(movie.getOriginalLanguage());
    }

    private void setAdult(View view){
        TextView t=(TextView)view.findViewById(R.id.txt_adult);
        if(movie.isAdult()){
            t.setText("Yes");
        }
        else{
            t.setText("No");
        }
    }

    private void setOverview(View view){
        TextView t=(TextView)view.findViewById(R.id.txt_overview);
        t.setText(movie.getOverview());
    }

    private void setYear(View view){
        TextView t =(TextView)view.findViewById(R.id.txt_year);
        t.setText(movie.getReleaseDate());
    }

    private void setPopularity(View view){
        TextView t=(TextView)view.findViewById(R.id.txt_popularity);
        t.setText(movie.getPopularity().toString());
    }

    private void setPoster(View view){
        String path= ProjectConst.Base_Image_URl + movie.getPosterPath();
        Bitmap bitmap= ImageUtils.getBitmapFromURL(path);
        //Bitmap bitmap=ImageUtils.getBitmap(path);
        Log.d("Data", "Got Bitmap");
        ImageView imageView=(ImageView)view.findViewById(R.id.posterpic);
        imageView.setImageBitmap(bitmap);
    }

}
