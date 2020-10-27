package com.example.dynamicquakes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Animation dynamic = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.from_left);
        Animation quakes = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.from_right);

        TextView dynamicsView = findViewById(R.id.dynamics);
        TextView quakesView = findViewById(R.id.quakes);

        dynamicsView.startAnimation(dynamic);
        quakesView.startAnimation(quakes);

        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}