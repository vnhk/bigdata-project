package com.bigdata.navigation.model;

public final class NavigationDataBuilder {
    private Long measurementNumber;
    private Long id;
    private City start;
    private City end;
    private Distance distance;
    private Time time;
    private ActualKilometers actualKilometers;
    private ActualSpeed actualSpeed;
    private MaxSpeed maxSpeed;

    private NavigationDataBuilder() {
    }

    public static NavigationDataBuilder aNavigationData() {
        return new NavigationDataBuilder();
    }

    public NavigationDataBuilder withMeasurementNumber(Long measurementNumber) {
        this.measurementNumber = measurementNumber;
        return this;
    }

    public NavigationDataBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public NavigationDataBuilder withStart(City start) {
        this.start = start;
        return this;
    }

    public NavigationDataBuilder withEnd(City end) {
        this.end = end;
        return this;
    }

    public NavigationDataBuilder withDistance(Distance distance) {
        this.distance = distance;
        return this;
    }

    public NavigationDataBuilder withTime(Time time) {
        this.time = time;
        return this;
    }

    public NavigationDataBuilder withActualKilometers(ActualKilometers actualKilometers) {
        this.actualKilometers = actualKilometers;
        return this;
    }

    public NavigationDataBuilder withActualSpeed(ActualSpeed actualSpeed) {
        this.actualSpeed = actualSpeed;
        return this;
    }

    public NavigationDataBuilder withMaxSpeed(MaxSpeed maxSpeed) {
        this.maxSpeed = maxSpeed;
        return this;
    }

    public NavigationData build() {
        return new NavigationData(id, start, end, distance, time, actualKilometers, actualSpeed, maxSpeed, measurementNumber);
    }
}
