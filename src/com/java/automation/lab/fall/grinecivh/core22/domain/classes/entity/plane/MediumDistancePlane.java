package com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.plane;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.exception.LackOfFuelException;

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
    public void fly(double distanceKm) {
        try {
            System.out.println("Medium distance plane " + this.getName() +" fly");
            super.fly(distanceKm);
        } catch (LackOfFuelException ex){
            ex.printStackTrace();
        }
    }
}

