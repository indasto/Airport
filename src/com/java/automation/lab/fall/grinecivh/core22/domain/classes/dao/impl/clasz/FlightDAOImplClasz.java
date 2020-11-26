package com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.impl.clasz;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.constant.IOConstant;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.basis.FlightDAO;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.flight.Flight;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.human.client.Client;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.io.ObjectIO;

import java.util.List;

public class FlightDAOImplClasz implements FlightDAO {
    @Override
    public Flight create(Flight o) {
        new ObjectIO<Flight>().write(o, IOConstant.FLIGHT_PATH);
        return o;
    }

    @Override
    public Flight getById(int id) {
        return new ObjectIO<Flight>().read(IOConstant.FLIGHT_PATH);
    }

    @Override
    public List<Flight> get() {
        return null;
    }

    @Override
    public Flight update(Flight o) {
        return null;
    }

    @Override
    public int deleteById(int id) {
        return 0;
    }
}
