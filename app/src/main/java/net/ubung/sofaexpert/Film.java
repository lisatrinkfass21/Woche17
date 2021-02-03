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
    private Date date;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");


    public Film(String name, String vote, String path, String beschreibung, String date) {
        this.name = name;
        this.vote = vote + " / 10";
        this.path = path;
        this.beschreibung = beschreibung;

        try {
            this.date = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.name+","+this.vote+","+this.path+","+this.beschreibung+","+sdf.format(date);
    }

    public static Film filmOfString(String film){
        String[] splittedFilms = film.split(",");
        String na = splittedFilms[0];
        String vo = splittedFilms[1];
        String pat = splittedFilms[2];
        String bes = splittedFilms[3];
        String dat = splittedFilms[4];
        Film temp = new Film(na, vo, pat, bes, dat);
        return temp;
    }

    public String getDate() {
        return sdf.format(this.date);
    }

    public void setDate(Date date) {
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


