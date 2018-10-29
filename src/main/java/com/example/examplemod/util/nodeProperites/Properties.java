package com.example.examplemod.util.nodeProperites;

import java.util.Random;

public class Properties {

    private Random random = new Random();
    private float fel = random.nextFloat() * (random.nextInt(90) + 10);
    private float leyGreed;
    private boolean corruption;
    private float capacity = random.nextFloat() * (random.nextInt(10000) + 200);

    public boolean isCorrupted() {
        if (getFel() > 77) {
            corruption = true;
        }
        return corruption;
    }

    public void drain(float temp) {
        setCapacity(getCapacity() - temp);
        if (capacity <= 100) {
            setFel(temp * 2);
        }
    }

    public void purify(float temp) {
        setFel(getFel() - temp);
    }









    public void setFel(float fel) {
        this.fel = fel;
    }

    public void setLeyGreed(float leyGreed) {
        this.leyGreed = leyGreed;
    }

    public float getFel() {
        return fel;
    }

    public float getLeyGreed() {
        return leyGreed;
    }

    public float getCapacity() {
        return capacity;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }
}
