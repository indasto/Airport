package com.java.automation.lab.fall.grinecivh.core22.domain.classes.ticket;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.flight.control.entity.FlightDeparture;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.util.Price;
import com.java.automation.lab.fall.grinecivh.core22.domain.enums.*;

import java.util.Objects;

public class Ticket {
    private AccessLevel al;
    private ClassLevel cl;
    private String flightId;
    private FlightDeparture flight;
    private double price;

    private Ticket(AccessLevel accessLevel, ClassLevel classLevel, String flightId, FlightDeparture flight) {

        this.al = accessLevel;
        this.cl = classLevel;
        this.flightId = flightId;
        this.flight = flight;
    }

    public static Ticket createTicket(AccessLevel accessLevel, ClassLevel classLevel, String flightId, FlightDeparture flight) {
        return new Ticket(accessLevel, classLevel, flightId, flight);
    }

    public AccessLevel getAl() {
        return al;
    }

    public ClassLevel getCl() {
        return cl;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setAl(AccessLevel al) {
        this.al = al;
    }

    public void setCl(ClassLevel cl) {
        this.cl = cl;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public FlightDeparture getFlight() {
        return flight;
    }

    public void setFlight(FlightDeparture flight) {
        this.flight = flight;
    }

    public void calculatePrice() {
        price = Price.getTicketPrice(this);
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Access level: " + al + ", Class level: " + cl + ", Flight Id='" + flightId +
                ", Flight=" + flight;
    }

    @Override
    public boolean equals(Object ref) {
        if (this == ref) {
            return true;
        }

        if (ref == null || getClass() != ref.getClass()) {
            return false;
        }

        Ticket ticket = (Ticket) ref;

        return al == ticket.al &&
                cl == ticket.cl &&
                Objects.equals(flightId, ticket.flightId) &&
                Objects.equals(flight, ticket.flight);
    }

    @Override
    public int hashCode() {
        return al.hashCode() + cl.hashCode() + flightId.hashCode();
    }
}
