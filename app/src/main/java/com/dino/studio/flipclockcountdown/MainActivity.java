package com.dino.studio.flipclockcountdown;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dino.studio.flipclockcoutdown.FlipClock;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FlipClock flipClock = (FlipClock) findViewById(R.id.flipClock);
        flipClock.setCurrentTime(10, 10, 10);
    }
}
