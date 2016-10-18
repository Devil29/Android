package com.example.vishalkumar1.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.vishalkumar1.recyclerview.adapter.PlayerAdapter;
import com.example.vishalkumar1.recyclerview.model.Player;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Player> players = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPlayers();
        initRecycler();
    }

    void initPlayers(){
        players.add(new Player("Vishal", "10","1000"));
        players.add(new Player("Gaurav", "20","2000"));
        players.add(new Player("kumar", "30","3000"));
        players.add(new Player("gupta", "40","4000"));
    }

    void initRecycler(){
        Log.d(players.get(0).getName(), players.get(1).getName());
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new PlayerAdapter(players));

    }
}
