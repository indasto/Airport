package com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.plane;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.human.worker.Pilot;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.exception.MaxDistanceException;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.human.worker.Steward;

import java.util.ArrayList;
import java.util.List;


public class AbstractPassengerPlane extends AbstractPlane {

    private List<Steward> stewards;
    protected int maxFlightDistanceKm;
    private transient int totalFirstClassSits;
    private transient int totalBusinessClassSits;
    private transient int totalEconomClassSits;
    private transient int bookedFirstClassSits = 0;
    private transient int bookedBusinessClassSits = 0;
    private transient int bookedEconomClassSits = 0;


    public AbstractPassengerPlane(String model, double currentFuel, double maxFuel, double priceOfAPlane,
                                  int yearOfCommissioning, double fuelConsumptionPerKm, int totalFirstClassSits,
                                  int totalBusinessClassSits, int totalEconomClassSits, int maxFlightDistanceKm,
                                  Pilot pilot) {

        super(model, currentFuel, maxFuel, priceOfAPlane, yearOfCommissioning, fuelConsumptionPerKm, pilot);

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

    public String bookEconomSit() {
        if (bookedEconomClassSits <= totalEconomClassSits) {
            bookedEconomClassSits++;
        } else {
            System.out.println("No econom sits left");
        }

        return bookedEconomClassSits + "";
    }

    public String bookEconomSit(int howMany) {
        if (bookedEconomClassSits + howMany <= totalEconomClassSits) {
            bookedEconomClassSits += howMany;
        } else {
            System.out.println("No econom sits left");
        }
        return bookedEconomClassSits + "";
    }

    public String bookBusinessSit() {
        if (bookedBusinessClassSits <= totalBusinessClassSits) {
            bookedBusinessClassSits++;
        } else {
            System.out.println("No business sits left");
        }

        return bookedBusinessClassSits + "";
    }

    public String bookBusinessSit(int howMany) {
        if (bookedBusinessClassSits + howMany <= totalBusinessClassSits) {
            bookedBusinessClassSits += howMany;
        } else {
            System.out.println("No business sits left");
        }
        return bookedBusinessClassSits + "";
    }

    public String bookFirstClassSit() {
        if (bookedFirstClassSits <= totalFirstClassSits) {
            bookedEconomClassSits++;
        } else {
            System.out.println("No first class sits left");
        }
        return bookedFirstClassSits + "";
    }

    public String bookFirstClassSit(int howMany) {
        if (bookedFirstClassSits + howMany <= totalFirstClassSits) {
            bookedEconomClassSits += howMany;
        } else {
            System.out.println("No first class sits left");
        }
        return bookedFirstClassSits + "";
    }

    public List<Steward> getStewards() {
        return stewards;
    }

    public void setStewards(List<Steward> stewards) {
        this.stewards = stewards;
    }

    public int getMaxFlightDistanceKm() {
        return maxFlightDistanceKm;
    }

    public void setMaxFlightDistanceKm(int maxFlightDistanceKm) {
        this.maxFlightDistanceKm = maxFlightDistanceKm;
    }

    public int getTotalFirstClassSits() {
        return totalFirstClassSits;
    }

    public void setTotalFirstClassSits(int totalFirstClassSits) {
        this.totalFirstClassSits = totalFirstClassSits;
    }

    public int getTotalBusinessClassSits() {
        return totalBusinessClassSits;
    }

    public void setTotalBusinessClassSits(int totalBusinessClassSits) {
        this.totalBusinessClassSits = totalBusinessClassSits;
    }

    public int getTotalEconomClassSits() {
        return totalEconomClassSits;
    }

    public void setTotalEconomClassSits(int totalEconomClassSits) {
        this.totalEconomClassSits = totalEconomClassSits;
    }

    public int getBookedFirstClassSits() {
        return bookedFirstClassSits;
    }

    public void setBookedFirstClassSits(int bookedFirstClassSits) {
        this.bookedFirstClassSits = bookedFirstClassSits;
    }

    public int getBookedBusinessClassSits() {
        return bookedBusinessClassSits;
    }

    public void setBookedBusinessClassSits(int bookedBusinessClassSits) {
        this.bookedBusinessClassSits = bookedBusinessClassSits;
    }

    public int getBookedEconomClassSits() {
        return bookedEconomClassSits;
    }

    public void setBookedEconomClassSits(int bookedEconomClassSits) {
        this.bookedEconomClassSits = bookedEconomClassSits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        AbstractPassengerPlane that = (AbstractPassengerPlane) o;

        if (maxFlightDistanceKm != that.maxFlightDistanceKm) return false;
        if (totalFirstClassSits != that.totalFirstClassSits) return false;
        if (totalBusinessClassSits != that.totalBusinessClassSits) return false;
        if (totalEconomClassSits != that.totalEconomClassSits) return false;
        if (bookedFirstClassSits != that.bookedFirstClassSits) return false;
        if (bookedBusinessClassSits != that.bookedBusinessClassSits) return false;
        if (bookedEconomClassSits != that.bookedEconomClassSits) return false;
        return stewards != null ? stewards.equals(that.stewards) : that.stewards == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (stewards != null ? stewards.hashCode() : 0);
        result = 31 * result + maxFlightDistanceKm;
        result = 31 * result + totalFirstClassSits;
        result = 31 * result + totalBusinessClassSits;
        result = 31 * result + totalEconomClassSits;
        result = 31 * result + bookedFirstClassSits;
        result = 31 * result + bookedBusinessClassSits;
        result = 31 * result + bookedEconomClassSits;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AbstractPassengerPlane{");
        sb.append("stewards=").append(stewards);
        sb.append(", maxFlightDistanceKm=").append(maxFlightDistanceKm);
        sb.append(", totalFirstClassSits=").append(totalFirstClassSits);
        sb.append(", totalBusinessClassSits=").append(totalBusinessClassSits);
        sb.append(", totalEconomClassSits=").append(totalEconomClassSits);
        sb.append(", bookedFirstClassSits=").append(bookedFirstClassSits);
        sb.append(", bookedBusinessClassSits=").append(bookedBusinessClassSits);
        sb.append(", bookedEconomClassSits=").append(bookedEconomClassSits);
        sb.append('}');
        return sb.toString();
    }
}
