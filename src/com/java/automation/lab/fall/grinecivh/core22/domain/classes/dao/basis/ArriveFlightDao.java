package com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.basis;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.flight.FlightArrive;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.flight.FlightDeparture;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.AirlineCompany;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.ticket.Ticket;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.service.PlaneService;

import java.util.Queue;

public interface ArriveFlightDao {

    public boolean offerArriveFlight(FlightArrive fa);

    public FlightArrive pollArriveFlight();

    public FlightArrive peekArriveFlight();

    public Queue<FlightArrive> getFlightArrives();

    public PlaneService getPm();

    public void setFlightArrives(Queue<FlightArrive> flightArrives);

    public void setPm(PlaneService pm);
}
