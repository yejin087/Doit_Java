package com.example.myapp06;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class gridView extends AppCompatActivity {

    Integer[] posterId = {R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov02, R.drawable.mov03, R.drawable.mov02, R.drawable.mov03, R.drawable.mov02, R.drawable.mov03, R.drawable.mov02, R.drawable.mov03, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10, R.drawable.mov11, R.drawable.mov12, R.drawable.mov13, R.drawable.mov14, R.drawable.mov15};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);


        setTitle("grid View");

        GridView gridView = findViewById(R.id.gridView);
        GridAdapter gridAdapter = new GridAdapter(this);
        gridView.setAdapter(gridAdapter);

    }

    public class GridAdapter extends BaseAdapter {

        Context context;

        public GridAdapter(Context context) {
            this.context = context;

        }

        @Override
        public int getCount() {
            return posterId.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(200, 300));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5, 5, 5, 5);

            imageView.setImageResource(posterId[i]);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    View dialogView = View.inflate(gridView.this, R.layout.gridview_dialog, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(gridView.this);
                    ImageView ivPoster = dialogView.findViewById(R.id.ivPoster);
                    ivPoster.setImageResource(posterId[i]);

                    dlg.setView(dialogView);
                    dlg.setNegativeButton("x", null);
                    dlg.show();

                }
            });

            return imageView;
        }
    }
}