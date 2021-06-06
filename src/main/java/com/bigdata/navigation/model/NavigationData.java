package com.bigdata.navigation.model;


public class NavigationData {
    private final Long id;
    private final City start;
    private final City end;
    private final Distance distance;
    private final Time time;
    private final ActualKilometers actualKilometers;
    private final ActualSpeed actualSpeed;
    private final MaxSpeed maxSpeed;
    private Long measurementNumber;

    public NavigationData(Long id, City start, City end, Distance distance, Time time, ActualKilometers actualKilometers, ActualSpeed actualSpeed, MaxSpeed maxSpeed, Long measurementNumber) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.distance = distance;
        this.time = time;
        this.actualKilometers = actualKilometers;
        this.actualSpeed = actualSpeed;
        this.maxSpeed = maxSpeed;
        this.measurementNumber = measurementNumber;
    }

    public Long getId() {
        return id;
    }

    public City getStart() {
        return start;
    }

    public City getEnd() {
        return end;
    }

    public Distance getDistance() {
        return distance;
    }

    public Time getTime() {
        return time;
    }

    public ActualKilometers getActualKilometers() {
        return actualKilometers;
    }

    public ActualSpeed getActualSpeed() {
        return actualSpeed;
    }

    public MaxSpeed getMaxSpeed() {
        return maxSpeed;
    }

    public Long getMeasurementNumber() {
        return measurementNumber;
    }

    public void setMeasurementNumber(Long measurementNumber) {
        this.measurementNumber = measurementNumber;
    }


}
