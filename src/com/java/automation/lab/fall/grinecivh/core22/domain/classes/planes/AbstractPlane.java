package com.java.automation.lab.fall.grinecivh.core22.domain.classes.planes;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.Exception.LackOfFuelException;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.Exception.MaxFuelException;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.humans.Pilot;
import com.java.automation.lab.fall.grinecivh.core22.domain.interfaces.Fly;
import com.java.automation.lab.fall.grinecivh.core22.domain.interfaces.Refuel;

import java.util.*;


public abstract class AbstractPlane implements Fly, Refuel {

    private double currentFuel;
    private double maxFuel;
    private double priceOfAPlane;
    private double fuelConsumptionPerKm;
    private int yearOfCommissioning;
    private String name;
    private List<Pilot> pilots;
    private boolean inFlight = false;

    public AbstractPlane(double currentFuel, double maxFuel, double priceOfAPlane, int yearOfCommissioning,
                         double fuelConsumptionPerKm, String name) throws MaxFuelException {

        int currentYear = getCurrentYear();

        if (maxFuel <=1000){
            throw new MaxFuelException();
        } else {
            this.maxFuel = maxFuel;
        }

        this.currentFuel = currentFuel;
        this.priceOfAPlane = priceOfAPlane;
        this.yearOfCommissioning = yearOfCommissioning;
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
        this.name = name;
    }

    public void addPilot(Pilot pilot){
        pilots.add(pilot);
    }

    public void removePilot(int index){
        if (index<pilots.size()){
            pilots.remove(index);
        } else {
            System.out.println("There is no such pilot");
        }
    }

    public void printPilots(){
        for (int i = 0; i < pilots.size(); i++) {
            System.out.println("Index: "+ i);
            pilots.get(i).toString();
        }
    }

    private int getCurrentYear() {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
        calendar.setTime(new java.util.Date());
        return calendar.get(java.util.Calendar.YEAR);
    }

    public void fuelUp(double amountOfLiters) throws RuntimeException {
        if (amountOfLiters <= 0) {
            throw new RuntimeException();
        }

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

    public double getCurrentFuel() {
        return currentFuel;
    }

    public List<Pilot> getPilots() {
        return pilots;
    }

    public double getFuelConsumptionPerKm() {
        return fuelConsumptionPerKm;
    }

    public double getMaxFuel() {
        return maxFuel;
    }

    public double getPriceOfAPlane() {
        return priceOfAPlane;
    }

    public int getYearOfCommissioning() {
        return yearOfCommissioning;
    }

    public String getName() {
        return name;
    }

    public void setCurrentFuel(double currentFuel) {
        this.currentFuel = currentFuel;
    }

    public void setFuelConsumptionPerKm(double fuelConsumptionPerKm) {
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
    }

    public void setMaxFuel(double maxFuel) {
        this.maxFuel = maxFuel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPilots(ArrayList<Pilot> pilots) {
        this.pilots = pilots;
    }

    public void setPriceOfAPlane(double priceOfAPlane) {
        this.priceOfAPlane = priceOfAPlane;
    }

    public void setYearOfCommissioning(int yearOfCommissioning) {
        this.yearOfCommissioning = yearOfCommissioning;
    }

    public void setInFlight(boolean inFlight) {
        this.inFlight = inFlight;
    }

    public boolean isInFlight() {
        return inFlight;
    }


    @Override
    public String toString() {
        return  "Current Fuel: " + currentFuel +
                ", MaxFuel: " + maxFuel +
                ", Price Of a Plane: " + priceOfAPlane +
                ", Fuel Consumption per km: " + fuelConsumptionPerKm +
                ", Year of Commission: " + yearOfCommissioning +
                ", Name: " + name +
                ", Pilots: " + pilots +
                ", Currently in flight: " + inFlight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractPlane that = (AbstractPlane) o;
        return Double.compare(that.currentFuel, currentFuel) == 0 &&
                Double.compare(that.maxFuel, maxFuel) == 0 &&
                Double.compare(that.priceOfAPlane, priceOfAPlane) == 0 &&
                Double.compare(that.fuelConsumptionPerKm, fuelConsumptionPerKm) == 0 &&
                yearOfCommissioning == that.yearOfCommissioning &&
                inFlight == that.inFlight &&
                Objects.equals(name, that.name) &&
                Objects.equals(pilots, that.pilots);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentFuel, maxFuel, priceOfAPlane, fuelConsumptionPerKm,
                yearOfCommissioning, name, pilots, inFlight);
    }
}
