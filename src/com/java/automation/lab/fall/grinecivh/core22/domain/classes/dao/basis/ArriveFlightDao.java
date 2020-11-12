package com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.basis;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.flight.FlightArrive;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.flight.FlightDeparture;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.AirlineCompany;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.ticket.Ticket;

public interface ArriveFlightDao {

    public boolean offerArriveFlight(FlightArrive fa);

    public FlightArrive pollArriveFlight();

    public FlightArrive peekArriveFlight();

}
