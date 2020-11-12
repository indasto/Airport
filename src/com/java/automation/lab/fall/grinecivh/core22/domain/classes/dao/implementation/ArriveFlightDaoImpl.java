package com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.implementation;


import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.flight.Route;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.flight.FlightArrive;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.basis.ArriveFlightDao;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.service.PlaneService;

import java.util.*;

public class ArriveFlightDaoImpl implements ArriveFlightDao {
    private PlaneService pm;
    private Queue<FlightArrive> flightArrives;
    private Route routes;

    public ArriveFlightDaoImpl(PlaneService pm, Route route) {
        this.pm = pm;
        this.routes = route;
        flightArrives = new ArrayDeque<>();
    }

    public boolean offerArriveFlight(FlightArrive fa) {
        return flightArrives.offer(fa);
    }

    public FlightArrive pollArriveFlight() {
        return flightArrives.poll();
    }

    public FlightArrive peekArriveFlight() {
        return flightArrives.peek();
    }

    public Queue<FlightArrive> getFlightArrives() {
        return flightArrives;
    }

    public PlaneService getPm() {
        return pm;
    }

    public void setFlightArrives(Queue<FlightArrive> flightArrives) {
        this.flightArrives = flightArrives;
    }

    public void setPm(PlaneService pm) {
        this.pm = pm;
    }

    @Override
    public String toString() {
        return
                "Plane Manager: " + pm + ", Flight Arrives=" + flightArrives;
    }

    @Override
    public boolean equals(Object ref) {
        if (this == ref) {
            return true;
        }

        if (ref == null || getClass() != ref.getClass()) {
            return false;
        }

        ArriveFlightDaoImpl that = (ArriveFlightDaoImpl) ref;
        return Objects.equals(pm, that.pm) &&
                Objects.equals(flightArrives, that.flightArrives);
    }

    @Override
    public int hashCode() {
        return flightArrives.hashCode() + pm.hashCode();
    }
}
