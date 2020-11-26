package com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.impl.mock;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.basis.FlightDAO;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.flight.Flight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlightDAOImpl implements FlightDAO {

    private List<Flight> flights;

    public FlightDAOImpl() {
        flights = new ArrayList<>();
    }

    @Override
    public Flight create(Flight o) {
        flights.add(o);
        return o;
    }

    @Override
    public Flight getById(int id) {
        return flights.get(id);
    }

    @Override
    public List<Flight> get() {
        return Collections.unmodifiableList(flights);
    }

    @Override
    public Flight update(Flight o) {
        return null;
    }

    @Override
    public int deleteById(int id) {
        flights.remove(id);
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlightDAOImpl flightDAO = (FlightDAOImpl) o;

        return flights != null ? flights.equals(flightDAO.flights) : flightDAO.flights == null;
    }

    @Override
    public int hashCode() {
        return flights != null ? flights.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FlightDAOImplClasz{");
        sb.append("flights=").append(flights);
        sb.append('}');
        return sb.toString();
    }
}
