package com.bigdata.navigation.model;

import java.security.InvalidParameterException;

public class Distance {
    private final int kilometers;

    private Distance(int kilometers) {
        this.kilometers = kilometers;
    }

    public static Distance getDistanceTest() {
        return new Distance(20);
    }

    public static Distance getDistance(City city1, City city2) {
        if (isBetween(City.LODZ, City.KIELCE, city1, city2)) {
            return new Distance(152);
        }

        if (isBetween(City.LODZ, City.WARSZAWA, city1, city2)) {
            return new Distance(140);
        }

        if (isBetween(City.LODZ, City.RZESZOW, city1, city2)) {
            return new Distance(304);
        }

        if (isBetween(City.LODZ, City.BIALYSTOK, city1, city2)) {
            return new Distance(327);
        }

        if (isBetween(City.LODZ, City.GDANSK, city1, city2)) {
            return new Distance(340);
        }

        if (isBetween(City.LODZ, City.TUMLIN, city1, city2)) {
            return new Distance(135);
        }

        if (isBetween(City.LODZ, City.TORUN, city1, city2)) {
            return new Distance(183);
        }
        //kielce

        if (isBetween(City.KIELCE, City.WARSZAWA, city1, city2)) {
            return new Distance(177);
        }

        if (isBetween(City.KIELCE, City.RZESZOW, city1, city2)) {
            return new Distance(155);
        }

        if (isBetween(City.KIELCE, City.BIALYSTOK, city1, city2)) {
            return new Distance(372);
        }

        if (isBetween(City.KIELCE, City.GDANSK, city1, city2)) {
            return new Distance(468);
        }

        if (isBetween(City.KIELCE, City.TUMLIN, city1, city2)) {
            return new Distance(15);
        }

        if (isBetween(City.KIELCE, City.TORUN, city1, city2)) {
            return new Distance(310);
        }

        //warszawa

        if (isBetween(City.WARSZAWA, City.RZESZOW, city1, city2)) {
            return new Distance(317);
        }

        if (isBetween(City.WARSZAWA, City.BIALYSTOK, city1, city2)) {
            return new Distance(200);
        }

        if (isBetween(City.WARSZAWA, City.GDANSK, city1, city2)) {
            return new Distance(416);
        }

        if (isBetween(City.WARSZAWA, City.TUMLIN, city1, city2)) {
            return new Distance(174);
        }

        if (isBetween(City.WARSZAWA, City.TORUN, city1, city2)) {
            return new Distance(259);
        }

        //rzeszow

        if (isBetween(City.RZESZOW, City.BIALYSTOK, city1, city2)) {
            return new Distance(493);
        }

        if (isBetween(City.RZESZOW, City.GDANSK, city1, city2)) {
            return new Distance(416);
        }

        if (isBetween(City.RZESZOW, City.TUMLIN, city1, city2)) {
            return new Distance(172);
        }

        if (isBetween(City.RZESZOW, City.TORUN, city1, city2)) {
            return new Distance(467);
        }

        //bialystok

        if (isBetween(City.BIALYSTOK, City.GDANSK, city1, city2)) {
            return new Distance(422);
        }

        if (isBetween(City.BIALYSTOK, City.TUMLIN, city1, city2)) {
            return new Distance(368);
        }

        if (isBetween(City.BIALYSTOK, City.TORUN, city1, city2)) {
            return new Distance(447);
        }

        //GDANSK

        if (isBetween(City.GDANSK, City.TUMLIN, city1, city2)) {
            return new Distance(457);
        }

        if (isBetween(City.GDANSK, City.TORUN, city1, city2)) {
            return new Distance(170);
        }

        //TUMLIN
        if (isBetween(City.TUMLIN, City.TORUN, city1, city2)) {
            return new Distance(298);
        }


        throw new InvalidParameterException();
    }

    private static boolean isBetween(City start, City end, City city1, City city2) {
        return start.equals(city1) && end.equals(city2) || start.equals(city2) && end.equals(city1);
    }

    public int getKilometers() {
        return kilometers;
    }
}
