package com.bigdata.navigation.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class JsonNavigationData implements Serializable {
    private final Map<String, Object> measurement = new HashMap<>();

    public JsonNavigationData(NavigationData data) {
        convert(data);
    }

    private void convert(NavigationData data) {
        setId(data.getId());
        setStartCity(data.getStart());
        setEndCity(data.getEnd());
        setTime(data.getTime());
        setActualKilometers(data.getActualKilometers());
        setDistance(data.getDistance());
        setActualSpeed(data.getActualSpeed());
        setMaxSpeed(data.getMaxSpeed());
        setMeasurementNumber(data.getMeasurementNumber());
    }

    private void setMeasurementNumber(Long number) {
        measurement.put("measurementNumber", number);
    }

    private void setMaxSpeed(MaxSpeed maxSpeed) {
        measurement.put("maxSpeed", maxSpeed.value());
    }

    private void setActualSpeed(ActualSpeed actualSpeed) {
        measurement.put("actualSpeed", actualSpeed.value());
    }

    private void setDistance(Distance distance) {
        measurement.put("distance", distance.getKilometers());
    }

    private void setActualKilometers(ActualKilometers actualKilometers) {
        measurement.put("actualKilometers", actualKilometers.getKilometers());
    }

    private void setTime(Time time) {
        Map<String, Object> dataTimeJson = new HashMap<>();
        Map<String, Object> dataJson = new HashMap<>();
        Map<String, Object> timeJson = new HashMap<>();
        dataJson.put("dayOfMonth", time.getTime().getDayOfMonth());
        dataJson.put("dayOfWeek", time.getTime().getDayOfWeek());
        dataJson.put("month", time.getTime().getMonthValue());
        dataJson.put("year", time.getTime().getYear());
        timeJson.put("hours", time.getTime().getHour());
        timeJson.put("minutes", time.getTime().getMinute());
        timeJson.put("seconds", time.getTime().getSecond());

        dataTimeJson.put("data", dataJson);
        dataTimeJson.put("time", timeJson);
        dataTimeJson.put("timestamp", Timestamp.valueOf(time.getTime()));

        measurement.put("dataTime", dataTimeJson);
    }

    private void setStartCity(City start) {
        measurement.put("cityA", start.name());
    }

    private void setEndCity(City end) {
        measurement.put("cityB", end.name());
    }

    public void setId(Long id) {
        measurement.put("navigationId", id);
    }
}
