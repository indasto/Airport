package com.java.automation.lab.fall.grinecivh.core22.domain.classes.planes;

public class PlaneFactory {

    public static AbstractPlane createPassengerPlane(double currentFuel, double maxFuel, double priceOfAPlane, int yearOfCommissioning,
                                                     double fuelConsumptionPerKm, String name, int totalFirstClassSits,
                                                     int totalBusinessClassSits, int totalEconomClassSits,
                                                     int maxFlightDistanceKm) {

        AbstractPassengerPlane plane = null;

        if (totalBusinessClassSits == 0 && totalEconomClassSits == 0) {
            plane = new PrivatePlane(currentFuel, maxFuel, priceOfAPlane, yearOfCommissioning, fuelConsumptionPerKm,
                    name, totalFirstClassSits, maxFlightDistanceKm);
        } else if (maxFlightDistanceKm > 50 && maxFlightDistanceKm <= 2500) {
            plane = new ShortDistancePlane(currentFuel, maxFuel, priceOfAPlane, yearOfCommissioning, fuelConsumptionPerKm,
                    name, totalFirstClassSits, totalBusinessClassSits, totalEconomClassSits, maxFlightDistanceKm);
        } else if (maxFlightDistanceKm <= 5000) {
            plane = new MediumDistancePlane(currentFuel, maxFuel, priceOfAPlane, yearOfCommissioning, fuelConsumptionPerKm,
                    name, totalFirstClassSits, totalBusinessClassSits, totalEconomClassSits, maxFlightDistanceKm);
        } else if (maxFlightDistanceKm <= 15000){
            plane = new LongDistancePlane(currentFuel, maxFuel, priceOfAPlane, yearOfCommissioning, fuelConsumptionPerKm,
                    name, totalFirstClassSits, totalBusinessClassSits, totalEconomClassSits, maxFlightDistanceKm);
        }


        return plane;
    }
}


