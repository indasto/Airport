package com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.plane;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.exception.LackOfFuelException;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.exception.MaxFuelException;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.human.worker.Pilot;
import com.java.automation.lab.fall.grinecivh.core22.domain.interfaces.Fly;
import com.java.automation.lab.fall.grinecivh.core22.domain.interfaces.Refuel;

import java.util.*;


public abstract class AbstractPlane implements Fly, Refuel {

    private String model;
    private double currentFuel;
    private double maxFuel;
    private double priceOfAPlane;
    private double fuelConsumptionPerKm;
    private int yearOfCommission;
    private Pilot pilot;
    private boolean inFlight = false;

    public AbstractPlane(String model, double currentFuel, double maxFuel, double priceOfAPlane, int yearOfCommission,
                         double fuelConsumptionPerKm, Pilot pilot)  {

        int currentYear = getCurrentYear();

        if (maxFuel <=1000){
            throw new MaxFuelException();
        } else {
            this.maxFuel = maxFuel;
        }
        this.model = model;
        this.currentFuel = currentFuel;
        this.priceOfAPlane = priceOfAPlane;
        this.yearOfCommission = yearOfCommission;
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
        this.pilot = pilot;
    }

    private int getCurrentYear() {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
        calendar.setTime(new java.util.Date());
        return calendar.get(java.util.Calendar.YEAR);
    }

    public void fuelUp(double amountOfLiters) {

        if ((amountOfLiters + currentFuel) <= maxFuel) {
            currentFuel = maxFuel;
            System.out.println("Fueling plane... Plane was fueled to max. It took only "
                    + (maxFuel - amountOfLiters) + " liters.");
        } else {
            currentFuel += amountOfLiters;
            System.out.println("Fueling plane... Current fuel: " + currentFuel);
        }
    }

    public void fly(double distanceKm) throws LackOfFuelException {

        if (distanceKm <= 0) {
            System.out.println("Distance can't be 0 and less");
        }

        if ((distanceKm * fuelConsumptionPerKm) > currentFuel) {
            throw new LackOfFuelException();
        } else {
            currentFuel -= distanceKm * fuelConsumptionPerKm;

        }

    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getCurrentFuel() {
        return currentFuel;
    }

    public void setCurrentFuel(double currentFuel) {
        this.currentFuel = currentFuel;
    }

    public double getMaxFuel() {
        return maxFuel;
    }

    public void setMaxFuel(double maxFuel) {
        this.maxFuel = maxFuel;
    }

    public double getPriceOfAPlane() {
        return priceOfAPlane;
    }

    public void setPriceOfAPlane(double priceOfAPlane) {
        this.priceOfAPlane = priceOfAPlane;
    }

    public double getFuelConsumptionPerKm() {
        return fuelConsumptionPerKm;
    }

    public void setFuelConsumptionPerKm(double fuelConsumptionPerKm) {
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
    }

    public int getYearOfCommission() {
        return yearOfCommission;
    }

    public void setYearOfCommission(int yearOfCommission) {
        this.yearOfCommission = yearOfCommission;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public boolean isInFlight() {
        return inFlight;
    }

    public void setInFlight(boolean inFlight) {
        this.inFlight = inFlight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractPlane that = (AbstractPlane) o;

        if (Double.compare(that.currentFuel, currentFuel) != 0) return false;
        if (Double.compare(that.maxFuel, maxFuel) != 0) return false;
        if (Double.compare(that.priceOfAPlane, priceOfAPlane) != 0) return false;
        if (Double.compare(that.fuelConsumptionPerKm, fuelConsumptionPerKm) != 0) return false;
        if (yearOfCommission != that.yearOfCommission) return false;
        if (inFlight != that.inFlight) return false;
        if (model != null ? !model.equals(that.model) : that.model != null) return false;
        return pilot != null ? pilot.equals(that.pilot) : that.pilot == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = model != null ? model.hashCode() : 0;
        temp = Double.doubleToLongBits(currentFuel);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(maxFuel);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(priceOfAPlane);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(fuelConsumptionPerKm);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + yearOfCommission;
        result = 31 * result + (pilot != null ? pilot.hashCode() : 0);
        result = 31 * result + (inFlight ? 1 : 0);
        return result;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AbstractPlane{");
        sb.append("model='").append(model).append('\'');
        sb.append(", currentFuel=").append(currentFuel);
        sb.append(", maxFuel=").append(maxFuel);
        sb.append(", priceOfAPlane=").append(priceOfAPlane);
        sb.append(", fuelConsumptionPerKm=").append(fuelConsumptionPerKm);
        sb.append(", yearOfCommission=").append(yearOfCommission);
        sb.append(", pilot=").append(pilot);
        sb.append(", inFlight=").append(inFlight);
        sb.append('}');
        return sb.toString();
    }
}
