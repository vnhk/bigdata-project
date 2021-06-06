package com.bigdata.navigation.model;

import java.util.Random;

public class MaxSpeed {
    private final static int[] MAX_SPEED = new int[]{30, 50, 70, 90, 100, 120, 140};
    private static Random random = new Random();
    private int maxSpeed;

    private MaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public static MaxSpeed getMaxSpeed() {
        return new MaxSpeed(MAX_SPEED[random.nextInt(MAX_SPEED.length)]);
    }

    public void updateMaxSpeed() {
        maxSpeed = MAX_SPEED[random.nextInt(MAX_SPEED.length)];
    }

    public int value() {
        return maxSpeed;
    }
}
