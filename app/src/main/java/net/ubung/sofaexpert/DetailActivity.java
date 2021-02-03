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
         Film tmp = Film.filmOfString(in.getStringExtra("Film"));
         name.setText(tmp.getName());
         vote.setText(tmp.getVote());
         besch.setText(tmp.getBeschreibung());
         dat.setText(tmp.getDate());
         String pfad = MainActivity.URL_PICTURES+tmp.getPath();

        Picasso.get().load(pfad).into(link);
    }
}