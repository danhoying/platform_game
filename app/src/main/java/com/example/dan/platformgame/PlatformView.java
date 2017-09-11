package com.example.dan.platformgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class PlatformView extends SurfaceView implements Runnable {
    private boolean debugging = true;
    private volatile boolean running;
    private Thread gameThread = null;

    // For drawing
    private Paint paint;
    private Canvas canvas;
    private SurfaceHolder ourHolder;

    Context context;
    long startFrameTime;
    long timeThisFrame;
    long fps;

    // New engine classes
    private LevelManager lm;
    private Viewport vp;
    InputController ic;

    PlatformView(Context context, int screenWidth, int screenHeight) {
        super(context);
        this.context = context;

        // Initialize drawing objects
        ourHolder = getHolder();
        paint = new Paint();
    }

    @Override
    public void run() {
        while (running) {
            startFrameTime = System.currentTimeMillis();

            update();
            draw();

            // Calculate the fps this frame to time animations and movement
            timeThisFrame = System.currentTimeMillis() - startFrameTime;
            if (timeThisFrame >= 1) {
                fps = 1000 / timeThisFrame;
            }
        }
    }

    private void draw() {
        if (ourHolder.getSurface().isValid()) {
            canvas = ourHolder.lockCanvas();
            paint.setColor(Color.argb(255, 0, 0, 255));
            canvas.drawColor(Color.argb(255, 0, 0, 255));

            // New drawing code here

            ourHolder.unlockCanvasAndPost(canvas);
        }
    }

    public void pause() {
        running = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            Log.e("error", "failed to pause thread");
        }
    }

    public void resume() {
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }
}
