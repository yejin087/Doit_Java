package com.example.myapp06;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class recycler extends AppCompatActivity {
    private final ArrayList<FriendItem> friendItems = new ArrayList<>();
    Integer[] posterId = {R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10, R.drawable.mov11, R.drawable.mov12, R.drawable.mov13, R.drawable.mov14, R.drawable.mov15};
    private RecyclerView recyclerView;
    private MyRecyclerAdapter myRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        recyclerView = findViewById(R.id.recyclerView);


        for (int i = 0; i < 10; i++) {
            friendItems.add(new FriendItem("no" + i, " msg " + i, posterId[i]));
        }

        myRecyclerAdapter = new MyRecyclerAdapter(friendItems);
        recyclerView.setAdapter(myRecyclerAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 5));
    }


}