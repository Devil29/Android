package com.example.vishalkumar1.moviesrating.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.vishalkumar1.moviesrating.R;

public class SplashActivity extends Activity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        textView = (TextView) findViewById(R.id.text);
        Thread timer = new Thread() {
            public void run() {
                try {
                    Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
                    textView.startAnimation(animation);
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent i = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();
    }
}
