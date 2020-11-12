package com.example.stippejan.aufgabe4;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movie {

    @SerializedName("title")
    private String title;
    @SerializedName("year")
    private int year;
    @SerializedName("duration")
    private int duration;
    @SerializedName("imdbScore")
    private double imdbScore;
    @SerializedName("synchronized")
    private boolean audioSynchronized;
    @SerializedName("cast")
    private List<String> cast;

    public Movie(String title, int year, int duration, double imdbScore, boolean audioSynchronized, List<String> cast) {
        this.title = title;
        this.year = year;
        this.duration = duration;
        this.imdbScore = imdbScore;
        this.audioSynchronized = audioSynchronized;
        this.cast = cast;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getImdbScore() {
        return imdbScore;
    }

    public void setImdbScore(double imdbScore) {
        this.imdbScore = imdbScore;
    }

    public boolean isAudioSynchronized() {
        return audioSynchronized;
    }

    public void setAudioSynchronized(boolean audioSynchronized) {
        this.audioSynchronized = audioSynchronized;
    }

    public List<String> getCast() {
        return cast;
    }

    public void setCast(List<String> cast) {
        this.cast = cast;
    }

}
