package com.mypkg.Entity;

/**
 * Created by Ujjwal on 12/22/2016.
 */
public class User {

    private int id;
    private String name;
    private String userType;

    public User(int id, String name, String userType) {
        this.id = id;
        this.name = name;
        this.userType = userType;
    }

    public User(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}