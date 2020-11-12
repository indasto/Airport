package com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.flight;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.plane.AbstractPassengerPlane;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.plane.AbstractPlane;
import com.java.automation.lab.fall.grinecivh.core22.domain.interfaces.FlightProcess;

import java.time.OffsetDateTime;
import java.util.Objects;

public class FlightArrive implements FlightProcess {

    private String comesFrom;
    private OffsetDateTime dateOfArrive;
    private String arrivalGate;
    private int distance;
    private AbstractPassengerPlane plane;

    public FlightArrive(String comesFrom, OffsetDateTime date, String arrivalGate, int distance) {
        this.comesFrom = comesFrom;
        dateOfArrive = date;
        this.arrivalGate = arrivalGate;
        this.distance = distance;
    }

    @Override
    public void takeoff(int time) {
       timeToProcess(time); //waiting for passengers to board
    }

    @Override
    public void land(int time) {
        timeToProcess(time);
    }

    public void timeToProcess(int time) {}

    public OffsetDateTime getDateOfArrive() {
        return dateOfArrive;
    }

    public int getDistance() {
        return distance;
    }

    public String getArrivalGate() {
        return arrivalGate;
    }

    public String getComesFrom() {
        return comesFrom;
    }

    public void setArrivalGate(String arrivalGate) {
        this.arrivalGate = arrivalGate;
    }

    public void setComesFrom(String comesFrom) {
        this.comesFrom = comesFrom;
    }

    public void setDateOfArrive(OffsetDateTime dateOfArrive) {
        this.dateOfArrive = dateOfArrive;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public AbstractPlane getPlane() {
        return plane;
    }

    public void setPlane(AbstractPassengerPlane plane) {
        this.plane = plane;
    }

    @Override
    public String toString() {
        return "The plane comes from: " + comesFrom +", Date Of Arrive: " + dateOfArrive +
                ", Arrival Gate: " + arrivalGate + ", Distance: " + distance + ", Plane: " + plane;
    }

    @Override
    public boolean equals(Object ref) {
        if (this == ref) {
            return true;
        }

        if (ref == null || getClass() != ref.getClass()) {
            return false;
        }

        FlightArrive that = (FlightArrive) ref;

        return  distance == that.distance &&
                Objects.equals(comesFrom, that.comesFrom) &&
                Objects.equals(dateOfArrive, that.dateOfArrive) &&
                Objects.equals(arrivalGate, that.arrivalGate) &&
                Objects.equals(plane, that.plane);
    }

    @Override
    public int hashCode() {
        return distance+plane.hashCode()+arrivalGate.hashCode();
    }
}
