package com.java.automation.lab.fall.grinecivh.core22.domain.classes.planes;

public class PrivatePlane extends AbstractPassengerPlane {


    public PrivatePlane(double currentFuel, double maxFuel, double priceOfAPlane, int yearOfCommissioning,
                              double fuelConsumptionPerKm, String name, int maxFlightDistanceKm,
                              int totalFirstClassSits) {

        super(currentFuel, maxFuel, priceOfAPlane, yearOfCommissioning, fuelConsumptionPerKm, name, totalFirstClassSits,
                0, 0, maxFlightDistanceKm);
    }

    @Override
    public boolean fly(double distanceKm) {
        System.out.println("Private plane " + this.getName() +" fly");
        return super.fly(distanceKm);
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
