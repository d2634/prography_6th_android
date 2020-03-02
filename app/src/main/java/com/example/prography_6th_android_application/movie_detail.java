package com.example.prography_6th_android_application;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class movie_detail extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.movie_detail_layout);

        TextView title_t=(TextView)findViewById(R.id.title);
        TextView release_t=(TextView)findViewById(R.id.release);
        TextView director_t=(TextView)findViewById(R.id.director);
        TextView rt_score=(TextView)findViewById(R.id.rt_score);
        TextView description_t=(TextView)findViewById(R.id.description);

        Intent intent = getIntent();

        String name = intent.getExtras().getString("title");
        title_t.setText(name);

        String release= intent.getExtras().getString("release");
        release_t.setText("release date: "+ release);

        String director = intent.getExtras().getString("director");
        String producer = intent.getExtras().getString("producer");
        director_t.setText("director: "+director+"  producer: "+producer);

        String score = intent.getExtras().getString("rt_score");
        rt_score.setText("Rotten Tomato score: "+score);

        String description = intent.getExtras().getString("description");
        description_t.setText(description);

    }
}
