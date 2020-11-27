package com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.ticket;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.flight.Flight;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.util.Price;
import com.java.automation.lab.fall.grinecivh.core22.domain.enums.*;


public class Ticket {
    private AccessLevel al;
    private ClassLevel cl;
    private Flight flight;
    private double price;

    private Ticket(AccessLevel accessLevel, ClassLevel classLevel, Flight flight) {
        this.al = accessLevel;
        this.cl = classLevel;
        this.flight = flight;
        price = Price.getTicketPrice(this);
    }

    public static Ticket createTicket(AccessLevel accessLevel, ClassLevel classLevel, Flight flight) {
        return new Ticket(accessLevel, classLevel, flight);
    }

    public AccessLevel getAl() {
        return al;
    }

    public void setAl(AccessLevel al) {
        this.al = al;
    }

    public ClassLevel getCl() {
        return cl;
    }

    public void setCl(ClassLevel cl) {
        this.cl = cl;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (Double.compare(ticket.price, price) != 0) return false;
        if (al != ticket.al) return false;
        if (cl != ticket.cl) return false;
        return flight != null ? flight.equals(ticket.flight) : ticket.flight == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = al != null ? al.hashCode() : 0;
        result = 31 * result + (cl != null ? cl.hashCode() : 0);
        result = 31 * result + (flight != null ? flight.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ticket{");
        sb.append("al=").append(al);
        sb.append(", cl=").append(cl);
        sb.append(", flight=").append(flight);
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
