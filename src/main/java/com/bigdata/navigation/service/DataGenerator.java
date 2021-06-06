package com.bigdata.navigation.service;

import com.bigdata.navigation.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class DataGenerator {
    private final int SECONDS_BETWEEN_MEASUREMENTS = 60;
    private Random random;
    private List<NavigationData> navigationDataList;

    public DataGenerator() {
        navigationDataList = new ArrayList<>();

        random = new Random();
    }

    public NavigationData generateStartData() {
        City randomStartCity = City.getRandomStartCity();
        City randomEndCity = City.getRandomEndCity(randomStartCity);
        NavigationData data = NavigationDataBuilder
                .aNavigationData()
                .withId(getUniqueId())
                .withStart(randomStartCity)
                .withEnd(randomEndCity)
                .withDistance(Distance.getDistance(randomStartCity, randomEndCity))
                .withTime(Time.getStartTime())
                .withActualKilometers(new ActualKilometers())
                .withActualSpeed(ActualSpeed.getSpeed())
                .withMaxSpeed(MaxSpeed.getMaxSpeed())
                .withMeasurementNumber(1L)
                .build();

        navigationDataList.add(data);

        return data;
    }

    public List<JsonNavigationData> generateCarTripMessages(NavigationData navigationData) {
        List<JsonNavigationData> result = new LinkedList<>();
        Time startTime = navigationData.getTime();
        Distance distance = navigationData.getDistance();
        ActualSpeed actualSpeed = navigationData.getActualSpeed();
        ActualKilometers actualKilometers = navigationData.getActualKilometers();
        MaxSpeed maxSpeed = navigationData.getMaxSpeed();

        int randomAverageSpeed = random.nextInt(60) + 45;

        double averageTimeInSeconds = ((double) distance.getKilometers() / (double) randomAverageSpeed) * 3600;
        long measurements = Math.round(averageTimeInSeconds / (SECONDS_BETWEEN_MEASUREMENTS * 1.0));

        long index = 0;

        double averageKilometersChange = ((double) distance.getKilometers()) / (double) measurements;

        while (index < measurements) {
            navigationData.setMeasurementNumber(index);
            startTime.plusSeconds(SECONDS_BETWEEN_MEASUREMENTS);
            actualSpeed.updateSpeed();
            maxSpeed.updateMaxSpeed();
            actualKilometers.appendKilometers(averageKilometersChange);

            result.add(createJsonData(navigationData));
            index++;
        }

        return result;
    }

    private JsonNavigationData createJsonData(NavigationData navigationData) {
        return new JsonNavigationData(navigationData);
    }

    private Long getUniqueId() {
        List<Long> ids = getIds();

        long randomId;

        do {
            randomId = random.nextLong();
        } while (ids.contains(randomId) || randomId < 0);

        return randomId;
    }

    private List<Long> getIds() {
        return navigationDataList
                .stream()
                .map(NavigationData::getId)
                .collect(Collectors.toList());
    }
}
