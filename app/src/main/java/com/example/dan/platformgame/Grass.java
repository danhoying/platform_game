package com.example.dan.platformgame;

public class Grass extends GameObject {

    Grass(float worldStartX, float worldStartY, char type) {
        final float HEIGHT = 1;
        final float WIDTH = 1;

        setHeight(HEIGHT);
        setWidth(WIDTH);
        setType(type);
        setBitmapName("turf");
        setWorldLocation(worldStartX, worldStartY, 0);
    }

    public void update(long fps, float gravity) {}
}
