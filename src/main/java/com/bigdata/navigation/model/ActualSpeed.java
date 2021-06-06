package com.bigdata.navigation.model;

import java.util.Random;

public class ActualSpeed {
    private static Random random = new Random();
    private static int MAX_SPEED = 150;
    private int speed;

    private ActualSpeed(int speed) {
        this.speed = speed;
    }

    public static ActualSpeed getSpeed() {

        return new ActualSpeed(random.nextInt(MAX_SPEED));
    }

    public void updateSpeed() {
        speed = random.nextInt(MAX_SPEED);
    }

    public int value() {
        return speed;
    }
}
