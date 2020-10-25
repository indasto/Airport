package com.java.automation.lab.fall.grinecivh.core22.domain.classes.planes;


public class ShortDistancePlane extends AbstractPassengerPlane {

    public ShortDistancePlane(double currentFuel, double maxFuel, double priceOfAPlane, int yearOfCommissioning,
                              double fuelConsumptionPerKm, String name, int maxFlightDistanceKm,
                              int totalFirstClassSits, int totalBusinessClassSits, int totalEconomClassSits) throws RuntimeException {

        super(currentFuel, maxFuel, priceOfAPlane, yearOfCommissioning, fuelConsumptionPerKm, name, totalFirstClassSits,
                totalBusinessClassSits, totalEconomClassSits);

        if (maxFlightDistanceKm >50 && maxFlightDistanceKm <= 2500) {
            super.maxFlightDistanceKm = maxFlightDistanceKm;
        } else {
            System.out.println("It is not a short distance plane");
            throw new RuntimeException();
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
