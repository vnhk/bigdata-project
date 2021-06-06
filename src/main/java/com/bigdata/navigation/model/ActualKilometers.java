package com.bigdata.navigation.model;

public class ActualKilometers {
    private double kilometers;

    public ActualKilometers() {
        this.kilometers = 0.0;
    }

    public double getKilometers() {
        return kilometers;
    }

    public void appendKilometers(double kilometers) {
        this.kilometers += kilometers;
    }
}
