package com.example.dan.platformgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;

import java.util.ArrayList;

public class LevelManager {
    private String level;
    private boolean playing;
    int mapWidth;
    int mapHeight;
    int playerIndex;
    float gravity;

    Player player;
    LevelData levelData;
    ArrayList<GameObject> gameObjects;
    ArrayList<Rect> currentButtons;
    Bitmap[] bitmapsArray;

    public LevelManager(Context context, int pixelsPerMetre, int screenWidth, InputController ic,
                        String level, float px, float py) {
        this.level = level;

        switch (level) {
            case "LevelCave":
                levelData = new LevelCave();
                break;
            // Add more levels here
        }
        gameObjects = new ArrayList<>();

        // To hold 1 of every bitmap
        bitmapsArray = new Bitmap[25];

        // Load all the GameObjects and Bitmaps
        loadMapData(context, pixelsPerMetre, px, py);
        playing = true;
    }

    public boolean isPlaying() {
        return playing;
    }
}
