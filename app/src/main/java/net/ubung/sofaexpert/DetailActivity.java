package net.ubung.sofaexpert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

         TextView  name =  findViewById(R.id.movieName);
         TextView vote = findViewById(R.id.movieBewertung);
         TextView besch = findViewById(R.id.movieBesch);
         TextView dat = findViewById(R.id.movieDate);
         ImageView link = findViewById(R.id.movieImage);

         Intent in  = getIntent();
         name.setText(in.getStringExtra("name"));
         vote.setText(in.getStringExtra("vote") + " / 10");
        dat.setText(in.getStringExtra("date"));
         besch.setText(in.getStringExtra("besch"));

         String pfad = MainActivity.URL_PICTURES+in.getStringExtra("path");

        Picasso.get().load(pfad).into(link);
    }
}