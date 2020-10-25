package com.java.automation.lab.fall.grinecivh.core22.domain.classes.flight.control;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.planes.AbstractPassengerPlane;
import com.java.automation.lab.fall.grinecivh.core22.domain.interfaces.FlightProcessing;

import java.time.OffsetDateTime;
import java.util.Objects;

public class FlightDeparture implements FlightProcessing {

    private String destination;
    private OffsetDateTime dateOfDeparture;
    private String boardingGate;
    private int distance;
    private AbstractPassengerPlane plane;

    public FlightDeparture(String destination, OffsetDateTime dateOfDeparture, String boardingGate, int distance, AbstractPassengerPlane plane){

        this.destination = destination;
        this.dateOfDeparture = dateOfDeparture;
        this.boardingGate = boardingGate;
        this.distance = distance;
        this.plane = plane;

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

    public AbstractPassengerPlane getPlane() {
        return plane;
    }

    public int getDistance() {
        return distance;
    }

    public OffsetDateTime getDateOfDeparture() {
        return dateOfDeparture;
    }

    public String getBoardingGate() {
        return boardingGate;
    }

    public String getDestination() {
        return destination;
    }

    public void setPlane(AbstractPassengerPlane plane) {
        this.plane = plane;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setBoardingGate(String boardingGate) {
        this.boardingGate = boardingGate;
    }

    public void setDateOfDeparture(OffsetDateTime dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return  "Destination: " + destination  + ", Date Of Departure: " + dateOfDeparture +
                ", Boarding Gate: " + boardingGate + ", Distance: " + distance + ", Plane: " + plane;
    }

    @Override
    public boolean equals(Object ref) {
        if (this == ref) {
            return true;
        }

        if (ref == null || getClass() != ref.getClass()) {
            return false;
        }

        FlightDeparture that = (FlightDeparture) ref;

        return  distance == that.distance &&
                Objects.equals(destination, that.destination) &&
                Objects.equals(dateOfDeparture, that.dateOfDeparture) &&
                Objects.equals(boardingGate, that.boardingGate) &&
                Objects.equals(plane, that.plane);
    }

    @Override
    public int hashCode() {
        return distance+destination.hashCode()+boardingGate.hashCode();
    }
}
