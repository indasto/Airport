package com.java.automation.lab.fall.grinecivh.core22.domain.classes.planes;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.Exception.MaxDistanceException;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.humans.Steward;
import com.java.automation.lab.fall.grinecivh.core22.domain.interfaces.Fly;
import com.java.automation.lab.fall.grinecivh.core22.domain.interfaces.Refuel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractPassengerPlane extends AbstractPlane {

    private List<Steward> stewards;
    protected int maxFlightDistanceKm;
    private int totalFirstClassSits;
    private int totalBusinessClassSits;
    private int totalEconomClassSits;
    private int bookedFirstClassSits = 0;
    private int bookedBusinessClassSits = 0;
    private int bookedEconomClassSits = 0;


    public AbstractPassengerPlane(double currentFuel, double maxFuel, double priceOfAPlane, int yearOfCommissioning,
                                  double fuelConsumptionPerKm, String name, int totalFirstClassSits,
                                  int totalBusinessClassSits, int totalEconomClassSits, int maxFlightDistanceKm) throws MaxDistanceException {

        super(currentFuel, maxFuel, priceOfAPlane, yearOfCommissioning, fuelConsumptionPerKm, name);

        if (maxFlightDistanceKm<50){
            throw new MaxDistanceException();
        }

        this.totalBusinessClassSits = totalBusinessClassSits;
        this.totalEconomClassSits = totalEconomClassSits;
        this.totalFirstClassSits = totalFirstClassSits;
        this.maxFlightDistanceKm = maxFlightDistanceKm;
        stewards = new ArrayList<>();
    }

    public void addSteward(Steward steward) {
        stewards.add(steward);
    }

    public void removeSteward(int index) {
        if (index < stewards.size()) {
            stewards.remove(index);
        } else {
            System.out.println("There is no such steward");
        }
    }

    public void printStewards() {
        for (int i = 0; i < stewards.size(); i++) {
            System.out.println("Index: " + i);
            stewards.get(i).toString();
        }
    }

    public int getTotalBusinessClassSits() {
        return totalBusinessClassSits;
    }

    public int getTotalEconomClassSits() {
        return totalEconomClassSits;
    }

    public int getTotalFirstClassSits() {
        return totalFirstClassSits;
    }

    public void setTotalBusinessClassSits(int totalBusinessClassSits) {
        this.totalBusinessClassSits = totalBusinessClassSits;
    }

    public void setTotalEconomClassSits(int totalEconomClassSits) {
        this.totalEconomClassSits = totalEconomClassSits;
    }

    public void setTotalFirstClassSits(int totalFirstClassSits) {
        this.totalFirstClassSits = totalFirstClassSits;
    }

    public void setStewards(ArrayList<Steward> stewards) {
        this.stewards = stewards;
    }

    public List<Steward> getStewards() {
        return stewards;
    }

    public int getMaxFlightDistanceKm() {
        return maxFlightDistanceKm;
    }

    public void setMaxFlightDistanceKm(int maxFlightDistanceKm) {
        this.maxFlightDistanceKm = maxFlightDistanceKm;
    }

    public int getBookedBusinessClassSits() {
        return bookedBusinessClassSits;
    }

    public int getBookedEconomClassSits() {
        return bookedEconomClassSits;
    }

    public int getBookedFirstClassSits() {
        return bookedFirstClassSits;
    }

    public String bookEconomSit() {
        if (bookedEconomClassSits <= totalEconomClassSits) {
            bookedEconomClassSits++;
        } else {
            System.out.println("No econom sits left");
        }

        return bookedEconomClassSits+"";
    }

    public String bookEconomSit(int howMany) {
        if (bookedEconomClassSits + howMany <= totalEconomClassSits) {
            bookedEconomClassSits += howMany;
        } else {
            System.out.println("No econom sits left");
        }
        return bookedEconomClassSits+"";
    }

    public String bookBusinessSit() {
        if (bookedBusinessClassSits <= totalBusinessClassSits) {
            bookedBusinessClassSits++;
        } else {
            System.out.println("No business sits left");
        }

        return bookedBusinessClassSits+"";
    }

    public String bookBusinessSit(int howMany) {
        if (bookedBusinessClassSits + howMany <= totalBusinessClassSits) {
            bookedBusinessClassSits += howMany;
        } else {
            System.out.println("No business sits left");
        }
        return bookedBusinessClassSits+"";
    }

    public String bookFirstClassSit() {
        if (bookedFirstClassSits <= totalFirstClassSits) {
            bookedEconomClassSits++;
        } else {
            System.out.println("No first class sits left");
        }
        return bookedFirstClassSits+"";
    }

    public String bookFirstClassSit(int howMany) {
        if (bookedFirstClassSits + howMany <= totalFirstClassSits) {
            bookedEconomClassSits += howMany;
        } else {
            System.out.println("No first class sits left");
        }
        return bookedFirstClassSits+"";
    }


    @Override
    public String toString() {
        return  super.toString() +
                "Stewards: " + stewards +
                ", Maximum Flight Distance (km): " + maxFlightDistanceKm +
                ", Total First Class Sits: " + totalFirstClassSits +
                ", Total Business Class Sits: " + totalBusinessClassSits +
                ", Total Econom Class Sits: " + totalEconomClassSits +
                ", Booked First Class Sits: " + bookedFirstClassSits +
                ", Booked Business Class Sits: " + bookedBusinessClassSits +
                ", Booked Econom Class Sits: " + bookedEconomClassSits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractPassengerPlane that = (AbstractPassengerPlane) o;
        return maxFlightDistanceKm == that.maxFlightDistanceKm &&
                totalFirstClassSits == that.totalFirstClassSits &&
                totalBusinessClassSits == that.totalBusinessClassSits &&
                totalEconomClassSits == that.totalEconomClassSits &&
                bookedFirstClassSits == that.bookedFirstClassSits &&
                bookedBusinessClassSits == that.bookedBusinessClassSits &&
                bookedEconomClassSits == that.bookedEconomClassSits &&
                Objects.equals(stewards, that.stewards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stewards, maxFlightDistanceKm, totalFirstClassSits, totalBusinessClassSits,
                totalEconomClassSits, bookedFirstClassSits, bookedBusinessClassSits, bookedEconomClassSits);
    }
}
