package com.example.vishalkumar1.moviesrating.activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vishalkumar1.moviesrating.R;

/**
 * Created by vishal.kumar1 on 27/08/16.
 */
public class SearchMovieFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view=inflater.inflate(R.layout.fragment_search_movie,container,false);
        return view;
    }
}
