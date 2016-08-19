package com.example.vishalkumar1.retrofit.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by vishal.kumar1 on 18/08/16.
 */
public class Users {
    @SerializedName("results")
    private List<User> results;

    public Users(List<User> results){
        this.results=results;
    }

    public List<User> getName(){
        return results;
    }

    public void setName(List<User> results){
        this.results=results;
    }
}
