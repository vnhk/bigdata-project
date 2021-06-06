package com.bigdata.navigation.model;

import java.time.LocalDateTime;
import java.util.Random;

public class Time {
    private static Random random = new Random();

    public LocalDateTime getTime() {
        return time;
    }

    private LocalDateTime time;

    private Time(LocalDateTime time) {
        this.time = time;
    }

    public static Time getStartTime() {
        int dayOfMonth = random.nextInt(29) + 1;
        int month = random.nextInt(12) + 1;

        if (month == 2) {
            month = 3;
        }

        int year = 2020;

        int hour = random.nextInt(24);
        int minutes = random.nextInt(60);
        int seconds = random.nextInt(60);

        return new Time(LocalDateTime.of(year, month, dayOfMonth, hour, minutes, seconds));
    }

    public void plusSeconds(long seconds) {
        time = time.plusSeconds(seconds);
    }
}
