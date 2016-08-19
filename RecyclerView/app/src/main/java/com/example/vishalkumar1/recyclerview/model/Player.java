package com.example.vishalkumar1.recyclerview.model;

/**
 * Created by vishal.kumar1 on 19/08/16.
 */
public class Player {
    private String name,age,run;

    public Player(String name, String age, String run){
        this.name=name;
        this.age=age;
        this.run=run;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getAge(){
        return age;
    }

    public void setAge(String age){
        this.age=age;
    }

    public String getRun(){
        return run;
    }

    public void setRun(String run){
        this.run=run;
    }

}
