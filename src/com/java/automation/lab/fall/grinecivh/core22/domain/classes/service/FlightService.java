package com.java.automation.lab.fall.grinecivh.core22.domain.classes.service;


import com.java.automation.lab.fall.grinecivh.core22.domain.classes.constant.PropertyConstant;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.basis.FlightDAO;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.flight.Flight;

import java.util.List;

public class FlightService extends BaseService{

    private FlightDAO flightDAO = FLIGHT_DAOS.get(PROPS.getValue(PropertyConstant.ENV_KEY));;

    public FlightService() {
    }

    public Flight create(Flight flight) {
        return flightDAO.create(flight);
    }

    public Flight getById(int id) {
        return flightDAO.getById(id);
    }

    public List<Flight> get() {
        return flightDAO.get();
    }

    public Flight update(Flight flight) {
        return flightDAO.update(flight);
    }

    public int deleteById(int id) {
        return flightDAO.deleteById(id);
    }
}
