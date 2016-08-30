package com.example.vishalkumar1.moviesrating.activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.vishalkumar1.moviesrating.R;
import com.example.vishalkumar1.moviesrating.activity.MainActivity;

/**
 * Created by vishal.kumar1 on 30/08/16.
 */
public class SearchPersonFragment extends BaseFragment implements View.OnClickListener {

    TextView t;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view=inflater.inflate(R.layout.fragment_search_person,container,false);
        t= (TextView) view.findViewById(R.id.txt_search_person);
        Button button=(Button) view.findViewById(R.id.btn_searchPerson);
        button.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_searchPerson:
                Log.d("Search", t.getText().toString() );
                ((MainActivity)getActivity()).SearchPersonResult(t.getText().toString());
                break;
        }
    }
}

