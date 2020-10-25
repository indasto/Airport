package com.java.automation.lab.fall.grinecivh.core22.domain.classes.planes;

public class MediumDistancePlane extends AbstractPassengerPlane {


    public MediumDistancePlane(double currentFuel, double maxFuel, double priceOfAPlane, int yearOfCommissioning,
                               double fuelConsumptionPerKm, String name, int maxFlightDistanceKm,
                               int totalFirstClassSits, int totalBusinessClassSits, int totalEconomClassSits) throws RuntimeException {

        super(currentFuel, maxFuel, priceOfAPlane, yearOfCommissioning, fuelConsumptionPerKm, name, totalFirstClassSits,
                totalBusinessClassSits, totalEconomClassSits);

        if (maxFlightDistanceKm >2500 && maxFlightDistanceKm <= 5000) {
            super.maxFlightDistanceKm = maxFlightDistanceKm;
        } else {
            System.out.println("It is not a medium distance plane");
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

