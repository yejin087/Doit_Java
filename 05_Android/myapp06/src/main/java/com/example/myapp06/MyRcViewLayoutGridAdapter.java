package com.example.myapp06;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyRcViewLayoutGridAdapter extends RecyclerView.Adapter<MyRcViewLayoutGridAdapter.ViewHolder> {

    ArrayList<MovieItem> movieItems;

    public MyRcViewLayoutGridAdapter(ArrayList<MovieItem> movieItems) {
        this.movieItems = movieItems;
        Log.d(">>>", ">>>>" + movieItems.size());
    }

    @NonNull
    @Override
    public MyRcViewLayoutGridAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.recycler_layoutgrid_item, parent, false);

        MyRcViewLayoutGridAdapter.ViewHolder viewHolder = new MyRcViewLayoutGridAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyRcViewLayoutGridAdapter.ViewHolder holder, int position) {
        MovieItem movieItem = movieItems.get(position);
        Log.d(">>>", movieItem.getPosterId() + "");
        holder.imageView.setImageResource(movieItem.getPosterId());
    }

    @Override
    public int getItemCount() {
        return movieItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.profile);
        }
    }
}
