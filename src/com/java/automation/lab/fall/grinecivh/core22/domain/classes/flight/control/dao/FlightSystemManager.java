package com.java.automation.lab.fall.grinecivh.core22.domain.classes.flight.control.dao;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.main.entity.AirlineCompany;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.flight.control.entity.Route;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.flight.control.entity.FlightArrive;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.flight.control.entity.FlightDeparture;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.ticket.Ticket;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.planes.entity.AbstractPassengerPlane;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.planes.dao.PlaneManager;
import com.java.automation.lab.fall.grinecivh.core22.domain.enums.ClassLevel;
import com.java.automation.lab.fall.grinecivh.core22.domain.interfaces.dao.FlightDao;

import java.util.*;

public class FlightSystemManager implements FlightDao {
    private PlaneManager pm;
    private Queue<FlightArrive> flightArrives;
    private Queue<FlightDeparture> flightDepartures;
    private Route routes;

    public FlightSystemManager(PlaneManager pm, Route route) {
        this.pm = pm;
        this.routes = route;
        flightArrives = new ArrayDeque<>();
        flightDepartures = new ArrayDeque<>();
    }

    public String getTicketId(Ticket ticket) {

        FlightDeparture fd = ticket.getFlight();

        final String[] ticketId = {null};

        flightDepartures.forEach((FlightDeparture flight) -> {
            if (flight.equals(fd)) {
                ClassLevel classLvl = ticket.getCl();
                if (classLvl == ClassLevel.FIRST) {
                    ticketId[0] = "First class " + flight.getPlane().getName() + flight.getPlane().bookFirstClassSit();
                } else if (classLvl == ClassLevel.BUSINESS) {
                    ticketId[0] = "Business class " + flight.getPlane().getName() + flight.getPlane().bookFirstClassSit();
                } else if (classLvl == ClassLevel.ECONOM) {
                    ticketId[0] = "Econom class " + flight.getPlane().getName() + flight.getPlane().bookFirstClassSit();
                }
            }
        });

        return ticketId[0];
    }

    public boolean offerArriveFlight(FlightArrive fa) {
        return flightArrives.offer(fa);
    }

    public boolean offerDepartureFlight(FlightDeparture fd) {
        return flightDepartures.offer(fd);
    }

    public boolean offerDepartureFlight(String routName, AirlineCompany airlineCompany) {
        Map<String, Integer> route = routes.getRoute(routName);
        boolean isAdded = true;
        for (Map.Entry<String, Integer> entry : route.entrySet()) {

            Class planeClass = routes.findPassengerPlaneClass(routName, entry.getKey());
            AbstractPassengerPlane plane = null;
            if (pm.isPlaneAvailable(planeClass)) {
                plane = pm.getPassengerPlane(planeClass);
            }
            if (!flightDepartures.offer(new FlightDeparture(entry.getKey(), entry.getValue(), plane, airlineCompany))) {
                isAdded = false;
            }
        }
        return isAdded;
    }

    public FlightDeparture pollDepartureFlight() {
        return flightDepartures.poll();
    }

    public FlightArrive pollArriveFlight() {
        return flightArrives.poll();
    }

    public FlightDeparture peekDepartureFlight() {
        return flightDepartures.peek();
    }

    public FlightArrive peekArriveFlight() {
        return flightArrives.peek();
    }

    public Queue<FlightArrive> getFlightArrives() {
        return flightArrives;
    }

    public Queue<FlightDeparture> getFlightDepartures() {
        return flightDepartures;
    }

    public PlaneManager getPm() {
        return pm;
    }

    public void setFlightArrives(Queue<FlightArrive> flightArrives) {
        this.flightArrives = flightArrives;
    }

    public void setFlightDepartures(Queue<FlightDeparture> flightDepartures) {
        this.flightDepartures = flightDepartures;
    }

    public void setPm(PlaneManager pm) {
        this.pm = pm;
    }


    @Override
    public String toString() {
        return
                "Plane Manager: " + pm + ", Flight Arrives=" + flightArrives +
                        ", FlightDepartures=" + flightDepartures;
    }

    @Override
    public boolean equals(Object ref) {
        if (this == ref) {
            return true;
        }

        if (ref == null || getClass() != ref.getClass()) {
            return false;
        }

        FlightSystemManager that = (FlightSystemManager) ref;
        return Objects.equals(pm, that.pm) &&
                Objects.equals(flightArrives, that.flightArrives) &&
                Objects.equals(flightDepartures, that.flightDepartures);
    }

    @Override
    public int hashCode() {
        return flightDepartures.hashCode() + flightArrives.hashCode() + pm.hashCode();
    }
}
