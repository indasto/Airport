package com.java.automation.lab.fall.grinecivh.core22.domain.classes.humans.client;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.flight.control.FlightDeparture;
import com.java.automation.lab.fall.grinecivh.core22.domain.enums.*;

import java.util.Objects;

public class Ticket{
    private AccessLevel al;
    private ClassLevel cl;
    private String flightId;
    private FlightDeparture flight;

    private Ticket(AccessLevel accessLevel, ClassLevel classLevel, String flightId, FlightDeparture flight){

        this.al = accessLevel;
        this.cl = classLevel;
        this.flightId = flightId;
        this.flight = flight;
    }

//    @Override
//    public void run() {
//
//            synchronized (this) {
//                Scanner sc = new Scanner(System.in);
//                String change = null;
//
//                do {
//                    String input;
//                    System.out.println("What do you want to change? (Access level, Class level, exit)");
//                    input = sc.nextLine();
//                    if (input.equals("Access level")) {
//                        System.out.println("Input new access level (A1 ,A2, B1, B2, C)");
//                        input = sc.nextLine();
//                        if (input.equals("A1") || input.equals("A2") || input.equals("B1") || input.equals("B2") || input.equals("C")) {
//                            change = input;
//                            al = AccessLevel.valueOf(change);
//                        }
//                    } else if (input.equals("Class level")) {
//                        System.out.println("Input new Class level (First, Business, Econom)");
//                        input = sc.nextLine();
//                        if (input.equals("First") || input.equals("Business") || input.equals("Econom")) {
//                            change = input;
//                            cl = ClassLevel.valueOf(change.toUpperCase());
//                        }
//                    }
//                } while (change == null);
//
//                sc.close();
//            }
//
//    }
//
//    @Override
//    public void edit() {
//        Thread thread = new Thread(this,flightId);
//        thread.start();
//    }

    public static Ticket createTicket(AccessLevel accessLevel, ClassLevel classLevel, String flightId, FlightDeparture flight){
        return new Ticket(accessLevel,classLevel,flightId,flight);
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


    @Override
    public String toString() {
        return  "Access level: " + al + ", Class level: " + cl + ", Flight Id='" + flightId +
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

        return  al == ticket.al &&
                cl == ticket.cl &&
                Objects.equals(flightId, ticket.flightId) &&
                Objects.equals(flight, ticket.flight);
    }

    @Override
    public int hashCode() {
        return al.hashCode()+cl.hashCode()+flightId.hashCode();
    }
}
