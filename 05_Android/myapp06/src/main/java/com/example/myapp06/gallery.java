package com.example.myapp06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class gallery extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        Gallery gallery = findViewById(R.id.gallery);
        MyGallgeryAdapter galleryAdapter = new MyGallgeryAdapter(this);
        gallery.setAdapter(galleryAdapter);


    }

    public class MyGallgeryAdapter extends BaseAdapter {

        Integer[] posterId = {R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10, R.drawable.mov11, R.drawable.mov12, R.drawable.mov13, R.drawable.mov14, R.drawable.mov15};
        Context context;

        public MyGallgeryAdapter(Context context) {
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
            Log.d(">>>view", " " + i + "/// " + view + "/// " + viewGroup.toString());
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(posterId[i]);
            imageView.setLayoutParams(new Gallery.LayoutParams(200, 300));
            imageView.setPadding(5, 5, 5, 5);

            imageView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    ImageView ivPoster = findViewById(R.id.ivPoster);
                    ivPoster.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    ivPoster.setImageResource(posterId[i]);
                    return false;
                }
            });
            return imageView;
        }


    }
}