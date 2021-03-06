package net.ubung.sofaexpert;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Movie;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    GridView gridView;
    static String URL_PICTURES = "http://image.tmdb.org/t/p/w154/";
    MovieAdapter mva;
    List<Film> movies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadAll();
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("name",movies.get(position).getName());
                intent.putExtra("vote", movies.get(position).getVote());
                intent.putExtra("path", movies.get(position).getPath());
                intent.putExtra("date", movies.get(position).getDate());
                intent.putExtra("besch", movies.get(position).getBeschreibung());
                startActivity(intent);
            }
        });

    }

    private void loadAll() {
         ProgressDialog pd = new ProgressDialog(this);
         pd.setMessage("loading.....");
        pd.show();
        loadPictFromJSON();
        gridView = (GridView) findViewById(R.id.gridview);
        bindAdapterToListView(gridView);
        pd.dismiss();
    }


    private void loadPictFromJSON(){
        try {
            AssetManager assests = getAssets();
            InputStream in = assests.open("movies.json");
            int size = in.available();
            byte[] buffer = new byte[size];
            in.read(buffer);
            in.close();

            String jsonString = new String(buffer, "UTF-8");

            JSONObject json = new JSONObject(jsonString);
            JSONArray results = json.getJSONArray("results");

            for (int i = 0; i < results.length(); i++) {
                String name = results.getJSONObject(i).getString("title");
                String vote = results.getJSONObject(i).getString("vote_average");
                String path = results.getJSONObject(i).getString("poster_path");
                String beschreibung = results.getJSONObject(i).getString("overview");
                String date = results.getJSONObject(i).getString("release_date");
                path= path.replace("/","");
                Film mov = new Film(name, vote, path, beschreibung, date);
                movies.add(mov);
                System.out.println(mov.toString());

            }

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void bindAdapterToListView(GridView gridView) {
        mva = new MovieAdapter(this, R.layout.activity_main, movies);
        gridView.setAdapter(mva);

    }
}