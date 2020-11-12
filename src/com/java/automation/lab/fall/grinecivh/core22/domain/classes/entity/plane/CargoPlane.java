package com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.plane;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.Exception.LackOfFuelException;

import java.util.Objects;

public class CargoPlane extends AbstractPlane {

    private double capacityTons;

    public CargoPlane(double currentFuel, double maxFuel, double priceOfAPlane, int yearOfCommissioning,
                      double fuelConsumptionPerKm, String name, double capacityTons) throws RuntimeException {

        super(currentFuel, maxFuel, priceOfAPlane, yearOfCommissioning, fuelConsumptionPerKm, name);

        if (capacityTons <= 0) {
            throw new RuntimeException();
        }

        this.capacityTons = capacityTons;
    }

    public double getCapacityTons() {
        return capacityTons;
    }

    public void setCapacityTons(double capacityTons) {
        this.capacityTons = capacityTons;
    }


    @Override
    public String toString() {
        return  super.toString() +
                "Capacity (tons): " + capacityTons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CargoPlane that = (CargoPlane) o;
        return Double.compare(that.capacityTons, capacityTons) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), capacityTons);
    }

    @Override
    public void fly(double distanceKm) {

        try {
            System.out.println("Cargo " + this.getName() +" fly");
            super.fly(distanceKm);
        } catch (LackOfFuelException ex){
            ex.printStackTrace();
        }

    }
}
