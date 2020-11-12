package com.example.stippejan.aufgabe4;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class User {

    // Properties for a User-object
    @SerializedName("user")
    private String userName;
    @SerializedName("lastLogin")
    private String lastLogin;
    @SerializedName("movies")
    private List<Movie> movieList;

    // Constructor
    public User(String userName, String lastLogin, List<Movie> movieList) {
        this.userName = userName;
        this.lastLogin = lastLogin;
        this.movieList = movieList;
    }

    // Getter- and Setter-methods
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

}
