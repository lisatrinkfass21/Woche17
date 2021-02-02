package net.ubung.sofaexpert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Film {
        private String name;
        private double vote;
        private String path;
        private String beschreibung;
        private Date date;


        public Film(String name, String vote, String path, String beschreibung, String date) {
            this.name = name;
            this.vote = Double.parseDouble(vote);
            this.path = path;
            this.beschreibung = beschreibung;
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            try {
                this.date = sdf.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        public Date getDate() {
            return date;
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

        public double getVote() {
            return vote;
        }

        public void setVote(double vote) {
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


