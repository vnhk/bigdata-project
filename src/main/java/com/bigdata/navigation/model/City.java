package com.bigdata.navigation.model;

import java.util.Random;

public enum City {
    WARSZAWA, LODZ, KIELCE, RZESZOW, TUMLIN, GDANSK, BIALYSTOK, TORUN;

    public static City getRandomStartCity() {
        Random random = new Random();

        int length = City.values().length;
        int randomIndex = random.nextInt(length);

        return City.values()[randomIndex];
    }

    public static City getRandomEndCity(City startCity) {
        Random random = new Random();
        int length = City.values().length;

        int randomIndex;
        do {
            randomIndex = random.nextInt(length);
        } while (City.values()[randomIndex].equals(startCity));


        return City.values()[randomIndex];
    }
}
