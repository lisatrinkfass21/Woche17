package net.ubung.sofaexpert;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.BaseStream;

public class MovieAdapter extends BaseAdapter {

    private int gridViewItemId;
    private List<Film> movies = new ArrayList<>();
    private LayoutInflater inflater;
    private Context co;


    public MovieAdapter(Context co, int gridViewItemId, List<Film> movies){
        this.inflater = (LayoutInflater) co.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.movies.addAll(movies);
        this.gridViewItemId = gridViewItemId;
        this.co = co;
    }
    @Override
    public int getCount() {
        return this.movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView iv;
                 if(convertView == null){
                     iv = new ImageView(co);
                     iv.setLayoutParams(new GridView.LayoutParams(540, 1000));
                     iv.setPadding(8,0,8,0);
                 }else{
                     iv = (ImageView) convertView;
                 }
        String url = MainActivity.URL_PICTURES+movies.get(position).getPath();
        Picasso.get().load(url).into(iv);
        return iv;
    }
}


