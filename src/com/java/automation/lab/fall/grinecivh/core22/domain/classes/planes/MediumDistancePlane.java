package com.java.automation.lab.fall.grinecivh.core22.domain.classes.planes;

public class MediumDistancePlane extends AbstractPassengerPlane {


    public MediumDistancePlane(double currentFuel, double maxFuel, double priceOfAPlane, int yearOfCommissioning,
                               double fuelConsumptionPerKm, String name, int maxFlightDistanceKm,
                               int totalFirstClassSits, int totalBusinessClassSits, int totalEconomClassSits) throws RuntimeException {

        super(currentFuel, maxFuel, priceOfAPlane, yearOfCommissioning, fuelConsumptionPerKm, name, totalFirstClassSits,
                totalBusinessClassSits, totalEconomClassSits, maxFlightDistanceKm);

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

    @Override
    public boolean fly(double distanceKm) {
        System.out.println("Medium distance plane " + this.getName() +" fly");
        return super.fly(distanceKm);
    }
}

