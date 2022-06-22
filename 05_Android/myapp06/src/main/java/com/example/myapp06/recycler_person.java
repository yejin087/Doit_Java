package com.example.myapp06;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class recycler_person extends AppCompatActivity {

    RecyclerView recyclerView;
    PersonAdapter personAdapter;
    ArrayList<Person> personArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_person);

        recyclerView = findViewById(R.id.recyclerView);


        for (int i = 0; i < 15; i++) {
            personArrayList.add(new Person("name" + i, "tel" + i, R.drawable.mov03));
        }

        personAdapter = new PersonAdapter(personArrayList);

        personAdapter.setPersonListener(new PersonListener() {
            @Override
            public void onItemClick(int position) {
                Person person = personAdapter.getItem(position);
                Toast.makeText(getApplicationContext(), person.getName() + " ", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onItemLongClick(int position) {
                personAdapter.removeItem(position);
            }
        });
        recyclerView.setAdapter(personAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}