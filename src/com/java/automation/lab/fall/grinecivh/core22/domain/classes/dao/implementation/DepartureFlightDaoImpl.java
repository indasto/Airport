package com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.implementation;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.basis.DepartureFlightDao;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.AirlineCompany;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.flight.FlightDeparture;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.flight.Route;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.plane.AbstractPassengerPlane;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.ticket.Ticket;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.service.PlaneService;
import com.java.automation.lab.fall.grinecivh.core22.domain.enums.ClassLevel;

import java.util.Map;
import java.util.Queue;

public class DepartureFlightDaoImpl implements DepartureFlightDao {
    private PlaneService pm;
    private Queue<FlightDeparture> flightDepartures;
    private Route routes;

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

    public FlightDeparture peekDepartureFlight() {
        return flightDepartures.peek();
    }

    public FlightDeparture pollDepartureFlight() {
        return flightDepartures.poll();
    }

    public void setFlightDepartures(Queue<FlightDeparture> flightDepartures) {
        this.flightDepartures = flightDepartures;
    }
}
