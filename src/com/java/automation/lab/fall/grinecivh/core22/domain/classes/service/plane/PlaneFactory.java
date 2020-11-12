package com.java.automation.lab.fall.grinecivh.core22.domain.classes.service.plane;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.plane.AbstractPassengerPlane;

public class PlaneFactory {

    public static <T extends AbstractPassengerPlane> T createPassengerPlane(double currentFuel, double maxFuel, double priceOfAPlane, int yearOfCommissioning,
                                                                            double fuelConsumptionPerKm, String name, int totalFirstClassSits,
                                                                            int totalBusinessClassSits, int totalEconomClassSits,
                                                                            int maxFlightDistanceKm)
    {
        T plane = (T) new AbstractPassengerPlane(currentFuel, maxFuel, priceOfAPlane, yearOfCommissioning, fuelConsumptionPerKm,
                name, totalFirstClassSits, totalBusinessClassSits, totalEconomClassSits, maxFlightDistanceKm);

        return plane;
    }
}


