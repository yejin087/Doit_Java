package com.example.myapp04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class rating_pic extends AppCompatActivity {

    Button btnResult;
    ImageView[] imageViews = new ImageView[9];
    Integer[] imageViewIds = {R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5, R.id.iv6, R.id.iv7, R.id.iv8, R.id.iv9};
    String[] imageNames = {"pic1", "pic2", "pic3", "pic4", "pic5", "pic6", "pic7", "pic8", "pic9"};
    int[] voteCounts = new int[9];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_pic);

        btnResult = findViewById(R.id.btnResult);

        for (int i = 0; i < imageViewIds.length; i++) {
            int index = i;
            imageViews[index] = findViewById(imageViewIds[i]);
            imageViews[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    voteCounts[index]++;
                    Toast.makeText(getApplicationContext(), imageNames[index] + "/" + voteCounts[index], Toast.LENGTH_SHORT).show();
                }
            });

        }

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), rating_pic_second.class);

                intent.putExtra("voteCount", voteCounts);
                intent.putExtra("imageName", imageNames);
                
                startActivity(intent);

            }
        });
    }
}
