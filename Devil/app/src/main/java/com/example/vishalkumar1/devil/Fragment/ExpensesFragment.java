package com.example.vishalkumar1.devil.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.vishalkumar1.devil.R;

/**
 * Created by vishal.kumar1 on 14/08/16.
 */
public class ExpensesFragment extends  BaseFragment {

    public ExpensesFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_expenses,container,false);

        Button button= (Button)view.findViewById(R.id.btn_showexp);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showExp();
            }
        });
        return view;
    }

    private  void showExp(){

    }
}
