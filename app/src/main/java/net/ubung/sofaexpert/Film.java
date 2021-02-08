package net.ubung.sofaexpert;

import android.graphics.Movie;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Film {
    private String name;
    private String vote;
    private String path;
    private String beschreibung;
    private String date;


    public Film(String name, String vote, String path, String beschreibung, String date) {
        this.name = name;
        this.vote = vote ;
        this.path = path;
        this.beschreibung = beschreibung;
        this.date = date;
    }

    @Override
    public String toString() {
        return this.name+","+this.vote+","+this.path+","+this.beschreibung+","+ this.date;
    }


    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }
}


