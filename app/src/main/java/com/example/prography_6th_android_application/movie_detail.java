package com.example.prography_6th_android_application;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class movie_detail extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

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
        director_t.setText("director: "+director+" / producer: "+producer);

        String score = intent.getExtras().getString("rt_score");
        rt_score.setText("Rotten Tomato score: "+score);

        String description = intent.getExtras().getString("description");
        description_t.setText(description);

        TextView delete;
        delete=(TextView) findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //바깥레이어 클릭시 안닫히게
        if(event.getAction()==MotionEvent.ACTION_OUTSIDE){
            return false;
        }
        return true;
    }

}
