package com.example.vishalkumar1.recyclerview.adapter;

import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vishalkumar1.recyclerview.R;
import com.example.vishalkumar1.recyclerview.model.Player;

import java.util.List;

/**
 * Created by vishal.kumar1 on 19/08/16.
 */
public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.MyViewHolder> {

    private List<Player> PlayerList;

    public PlayerAdapter(List<Player> playerList) {
        PlayerList = playerList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.player_list_row,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Player player=PlayerList.get(position);
        holder.pname.setText(player.getName());
        holder.run.setText(player.getRun());
        holder.age.setText(player.getAge());
    }

    @Override
    public int getItemCount() {
        return PlayerList.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder{
        public TextView pname,run,age;

        public MyViewHolder(View view){
            super(view);
            pname=(TextView)view.findViewById(R.id.name);
            run=(TextView)view.findViewById(R.id.run);
            age=(TextView)view.findViewById(R.id.age);
        }

    }
}

































