package com.example.vishalkumar1.retrofit.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by vishal.kumar1 on 19/08/16.
 */
public class User {
    @SerializedName("name")
    private String name;

    public User(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }
}
