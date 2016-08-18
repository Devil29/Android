package com.example.vishalkumar1.retrofit.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by vishal.kumar1 on 18/08/16.
 */
public class Users {
    @SerializedName("name")
    private String name;

    Users(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }
}
