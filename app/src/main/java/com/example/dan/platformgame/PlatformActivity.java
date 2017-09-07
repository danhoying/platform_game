package com.example.dan.platformgame;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;

public class PlatformActivity extends AppCompatActivity {

    // The object to handle the View
    private PlatformView platformView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get a Display object to access screen details
        Display display = getWindowManager().getDefaultDisplay();

        // Load the resolution into a Point object
        Point resolution = new Point();
        display.getSize(resolution);

        // Set view for game using resolution object
        platformView = new PlatformView(this, resolution.x, resolution.y);

        // Make our platformView the view for the Activity
        setContentView(platformView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        platformView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        platformView.resume();
    }

}
