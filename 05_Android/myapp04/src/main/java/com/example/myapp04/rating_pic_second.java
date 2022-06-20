package com.example.myapp04;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;

import org.w3c.dom.Text;

public class rating_pic_second extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rating_pic_second);

        Intent intent = getIntent();
//        Log.d("second", intent.getIntArrayExtra("imageName").toString());
        int[] voteResults = intent.getIntArrayExtra("voteCount");
        String[] imageNames = intent.getStringArrayExtra("imageName");

        TextView[] tv = new TextView[imageNames.length];
        RatingBar[] rbar = new RatingBar[imageNames.length];

        Integer[] tvId = {R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5, R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9};
        Integer[] rbarId = {R.id.rbar1, R.id.rbar2, R.id.rbar3, R.id.rbar4, R.id.rbar5, R.id.rbar6, R.id.rbar7, R.id.rbar8, R.id.rbar9};


        Integer[] imageFileId = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5, R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9};

        for (int i = 0; i < voteResults.length; i++) {
            tv[i] = findViewById(tvId[i]);
            rbar[i] = findViewById(rbarId[i]);
        }

        for (int i = 0; i < voteResults.length; i++) {
            tv[i].setText(imageNames[i]);
            rbar[i].setRating(voteResults[i]);
        }

        TextView tvTop = findViewById(R.id.tvTop);

        int maxVote = 0;
        int maxVoteIdx = -1;
        for (int i = 0; i < voteResults.length; i++) {
            if (maxVote < voteResults[i]) {
                maxVote = voteResults[i];
                maxVoteIdx = i;
            }
        }
        tvTop.setText(imageNames[maxVoteIdx]);

        ImageView ivTop = findViewById(R.id.ivTop);
        ivTop.setImageResource(imageFileId[maxVoteIdx]);

        Button btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
