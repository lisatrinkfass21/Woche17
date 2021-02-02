package net.ubung.sofaexpert;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.BaseStream;

public class MovieAdapter extends BaseAdapter {

    private int gridViewItemId;
    private List<Film> movies = new ArrayList<>();
    private LayoutInflater inflater;


    public MovieAdapter(Context co, int gridViewItemId, List<Film> movies){
        this.inflater = (LayoutInflater) co.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.movies.addAll(movies);
        this.gridViewItemId = gridViewItemId;
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
        String url = MainActivity.URL_PICTURES+movies.get(position).getPath();
        View listItem = (convertView == null)?
                inflater.inflate(this.gridViewItemId,null) : convertView;
        ImageView iv = (ImageView) listItem.findViewById(R.id.icon);
        Picasso.get().load(url).into(iv);




        return listItem;
    }
}
