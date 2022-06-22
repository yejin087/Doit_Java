package com.example.myapp06;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class recycler_layoutgrid extends AppCompatActivity {

    Integer[] posterId = {R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov02, R.drawable.mov03, R.drawable.mov02, R.drawable.mov03, R.drawable.mov02, R.drawable.mov03, R.drawable.mov02, R.drawable.mov03, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10, R.drawable.mov11, R.drawable.mov12, R.drawable.mov13, R.drawable.mov14, R.drawable.mov15};
    ArrayList<MovieItem> movieItems = new ArrayList<>();
    private RecyclerView recyclerView;
    private MyRcViewLayoutGridAdapter myRcViewLayoutGridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        recyclerView = findViewById(R.id.recyclerView);

        for (int i = 0; i < posterId.length; i++) {
            movieItems.add(new MovieItem(posterId[i], "movie" + i));
        }

        myRcViewLayoutGridAdapter = new MyRcViewLayoutGridAdapter(movieItems);
        recyclerView.setAdapter(myRcViewLayoutGridAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 5));
    }


}